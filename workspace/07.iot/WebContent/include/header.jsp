<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>IoT</title>
<!--제이쿼리  -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<!-- Favicon-->
<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
<!-- Font Awesome icons (free version)-->
<script src="https://use.fontawesome.com/releases/v5.15.3/js/all.js"
	crossorigin="anonymous"></script>
<!-- Google fonts-->
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700"
	rel="stylesheet" type="text/css" />
<link
	href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic"
	rel="stylesheet" type="text/css" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="css/styles.css" rel="stylesheet" />
</head>
<!-- Navigation-->
<nav
	class="navbar navbar-expand-lg bg-secondary text-uppercase fixed-top"
	id="mainNav">
	<div class="container">
		<a class="navbar-brand" href="#page-top">Start Bootstrap</a>
		<button
			class="navbar-toggler text-uppercase font-weight-bold bg-primary text-white rounded"
			type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarResponsive" aria-controls="navbarResponsive"
			aria-expanded="false" aria-label="Toggle navigation">
			Menu <i class="fas fa-bars"></i>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav ms-auto">
				<li class="nav-item mx-0 mx-lg-1"><a
					class="nav-link py-3 px-0 px-lg-3 rounded" href="exam">시험보기</a></li>
				<li class="nav-item mx-0 mx-lg-1"><a
					class="nav-link py-3 px-0 px-lg-3 rounded" href="list.cu">고객관리</a></li>
				<li class="nav-item mx-0 mx-lg-1"><a
					class="nav-link py-3 px-0 px-lg-3 rounded" href="list.bo">게시판</a></li>
				<li class="nav-item mx-0 mx-lg-1">
				<c:if test="${empty logininfo}">
				<a class="nav-link py-3 px-0 px-lg-3 rounded" href="login">로그인</a>
				<a class="nav-link py-3 px-0 px-lg-3 rounded" href="join">회원가입</a>
				</c:if>
				<c:if test="${!empty logininfo}">
					<strong>${logininfo.name}</strong>님 
					<a class="nav-link py-3 px-0 px-lg-3 rounded" href="logout">로그아웃</a>
				</c:if>
				</li>
			</ul>
		</div>
	</div>
</nav>
<!-- Masthead-->
<header class="masthead bg-primary text-white text-center">
	
</header>
<!-- Portfolio Section-->
