<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Index</title>
	 <style><%@include file="/static/bootstrap/css/bootstrap.min.css"%></style>
	<style><%@include file="/static/css/index.css"%></style>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>

<body>

    <div class="container root">
    
        <!-- Thanh menu-->
       <jsp:include page="/views/user/nav-menu.jsp"></jsp:include>
		
       <jsp:include page="${view }"></jsp:include>
       
       
        <div class="row footer">
            <div class="container">
                <p class="copyright-text">Copyright &copy; 2021 All Rights Reserved by PC00653</p>
            </div>

        </div>
    </div>

    <!--modal quen mk-->
   <c:import url="/views/user/modal.jsp"></c:import>
     <script type="text/javascript" src="<c:url value = '/static/js/user.js' />"></script>
   
     <script type="text/javascript">
     $(window).bind('scroll', function () {
         var navHeight = $(window).height() - 600;
         if ($(window).scrollTop() > navHeight) {
             $('.navbar').addClass('fixed');
         }
         else {
             $('.navbar').removeClass('fixed');
         }
     })
 });
        
    </script>
 		
 
</body>

</html>