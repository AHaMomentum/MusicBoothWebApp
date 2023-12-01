package bookingPackage;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import roomPackage.RoomManagement;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import customerPackage.CheckInCheckOut;


public class Booking extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RoomManagement RoomClass = new RoomManagement();
    ArrayList<RoomManagement> arrayRoom = RoomManagement.arrayRooms;
    public ArrayList<String> stringRooms = RoomManagement.roomList;
    public Date booking = RoomClass.booking;
    public ArrayList<Booking> bookingList = new ArrayList<Booking>();
    public String bookingDate;
    double random = Math.random() * 49 + 1;
    public int bookingID; // the booking ID that is output for the customer;
    public String Example;
    public String CustName;
    public RoomManagement room = new RoomManagement();
    public int deleteID; //the ID that the customer enters to delete their booking;
    public int customerID; //the ID that the customer enters to get their booking;
    public int changeID; 
    public int indexBooking;
    public String BookingSearch;
    boolean verifyGet;
    boolean verifyDelete;
    public Booking BookingDeletion;
    public String BookedRoom;
    public boolean verifyAdd;  
    public String BookingError;
    public String ChangedBooking;
    public Booking BookingGet;
    Scanner scanner = new Scanner (System.in);
    public boolean verifyChange;
	public String ChangeLName;
	public String ChangeFName;
	public String ChangeEMail;
	public String GetOutput;
	public String BookingRoomGet;
	public String StringRepresentation = RoomManagement.StringRepresentation;
   
    public Booking() {
        super();
        // TODO Auto-generated constructor stub
    }
    

	
	public Booking(RoomManagement room, String bookingDate, String CustName) {
		//constructor
		this.room = room;
		this.CustName = CustName;
		this.bookingDate = bookingDate;
	
	}
	
	public void setRoom(RoomManagement room) {
		//setter
		this.room = room;
	}
	
	public RoomManagement getRoom() {
		//getter
		return room;
	}
	
	
	public String getCustName() {
		//getter
		return CustName;
	}
	
	public void setCustName(String CustName) {
		//setter
		this.CustName = CustName;
	}
	
	public String getBookingDate() { 
		//getter
		return bookingDate;
	}
	
	private void setBookingDate(String bookingDate) {
		//setter
		this.bookingDate = bookingDate;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		// the method is used to manage and process multiple forms from different jsp's. Therefore, there are if conditions and nested branches. The first step in this method is to differentiate between the four calling forms and assign them variables:  
		//"getBooking", "deleteBooking", "changeBooking", "addBoking". Again the parameters are printed out for control purposes only. If either one of the variables is not null (they are null by default if not selected, only one can be selected at a time),
		// it will trigger the corresponding reaction. 
		//For getBooking that is that fetching of the parameters in the form and their assignment to constants, invoking the method getBooking(). If the boolean result verifGet of the method getBooking() is true, the constants customerID and GetOutput are set 
		//as Attributes and forwarded to confirmation.jsp. If the boolean is false, an alert with a message is triggered that redirects the client.
		//For deleteBooking it is too fetching the parameters of the corresponding form and assigning them to constants. Then, the method deleteBooking() is invoked. If the boolean result verifyDelete is true, the constant BookingDeletion is removed from bookingList,
		//A message informing about the deletion and the deleteID are set as Attributes and forwarded to confirmation.jsp and the bookingList after the deletion is printed out in the console. If the boolean is false, an alert with a message is triggered that redirects the client.
		// For changeBooking all parameters are fetched from the from and assigned to constants too, after, the method changeBooking() is invoked. If the returned boolean verifyChange is true, the new Booking and the changeID are set as Attributes for
		// confirmation.jsp. If the boolean is false, an alert with a message is triggered that redirects the client.
		//For addBooking all parameters are fetched from the from, too. Then the method addBooking is invoked. If the returned boolean verifyAdd is true, the new bookingID and further information are set as attributes forwarded to confirmation.jsp. 
		// If the boolean is false, an alert with a message is triggered that redirects the client.
		
		String getBooking = request.getParameter("Get Booking");
		System.out.println("Get Booking equals: " + getBooking);
		String deleteBooking = request.getParameter("Delete Booking");
		System.out.println("Delete Booking equals: " + deleteBooking);
		String changeBooking = request.getParameter("Change Booking");
		System.out.println(changeBooking);
		String addBooking = request.getParameter("Add Booking");
		System.out.println("Add Booking equals: " + addBooking);
		
		if (getBooking != null) { 
			
			String stringID = request.getParameter("bookingID");
			customerID = Integer.parseInt(stringID);
			System.out.println("This is the customerID: " + customerID);
			getBooking(customerID);
			
			if (verifyGet == true) {
				request.setAttribute("action", customerID);
				request.setAttribute("secondVariable", GetOutput);
				RequestDispatcher rs = request.getServletContext().getRequestDispatcher("/confirmation.jsp");
				rs.forward(request,response); 
			} else if (verifyGet == false) {
				PrintWriter out = response.getWriter();
				   out.println("<script type=\"text/javascript\">");
				   out.println("alert('Our apologies, no Booking corresponding with the entered ID could be found. Please retry!');");
				   out.println("location='newAppointment.jsp';");
				   out.println("</script>");
			}
			
		}
		if (deleteBooking != null) {
			
			String deleteString = request.getParameter("deleteID");
			deleteID = Integer.parseInt(deleteString);
			deleteBooking(deleteID);
			
			if (verifyDelete == true) {
				System.out.println("Booking to be deleted: " + BookingDeletion);
				bookingList.remove(BookingDeletion);
				System.out.println("BookingList after deletion: " + bookingList);
				String Deletion = "Your Booking was deleted";
				request.setAttribute("action", deleteID);
				request.setAttribute("secondVariable", Deletion);
				RequestDispatcher rs = request.getServletContext().getRequestDispatcher("/confirmation.jsp");
				rs.forward(request,response); 
			} else if ( verifyDelete == false) {
				PrintWriter out = response.getWriter();
				   out.println("<script type=\"text/javascript\">");
				   out.println("alert('Our apologies, no Booking corresponding with the entered ID could be found. Please retry!');");
				   out.println("location='newAppointment.jsp';");
				   out.println("</script>");
			}
			
		}
		if (changeBooking != null) {
			//First, all Parameters from the corresponding jsp form are fetched and assigned to a constant, then the method getBooking(int) is invoked. depending on the results of the method, different if statements are called. If verifyChange is true, 
			
			String changeString = request.getParameter("changeID");
			changeID = Integer.parseInt(changeString);
			ChangeLName = request.getParameter("changelName");
			ChangeFName = request.getParameter("changefName");
			ChangeEMail = request.getParameter("changeEMail");
			changeBooking(changeID, ChangeLName, ChangeFName, ChangeEMail);
			if (verifyChange == true) {
				System.out.println("Customer Information changed");
				request.setAttribute("action", changeID);
				request.setAttribute("secondVariable", ChangedBooking);
				RequestDispatcher rs = request.getServletContext().getRequestDispatcher("/confirmation.jsp");
				rs.forward(request,response); 
			} else {
				PrintWriter out = response.getWriter();
				   out.println("<script type=\"text/javascript\">");
				   out.println("alert('Our apologies, no booking with the corresponding ID could be found. Please retry');");
				   out.println("location='index.jsp';");
				   out.println("</script>");
			}
			
		}
		if (addBooking != null) {
			//First, all Parameters from the corresponding jsp form are fetched and assigned to a constant. Then, the method addBooking(Room, String, String) is invoked. IDepending on the resulting boolean, a different if condition is started: id verifyAdd is true, 
			//The bookingID is set an attribute and displayed in the jsp, to wich the servlet fowards then. If verify add is false, the PrintWriter will open a popUp window explaining that he booking process failed and that the customer has to retry. It then
			// redirects to the jsp bookingInterface.
			
			BookedRoom = request.getParameter("finalBookingInformation");
			System.out.println("Booked Room: " + BookedRoom);
			bookingDate = request.getParameter("bookingTimePost");
			System.out.println("BookingDate: " + bookingDate);
			CustName = request.getParameter("CustomerInformation");
			System.out.println("CustomerInformations: " + CustName);
			addBooking(BookedRoom, CustName, bookingDate);
			
			if (verifyAdd == true) {
				String ReturnHome = "You can now return Home";
				request.setAttribute("secondVariable", ReturnHome);
				request.setAttribute("action", bookingID);
				RequestDispatcher rs = request.getServletContext().getRequestDispatcher("/confirmation.jsp");
				rs.forward(request,response); 
				System.out.println("This is the bookingID: " + bookingID);
				
			} else if (verifyAdd == false) {
				request.setAttribute("bookingStatus", verifyAdd);
				request.setAttribute("Booking", BookingError);
	        	response.sendRedirect(request.getContextPath() + "/newAppointment.jsp");
				PrintWriter out = response.getWriter();
				   out.println("<script type=\"text/javascript\">");
				   out.println("alert('Our apologies, the Booking could not be completed. Please retry!');");
				   out.println("location='index.jsp';");
				   out.println("</script>");
			}
		}
	}
	
	public void addBooking(String BookedRoom2, String CustName2, String bookingDate2) {
		//In this method, a new Booking is created. This method is invoked from doPost(). If the BookedRoom, that was previously evaluated in RoomManagements doPost() method, equals any room from the RoomManagement.arrayRooms method, a new Booking is created,
		//for that Booking, the room is set the room that BookedRoom equaled, the BookingDate is set the entered booking date and the customer name is set the first, last name and email of the customer. The Booking is added to the bookingList. Via the method
		//bookingList.indexOf(newObject) the bookingID constant is assigned. Thereby, working with bookings can be made easier. Then the boolean verifyAdd is set true. If all of these actions fail, the boolean verifyAdd is set false.
		
	        if (BookedRoom.equals(RoomManagement.roomList.get(0)))  {
	        	System.out.println("BookedRoom.equalsCS1");
	            Booking CS1Booking = new Booking();
	            room = RoomManagement.arrayRooms.get(0);
	            CS1Booking.setRoom(room);
	            CS1Booking.setBookingDate(bookingDate);
	            CS1Booking.setCustName(CustName);
	            bookingList.add(CS1Booking);
	            System.out.println("This is CS1Booking: " + CS1Booking);
	            bookingID = bookingList.indexOf(CS1Booking);
	            verifyAdd = true;
	        } 
	        if (BookedRoom.equals(RoomManagement.roomList.get(1))) {
	        	System.out.println("BookedRoom.equalsCS2");
	        	Booking CS2Booking = new Booking(); 
	        	room = RoomManagement.arrayRooms.get(1);
	        	CS2Booking.setRoom(room);
	        	CS2Booking.setBookingDate(bookingDate);
	            CS2Booking.setCustName(CustName);
	        	bookingList.add(CS2Booking);
	        	System.out.println("This is CS2Booking: " + CS2Booking);
	        	bookingID = bookingList.indexOf(CS2Booking);
	        	verifyAdd = true;
	        }  
	        if (BookedRoom.equals(RoomManagement.roomList.get(2))) {
	        	System.out.println("BookedRoom.equalsTR1");
	        	Booking TR1Booking = new Booking();
	        	room = RoomManagement.arrayRooms.get(2);
	        	TR1Booking.setRoom(room);
	        	TR1Booking.setBookingDate(bookingDate);
	            TR1Booking.setCustName(CustName);
	        	bookingList.add(TR1Booking);
	        	System.out.println("This is TR1Booking: " + TR1Booking);
	        	bookingID = bookingList.indexOf(TR1Booking);
	        	verifyAdd = true;
	        }  
	        if (BookedRoom.equals(RoomManagement.roomList.get(3))) {
	        	System.out.println("BookedRoom.equalsTR2");
	        	Booking TR2Booking = new Booking();
	        	room = RoomManagement.arrayRooms.get(3);
	        	TR2Booking.setRoom(room);
	        	TR2Booking.setBookingDate(bookingDate);
	            TR2Booking.setCustName(CustName);
	        	bookingList.add(TR2Booking);
	        	System.out.println("This is TR2Booking: " + TR2Booking);
	        	bookingID = bookingList.indexOf(TR2Booking);
	        	verifyAdd = true;
	        } 
	        if (BookedRoom.equals(RoomManagement.roomList.get(4))) {
	        	System.out.println("BookedRoom.equalsPS1");
	        	Booking PS1Booking = new Booking();
	        	room = RoomManagement.arrayRooms.get(4);
	        	PS1Booking.setRoom(room);
	        	PS1Booking.setBookingDate(bookingDate);
	            PS1Booking.setCustName(CustName);
	        	bookingList.add(PS1Booking);
	        	System.out.println("This is PS1Booking: " + PS1Booking);
	        	bookingID = bookingList.indexOf(PS1Booking);
	        	verifyAdd = true;
	        }  
	        if (BookedRoom.equals(RoomManagement.roomList.get(5))) {
	        	System.out.println("BookedRoom.equalsPS2");
	            Booking PS2Booking = new Booking();
	            room = RoomManagement.arrayRooms.get(5);
	            PS2Booking.setRoom(room);
	            PS2Booking.setBookingDate(bookingDate);
	            PS2Booking.setCustName(CustName);
	            bookingList.add(PS2Booking);
	            System.out.println("This is PS2Booking: " + PS2Booking);
	            bookingID = bookingList.indexOf(PS2Booking);
	            verifyAdd = true;
	        } 
	        if ( !BookedRoom.equals(RoomManagement.roomList.get(0)) && !BookedRoom.equals(RoomManagement.roomList.get(1)) && !BookedRoom.equals(RoomManagement.roomList.get(2)) && !BookedRoom.equals(RoomManagement.roomList.get(3)) && !BookedRoom.equals(RoomManagement.roomList.get(4)) && !BookedRoom.equals(RoomManagement.roomList.get(5))) {
	        	System.out.println("Booking could not be added");
	        	verifyAdd = false; 
	        }
	        System.out.println("This is the BookingList: " + bookingList);
		}
	
		//for every element in the bookingList it is checked, whether the entered ID "changeID" equals the BookingID. If so, the Object is gotten out of the List and assigned the constant ChangedBooking. The Name ChangedCustomer is created with the newly entered
		//customer data and set as ChangedBookings Customer Name "CustName". The boolean verifyChange is then set true. If there is no Object with a matching ID, verifyChange is set false. 
	
	public boolean changeBooking(int changeID, String ChangeLName, String ChangeFName, String ChangeEMail) {
		// with this method an existing booking can be changed. Please be aware that only the customer name can be changed, like it is written in the newAppointment.jsp site. 
		// if the changeID is smaller than the size of the bookingList, this means that the booking is contained in the bookingList, as the bookingID/changeID etc. is just the index. Therefore the first step checks exactly that.
		// If it is contained, a new customer is created, and set as the customer name of the booking with the changeID index. The last step is getting the room of the booking, getting via the method getRooms() the corresponding roomList String representation and 
		// exchanging all <br> for spaces. The thereby created string room, the booking date and the new name are concatenated and assigned a constant. The boolean verifyChange is set true. If the changeID is bigger than the size of bookingList, verifyChange is false.
		if (changeID <= bookingList.size() == true) {
			System.out.println("changeID is in bookingList");
			String newCustomer = ChangeLName + " " + ChangeFName + " " + ChangeEMail;
			System.out.println("This is the new customer: " + newCustomer);
			Booking ToBeChanged = bookingList.get(changeID);
			ToBeChanged.setCustName(newCustomer);
			RoomManagement RoomforChange = ToBeChanged.room;
			String RoomChange = RoomManagement.getRooms(RoomforChange).replace(" <br> ", " ");
			ChangedBooking = RoomChange + " " +ToBeChanged.bookingDate + " "+ ToBeChanged.CustName;
			verifyChange = true;
		} else if (changeID > bookingList.size() == true) {
			verifyChange = false;
		}
		return verifyChange;
	}

	
	public Booking deleteBooking(int deleteID) {
		// This method deletes the booking which ID is entered. That however leaves a 'gap' in the arrayList, that is fairly fast closed, thereby changing indices of the other Bookings-- I do not recommend deleting a Booking. 
		// In this method I tried to loop more because I felt I did too many if conditions, but then I liked the if condition too much. So the following applies for all Bookings B of the BookingList: Again, if the deleteID is smaller or as big as the bookingList.size() it is contained in the bookingList. If this is the
		// case, verifyDelete is set true, BookingDeletion is the Booking B. If the deleteID is bigger than bookingList.size(), verifyDelete is false. 
		
		for (Booking B : bookingList) {
			if (deleteID <= bookingList.size())  {
				verifyDelete = true;
				BookingDeletion = B;
		        return B;
		    } else if (deleteID < bookingList.size()) {
		    	verifyDelete = false;
		    	System.out.println("No booking with the corresponding ID could be found");
		    }
		}
		return BookingDeletion;
	}
	
	public String getBooking(int customerID) {
		// This method is used to display the method, mainly so that customers can verify their bookings. Again, if the customerID is smaller or as big as the bookingList.size() it is contained in the bookingList. If that applies, the Booking with the index of
		// the entered customerID is assigned a constant. The Bookings room is assigned a variable and via the method getRooms() and .replace(" <br> ", " ") the room can be visually represented as a string for the web. That, the bookingDate of the booking, and
		// the customer name are assigned a constant and the boolean verifyAdd is set true. If the customerID is bigger than the bookingList.size(), verifyAdd is false.
		if (customerID <= bookingList.size() == true) {
			BookingGet = bookingList.get(customerID);
			RoomManagement RoomGet = BookingGet.room;
			String RoomString = RoomManagement.getRooms(RoomGet);
			BookingRoomGet = RoomString.replace(" <br> ", " ");
			GetOutput = BookingRoomGet + "  "+ BookingGet.bookingDate +"  "+ BookingGet.CustName; 
			verifyGet = true;
		} else if (customerID > bookingList.size() == true) {
			verifyGet = false;
		}
		return GetOutput;
	}

	
	public ArrayList<Booking> getBookingList() { //basic getter
	    return this.bookingList;
	}
	
}

