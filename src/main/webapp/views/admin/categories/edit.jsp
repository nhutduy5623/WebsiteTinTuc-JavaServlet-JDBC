<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quản lý thể loại</title>
</head>
<body>
<h1 id="CategoryTitle"></h1>
<style>
@import url(https://fonts.googleapis.com/css?family=Merriweather);
$red: #e74c3c;

*, 
*:before, 
*:after {
   @include box-sizing(border-box); 
}

h1 {
   text-align: center;
   color: #a8a8a8;
   @include text-shadow(1px 1px 0 rgba(white, 1));
}

.formEdit {
	background-color: white;
   max-width: 500px;
	width: 50%;
   margin: 20px auto;
	display: flex;
  input, textarea {
     border:0; outline:0;
     padding: 1em;
     @include border-radius(8px);
     display: block;
     width: 100%;
     margin-top: 1em;
     font-family: 'Merriweather', sans-serif;
     @include box-shadow(0 1px 1px rgba(black, 0.1));
     resize: none;
    
    &:focus {
       @include box-shadow(0 0px 2px rgba($red, 1)!important);
    }
  }
  
  #input-submit {
     color: white; 
     background: $red;
     cursor: pointer;
    
    &:hover {
       @include box-shadow(0 1px 1px 1px rgba(#aaa, 0.6)); 
    }
  }
  

}


@media (max-width: 480px) {
  .half {
     width: 100%; 
     float: none;
     margin-bottom: 0; 
  }
}


/* Clearfix */
.formEdit:before,
.formEdit:after {
    content: " "; /* 1 */
    display: table; /* 2 */
}
.formEdit {
	display: flex;
	flex-direction: column;
	width: 100%;
	height: 100%;
}

.formEdit > div {
	display: flex;
	width: 90%;
	margin: 5px;
	flex-direction: column;
	flex-wrap: wrap;
}
.formEdit > div > input{
	width: 90%;
	margin: 5px;
}

.formEdit:after {
    clear: both;
}
</style>
<form class="formEdit" id = "formEditCategory">
	<div>
		<p>Category Name: </p>
		<input type="text" id="typeName" name="typeName" value="${model.typeName}" placeholder="Category Name">
	</div>
	<div>
		<p>Category Code: </p>
		<input type="text" id="code" name="code" value="${model.code}" placeholder="Code">
	</div>
	<div>
		<p>Category Description: </p>
		<textarea name="description" type="text" id="description" placeholder="description">${model.description}</textarea> 
	</div>
	<input type="hidden" name="id" id="id" value="${model.id}">
	<div></div>
      	<input type="submit" value="submitCtg" id="submitCtg">
</form>	
<c:url var="ApiUrl" value="/api-admin-category"/>
	<script>
		if($("#ctgName").val()=="") {
			$("#CategoryTitle").html("Thêm Thể Loại");
		} else {
			$("#CategoryTitle").html("Sửa Thể Loại");
		}
		
		$("#submitCtg").click(function (e) {
			e.preventDefault();
			var data={};
			var formData = $('#formEditCategory').serializeArray();
			formData.forEach(element => {
				data[""+element.name+""] = element.value;
				
			});
			var id = $("#id").val();	
			data = JSON.stringify(data);	
			if(id == "0" || id == "") {
				
				$.ajax({
					url: '${ApiUrl}',
					type: 'POST',
					contentType: 'application/json',
					data: data,
					success: function(result) {
						if (confirm('Thêm hoàn tất!')) {
							window.location.href = window.location.protocol + "//" + window.location.host + "/" + window.location.pathname.split('/')[1]+"/admin-category?nextPage=1&maxPageItem=5&sortName=createDate&sortBy=1"
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
							window.location.href = window.location.protocol + "//" + window.location.host + "/" + window.location.pathname.split('/')[1]+"/admin-category?nextPage=1&maxPageItem=5&sortName=createDate&sortBy=1"
						}	
					},
					error: function (error) {
						console.log(error)
					}
				})


			}
		})
		
		
	</script>
</body>
</html>