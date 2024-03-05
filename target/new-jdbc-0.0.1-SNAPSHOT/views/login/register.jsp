<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Login</title>

</head>
<body>
<div class="wrapper fadeInDown" class = "formLogin">
  <div id="formContent">
    <!-- Tabs Titles -->

    <!-- Icon -->
    <div class="fadeIn first">
      <img src="" id="icon" alt="User Icon" />
    </div>

    <!-- Login Form -->
    <form id="formRegister" action="dang-ky?action=register" method="post">
      <input type="text" id="fullName" class="loginInput" name="fullName" placeholder="Fullname">
      <input type="text" id="userName" class="loginInput" name="userName" placeholder="Username">
      <input type="password" id="passWord" class="loginInput" name="passWord" placeholder="Password">
      <input type="password" id="cfPassword" class="loginInput" name="confirmpassWord" placeholder="Confirm Passord">
      <input type="button" id="btnSubmitRegister" class="fadeIn fourth" value="Register">
      <input type="hidden" name = "action" value="register">
	  <input type="hidden" id = "MessageFormServer" value="${Message}">
      
    </form>

    <!-- Remind Passowrd -->
    <div id="formFooter">
    	<p>Bạn đã có tài khoản? <a class="underlineHover" href="dang-nhap?action=login">Đăng nhập</a></p>
      	
    </div>

  </div>
</div>
<script src="template/ValidityCheck/ValidityCheck.js"></script>
<script>
if($("#MessageFormServer").val()!="")
	if($("#MessageFormServer").val()=="User exists!") {
		alert("Tên người dùng đã tồn tại!")
	} else {
		if (confirm('Đăng ký thành công! Quay về trang đăng nhập?')) {
			window.location.href = window.location.protocol + "//" + window.location.host + "/" + window.location.pathname.split('/')[1]+"/dang-nhap?action=login"
		}	
	}

$("#btnSubmitRegister").click(function(){
	var check = 1;
	var s=checkUserName($("#fullName").val(), 8, "fullName") + "" + checkUserName($("#userName").val(), 8, "userName") + "" + checkUserName($("#passWord").val(), 8, "passWord")+ "" + confirmPassword($("#passWord").val(),$("#cfPassword").val());
	if(s!=""){
		alert(s);
	} else {
		$("#formRegister").submit();
	}		
})
</script>


</body>

</html>
