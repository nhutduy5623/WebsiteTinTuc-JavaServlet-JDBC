<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<div class="col-lg-8">
                    <!-- Post content-->
                    <article>
                        <!-- Post header-->
                        <header class="mb-4">
                            <!-- Post title-->
                            <h1 class="fw-bolder mb-1">${model.title}</h1>
                            <!-- Post meta content-->
                            <div class="text-muted fst-italic mb-2">Posted on January 1, 2023 by Start Bootstrap</div>
                            <!-- Post categories-->
                            <a class="badge bg-secondary text-decoration-none link-light" href="#!">Web Design</a>
                            <a class="badge bg-secondary text-decoration-none link-light" href="#!">Freebies</a>
                        </header>
                        <!-- Preview image figure-->
                        <figure class="mb-4"><img class="img-fluid rounded" src="${model.thumbnail}" alt="..." /></figure>
                        <!-- Post content-->
                        <section class="mb-5">
                        <h3>${model.description}</h3>
                            <p>${model.content}</p>
                        </section>
                    </article>









                    
                    <!-- Comments section -->
                    <section class="mb-5"  id="commentContainer">
                        <div class="card bg-light">
                            <div class="card-body">
                                
                                
                                <!-- Comment form-->
                                <form style="display: flex; flex-direction: column;" class="mb-4" name="commentForm" id="commentForm">
                                	<c:if test="${empty currentUSER}"></c:if>
                                	<c:if test="${not empty currentUSER}">
                                		<textarea style="flex: 1" name="content" id="cmtContent" class="form-control" rows="3" placeholder="Join the discussion and leave a comment!"></textarea><button style="width: 15%; margin-left: 85%; margin-top: 1%" id="submitCmt" name="submitCmt">Đăng</button>
                                		<input type="hidden" name="userId" value="${currentUSER.id}">
                                		<input type="hidden" name="createBy" value="${currentUSER.userName}">
                                		
                                		<input type="hidden" name="newsId" value="${model.id}">
                                		<input type="hidden" id="cmtId" name="cmtId" value="0">
                                		
                                	</c:if>
                                </form>
                                <!-- Comment with nested comments-->
                               	<c:forEach var="item" items="${comment.listResult}">
                               	<c:if test="${item.cmtId==0}">
									<div style="di" class="d-flex mb-4 Maincomment">
	                                    <!-- Parent comment-->
	                                    <div class="flex-shrink-0"><img class="rounded-circle" src="https://dummyimage.com/50x50/ced4da/6c757d.jpg" alt="..." /></div>
	                                    	<div class="ms-3">
	                                        <div class="fw-bold">${item.createBy}</div>
	                                       	${item.content}		    
	                                       	<div class="replayCmt" id="replycmt_${item.id}_${item.createBy}"  style="margin-top: 1%"><a href="#!">trả lời</a></div> 
	                                       	                               	
		                                       		<c:forEach var="item2" items="${item.listCmtResponse}">
		                                       			<div class="d-flex mt-4">
					                                    	<div class="flex-shrink-0"><img class="rounded-circle" src="https://dummyimage.com/50x50/ced4da/6c757d.jpg" alt="..." /></div>
					                                            <div class="ms-3">
					                                                <div class="fw-bold">${item2.createBy}</div>
					                                                ${item2.content}
					                                            	<div class="replayCmt" id="replycmt_${item.id}_${item2.createBy}"  style="margin-top: 1%"><a href="#!">trả lời</a></div> 
					                                                
					                                        </div>
					                                    </div>
		                                       		</c:forEach>
		                                       	
                                			</div>
	                                    
	                                   
                                	</div>
                                	
                                	</c:if>
								</c:forEach>
                               
                              
                            </div>
                        </div>
                        <input type="hidden" class="ThisPage" value="newsPost">	
                        <script type="text/javascript">
							<c:url var="ApiUrl" value="api-admin-comment" />
						
							$("#submitCmt").click(function(e) {
								e.preventDefault();
								var formData = $('#commentForm').serializeArray();
								var data = {};
								formData.forEach(element => {
									data[""+element.name+""] = element.value;
									console.log("-----Data-----"+element.value)
								});
								data = JSON.stringify(data);	
								console.log(data);
								$.ajax({
									url: '${ApiUrl}',
									type: 'POST',
									contentType: 'application/json',
									data: data,
									success: function(result) {
										$("#commentContainer").load(location.href+" #commentContainer>*");
										
									},
									error: function (error) {
										console.log("Error---"+error)
									}
								})
								
							})
							
							$(".replayCmt").click(function(e) {
								e.preventDefault();
								var id = $(this).attr("id").split("_")[1];
								var ReplyUser = $(this).attr("id").split("_")[2]
								$("#cmtContent").val("@"+ReplyUser+": ")
								$("#cmtContent").focus()
								$("#cmtId").val(id)
							})
							</script>
                        
                    </section>

                </div>