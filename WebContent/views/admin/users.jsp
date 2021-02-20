<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>video</title>
<style><%@include file="/static/bootstrap/css/bootstrap.min.css"%></style>
	<style><%@include file="/static/css/admin.css"%></style>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	

</head>

<body>
	<div class="container">
		<jsp:include page="/views/admin/admin-menu.jsp"></jsp:include>

		<ul class="nav nav-tabs" id="myTab" role="tablist">
			<li class="nav-item"><a class="nav-link active" id="home-tab"
				data-toggle="tab" href="#edit" role="tab" aria-controls="home"
				aria-selected="true">User Edition</a></li>
			<li class="nav-item"><a class="nav-link" id="profile-tab"
				data-toggle="tab" href="#list" role="tab" aria-controls="profile"
				aria-selected="false">User List</a></li>

		</ul>
		<div class="tab-content" id="myTabContent">
			<div class="tab-pane fade show active" id="edit" role="tabpanel"
				aria-labelledby="home-tab">
		
				<c:if test="${mess != null }">
				<div class="alert alert-success text-center" role="alert">
  					${mess }
  					 <button type="button" class="close" data-dismiss="alert" aria-label="Close">
    					<span aria-hidden="true">&times;</span>
  				</button>
				</div>
				</c:if>
				<div class="timkiem">
					<form class="form-inline my-2 my-lg-0 ">
						<input class="form-control mr-sm-2" type="search"
							placeholder="Search User" aria-label="Search">
						<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
					</form>
					</div>
				
				<div class="form-group">
				
					<form action="" method="post" enctype="multipart/form-data">
						<div class="container">

							<div class="form-group row">
								<input value="${user.admin }" hidden name="admin">
								<div class="col-sm-6">
									<label for="" class="col-sm-1-12 col-form-label">User
										name</label> <input type="text" class="form-control" name="id"
										id="inputName" placeholder="" value="${user.id }">
								</div>
								<div class="col-sm-6">
									<label for="" class="col-sm-1-12 col-form-label">Password</label>
									<input type="text" class="form-control" name="password" id="inputName"
										placeholder="" value="${user.password }">
								</div>
							</div>
							<div class="form-group row">
								<div class="col-sm-6">
									<label for="inputName" class="col-sm-1-12 col-form-label">Full
										name</label> <input type="text" class="form-control" name="fullName"
										id="inputName" placeholder="" value="${user.fullName }">
								</div>
								<div class="col-sm-6">
									<label for="inputName" class="col-sm-1-12 col-form-label">Email</label>
									<input type="text" class="form-control" name="email"
										id="inputName" placeholder="" value="${user.email }">
								</div>
							</div>
							
							<div class="col-sm-12 text-right btn-sub">
								<button formaction="/Java4_ASM_PC00653/admin/updata-user" class="btn btn-primary">Update</button>
								<button formaction="/Java4_ASM_PC00653/admin/delete-user" class="btn btn-primary">Delete</button>
							</div>
						</div>

					</form>
				</div>


			</div>
			<div class="tab-pane fade" id="list" role="tabpanel"
				aria-labelledby="profile-tab">
				
				<table class="table table-light table-hover">
					<caption>
						
						<div class="text-right">
							<div class="btn-group" role="group" aria-label="Button group">
								<button class="btn btn-secondary mr-4" type="button">|<
								</button>
								<button class="btn btn-secondary mr-4" type="button">
									<<</button>
								<button class="btn btn-secondary mr-4" type="button">>></button>
								<button class="btn btn-secondary mr-4" type="button">>|</button>
							</div>
						</div>
					</caption>
					
					<thead class="thead-light">
						<tr>
							
							<th>User name</th>
							<th>Password</th>
							<th>Full name</th>
							<th>Email</th>
							<th>Role</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="u" items="${users }">
						<c:url var="urlEditUser" value="/admin/edit-user">
							<c:param name="idu" value="${u.id }"></c:param>
						</c:url>
						<tr>
							
							<td>${u.id }</td>
							<td>${u.password }</td>
							<td>${u.fullName }</td>
							<td>${u.email }</td>
							<c:choose>
								<c:when test="${u.admin }"><td>Admin</td></c:when>
								<c:when test="${u.admin==false }"><td>User</td></c:when>
							</c:choose>
							<td><a href="${urlEditUser }">Edit</a></td>
						</tr>
						</c:forEach>
						
					</tbody>

				</table>
			</div>
		</div>
	</div>

</body>

</html>