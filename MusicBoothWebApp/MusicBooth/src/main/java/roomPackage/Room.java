package roomPackage;

import jakarta.servlet.RequestDispatcher;
import java.util.Scanner;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.function.Predicate;



public class Room extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public static boolean CS1; //CityMusicSchool1
    public static boolean CS2; //CityMusicSchool2
    public static boolean TR1; //TheatreRoom1
    public static boolean TR2; //TheatreRoom2
    public static boolean PS1; //PrivateMusicSchool1
    public static boolean PS2; //PrivateMusicSchool2
    public String address;
    public float roomNumber;
    public int duration;
    public int numberOfPersons;
    public boolean piano;
    public boolean brailleOrCane;
    public boolean wheelchairAccess;
    public String contact;
    public boolean booked; //roomStatus
    public static ArrayList<String> roomList = new ArrayList<String>();
    public static ArrayList<Room> arrayRooms = new ArrayList<Room>();
    Scanner scanner = new Scanner (System.in);


    public Room() {
        super();
    }
    
    

	public Room(String address2, float roomNumber2, int duration2, int numberOfPersons2, boolean piano2,
			boolean brailleOrCane2, boolean wheelchairAccess2, String contact2, boolean booked2) {
		// TODO Auto-generated constructor stub
	}



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { // gets the input from bookingInterface.jsp
		//"Database"
	
			String CityMusicSchool1 = " Address: Upperstreet 1, 100101 thisCity " + "\n" + " Room Number: 3 " + "\n" + " 2 hours " + "\n" + " 4 person(s) " + "\n" +
					" Room with piano " + "\n" + " No braille/white cane aids " + "\n" + " Wheelchair accessible " + "\n" + " citymusic@citymail.city ";
			
				
			String CityMusicSchool2 = " Address: Upperstreet 1, 100101 thisCity " + "\n" + " Room Number: 5 " + "\n" + " 4 hours " + "\n" + " 1 person(s) " + "\n" + 
										" No piano " + "\n" + " No braille/white cane aids " + "\n" + " Not wheelchair accessible " + "\n" + " citymusic@citymail.city ";
				
			String TheatreRoom1 = " Address: Edgestreet 96, 100122 thisCity " + "\n" + " Room Number: 9 " + "\n" + " 3 hours " + "\n" + " 16 person(s) " + "\n" + 
									" Room with piano "+ "\n" + " Braille/white cane aids existent "+ "\n" + " Wheelchair accessible "+ "\n" + " playce2be@theatre.contact ";
				
			String TheatreRoom2 = " Address: Edgestreet 96, 100122 thisCity " + "\n" + " Room Number: 2 " + "\n" + " 6 hours " + "\n" + " 2 person(s) " + "\n" + 
											" No piano " + "\n" + " Braille/white cane aids existent " + "\n" + " Wheelchair accessible " + "\n" + " playce2be@theatre.contact ";
				
			String PrivateMusicSchool1 = " Address: Chop Way, 100109 thisCity " + "\n" + " Room Number: 6 " + "\n" + " 2 hours" + "\n" + " 2 person(s) " + "\n" + 
										" Room with piano " + "\n" + " No braille/white cane aids " + "\n" + " Not wheelchair accessible " + "\n" + " musicisfun@musicschool.org ";
				
			String PrivateMusicSchool2 = " Address: Chop Way, 100109 thisCity " + "\n" + " Room Number: 1 " + "\n" + " 3 hours " + "\n" + " 1 person(s) " + "\n" + 
										" Room with piano " + "\n" + " No braille/white cane aids " + "\n" + " Not wheelchair accessible " + "\n" + " musicisfun@musicschool.org ";
			//all the line breaks are not displayed. This is the declaration of six individual Strings as rooms.

			roomList.add(CityMusicSchool1);
			roomList.add(CityMusicSchool2);
			roomList.add(TheatreRoom1);
			roomList.add(TheatreRoom2);
			roomList.add(PrivateMusicSchool1);
			roomList.add(PrivateMusicSchool2);
			//Rooms are added to the ArrayList<String> roomList. 
				
			request.setAttribute("CityMusicSchool1", CityMusicSchool1); //forward CityMusicSchool1 to the individual place in the JSP file to be displayed 
			request.setAttribute("CityMusicSchool2", CityMusicSchool2); //forward CityMusicSchool2 to individual place in the JSP file
			request.setAttribute("TheatreRoom1", TheatreRoom1); //forwarded to the JSP file
			request.setAttribute("TheatreRoom2", TheatreRoom2); // forwarded to the individual place
			request.setAttribute("PrivateMusicSchool1", PrivateMusicSchool1); // forwarded to the individual place
			request.setAttribute("PrivateMusicSchool2", PrivateMusicSchool2);  //forwarded to the individual place in the JSP file
			RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/bookingInterface.jsp");
			rd.forward(request,response); 
			// this works really great, because the servlet is invoked via a button first. I tried having this method in the Customer.java servlet, however that changed nothing.
	}


	public String changeRoom() {
		System.out.println("Enter the Object you want to change: "); 
		String object = scanner.nextLine(); //get object that should be replaced in ArrayList via scanner
			
		System.out.println("Enter the object you want to change it to: ");
		String newObject = scanner.nextLine(); //get new object for ArrayList via scanner
			
		int i = roomList.indexOf(object); //get index of old object
		roomList.set(i, newObject); // set the new Object at the index of the old object
		return roomList.get(i); // return the object at the index of the old/new object
		
	}
	
	public ArrayList<String> deleteRoom() {
		String ValidatesConfirmation = "YES"; //string that is later used to confirm the deletion is also YES, VaidatesConfrim will be used as comparison
		
		System.out.println("Enter Object you want to delete: ");
		String deletionObject = scanner.nextLine(); //scanner gets the object from the ArrayList that is supposed to be deleted
			
		System.out.println("Are you sure? For deletion, enter YES: ");
		String deletionConfirmed = scanner.nextLine(); //scanner gets the deletionConfirmed String, that should be YES or yes
		
		if (deletionConfirmed.equalsIgnoreCase(ValidatesConfirmation)) { //if deletionConfimed equals ValidatesConfirm, meaning it is YES or yes or anything with yes, the previously entered object will be deleted from the roomlist
			if (deletionObject.equalsIgnoreCase("CityMusicSchool1")) { //if the object to be deleted is CityMusicSchool1, not just delete it from roomList, but also from arrayRooms
				arrayRooms.remove(0);
			} else if (deletionObject.equalsIgnoreCase("CityMusicSchool2")) {
				arrayRooms.remove(1);
			} else if (deletionObject.equalsIgnoreCase("TheatreRoom1")) {
				arrayRooms.remove(2);
			} else if (deletionObject.equalsIgnoreCase("TheatreRoom2")) {
				arrayRooms.remove(3);
			} else if (deletionObject.equalsIgnoreCase("PrivateMusicSchool1")) {
				arrayRooms.remove(4);
			} else if (deletionObject.equalsIgnoreCase("PrivateMusicSchool2")) {
				arrayRooms.remove(5);
			}
			roomList.remove(deletionObject);
		}
		return roomList; // the ArrayList is listed again- now with an object less
		
	}
	
	public void addRooms() {
		Room CS1Room = new Room(" Upperstreet 1, 100101 thisCity ", 3, 2 , 4 , true, false, true, " citymusic@citymail.city ", false);
		Room CS2Room = new Room(" Upperstreet 1, 100101 thisCity ", 5, 4, 1, false, false, false, " citymusic@citymail.city ", false);
		Room TR1Room = new Room(" Edgestreet 96, 100122 thisCity ", 9, 3, 16,  true, true, true, " playce2be@theatre.contact ", false);
		Room TR2Room = new Room(" Edgestreet 96, 100122 thisCity ", 2, 6, 2, false, true, true," playce2be@theatre.contact ", false);
		Room PS1Room = new Room(" Chop Way, 100109 thisCity ", 6, 2, 2, true, false, false, " musicisfun@musicschool.org ", false);
		Room PS2Room = new Room(" Chop Way, 100109 thisCity ", 1, 3, 1, true, false, false, " musicisfun@musicschool.org ", false);
		
		arrayRooms.add(CS1Room);
		arrayRooms.add(CS2Room);
		arrayRooms.add(TR1Room);
		arrayRooms.add(TR2Room);
		arrayRooms.add(PS1Room);
		arrayRooms.add(PS2Room);
	}

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {// gets the input from bookingInterface.jsp
		
		//CityMusicSchool input
			if(request.getParameter("CityMusicSchool1") == null) { //check if the checkbox is selected
				//not selected
				CS1 = false;
			} else {
				CS1 = true;
				//BookingInformation1 = roomList.get(0); // alternative way that also did not work
			}
				
			if(request.getParameter("CityMusicSchool2") == null) {//check if the checkbox is selected
				//not selected
				CS2 = false;
			} else {
				CS2 = true;
				//BookingInformation2 = roomList.get(1);
			}
				
			//TheatreRoom input 
			if(request.getParameter("TheatreRoom1") == null) { //check if the checkbox is selected
				//not selected
				TR1 = false; 
			} else {
				TR1 = true;
				//BookingInformation3 = roomList.get(2);
			}
				
			if(request.getParameter("TheatreRoom2") == null) { //check if the checkbox is selected
				//not selected
				TR2 = false;
			} else {
				TR2 = true;
				//BookingInformation4 = roomList.get(3);
			}
				
			//PrivateMusicSchool input
			if(request.getParameter("PrivateMusicSchool1") == null) { //check if the checkbox is selected
				//not selected
				PS1 = false;
			} else {
				PS1 = true;
				//BookingInformation5 = roomList.get(4);
			}
				
			if(request.getParameter("PrivateMusicSchool2") == null) { //check if the checkbox is selected
				//not selected
				PS2 = false;
			} else {
				PS2 = true;
				//BookingInformation6 = roomList.get(5);
			}
				
		response.sendRedirect(request.getContextPath() + "/checkOut.jsp"); //redirected to checkOut.jsp
			
	}



	public void set(String string, int i, int j, int k, boolean b, boolean c, boolean d, String string2, boolean e) {
		// TODO Auto-generated method stub
		
	}
	

}
