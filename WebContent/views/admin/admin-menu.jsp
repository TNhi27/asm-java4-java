<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">

            <a class="navbar-brand" href="/Java4_ASM_PC00653/admin/home">
                <img class="img-logo" src= "<c:url value = '/static/img/logo.png' />">
            </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="/Java4_ASM_PC00653/admin/home"><i class="fa fa-home" aria-hidden="true"></i> Home <span
                                class="sr-only"></span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/Java4_ASM_PC00653/admin/all-video">Video</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/Java4_ASM_PC00653/admin/users">Users</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/Java4_ASM_PC00653/admin/reports">Reports</a>
                    </li>
                </ul>
                <div class="acc" style="display: flex;">
                    <i class="fa fa-user fa-2x" aria-hidden="true"></i>
                    <h3 style="padding-left: 10px;">ADMIN TOOL</h3>
                    
                    <a class="dropdown-item" href="/Java4_ASM_PC00653/logout">
                     <button class="btn btn-outline-success my-2 my-sm-0">Logout</button></a>
                </div>
            </div>
        </nav>
</body>
</html>