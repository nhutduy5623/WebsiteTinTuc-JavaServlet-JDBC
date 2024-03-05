<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Danh sách bài viết</title>

</head>
<body>
	<div class="main-content">
		<div class="main-content-inner">
			<div class="breadcrumbs ace-save-state" id="breadcrumbs">
				<ul class="breadcrumb">
					<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">Trang
							chủ</a></li>
					<li><a href="admin-news?action=add"><input type="button" id="btnAddNew" value = "Thêm mới"></a></li>	
				</ul>
				<!-- /.breadcrumb -->
			</div>
			<form action="admin-news" method="get" id="FChangePage">
			<div class="" style="width: 100%; display: flex; justify-content: flex-end;">
				<select style="margin:0% 2%" id="maxPageItem" name="maxPageItem">
						<option value="5">5</option>
						<option value="10">10</option>
						<option value="15">15</option>
						<option value="20">20</option>
				</select>
				<select style="margin:0% 2%" id="sort">
						<option value="title-1">Title a-z</option>
						<option value="title-2">Title z-a</option>
						<option value="createDate-1">Ngày đăng mới nhất</option>
						<option value="createDate-2">Ngày đăng cũ nhất</option>
				</select>
			</div>
				<div class="page-content">
				
					<div class="row">
					
						<div class="col-xs-12">
						
							<table class="table">
								<thead>
									<tr>
										<th scope="col">#</th>
										<th scope="col">Thumbnail</th>
										<th scope="col">Title</th>
										<th scope="col">Category</th>
										<th scope="col">Desciption</th>
										
										<th scope="col">...</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="item" items="${model.listResult}">
										<tr>
											<td scope="row">${item.id}</td>
											<td><img src="${item.thumbnail}" alt=""  width="60"></td>
											<td>${item.title}</td>
											<td>${item.category.typeName}</td>
											<td>${item.description}</td>
											<td>...</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
					<ul class="pagination" id="pagination1"></ul>
					<input type="hidden" value="${currenPage}" name="nextPage" id="nextPage" /> 
					<input type="hidden" value="" name="sortName" id="sortName" /> 
					<input type="hidden" value="" name="sortBy" id="sortBy" /> 
					
				</div>
			</form>
		</div>
	</div>
	<!-- /.main-content -->

	<script src="http://code.jquery.com/jquery-1.12.4.min.js"></script>
	<script src="template/paging/jq-paginator.js"></script>
	<script type="text/javascript">
		var totalPages = ${model.totalPages};
		var currentPage = ${model.nextPage};
		var maxPageItem = ${model.maxPageItem};
		var sortName = "${model.sortName}";
		var sortBy = "${model.sortBy}";
		var sort = sortName+"-"+sortBy;
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
</body>
</html>