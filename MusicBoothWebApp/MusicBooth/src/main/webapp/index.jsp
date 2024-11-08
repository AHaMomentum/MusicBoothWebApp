<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title> MusicBooth CheckIn</title>
	<style><%@include file="/WEB-INF/extstyle.css"%></style>
</head>
<header> 
	<img id="logo" src="${pageContext.request.contextPath}/media%20content/Logo%2326547C.png" alt="Here is the dark red coloured MusicBooth logo pictured. It consists of the word MusicBooth,
	the treble clef forming into the M of the word music and the alto clef being the b of booth.">
</header>
<body>
<div class="container">
	<div id="leftIndexDiv" class="item">
	<h1> Welcome to MusicBooth! </h1>
	</div>
	<div id="rightIndexDiv" class="item">
		<ul id="indexList">
  			<li id="indexNav"><a href="newAppointment.jsp">Book Room</a></li>
 			<li id="indexNav"><a href="newAppointment.jsp">Get Booking</a></li>
  			<li id="indexNav"><a href="newAppointment.jsp">Change Booking</a></li>
  			<li id="indexNav"><a href="newAppointment.jsp">Delete Booking</a></li>
		</ul>
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
