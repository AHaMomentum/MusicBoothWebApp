package bookingPackage;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import roomPackage.Room;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import customerPackage.Customer;


public class Booking extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Room RoomClass = new Room();
	public boolean CS1 = Room.CS1; 
    public boolean CS2 = Room.CS2;
    public boolean TR1 = Room.TR1; 
    public boolean TR2 = Room.TR2; 
    public boolean PS1 = Room.PS1; 
    public boolean PS2 = Room.PS1;
    public String BookingInformation;
    public String BookingInformation1;
    public String BookingInformation2;
    public String BookingInformation3;
    public String BookingInformation4;
    public String BookingInformation5;
    public String BookingInformation6;
    ArrayList<String> rooms = Room.roomList;
    ArrayList<Room> arrayRoom = Room.arrayRooms;
       
   
    public Booking() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String Error = "No Room could be found"; // to be used below (line 67)
		
		if (CS1 = true) { //if it the boolean CS1 is true (the user clicked CityMusicSchool1), then the variable BookingInformation will the first item in the Arraylist, i.e., CityMusicSchool1. This is the same with the following variables. 
			BookingInformation = rooms.get(0);
		} else if (CS2 = true) {
			BookingInformation = rooms.get(1);
		} else if (TR1 = true) {
			BookingInformation = rooms.get(2);
		} else if (TR2 = true) {
			BookingInformation = rooms.get(3);
		} else if (PS1 = true) {
			BookingInformation = rooms.get(4);
		} else if (PS2 = true) {
			BookingInformation = rooms.get(5);
		} else request.setAttribute("finalBookingInformation", Error); //if none of the previous booleans is true, i.e., no room was selected, then an Error Message is displayed that as set at the top of the Method. 
		
		request.setAttribute("finalBookingInformation", BookingInformation); //the variable with the chosen Room is then forwarded to the checkOut.jsp and displayed there.  
		RequestDispatcher rs = request.getServletContext().getRequestDispatcher("/checkOut.jsp");
		rs.forward(request,response); // So far, either the last, or the first Room is displayed, no matter what I choose.
		
		
		/** THIS IS AN ALTERNATIVE TECHNIQUE THAT I TRIED BECAUSE MY ATTEMPT DID NOT WORK: 
		if (CS1 = true) {
			BookingInformation1 = rooms.get(0);
		} else if (CS2 = true) {
			BookingInformation2 = rooms.get(1);
		} else if (TR1 = true) {
			BookingInformation3 = rooms.get(2);
		} else if (TR2 = true) {
			BookingInformation4 = rooms.get(3);
		} else if (PS1 = true) {
			BookingInformation5 = rooms.get(4);
		} else if (PS2 = true) {
			BookingInformation6 = rooms.get(5);
		} else request.setAttribute("finalBookingInformation", Error);
		
		BookingInformation = BookingInformation1 + BookingInformation2 + BookingInformation3 + BookingInformation4 + BookingInformation5 + BookingInformation6;
		request.setAttribute("finalBookingInformation", BookingInformation);
		**/
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**	
		if (BookingInformation.equals(rooms.get(0))) {
			arrayRoom.get(0).set(" Upperstreet 1, 100101 thisCity ", 3, 2 , 4 , true, false, true, " citymusic@citymail.city ", true);
		} else if (BookingInformation.equals(rooms.get(1))) {
			arrayRoom.get(1).set(" Upperstreet 1, 100101 thisCity ", 5, 4, 1, false, false, false, " citymusic@citymail.city ", true);
		} else if (BookingInformation.equals(rooms.get(2))) {
			arrayRoom.get(2).set(" Edgestreet 96, 100122 thisCity ", 9, 3, 16,  true, true, true, " playce2be@theatre.contact ", true);
		} else if (BookingInformation.equals(rooms.get(3))) {
			arrayRoom.get(3).set(" Edgestreet 96, 100122 thisCity ", 2, 6, 2, false, true, true," playce2be@theatre.contact ", true);
		} else if (BookingInformation.equals(rooms.get(4))) {
			arrayRoom.get(4).set(" Chop Way, 100109 thisCity ", 6, 2, 2, true, false, false, " musicisfun@musicschool.org ", true);
		} else if (BookingInformation.equals(rooms.get(5))) {
			arrayRoom.get(5).set(" Chop Way, 100109 thisCity ", 1, 3, 1, true, false, false, " musicisfun@musicschool.org ", true);
		}
		**/
		response.sendRedirect(request.getContextPath() + "/index.jsp"); //redirects to the Homepage after clicking "Confirm" on the checkOut.jsp page.
	}

}
