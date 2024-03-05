<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<div class="mainContent">
	<form class="formEdit" id="formEditNew">
		<div class="btnSubmit">
			<button type="submit" form="formEditNew" id="submitNew"
				value="Submit">
				<span>Submit</span>
			</button>
		</div>
		<div class="formInputs">
			<div>
				<p>Title:</p>
				<input type="text" id="title" name="title" value="${model.title}"
					placeholder="Title">
			</div>
			<div>
				<p>Thumbnail:</p>
				<input type="file" id="Thumbnail" name="thumbnail" value=""
					placeholder="Thumbnail">
			</div>
			<div>
				<p>Category:</p>
				<select id="categoryCode" name="categoryCode">
					<c:forEach var="item" items="${Category.listResult}">
						<option value="${item.code}">${item.typeName}</option>
					</c:forEach>
				</select>
			</div>
			<div>
				<p>Description:</p>
				<textarea name="description" id="description"
					placeholder="description">${model.description}</textarea>
			</div>
			<div>
				<p>Content:</p>
				<textarea  name="content" id="content" placeholder="content">${model.content}</textarea>
			</div>
			<input type="hidden" name="id" id="id" value="${model.id}">
		</div>


	</form>
	<c:url var="ApiUrl" value="/api-admin-new" />
	<c:url var="ApiUrlUploadImg" value="/api-UploadFile" />
	<script>
	var editor = ""
		$(document).ready(function(){
			editor = CKEDITOR.replace('content');
		})
		$("#submitNew").click(function (e) {
			e.preventDefault();
			var data={};
			var formData = $('#formEditNew').serializeArray();
			formData.forEach(element => {
				data[""+element.name+""] = element.value;
				console.log("-----Data-----"+element.value)
			});
			var content = CKEDITOR.instances['content'].getData();
			data["content"] = content;
			
			var thumbnail = $("#Thumbnail")[0].files[0].name;
			var id = $("#id").val();	
			data["thumbnail"]=thumbnail;
			data = JSON.stringify(data);	
			console.log("-----Data-----"+data)
			
			//Upload file
			var formData = new FormData();
			formData.append('fileName', $("#Thumbnail")[0].files[0]);				
			if(id == "0" || id == "") {		
				$.ajax({
					url: '${ApiUrlUploadImg}',
					type: 'POST',
					contentType: false,
					processData: false,
					data: formData,
					success: function(result) {
					},
					error: function (error) {
						console.log(error)
					}
				})
				$.ajax({
					url: '${ApiUrl}',
					type: 'POST',
					contentType: 'application/json',
					data: data,
					success: function(result) {
						if (confirm('Thêm hoàn tất!')) {
							window.location.href = window.location.protocol + "//" + window.location.host + "/" + window.location.pathname.split('/')[1]+"/admin-news?nextPage=1&maxPageItem=5&sortName=createDate&sortBy=1"
						}	
					},
					error: function (error) {
						console.log(error)
					}
				})

			} else {

				$.ajax({
					url: '${ApiUrl}',
					contentType: 'application/json',
					data: data,
					type: 'PUT',					
					success: function(result) {
						if (confirm('Thay đổi hoàn tất!')) {
							window.location.href = window.location.protocol + "//" + window.location.host + "/" + window.location.pathname.split('/')[1]+"/admin-news?nextPage=1&maxPageItem=5&sortName=createDate&sortBy=1"
						}	
					},
					error: function (error) {
						console.log(error)
					}
				})


			}
		})
		
		
	</script>
</div>