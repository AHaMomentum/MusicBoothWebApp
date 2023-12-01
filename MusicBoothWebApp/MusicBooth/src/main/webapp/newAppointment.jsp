<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title> MusicBooth Bookings </title>
	<style><%@include file="/WEB-INF/extstyle.css"%></style>
</head>
	<header>
	 <img id="logo" src="${pageContext.request.contextPath}/media%20content/Logo%2326547C.png" alt="Here is the dark red coloured MusicBooth logo pictured. It consists of the word MusicBooth,
	the treble clef forming into the M of the word music and the alto clef being the b of booth.">
	</header>
<body>
<div class="container">
	<div class="item">
	<h1 class="Head"> New Booking </h1>
		<form action=${pageContext.request.contextPath}/CheckInCheckOut method="post" class="form" id="indexForm"> <!-- Customer.java gets the input of the form -->
			<p class=Input>
		 	<input id="lName" type="text" placeholder="Last Name" name="lName" required/>
		 	<input id="fName" type="text" placeholder="First Name" name="fName" required/> 
		 	<input id="custEMail" type="text" placeholder="Email" name="custEMail" />
		 	<input id="dateTime" type="date" name="dateTime"/>
		 	<label for="numberOfPeople"> How many People: </label> <input id="numberOfPeople" type="number" name="numberOfPeople"  min=1 oninput="validity.valid||(value='');" required />
		 	<label for="durationWish"> Practice duration: </label> <input id="durationWish" type="number" name="durationWish"  min=1 max=6 oninput="validity.valid||(value='');" required /> 
		 	<label for="pianoInRoom"> Piano in the Room </label> <input id="pianoInRoom" type="radio" name="pianoInRoom" />
		 	Accessibility options:
		 	<label for="wheelchairAccessibility"> Wheelchair Accessible or Ground floor </label> <input id="wheelchairAccessibility" type="radio" name="wheelchairAccessibility"/>
		 	<label for="brailleAid"> Braille or White Cane Aids </label> <input id="brailleAid" type="radio" name="brailleAid"/>
		 	<br>
		 	<input class="Button" type="submit" name="Book" value="Book" />
			</p>
		</form>
	</div>
	<div class="item">
	<h1 class="Head"> Change Booking </h1>
	<p> Please be aware that you can only change your name and email address. For further booking changes, please delete your booking and then book again. Thank you, for your understanding! </p>
	<form action=${pageContext.request.contextPath}/Booking method="post" class="form" id="indexForm">
		<input id=changeID type="text" placeholder="Booking-ID" name="changeID" required/>
		<input id=changelName type="text" placeholder="Last Name (new)" name="changelName" required/>
		<input id=changefName type="text" placeholder="First Name (new)" name="changefName" required/>
		<input id=changeEMail type="text" placeholder="Email (new)" name="changeEMail" required/>
		<input class="Button" type="submit" name="Change Booking" value="Change Booking" />
	</form>
	</div>
</div>	
<div class="container">
	<div class="item">
	<h1 class="Head"> Get Booking </h1>
	<form action=${pageContext.request.contextPath}/Booking method="post" class="form" id="indexForm">
		<input id=bookingID type="text" placeholder="Booking-ID" name="bookingID" required/>
		<input class="Button" type="submit" name="Get Booking" value="Get Booking" />
	</form>
	</div>
	<div class="item">
	<h1 class="Head"> Delete Booking </h1>
	<form action=${pageContext.request.contextPath}/Booking method="post" class="form" id="indexForm">
		<input id=deleteID type="text" placeholder="Booking-ID" name="deleteID" required/>
		<input class="Button" type="submit" name="Delete Booking" value="Delete Booking" />
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