
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
 <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>Thống Kê</title>
<style><%@include file="/static/bootstrap/css/bootstrap.min.css"%></style>
	<style><%@include file="/static/css/admin.css"%></style>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

</head>

<body>
	<div class="container">
		<jsp:include page="/views/admin/admin-menu.jsp"></jsp:include>



		<ul class="nav nav-tabs" id="myTab" role="tablist">
			<li class="nav-item"><a class="nav-link active" id="home-tab"
				data-toggle="tab" href="#favorites" role="tab" aria-controls="home"
				aria-selected="true">Favorites</a></li>
			<li class="nav-item"><a class="nav-link" id="profile-tab"
				data-toggle="tab" href="#user" role="tab" aria-controls="profile"
				aria-selected="false">Favorite User </a></li>
			<li class="nav-item"><a class="nav-link" id="profile-tab"
				data-toggle="tab" href="#share" role="tab" aria-controls="profile"
				aria-selected="false">Share Friends</a></li>

		</ul>

		<div class="tab-content" id="myTabContent">
			<div class="tab-pane fade show active" id="favorites" role="tabpanel"
				aria-labelledby="home-tab">
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
							<th>Video Title</th>
							<th>Favorite Count <i class="fa fa-heart"
								style="color: rgb(255, 0, 0);" aria-hidden="true"></i></th>
							<th>Latest Date</th>
							<th>Oldest Date</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="f" items="${favorite }">
						<tr>
							<td>${f.gr }</td>
							<td>${f.likes }</td>
							<td>${f.newest }</td>
							<td>${f.oldest }</td>
						</tr>
						</c:forEach>
						
					</tbody>

				</table>
			</div>

			<div class="tab-pane fade" id="share" role="tabpanel"
				aria-labelledby="home-tab">
				<div class="row">
					<div class="col-sm-12 text-center">
						<h3>TITLE</h3>
						<select onchange="getByShare(this.value)" class="cbo-video  text-white bg-secondary" name="" id="">
							<option   value="null">--Chon Video--</option>
							<c:forEach var="f" items="${favorite }">
								<option value="${f.videoID }">${f.gr }</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<table class="table table-light table-hover">

					<thead class="thead-light">
						<tr>	
							<th>Sender Name</th>
							<th>Sender Email</th>
							<th>Receiver Email</th>
							<th>Sent Date</th>
						</tr>
					</thead>
					<tbody id="share-table">
						
					</tbody>

				</table>
			</div>

			<div class="tab-pane fade" id="user" role="tabpanel"
				aria-labelledby="home-tab">
				<div class="row">
					<div class="col-sm-12 text-center">
						<h3>TITLE</h3>
						<select onchange="getByUser(this.value)" class="  cbo-video  text-white bg-secondary" name="" id="cboUserFav">
							<option   value="null">--Chon Video--</option>
							<c:forEach var="f" items="${favorite }">
								<option value="${f.videoID }">${f.gr }</option>
							</c:forEach>
							
							
						</select>
					</div>
				</div>
				<table class="table table-light table-hover">

					<thead class="thead-light">
						<tr>
							
							<th>User name</th>
							<th>Full name</th>
							<th>Email</th>
							<th>Favorite date</th>
						</tr>
					</thead>
					<tbody id="userfav">
						<c:forEach var="u" items="${listF }">
						<tr>
							<td>${u.userID }</td>
							<td>${u.fullName }</td>
							<td>${u.email }</td>
							<td>${u.day }</td>
						</tr>
						</c:forEach>
						
						
					</tbody>

				</table>
			</div>
		</div>


	</div>
	
	
	  <script type="text/javascript" src="<c:url value = '/static/js/report.js' />"></script>
</body>

</html>