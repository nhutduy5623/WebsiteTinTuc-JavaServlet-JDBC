<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>


<!DOCTYPE html>
<html lang="en">
<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title><dec:title default="Trang Chủ" /></title>

<!--Login Page-->
<link rel="stylesheet"
	href="<c:url value='/template/login/style.css' />"
	class="LoginPage-main-stylesheet" id="main-LoginPage-style" />
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!--Login Page-->

<!-- Bootstrap core CSS -->
<link
	href="<c:url value='template/web/bootstrap/css/bootstrap.min.css'/>"
	rel="stylesheet">

<!-- Custom styles for this template -->

<style>
html {
	background-color: white !important;
}



.main-content {
	display: flex;
	flex-direction: row;
	justify-content: space-between;
}
.input-group {
    position: relative;
    display: flex !important;
    border-collapse: separate;
    flex-direction: row;
    flex-wrap: nowrap;
}
.cardItem {
	width: 45%;
}
</style>

<link href="<c:url value='template/web/css/stylepagePost.css'/>" rel="stylesheet" />
<link href="http://www.jqueryscript.net/css/jquerysctipttop.css"
	rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
<link rel="icon" type="image/x-icon" href="<c:url value='template/assets/favicon.ico'/>" />

</head>

<body>

	<!--Header-->
	<%@include file="/common/web/header.jsp"%>
	<!--Header-->

	<!--Container-->
	<div class="main-container" id="main-container">
		<script type="text/javascript">
			try {
				ace.settings.check('main-container', 'fixed')
			} catch (e) {
			}
		</script>
		

		<!-- Page content-->
		<div class="container">
			<div class="row">
				<dec:body />
				<%@include file="/common/web/menu.jsp"%>
			</div>
		</div>
		
	


	</div>

	<!--Container-->

	<!--Footer-->
	<%@include file="/common/web/footer.jsp"%>
	<!--Footer-->

	<a href="#" id="btn-scroll-up"
		class="btn-scroll-up btn btn-sm btn-inverse display"> <i
		class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
	</a>
	<script src="<c:url value='template/web/jquery/jquery.min.js'/>"></script>
	<script src="<c:url value= 'template/web/bootstrap/js/bootstrap.bundle.min.js'/>"></script>
	<script src="<c:url value= 'template/web/js/scripts.js'/>"></script>
	
</body>

</html>

<!-- Bootstrap core JavaScript -->
	
	
