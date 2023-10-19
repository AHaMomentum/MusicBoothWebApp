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
	
       
   
    public Booking() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		response.sendRedirect(request.getContextPath() + "/index.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Error = "No Room could be found";
		
		if (CS1 = true) {
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
		} else request.setAttribute("finalBookingInformation", Error);
		
		request.setAttribute("finalBookingInformation", BookingInformation);
		RequestDispatcher rs = request.getServletContext().getRequestDispatcher("/checkOut.jsp");
		rs.forward(request,response); 
		/**
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

}
