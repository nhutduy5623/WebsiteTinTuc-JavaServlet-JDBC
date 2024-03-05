<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<div id="navbar" class="navbar navbar-default          ace-save-state">
    <c:if test="${not empty currentUSER}"> 
    	<c:if test="${currentUSER.role.code eq 'ADMIN'}">
	    	<div class="navbar-container ace-save-state" id="navbar-container">
		        <div class="navbar-header pull-left">
		            <a href="#" class="navbar-brand">
		                <small>
		                    <i class="fa fa-leaf"></i>
		                    Trang quản trị
		                </small>
		            </a>
		        </div>
		        <div class="navbar-buttons navbar-header pull-right collapse navbar-collapse" role="navigation">
		            <ul class="nav ace-nav">
		                <li class="light-blue dropdown-modal">
		                    <a data-toggle="dropdown" href="#" class="dropdown-toggle">
		                        Xin chào, ${currentUSER.fullName}
		                        <!-- ${USERMODEL.fullName} -->
		                    </a>
		                    <li class="light-blue dropdown-modal">
		                        <a href='<c:url value="/thoat?action=logout"/>'>
		                            <i class="ace-icon fa fa-power-off"></i>
		                            Thoát
		                        </a>
		                    </li>
		            </ul>
		        </div>
	    	</div>
    	</c:if>
    	<c:if test="${currentUSER.role.code ne 'ADMIN'}">
    		<script>
    			var getUrl = window.location;
    			window.location.href=getUrl .protocol + "//" + getUrl.host + "/" + getUrl.pathname.split('/')[1]+"/trang-chu";
    		</script>
    	</c:if>
    </c:if>	
    <c:if test="${empty currentUSER}">
    	<script>
    			var getUrl = window.location;
    			window.location.href=getUrl .protocol + "//" + getUrl.host + "/" + getUrl.pathname.split('/')[1]+"/trang-chu";
    	</script>
    </c:if>
</div>