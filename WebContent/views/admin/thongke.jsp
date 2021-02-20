<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">

<title>Thống Kê</title>
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
						<span class="badge badge-info">2</span> Videos
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
							<th></th>
							<th>Video Title</th>
							<th>Favorite Count <i class="fa fa-heart"
								style="color: rgb(255, 0, 0);" aria-hidden="true"></i></th>
							<th>Latest Date</th>
							<th>Oldest Date</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>1</td>
							<td>HOW TO LEAN JAVA 4</td>
							<td>1222</td>
							<td>12/12/2020</td>
							<td>01/01/2021</td>
						</tr>
						<tr>
							<td>1</td>
							<td>HOW TO LEAN JAVA 5</td>
							<td>4000</td>
							<td>12/12/2020</td>
							<td>01/01/2021</td>
						</tr>
					</tbody>

				</table>
			</div>

			<div class="tab-pane fade" id="share" role="tabpanel"
				aria-labelledby="home-tab">
				<div class="row">
					<div class="col-sm-12 text-center">
						<h3>TITLE</h3>
						<select class="cbo-video  text-white bg-secondary" name="" id="">

							<option value="">HOW TO LEAN JAVA 4</option>
							<option value="">HOW TO LEAN JAVA 5</option>
						</select>
					</div>
				</div>
				<table class="table table-light table-hover">

					<thead class="thead-light">
						<tr>
							<th></th>
							<th>Sender Name</th>
							<th>Sender Email</th>
							<th>Receiver Email</th>
							<th>Sent Date</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>1</td>
							<td>Lưu Trường Tá</td>
							<td>truongta@gmail.com</td>
							<td>fpoltya@gmail.com</td>
							<td>01/01/2021</td>
						</tr>
						<tr>
							<td>2</td>
							<td>Lưu Tá Trường</td>
							<td>truongta@gmail.com</td>
							<td>fpoltya@gmail.com</td>
							<td>01/01/2021</td>
						</tr>
					</tbody>

				</table>
			</div>

			<div class="tab-pane fade" id="user" role="tabpanel"
				aria-labelledby="home-tab">
				<div class="row">
					<div class="col-sm-12 text-center">
						<h3>TITLE</h3>
						<select class="cbo-video  text-white bg-secondary" name="" id="">

							<option value="">HOW TO LEAN JAVA 4</option>
							<option value="">HOW TO LEAN JAVA 5</option>
						</select>
					</div>
				</div>
				<table class="table table-light table-hover">

					<thead class="thead-light">
						<tr>
							<th></th>
							<th>User name</th>
							<th>Full name</th>
							<th>Email</th>
							<th>Favorite date</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>1</td>
							<td>Truongta11</td>
							<td>Lưu Trường Tá</td>
							<td>truongta@gmail.com</td>
							<td>01/01/2021</td>
						</tr>
						<tr>
							<td>2</td>
							<td>Truongta11</td>
							<td>Lưu Trường Tá</td>
							<td>truongta@gmail.com</td>
							<td>01/01/2021</td>
						</tr>
					</tbody>

				</table>
			</div>
		</div>


	</div>
</body>

</html>