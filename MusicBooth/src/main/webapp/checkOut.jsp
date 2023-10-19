<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title> MusicBooth | CheckOut </title>
	<style><%@include file="/WEB-INF/extstyle.css"%></style>
</head>
<header> <img id="logo" src="${pageContext.request.contextPath}/media%20content/logo%2370161E.PNG" alt="Here is the dark red coloured MusicBooth logo pictured. It consists of the word MusicBooth,
	the treble clef forming into the M of the word music and the alto clef being the b of booth.">
</header>
<body>
	<form action=${pageContext.request.contextPath}/Booking method="post">
		<input class="Activation" type="submit" value="Show Results" />
	</form>
	<form action=${pageContext.request.contextPath}/Booking method="get">
		<h3> The Room </h3>
		<p> ${finalBookingInformation} </p>
		 Click on to confirm the booking.
		 <br>
		 <br>
		 <input class="Button" type="submit" value="Confirm" />
	</form>
	<p id="termsAndConditions"> Terms and Conditions apply </p>
</body>
</html>