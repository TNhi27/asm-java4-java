<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>


</head>

<body>
	<div class="container">
		<jsp:include page="/views/admin/admin-menu.jsp"></jsp:include>

		<ul class="nav nav-tabs" id="myTab" role="tablist">
			<li class="nav-item"><a class="nav-link active" id="home-tab"
				data-toggle="tab" href="#edit" role="tab" aria-controls="home"
				aria-selected="true">Video Edition</a></li>
			<li class="nav-item"><a class="nav-link" id="profile-tab"
				data-toggle="tab" href="#list" role="tab" aria-controls="profile"
				aria-selected="false">Video List</a></li>

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
				<div class="form-group">
					<form id="form-edit" action="" method="post" enctype="multipart/form-data">
						<div class="row">
							<div class="col-sm-4">
								<div class="img-vd">
									
									<img id="img" alt="" src='<c:url value="/static/file/${video.poster }"/>'>
									<input   class="form-control" type="file" name="poster" accept="image/*">
								</div>
							</div>
							<div class="col-sm-8">
								<label for="">YouTube ID</label> <input class="form-control"
									type="text" name="idytb" value="${video.id }"> 
									<label for="">Video title</label>
								<input value="${video.title }" class="form-control" type="text" name="title"> 
								<label
									for="">Views count</label> <input class="form-control"
									type="text" name="views" value="${video.views }">
									
								
								<div class="chk" style="display: flex;">
								
									<div class="form-check" style="margin-right: 20px;">
										<c:if test="${video.active }"><input  class="form-check-input" type="radio" name="active" checked="checked"  value="true"> </c:if>
										<c:if test="${video.active == false}"><input  class="form-check-input" type="radio" name="active"  value="true"> </c:if>
										<label class="form-check-label" for="exampleRadios2"> ACTIVE </label>
									</div>
									<div class="form-check">
										<c:if test="${video.active }"><input class="form-check-input " type="radio"
											name="active" id="in" value="false" ></c:if>
										<c:if test="${video.active ==false }"><input class="form-check-input " type="radio"
											name="active" id="in" value="false" checked="checked" ></c:if>
										<label class="form-check-label" for="exampleRadios2">
											INACTIVE </label>
									</div>
								</div>

							</div>
						</div>
						<br>
						<div class="col-sm-12">
							<h5>Description</h5>
							<textarea  id="my-textarea" class="form-control" name="description" rows="3">${video.description }</textarea>

						</div>
						<div class="col-sm-11 text-right btn-sub">
							<button formaction="/Java4_ASM_PC00653/create" class="btn btn-primary">Create</button>
							<button formaction="/Java4_ASM_PC00653/updata" class="btn btn-primary">Updata</button>
							<button formaction="/Java4_ASM_PC00653/delete" class="btn btn-primary">Delete</button>
							<button formaction="/Java4_ASM_PC00653/admin/all-video" class="btn btn-primary">Reset</button>
						
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
								<button class="btn btn-secondary mr-4" type="button">|<</button>
								<button class="btn btn-secondary mr-4" type="button"><<</button>
								<button class="btn btn-secondary mr-4" type="button">>></button>
								<button class="btn btn-secondary mr-4" type="button">>|</button>
							</div>
						</div>
					</caption>
					<thead class="thead-light">
						<tr>
							
							<th>Youtube ID</th>
							<th>Video Title</th>
							<th>View count</th>
							<th>Status</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
					
					<c:forEach items="${videos }" var="video">
					<c:url var="urlEdit" value="/edit">
						<c:param name="id" value="${video.id }"></c:param>
					</c:url>
						<tr>
							
							<td>${video.id }</td>
							<td>${video.title }</td>
							<td><span class="badge badge-info">${video.views }</span></td>
							<c:if test="${video.active ==true }"><td>Active <i class="fa fa-check" aria-hidden="true"></i></td></c:if>
							<c:if test="${video.active ==false }"><td>Inactive <i class="fa fa-check" aria-hidden="true"></i></td></c:if>							
							<td><a href="${urlEdit }">Edit</a></td>
 						</tr>
 						
					</c:forEach>
						
						
					</tbody>

				</table>
			</div>
		</div>

	</div>
	
	
</body>

</html>