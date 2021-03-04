<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>

<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login</title>

<style><%@include file="/static/css/index.css"%></style>
<style><%@include file="/static/bootstrap/css/bootstrap.min.css"%></style>
 <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script type="text/javascript"><%@include file="/static/bootstrap/js/bootstrap.min.js"%></script>
<script type="text/javascript"><%@include file="/static/bootstrap/jquery-3.5.1.min.js"%></script>

</head>

<body>

	<div class="container-fluid rootmen">
	
		<div class="form">
		<c:if test="${mess}">
			 <div class="alert alert-primary alert-dismissible fade show text-center">
			 	Đăng Nhập Thất Bại !
    			<button type="button" class="close" data-dismiss="alert" onclick="$('.alert').hide()">&times;</button>
			</div>
		</c:if>
		<c:if test="${mess1}">
			 <div class="alert alert-primary alert-dismissible fade show text-center">
			 	Dang ki thanh cong
    			<button type="button" class="close" data-dismiss="alert" onclick="$('.alert').hide()">&times;</button>
			</div>
		</c:if>
		
			<form class="form-group fr" action="/Java4_ASM_PC00653/login" method="post">
				
				<h1 class="text-center">
					<i class="fa fa-user-circle fa-2x" aria-hidden="true"></i>
				</h1>
				<h1 class="text-center">LOGIN</h1>
				<br> <label for="">USER NAME:</label> <input type="text"
					class="form-control" name="username" id="" aria-describedby="helpId"
					placeholder="Username ?">
					<br> <label for="">PASSWORD:</label>
				<input type="password" class="form-control" name="password" id=""
					aria-describedby="helpId" placeholder="Password ?"> <br>
					
				<div class="form-check">
					<input name="remember" class="form-check-input" type="checkbox" id="gridCheck">
					<label class="form-check-label" for="gridCheck"> Remember me ? </label>
				</div>
				
				<div class="text-right">
					<button class="btn btn-outline-light btn-login" type="submit">Login</button>
					<a href="/Java4_ASM_PC00653/dang-ki"><button class="btn btn-outline-light btn-login" type="button">Register</button></a>
				</div>
			</form>
		</div>
</body>

</html>