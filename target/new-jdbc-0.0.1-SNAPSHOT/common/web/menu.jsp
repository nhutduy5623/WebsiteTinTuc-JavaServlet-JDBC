<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- Side widgets-->
			<div class="col-lg-4">
				<!-- Search widget-->
				<div class="card mb-4">
					<div class="card-header">Search</div>
					<div class="card-body">
						<div class="input-group">
							<input class="form-control" type="text"
								placeholder="Enter search term..."
								aria-label="Enter search term..."
								aria-describedby="button-search" />
							<button class="btn btn-primary" id="button-search" type="button">Go!</button>
						</div>
					</div>
				</div>
				<!-- Categories widget-->
				<form action="trang-chu" method="get" id="FChangePage"
						style="width: 100%; display: flex; justify-content: flex-end;">
				<div class="card mb-4">
					<div class="card-header">Categories</div>
					<div class="card-body">
						<div class="row" style="display: flex; justify-content: space-between; flex-direction: row;">
							<li><a class="categoryFilter" id="" href="#">Tất cả</a></li>
							<c:forEach var="item" items="${Categorys}">
							<!-- Script ở file web/home.jsp -->
								<li><a class="categoryFilter" id="${item.code}" href="#">${item.typeName}</a></li>
							</c:forEach>	
						</div>
					</div>
				</div>
				<!-- Side widget-->
				<div class="card mb-4 Filter">
					<div class="card-header " >Filter</div>
					
						<input type="hidden" value="${ctg}" name="ctg" id="ctg" />
						<select style="margin: 0% 2%" id="maxPageItem" name="maxPageItem">
							<option value="5">5</option>
							<option value="10">10</option>
							<option value="15">15</option>
							<option value="20">20</option>
						</select> <select style="margin: 0% 2%" id="sort">
							<option selected="selected" value="title-1">Title a-z</option>
							<option value="title-2">Title z-a</option>
							<!-- 
							<option value="createDate-1">Ngày đăng mới nhất</option>
							<option value="createDate-2">Ngày đăng cũ nhất</option>
							 -->
						</select>
						
						<input type="hidden" value="${currenPage}" name="nextPage"
						id="nextPage" /> <input type="hidden" value="" name="sortName"
						id="sortName" /> <input type="hidden" value="" name="sortBy"
						id="sortBy" />
					
				</div>
				</form>
				<script>
				$(document).ready(function(){
					if($(".ThisPage").val() == "newsPost") 
						$(".Filter").hide();	
					else
						$(".Filter").show();
				})
				
				$('.categoryFilter').click(function(e){
					e.preventDefault();					
					$("#nextPage").val(1);
					$("#ctg").val($(this).attr("id"));
					$("#FChangePage").submit();	
				});
				
				
				</script>
				<script type="text/javascript">
	var totalPages = ${model.totalPages};
	var currentPage = ${model.nextPage};
	var maxPageItem = ${model.maxPageItem};
	var sortName = "${model.sortName}";
	var sortBy = "${model.sortBy}";
	var sort = sortName+"-"+sortBy;
	$("#ctg").val("${model.ctg}");
	$("#sort").val(sort).change();
	$("#sortName").val(sortName);	
	$("#sortBy").val(sortBy);	
	$("#maxPageItem").val(maxPageItem).change();
	console.log(totalPages);
	$.jqPaginator('#pagination1', {
		totalPages : totalPages,
		visiblePages : 5,
		currentPage : currentPage,
		onPageChange : function(nextPage, type) {
			if (type != "init") {
				$("#nextPage").val(nextPage);
				$("#FChangePage").submit();
			}
		}
	});
	$('#maxPageItem').on('change', function (e) {
		$("#nextPage").val(1);
		$("#FChangePage").submit();			
	});
	$('#sort').on('change', function (e) {
		$("#nextPage").val(1);
		var sortMethod = $("#sort").val().split("-");
		console.log(sortMethod);
		$("#sortName").val(sortMethod[0]);
		$("#sortBy").val(sortMethod[1]);
		
		$("#FChangePage").submit();			
	});
	
	
	</script>
				
			</div>