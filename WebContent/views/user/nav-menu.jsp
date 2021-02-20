<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

	
	<nav class="navbar navbar-expand-lg navbar-light bg-light">

            <a class="navbar-brand" href="/Java4_ASM_PC00653/">
                <img class="img-logo" src="<c:url value = '/static/img/logo.png' />" alt="">
            </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="/Java4_ASM_PC00653/">Home <span class="sr-only"></span></a>
                    </li>
                   <li class="nav-item">
                        <a class="nav-link" href="/Java4_ASM_PC00653/favorite">My Favorites</a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                            data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            My Account
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        	<c:choose>
		<c:when test="${empty sessionScope.user }">
							<a class="dropdown-item" href="/Java4_ASM_PC00653/login">Login</a>
                    		<a class="dropdown-item" href="/Java4_ASM_PC00653/dang-ki">Registration</a>
                    		 <a class="dropdown-item" href="#" data-toggle="modal" data-target="#modal-quen-mk">Forgot
                                Password</a>
		</c:when>
		<c:otherwise>
			 <a class="dropdown-item" href="/Java4_ASM_PC00653/logout">Logoff</a>
                            <a class="dropdown-item" href="#" data-toggle="modal" data-target="#modal-quen-mk">Forgot
                                Password</a>
                            
                            <a class="dropdown-item" href="" data-toggle="modal" data-target="#modal-doi-mk" >Change Password</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item"  href="" data-toggle="modal" data-target="#modal-cap-nhat-tk">EditProfile</a>
                           
		</c:otherwise>
	</c:choose>
                    		 
                           
                        </div>
                    </li>

                </ul>
                <form class="form-inline my-2 my-lg-0">
                    <input class="form-control mr-sm-2" type="search" placeholder="Search Video" aria-label="Search">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                </form>
            </div>
        </nav>
        
