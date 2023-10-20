<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title> MusicBooth Booking </title>
	<style><%@include file="/WEB-INF/extstyle.css"%></style>
</head>
<header> <img id="logo" src="${pageContext.request.contextPath}/media%20content/logo%2370161E.PNG" alt="Here is the dark red coloured MusicBooth logo pictured. It consists of the word MusicBooth,
	the treble clef forming into the M of the word music and the alto clef being the b of booth.">
</header>
<body>
	<form action=${pageContext.request.contextPath}/Room method="get"> <!-- Activate the Room Overview -->
		<input class="Activation" type="submit" value="Show Rooms" />
	</form>
	<form action=${pageContext.request.contextPath}/Room method="post"> <!-- Room.java processes the input in doPost() method -->
	<table id="roomTable"> 
		<tr>
			<th> Room Information </th>
			<th> </th>
		</tr>
		<tr>
			<td> ${CityMusicSchool1} </td>
			<td> <input id="CityMusicSchool1" type="checkbox" name="CityMusicSchool1" value="CityMusicSchool1" /> Choose </td>
		</tr>
		<tr>
			<td> ${requestScope.CityMusicSchool2} </td>
			<td> <input id="CityMusicSchool2" type="checkbox" name="CityMusicSchool2" value="CityMusicSchool2" /> Choose </td>
		</tr>
		<tr>
			<td> ${TheatreRoom1} </td>
			<td> <input id="TheatreRoom1" type="checkbox" name="TheatreRoom1" value="TheatreRoom1" /> Choose </td>
		</tr>
		<tr>
			<td> ${TheatreRoom2} </td>
			<td> <input id="TheatreRoom2" type="checkbox" name="TheatreRoom2" value="TheatreRoom2" /> Choose </td>
		</tr>
		<tr>
			<td> ${PrivateMusicSchool1} </td>
			<td> <input id="PrivateMusicSchool1" type="checkbox" name="PrivateMusicSchool1" value="PrivateMusicSchool1" /> Choose </td>
		</tr>
		<tr>
			<td> ${PrivateMusicSchool2} </td>
			<td> <input id="PrivateMusicSchool2" type="checkbox" name="PrivateMusicSchool2" value="PrivateMusicSchool2" /> Choose </td>
		</tr>
	</table>
	<input class="Button" type="submit" value="Continue" />
	</form>
