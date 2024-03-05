<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Blog Home - Start Bootstrap Template</title>
<!-- Favicon-->



<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="css/styles.css" rel="stylesheet" />
<link href="<c:url value='template/web/css/style.css'/>"
	rel="stylesheet">
</head>
<body>

	<!-- Page header with logo and tagline-->
	<header class="py-5 bg-light border-bottom mb-4">
		<div class="container">
			<div class="text-center my-5">
				<h1 class="fw-bolder">Welcome to Blog Home!</h1>
				<p class="lead mb-0">A Bootstrap 5 starter layout for your next
					blog homepage</p>
			</div>
		</div>
	</header>
			<!-- Blog entries-->
			<div class="col-lg-8">
				<!-- Featured blog post-->
				<div class="card mb-4">
					<a href="#!"><img class="card-img-top"
						src="https://dummyimage.com/850x350/dee2e6/6c757d.jpg" alt="..." /></a>
					<div class="card-body">
						<div class="small text-muted">January 1, 2023</div>
						<h2 class="card-title">Featured Post Title</h2>
						<p class="card-text">Lorem ipsum dolor sit amet, consectetur
							adipisicing elit. Reiciendis aliquid atque, nulla? Quos cum ex
							quis soluta, a laboriosam. Dicta expedita corporis animi vero
							voluptate voluptatibus possimus, veniam magni quis!</p>
						<a class="btn btn-primary" href="#!">Read more →</a>
					</div>
				</div>
				<!-- Nested row for non-featured blog posts-->
				<div class="row main-content">
					

					<!-- Blog post-->
					<!--
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
                             -->
					<c:forEach var="item" items="${model.listResult}">
						<div class="cardItem card mb-4">
							<a href="<c:url value='newsPost?id=${item.id}'/>" style="width: 100%">
							<img src="${item.thumbnail}" alt=""  onerror="this.src='https://dummyimage.com/700x350/dee2e6/6c757d.jpg'" style="width: 100%"/></a>
							<div class="card-body">
								<div class="small text-muted">January 1, 2023</div>
								<h2 class="card-title h4">${item.title}</h2>
								<p class="card-text">${item.description}</p>
								<a class="btn btn-primary" href="<c:url value='newsPost?id=${item.id}'/>">Read more →</a>
							</div>
						</div>

					</c:forEach>
				</div>
				<!-- Pagination-->

				<ul class="pagination" id="pagination1"></ul>
				
			</div>
			
	<!-- Bootstrap core JS-->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>


	<script src="http://code.jquery.com/jquery-1.12.4.min.js"></script>
	<script type="text/javascript" src="template/paging/jqPaginator.min.js"></script>

	<input type="hidden" class="ThisPage" value="homePage">	

</body>
</html>
