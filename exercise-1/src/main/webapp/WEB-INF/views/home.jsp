<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Trang chủ</title>
	<!-- Import Boostrap css, js, font awesome here -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
	<link href="https://use.fontawesome.com/releases/v5.0.4/css/all.css" rel="stylesheet">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js">
	</script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js">
	</script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
	<link href="./css/style.css" rel="stylesheet">
	<!-- <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"> -->
</head>

<body>
	<!-- Navigation -->
	<nav class="navbar navbar-expand-md navbar-light bg-light sticky-top">
		<div class="container-fluid">
			<div class="pl-5">
				<button type="button" class="btn btn-primary">Đăng ký</button>
				<button type="button" class="btn btn-secondary">Đăng nhập</button>
			</div>
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item">
						<a class="nav-link" href="#">Điện thoại</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="#">Laptop</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="#">PC-Linh kiện</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="#">Phụ kiện</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="#">Hàng gia dụng</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="#">Máy cũ giá rẻ</a>
					</li>
					<li class="nav-item mr-5 ml-3">
						<a href="#" class="nav-link" data-toggle="tooltip" title="Giỏ hàng">
							<i class="fa fa-shopping-cart" style="font-size:36px;color:black"></i>
						</a>
					</li>
				</ul>
			</div>
		</div>
	</nav>
	<!-- Carousel -->
	<div id="slides" class="carousel slide  mb-5 mt-5" data-ride="carousel">
		<ul class="carousel-indicators">
			<li data-target="#slides" data-slide-to="0" class="active"></li>
			<li data-target="#slides" data-slide-to="1"></li>
			<li data-target="#slides" data-slide-to="2"></li>
			<li data-target="#slides" data-slide-to="3"></li>
		</ul>
		<div class="carousel-inner">
			<div class="carousel-item active">
				<img src="./images/slide-1.jpg">
			</div>
			<div class="carousel-item">
				<img src="./images/slide-2.jpg">
			</div>
			<div class="carousel-item">
				<img src="./images/slide-3.webp">
			</div>
			<div class="carousel-item">
				<img src="./images/slide-4.webp">
			</div>
		</div>
	</div>
	<div class="container-fluid padding">
		<div class="row welcome text-center text-danger mb-5 mt-5">
			<div class="col-12">
				<h1 class="display-4">Danh mục sản phẩm</h1>
			</div>
			<!-- Horizontal Rule -->
			<hr>
		</div>
	</div>
	<div class="container-fluid padding">
		<div class="row text-center padding">
			<div class="col-xs-12 col-sm-6 col-md-3 ">
				<img src="./images/icon-houseware.jpg" height="50">
				<p>Hàng gia dụng</p>
			</div>
			<div class="col-xs-12 col-sm-6 col-md-3 ">
				<img src="./images/icon-laptop.jpg" height="50">
				<p>Hàng gia dụng</p>
			</div>
			<div class="col-xs-12 col-sm-6 col-md-3 ">
				<img src="./images/icon-mobile.jpg" height="50">
				<p>Hàng gia dụng</p>
			</div>
			<div class="col-xs-12 col-sm-6 col-md-3 ">
				<img src="./images/icon-pc.jpg" height="50">
				<p>Hàng gia dụng</p>
			</div>
			<div class="col-xs-12 col-sm-6 col-md-3 ">
				<img src="./images/icon-smart.jpg" height="50">
				<p>Hàng gia dụng</p>
			</div>
			<div class="col-xs-12 col-sm-6 col-md-3 ">
				<img src="./images/icon-smartwatch.jpg" height="50">
				<p>Hàng gia dụng</p>
			</div>
			<div class="col-xs-12 col-sm-6 col-md-3 ">
				<img src="./images/icon-tablet.jpg" height="50">
				<p>Hàng gia dụng</p>
			</div>
			<div class="col-xs-12 col-sm-6 col-md-3 ">
				<img src="./images/icon-tcdm.jpg" height="50">
				<p>Hàng gia dụng</p>
			</div>
		</div>
		<hr class="my-4">
	</div>
	<div id="emoji" class="collapse">
		<div class="container-fluid padding">
			<div class="row text-center">
				<div class="col-sm-6 col-md-3">
					<img class="gif" src="./images/gif/blinkEyes.gif" width="100" height="100">
				</div>
				<div class="col-sm-6 col-md-3">
					<img class="gif" src="./images/gif/blinkGirl.gif" width="100" height="100">
				</div>
				<div class="col-sm-6 col-md-3">
					<img class="gif" src="./images/gif/faceHaha.gif" width="100" height="100">
				</div>
				<div class="col-sm-6 col-md-3">
					<img class="gif" src="./images/gif/haha.gif" width="100" height="100">
				</div>
			</div>
		</div>
	</div>
	<div class="container-fluid padding">
		<div class="row welcome text-center text-danger mb-5 mt-5">
			<div class="col-12">
				<h1 class="display-4">Khuyến mãi hot</h1>
			</div>
		</div>
	</div>
	<div class="container-fluid padding">
		<div class="row padding">
		<c:forEach items="${products }" var="item">
		<div class="col-md-3 mb-3">
				<div class="card text-center .bg-light" data-toggle="tooltip" title="${item.name }">
					<div class="card-body">
						<img class="card-img-top mb-5" src="./images/${item.image }">
						<h4 class="card-title">${item.name }</h4>
						<p class="card-text">${item.price } USD</p>
						<a href="#" class="btn btn-outline-secondary">Mua hàng</a>
					</div>
				</div>
			</div>
		</c:forEach>
		</div>
	</div>
	<div class="container-fluid padding mt-5 mb-5">
		<div class="row padding">
			<div class="col-lg-6 mx-auto d-block">
				<img src="./images/title-des.jpg" class="img-fluid">
			</div>
		</div>
		<hr class="my-4">
	</div>
	<div class="container-fluid padding  mt-5 mb-5">
		<div class="row text-center padding">
			<div class="col-12">
				<h2 class="text-danger">Liên lạc với chúng tôi</h2>
			</div>
			<div class="col-12 social padding">
				<a href="#"><i class="fab fa-facebook"></i></a>
				<a href="#"><i class="fab fa-google-plus-g"></i></a>
				<a href="#"><i class="fab fa-instagram"></i></a>
				<a href="#"><i class="fab fa-youtube"></i></a>
			</div>
		</div>
	</div>
	<footer>
		<div class="container-fluid padding bg-dark text-white">
			<div class="row text-center">
				<div class="col-md-4">
					<hr class="light">
					<p>Tư vấn mua hàng (Miễn phí)</p>
					<p>1800 6601 (Nhánh 1)</p>
					<p>Hỗ trợ kỹ thuật</p>
					<p>1800 6601 (Nhánh 2)</p>
				</div>
				<div class="col-md-4">
					<hr class="light">
					<h5>Giờ làm việc</h5>
					<hr class="light">
					<p>Thứ hai-Chủ nhật: 8:00 - 21:00</p>
				</div>
				<div class="col-md-4">
					<hr class="light">
					<h5>Hệ thống cửa hàng</h5>
					<hr class="light">
					<p>Chính sách đổi trả</p>
					<p>Chính sách trả góp</p>
					<p>Hướng dẫn mua trả góp</p>
				</div>
				<div class="col-12">
					<hr class="light-100">
					<h5>&copy; 2007 - 2021 Công Ty Cổ Phần Bán Lẻ Kỹ Thuật Số FPT </h5>
				</div>
			</div>
		</div>
	</footer>
</body>
<script>
	$(document).ready(function () {
		$('[data-toggle="tooltip"]').tooltip();
	});
</script>

</html>