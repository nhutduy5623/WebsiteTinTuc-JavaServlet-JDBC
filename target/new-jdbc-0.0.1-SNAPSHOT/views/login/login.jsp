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
      <img src="http://danielzawadzki.com/codepen/01/icon.svg" id="icon" alt="User Icon" />
    </div>

    <!-- Login Form -->
    <form action="dang-nhap?action=login" method="post">
      <input type="text" id="user" class="loginInput" name="userName" placeholder="login">
      <input type="password" id="password" class="loginInput" name="passWord" placeholder="password">
      <input type="submit" class="fadeIn fourth" value="Log In">
      <input type="hidden" name = "action" value="login">
      <input type="hidden" id = "MessageFormServer" value="${MessageErro}">
      
    </form>

    <!-- Remind Passowrd -->
    <div id="formFooter">
    	<p>Bạn chưa có tài khoản? <a class="underlineHover" href="dang-ky?action=register">Đăng ký</a></p>
      	
    </div>

  </div>
</div>


<script>
if($("#MessageFormServer").val()!="")
	alert($("#MessageFormServer").val());
</script>
</body>
</html>
