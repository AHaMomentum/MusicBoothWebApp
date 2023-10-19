<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title> MusicBooth CheckIn</title>
	<style><%@include file="/WEB-INF/extstyle.css"%></style>
</head>
<header> <img id="logo" src="${pageContext.request.contextPath}/media%20content/logo%2370161E.PNG" alt="Here is the dark red coloured MusicBooth logo pictured. It consists of the word MusicBooth,
	the treble clef forming into the M of the word music and the alto clef being the b of booth.">
</header>
<body>
	<h3> Welcome! </h3>
	<form action=${pageContext.request.contextPath}/Customer method="get"> <!-- Customer.java gets the input of the form -->
		<p class=Input> Last Name: <input id="lName" type="text" name="lName" />
		 First Name: <input id="fName" type="text" name="fName" /> 
		 E-Mail: <input id="custEMail" type="text" name="custEMail" /> </p>
		<input class="Button" type="submit" value="Continue" />
	</form>
</body>
</html>