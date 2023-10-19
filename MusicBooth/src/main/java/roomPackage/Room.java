package roomPackage;

import jakarta.servlet.RequestDispatcher;
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
    public static ArrayList<String> roomList = new ArrayList<String>();


    public Room() {
        super();
    }
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//CityMusicSchool input
		if(request.getParameter("CityMusicSchool1") == null) {
			//not selected
			CS1 = false;
		} else {
			CS1 = true;
			//BookingInformation1 = roomList.get(0);
		}
		
		if(request.getParameter("CityMusicSchool2") == null) {
			//not selected
			CS2 = false;
		} else {
			CS2 = true;
			//BookingInformation2 = roomList.get(1);
		}
		
		//TheatreRoom input 
		if(request.getParameter("TheatreRoom1") == null) {
			//not selected
			TR1 = false; 
		} else {
			TR1 = true;
			//BookingInformation3 = roomList.get(2);
		}
		
		if(request.getParameter("TheatreRoom2") == null) {
			//not selected
			TR2 = false;
		} else {
			TR2 = true;
			//BookingInformation4 = roomList.get(3);
		}
		
		//PrivateMusicSchool input
		if(request.getParameter("PrivateMusicSchool1") == null) {
			//not selected
			PS1 = false;
		} else {
			PS1 = true;
			//BookingInformation5 = roomList.get(4);
		}
		
		if(request.getParameter("PrivateMusicSchool2") == null) {
			//not selected
			PS2 = false;
		} else {
			PS2 = true;
			//BookingInformation6 = roomList.get(5);
		}
		
		response.sendRedirect(request.getContextPath() + "/checkOut.jsp");
	}
	

	
	/**public void deleteRoom() {
		String deletion = contactDeletion + addressDeletion + roomNumberDeletion;
		if (rooms.removeIf(r -> r.contains(deletion))) { //If all conditions apply, the room will be deleted.  
			PrintWriter delete = response.getWriter();
			delete.print("Room number " + roomNumberDeletion + " at " + addressDeletion + " with the contact " + contactDeletion + " was deleted from the system."); // if the room is deleted, it is printed out.
		}
	}
	
	public boolean changeRooms() {
		
	}
	
	public void getRoom() {
		String stringGet = addressSearch + roomNumberSearch + contactSearch;
		if (rooms.contains(stringGet)) {
			int roomPosition = rooms.indexOf(stringGet) - 1 ;
			searchedRoom = rooms.get(roomPosition);
			PrintWriter search = response.getWriter();
			search.print("The room you searched for is: " + searchedRoom);
		} else { 
			throw new IllegalArgumentException("No Room found");
		}
	}
**/
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//"Database":
		String CityMusicSchool1 = " Address: Upperstreet 1, 100101 thisCity " + "\n" + " Room Number: 3 " + "\n" + " 2 hours " + "\n" + " 4 person(s) " + "\n" +
									" Room with piano " + "\n" + " No braille/white cane aids " + "\n" + " Wheelchair accessible " + "\n" + " citymusic@citymail.city ";
		
		String CityMusicSchool2 = " Address: Upperstreet 1, 100101 thisCity " + "\n" + " Room Number: 5 " + "\n" + " 4 hours " + "\n" + " 1 person(s) " + "\n" + 
									" No piano " + "\n" + " No braille/white cane aids " + "\n" + " Not wheelchair accessible " + "\n" + " citymusic@citymail.city ";
		
		String TheatreRoom1 = " Address: Edgestreet 96, 100122 thisCity " + "\n" + " Room Number: 9 " + "\n" + " 3 hours " + "\n" + " 16 person(s) " + "\n" + 
									" Room with piano "+ "\n" + " Braille/white cane aids existent "+ "\n" + " Wheelchair accessible "+ "\n" + " playce2be@theatre.contact ";
		
		String TheatreRoom2 = " Address: dgestreet 96, 100122 thisCity " + "\n" + " Room Number: 2 " + "\n" + " 6 hours " + "\n" + " 2 person(s) " + "\n" + 
									" No piano " + "\n" + " Braille/white cane aids existent " + "\n" + " Wheelchair accessible " + "\n" + " playce2be@theatre.contact ";
		
		String PrivateMusicSchool1 = " Address: Chop Way, 100109 thisCity " + "\n" + " Room Number: 6 " + "\n" + " 2 hours" + "\n" + " 2 person(s) " + "\n" + 
									" Room with piano " + "\n" + " No braille/white cane aids " + "\n" + " Not wheelchair accessible " + "\n" + " musicisfun@musicschool.org ";
		
		String PrivateMusicSchool2 = " Address: Chop Way, 100109 thisCity " + "\n" + " Room Number: 1 " + "\n" + " 3 hours " + "\n" + " 1 person(s) " + "\n" + 
									" Room with piano " + "\n" + " No braille/white cane aids " + "\n" + " Not wheelchair accessible " + "\n" + " musicisfun@musicschool.org ";

		roomList.add(CityMusicSchool1);
		roomList.add(CityMusicSchool2);
		roomList.add(TheatreRoom1);
		roomList.add(TheatreRoom2);
		roomList.add(PrivateMusicSchool1);
		roomList.add(PrivateMusicSchool2);
		
		request.setAttribute("CityMusicSchool1", CityMusicSchool1); //forward CityMusicSchool1 to the individual place in the JSP file
		request.setAttribute("CityMusicSchool2", CityMusicSchool2); //forward CityMusicSchool2 to individual place in the JSP file, here with a different path to see the outcome
		request.setAttribute("TheatreRoom1", TheatreRoom1); //forwarded to the JSP file
		request.setAttribute("TheatreRoom2", TheatreRoom2); // forwarded to the individual place
		request.setAttribute("PrivateMusicSchool1", PrivateMusicSchool1); // forwarded to the individual place
		request.setAttribute("PrivateMusicSchool2", PrivateMusicSchool2);  //forwarded to the individual place in the JSP file
		RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/bookingInterface.jsp");
		rd.forward(request,response); 
		
	}
	
	public void addBooking() {
		
	}

}
