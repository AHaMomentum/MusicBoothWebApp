<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<style><%@include file="/WEB-INF/extstyle.css"%></style>
<title>MusicBooth Confirmation</title>
</head>
<header> 
	<img id="logo" src="${pageContext.request.contextPath}/media%20content/Logo%2326547C.png" alt="Here is the dark red coloured MusicBooth logo pictured. It consists of the word MusicBooth,
	the treble clef forming into the M of the word music and the alto clef being the b of booth.">
</header>
<body class="body">
<div class=container>
	<div class="item">
	<input type="hidden" id="Booking" value="${Booking}" />
	<input type="hidden" id="verifyAdd" value="${verifyAdd}" />
	</div>
	<div class="item">
	<form action=${pageContext.request.contextPath}/CheckInCheckOut method="get" class="form">
		<h3> You're actions were successful! </h3>
		<p> Please keep your Booking-ID with you in order to use all functions of MusicBooth and to be identified. <br> Thank you very much for using MusicBooth! </p>
		<label for="action"> Your Booking-ID: </label><input type="text" name="action" value="${action}" />
		<input type="text" name="secondVariable" value="${secondVariable}" />
		<input class="Button" type="submit" name="Return to Home" Value="Return to Home"/>
	</form>
	</div>
</div>
</body>
<footer>
	<ul id="navList">
  		<li id="nav"><a href="index.jsp">Start</a></li>
  		<li id="nav"><a href="newAppointment.jsp">Booking Interface</a></li>
	</ul>
</footer>
</html>