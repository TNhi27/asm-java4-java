<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    
    <title>admin</title>
    
   	<style><%@include file="/static/bootstrap/css/bootstrap.min.css"%></style>
	<style><%@include file="/static/css/admin.css"%></style>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	
	
</head>

<body>
	<div class="container">
		<jsp:include page="/views/admin/admin-menu.jsp"></jsp:include>

		<div class="row">
			<div class="col-sm-6"">
				<iframe width=" 100%" height="280"
					src="https://www.youtube.com/embed/0OOsoZXm2R4" frameborder="0"
					allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
					allowfullscreen></iframe>
				<iframe width="100%" height="280"
					src="https://www.youtube.com/embed/UpcwjQtEfKI" frameborder="0"
					allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
					allowfullscreen></iframe>
			</div>
			<div class="col-sm-6">
				<h4 class="title-p text-center bg-info">Giới Thiệu Chung</h4>
				<ul>
					<li>Liên Hệ tài trợ/ Quảng cáo: </li>
					<li>Phòng khách hàng: 0905942902 (Mr Tài) – 0968759739 (Ms Thư)</li>
					<li>Mail: faptvgroup@gmail.com</li>
					<li>Fanpage: https://facebook.com/FAPtivi</li>
					<li>Website: http://faptvmedia.com/</li>
				</ul>
				FAPTV được thành lập vào ngày 14/02/2014 bởi các thành viên:
				Đạo diễn Trần Đức Viễn, Rapper Thái Vũ (Black Bi),
				AT117 (Tài trợ về thiết bị) và người mẫu Ribi Sachi 
				với niềm đam mê về nghệ thuật, mong muốn tạo ra điều 
				khác biệt so với các nội dung video trên các mạng xã hội.
				Năm 2014 cũng là thời điểm mạng xã hội Youtube phát triển mạnh tại Việt 
				Nam, các tiểu phẩm của nhóm ban đầu rất may mắn được cộng đồng mạng đón nhận, 
				và thật sự tạo ra dấu ấn riêng khi Producer Trần Long, Vinh Râu cùng Huỳnh Phương 
				tham gia trong sitcom Cơm Nguội. Nhóm hy vọng kênh FAPTV là nơi mọi người có thể 
				truy cập để giải trí sau những giờ làm việc để giải toả những căng thẳng, mệt mỏi 
				bằng những tình huống hài về các cuộc sống đời thường được kể theo cách riêng, dí 
				dỏm và hài hước của FAPTV.
			</div>
		</div>

		<!--footer-->
		<div class="row footer">
			<div class="container">
				<p class="copyright-text">Copyright &copy; 2021 All Rights
					Reserved by PC00653</p>
			</div>

		</div>
	</div>
</body>

</html>