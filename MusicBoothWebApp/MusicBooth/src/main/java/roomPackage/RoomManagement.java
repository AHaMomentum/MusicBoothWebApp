package roomPackage;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;

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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

import bookingPackage.Booking;



public class RoomManagement extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static boolean availabilityCS1;
	static boolean availabilityCS2;
	static boolean availabilityTR1;
	static boolean availabilityTR2;
	static boolean availabilityPS1;
	static boolean availabilityPS2;
    public static boolean CS1; //CityMusicSchool1
    public static boolean CS2; //CityMusicSchool2
    public static boolean TR1; //TheatreRoom1
    public static boolean TR2; //TheatreRoom2
    public static boolean PS1; //PrivateMusicSchool1
    public static boolean PS2; //PrivateMusicSchool2
    public String address;
    public float roomNumber;
    public static int duration;
    public static int numberOfPersons;
    public static boolean piano;
    public static boolean brailleOrCane;
    public static boolean wheelchairAccess;
    public String contact;
    public boolean booked; //roomStatus
    public Date booking;
    public static ArrayList<String> roomList = new ArrayList<String>();  
    public static ArrayList<RoomManagement> arrayRooms = new ArrayList<RoomManagement>();
    public static String BookingTime;
    public String CustomerData;
    Scanner scanner = new Scanner (System.in);
    public String BookingInformation;
    public String BookingInformation0;
    public String BookingInformation1;
    public String BookingInformation2;
    public String BookingInformation3;
    public String BookingInformation4;
    public String BookingInformation5;
    public static String StringRepresentation;
	public static String RoomRepresentation;
    

    public RoomManagement() {
        super();
    }
    
    

	public RoomManagement(String address2, float roomNumber2, int duration2, int numberOfPersons2, boolean piano2,
			boolean brailleOrCane2, boolean wheelchairAccess2, String contact2) {
	}



	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		//the doGet method gets the data from the jsp site, processes it, and decides how to forward. In this doGet, the first step is to establish two "databases", i.e., two arrayLists: roomList and arrayRooms. Afterwards, the parameters are fetched from 
		//the jsp site and assigned to the variables and constants. For control purposes, some minor steps are printed out on the console. They can be ignored during a course of normal business, in case of a problem, they might help find the cause. 
		//Next, the method addRooms() is invoked, the resulting booleans are then evaluated and depending on their status, different parameters are forwarded to bockingInterface.jsp as Attributes. If all booleans are true, all rooms are available and set as such
		// for bookingInterface.jsp.
	
			// This is the arrayList with attributes that can be displayed
			String CityMusicSchool1 =  " Address: Upperstreet 1, 100101 thisCity <br> Room Number: 3" + " | " + " 2 hours " + " | " + " 4 person(s) " + " <br> " + 
					" Room with piano " + " | " + " No braille/white cane aids " + " | " + " Wheelchair accessible " + " <br> " + " citymusic@citymail.city ";
				
			String CityMusicSchool2 = " Address: Upperstreet 1, 100101 thisCity " + " <br> " + " Room Number: 5 " + " | " + " 4 hours " + " | " + " 1 person(s) " + 
					" <br> " + " No piano " + " | " + " No braille/white cane aids " + " | " + " Not wheelchair accessible " + " <br> " + " citymusic@citymail.city ";
				
			String TheatreRoom1 = " Address: Edgestreet 96, 100122 thisCity " + "<br>" + " Room Number: 9 " + " | " + " 3 hours " + " | " + " 16 person(s) " + "<br>" + 
					" Room with piano "+ " | " + " Braille/white cane aids existent "+ " | " + " Wheelchair accessible "+ "<br>" + " playce2be@theatre.contact ";
				
			String TheatreRoom2 = " Address: Edgestreet 96, 100122 thisCity " + "<br>" + " Room Number: 2 " + " | " + " 6 hours " + " | " + " 2 person(s) " + "<br>" + 
					" No piano " + " | " + " Braille/white cane aids existent " + " | " + " Wheelchair accessible " + "<br>" + " playce2be@theatre.contact ";
				
			String PrivateMusicSchool1 = " Address: Chop Way, 100109 thisCity " + "<br>" + " Room Number: 6 " + " | " + " 2 hours" + " | " + " 2 person(s) " + "<br>" + 
					" Room with piano " + " | " + " No braille/white cane aids " + " | " + " Not wheelchair accessible " + "<br>" + " musicisfun@musicschool.org ";
				
			String PrivateMusicSchool2 = " Address: Chop Way, 100109 thisCity " + "<br>" + " Room Number: 1 " +  " | " + " 3 hours " + " | " + " 1 person(s) " + "<br>" + 
					" Room with piano " + " | " + " No braille/white cane aids " + " | " + " Not wheelchair accessible " + "<br>" + " musicisfun@musicschool.org ";

			roomList.add(0, CityMusicSchool1);
			roomList.add(1, CityMusicSchool2);
			roomList.add(2, TheatreRoom1);
			roomList.add(3, TheatreRoom2);
			roomList.add(4, PrivateMusicSchool1);
			roomList.add(5, PrivateMusicSchool2);

			System.out.println("Added to roomList for display: " + roomList);
			
			
			//This is the arrayList with attributes that can be worked with 
			RoomManagement CS1Room = new RoomManagement(" Upperstreet 1, 100101 thisCity ", 3, 2 , 4 , true, false, true, " citymusic@citymail.city ");
			RoomManagement CS2Room = new RoomManagement(" Upperstreet 1, 100101 thisCity ", 5, 4, 1, false, false, false, " citymusic@citymail.city ");
			RoomManagement TR1Room = new RoomManagement(" Edgestreet 96, 100122 thisCity ", 9, 3, 16,  true, true, true, " playce2be@theatre.contact ");
			RoomManagement TR2Room = new RoomManagement(" Edgestreet 96, 100122 thisCity ", 2, 6, 2, false, true, true," playce2be@theatre.contact ");
			RoomManagement PS1Room = new RoomManagement(" Chop Way, 100109 thisCity ", 6, 2, 2, true, false, false, " musicisfun@musicschool.org ");
			RoomManagement PS2Room = new RoomManagement(" Chop Way, 100109 thisCity ", 1, 3, 1, true, false, false, " musicisfun@musicschool.org ");
			
			arrayRooms.add(0, CS1Room);
			arrayRooms.add(1, CS2Room);
			arrayRooms.add(2, TR1Room);
			arrayRooms.add(3, TR2Room);
			arrayRooms.add(4, PS1Room);
			arrayRooms.add(5, PS2Room);
			
			System.out.println("Added to arrayList for working: " + arrayRooms);
			
			//This is the BookingTime that is passed on from the Customer.java file
			BookingTime = request.getParameter("dateTime");//This is zero-- WHYYYY
			request.setAttribute("bookingTime", BookingTime); 
			System.out.println("This is the Booking: " + BookingTime);
			CustomerData = request.getParameter("customer"); //This is zero-- WHYYYY
			request.setAttribute("CustomerData", CustomerData); 
			System.out.println("This is the Customer: " + CustomerData);
			String StringOfPersons = request.getParameter("numberOfPeople");
			numberOfPersons = Integer.parseInt(StringOfPersons);
			String durationString = request.getParameter("durationWish");
			duration = Integer.parseInt(durationString);
			
			String pianoString = request.getParameter("pianoInRoom");
			if (pianoString.equalsIgnoreCase("on")) {
				piano = true;
			} else {
				piano = false;
			}
			System.out.println("piano boolean " + piano);
			
			String wheelchairAccessString = request.getParameter("wheelchairAccessibility");
			if (wheelchairAccessString.equalsIgnoreCase("on")) {
				wheelchairAccess = true;
			} else {
				wheelchairAccess = false;
			}
			System.out.println("wheelchairAccess boolean " + wheelchairAccess);
			
			String brailleOrCaneString = request.getParameter("brailleAid");
			if (brailleOrCaneString.equals("on")) {
				brailleOrCane = true;
			}
			System.out.println("brailleOrCane boolean " + brailleOrCane);
		    
		    
		    addRooms(wheelchairAccess, numberOfPersons, brailleOrCane, piano, duration);
		    System.out.println("availabilityCS1 : "+ availabilityCS1 + " availabilityCS2: "+ availabilityCS2 +" availabilityTR1: " + availabilityTR1 + " availabilityTR2: " + availabilityTR2 + " availabilityPS1: " + availabilityPS1 + " availabiilityPS2: " + availabilityPS2);
		    String Unavailable = "------";
		    
		    if (availabilityCS1 == true) {
		    	request.setAttribute("CityMusicSchool1", CityMusicSchool1);
		    } else if (availabilityCS1 == false) {
		    	request.setAttribute("CityMusicSchool1", Unavailable);
		    } 
		    if (availabilityCS2 == true) {
		    	request.setAttribute("CityMusicSchool2", CityMusicSchool2);
		    } else if (availabilityCS2 == false) {
		    	request.setAttribute("CityMusicSchool2", Unavailable);
		    } 
		    if (availabilityTR1 == true ) {
		    	request.setAttribute("TheatreRoom1", TheatreRoom1);
		    } else if (availabilityTR1 == false) {
		    	request.setAttribute("TheatreRoom1", Unavailable);
		    }
		    if (availabilityTR2 == true) {
		    	request.setAttribute("TheatreRoom2", TheatreRoom2);
		    } else if (availabilityTR2 == false) {
		    	request.setAttribute("TheatreRoom2", Unavailable);
		    }
		    if (availabilityPS1 == true) {
		    	request.setAttribute("PrivateMusicSchool1", PrivateMusicSchool1);
		    } else if (availabilityPS1 == false) {
		    	request.setAttribute("PrivateMusicSchool1", Unavailable);
		    } 
		    if (availabilityPS2 == true) {
		    	request.setAttribute("PrivateMusicSchool2", PrivateMusicSchool2);
		    } else if (availabilityPS2 == false) {
		    	request.setAttribute("PrivateMusicSchool2", Unavailable);
		    }
		    
		    if (availabilityCS1 == false && availabilityCS2 == false && availabilityTR1 == false && availabilityTR2 == false && availabilityPS1 == false && availabilityPS2 == false) {
		    	String BookingError = "We apologise, no room fitting your criteria could be found.";
		    	System.out.println(BookingError);
		    	request.setAttribute("ErrorMessage", BookingError);
		    }
						
			request.getRequestDispatcher("/bookingInterface.jsp").forward(request, response); 
			
		
			// this works really great, because the servlet is invoked via a button first. I tried having this method in the Customer.java servlet, however that changed nothing.
	}
	static protected void addRooms(boolean wheelchairAccess2, int numberOfPersons2, boolean braillerOrCane2, boolean piano2, int duration2) { 
		//this method is used to find the rooms that fit the clients needs and wishes, here: attributes. The method if fairly easy, there are multiple nested if conditions, and 2 main groups of rooms: with and without piano. After that first if condition regarding
		// pianos come the individual rooms with their conditions: duration, numberOfPersons, brailleOrCane, wheelchairAccess. After a fitting room has been found, it has to be excluded that the room has already been booked. That is the third if condition. 
		//If that is the case, the boolean for that room is set false. If that is not the case, the boolean is set true, and if the bookingList is empty, the boolean is set true too. 
		
		
		Booking Booking = new Booking();
		Booking.getBookingList();
		
		if (piano == false) { //Room grouping 1 
			if (duration < 5 && numberOfPersons == 1 && brailleOrCane == false && wheelchairAccess == false) { //characteristics of CityMusicSchool2
				if (Booking.getRoom().equals(RoomManagement.arrayRooms.get(1)) == true) {
					if (BookingTime.equals(Booking.getBookingDate()) == false) {
						availabilityCS2 = true; // here the request set request.setAttribute("CityMusicSchool2", CityMusicSchool2); can later be set
						System.out.println("CityMusicSchool2 set available"); // console output that the room is available
					} else if (BookingTime.equals(Booking.getBookingDate()) == true) {
						// BookingTime and b.getString() is true means it is in use as there is no difference between the dates, i.e., they are the same.
						availabilityCS2 = false; //request.setAttribute("CityMusicSchool2", "------"); //Set "unavailable"
						System.out.println("CityMusicSchool2 set unavailable"); //console output that the room is set unavailable
					}
				} else if (Booking.getRoom().equals(RoomManagement.arrayRooms.get(1)) == false || Booking.getBookingList().isEmpty() == true) {
					availabilityCS2 = true; //request.setAttribute("CityMusicSchool2", CityMusicSchool2);
					System.out.println("CityMusicSchool2 set available");
				}
			}
			if (duration < 7 && numberOfPersons < 3 && brailleOrCane == true && wheelchairAccess == true) { //characteristics of PrivateMusicSchool2
		    	if (Booking.getRoom().equals(RoomManagement.arrayRooms.get(3)) == true) {
		    		if (BookingTime.equals(Booking.getBookingDate()) == false) {
		    			availabilityTR2 = true; //request.setAttribute("TheatreRoom2", TheatreRoom2);
		    			System.out.println("TheatreRoom2 set available");
		    		} else if (BookingTime.equals(Booking.getBookingDate()) == true) {
		    			availabilityTR2 = false; //request.setAttribute("TheatreRoom2", "------");
		    			System.out.println("TheatreRoom2 set unavailable");
		    		}
		    	} else if (Booking.getRoom().equals(RoomManagement.arrayRooms.get(3)) == false || Booking.getBookingList().isEmpty() == true) { 
		    		availabilityTR2 = true; //request.setAttribute("TheatreRoom2", TheatreRoom2);
		    		System.out.println("TheatreRoom2 set available");
		    	}
			}
		} else if (piano == true) {
			if (duration <= 4 && numberOfPersons == 1 && brailleOrCane == false && wheelchairAccess == false) {
				if (Booking.getRoom().equals(RoomManagement.arrayRooms.get(5)) == true) {
					if (BookingTime.equals(Booking.getBookingDate()) == false) {
						availabilityPS2 = true; //request.setAttribute("PrivateMusicSchool2", PrivateMusicSchool2);
						System.out.println("Step 1 PS2");
					} else if (BookingTime.equals(Booking.getBookingDate()) == true) {
						availabilityPS2 = false; //request.setAttribute("PrivateMusicSchool2", "------");
						System.out.println("False Step PS2");
					}
				} else if (Booking.getRoom().equals(RoomManagement.arrayRooms.get(5)) == false || Booking.getBookingList().isEmpty() == true) { 
					availabilityPS2 = true; //request.setAttribute("PrivateMusicSchool2", PrivateMusicSchool2);
					System.out.println("Step 3 PS2");
				}
			} 
			if (duration < 3 && numberOfPersons < 3 && wheelchairAccess == false && brailleOrCane == false) {
				if (Booking.getRoom().equals(RoomManagement.arrayRooms.get(4)) == true) {
					if (BookingTime.equals(Booking.getBookingDate()) == false) {
						availabilityPS1 = true; //request.setAttribute("PrivateMusicSchool1", PrivateMusicSchool1);
						System.out.println("PrivateMusicSchool1 set available");
					} else if (BookingTime.equals(Booking.getBookingDate()) == true) {
						availabilityPS1 = false; //request.setAttribute("PrivateMusicSchool1", "------");
						System.out.println("PrivateMusicSchool1 set unavailable");
					}
				} else if (Booking.getRoom().equals(RoomManagement.arrayRooms.get(4)) == false || Booking.getBookingList().isEmpty() == true) { 
					availabilityPS1 = true; //request.setAttribute("PrivateMusicSchool1", PrivateMusicSchool1);
					System.out.println("PrivateMusicSchool1 set available");
				}
			} 
			if (numberOfPersons < 5 && wheelchairAccess == true && duration < 3 && brailleOrCane == false) {
				if (Booking.getRoom().equals(RoomManagement.arrayRooms.get(0)) == true) {
					if (BookingTime.equals(Booking.getBookingDate()) == false) {
						availabilityCS1 = true; //request.setAttribute("CityMusicSchool1", CityMusicSchool1);
						System.out.println("CityMusicSchool1 set available");
					} else if (BookingTime.equals(Booking.getBookingDate()) == true) {
						availabilityCS1 = false; 
						System.out.println("CityMusicSchool1 set unavailable");
					}
				} else if (Booking.getRoom().equals(RoomManagement.arrayRooms.get(0)) == false || Booking.getBookingList().isEmpty() == true) {
					availabilityCS1 = true; //request.setAttribute("CityMusicSchool1", CityMusicSchool1);
					System.out.println("CityMusicSchool1 set available");
				}
			}
			if (numberOfPersons < 17 && wheelchairAccess == true && duration < 4 && brailleOrCane == true) {
				if (Booking.getRoom().equals(RoomManagement.arrayRooms.get(2)) == true) {
					if (BookingTime.equals(Booking.getBookingDate()) == false) {
						availabilityTR1 = true; //request.setAttribute("TheatreRoom1", TheatreRoom1);
						System.out.println("TheatreRoom1 set available");
					} else if (BookingTime.equals(Booking.getBookingDate()) == false) {
						availabilityTR1 = false; //request.setAttribute("TheatreRoom1", "------");
						System.out.println("TheatreRoom1 set unavailable");
					}
				} else if (Booking.getRoom().equals(RoomManagement.arrayRooms.get(2)) == false || Booking.getBookingList().isEmpty() == true) { 
					availabilityTR1 = true; //request.setAttribute("TheatreRoom1", TheatreRoom1);
					System.out.println("TheatreRoom1 set available");
				}
			}
		}

	}


	public String changeRooms() {
		// in comparison to the Booking interface, the changeRooms is only supposed to be changed by a administrator. Therefore, the function is not accessible through the web. 
		// The method will ask for the object to change, the scanner will assign it a variable. Same goes with the object that it should be changed to. Then the roomList is searched for the original object, and in its index is placed the new object. 
		// the new object is returned.
		System.out.println("Enter the Object you want to change: "); 
		String object = scanner.nextLine(); //get object that should be replaced in ArrayList via scanner
			
		System.out.println("Enter the object you want to change it to: ");
		String newObject = scanner.nextLine(); //get new object for ArrayList via scanner
			
		int i = roomList.indexOf(object); //get index of old object
		roomList.set(i, newObject); // set the new Object at the index of the old object
		return roomList.get(i); // return the object at the index of the old/new object
		
	}
	
	public ArrayList<String> deleteRooms() {
		// again, this method cannot be accessed via web, as it is not for the public. A Validation String is assigned the word YES to be later compared to the administrators input. Via console and scanner, the administrator is supposed to put in the object
		// that they want to delete. The object is assigned a variable (deletionObject). The next step is the input of the confirmation, the administrator is asked whether they want to delete the object. Their input is compared to the validation string that
		// equals yes. If they equals, i.e., the administrator wants to delete the object, the deleteionObject is compared to the existing Rooms of RoomList. If a match is found, the equivalent in the arrayRoom arrayList is deleted. Then the deletionObject
		// is deleted from the roomList arrayList. 
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
			} else System.out.println("No fitting object was found");
			roomList.remove(deletionObject);
		} 
		return roomList; // the ArrayList is listed again- now with an object less
		
	}

	

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { // gets the input from bookingInterface.jsp
		// this method evaluates the choice of the practice room that the customer has made. First and foremost, the parameters are fetched from the jsp form and assigned to variables. Then follows an if condition that evaluates
		// that if a practice room has been picked (!= null) and it equals any of the string names of the practice room, the boolean for that room will be true, else false. It cannot be picked more than one room, as they all have the same name, which
		// disables the ability in jsp/HTML to pick multiple radio buttons. Next, the constants BookingInformation are assigned (again, the printing is only for control purposes). The last if conditions sets the Attribute for the next jsp page checkOut.jsp.
		// Depending on the boolean, the corresponding BookingInformation is set attribute, i.e., if the boolean for CS1 is true, the BookingInformation that contains the room for CityMusicSchool1 is set as Attribute and forwarded, together with the previously
		//fetched Customer information.
		
		String practiceRoom = request.getParameter("practiceRoom");
		String BookingTimePost = request.getParameter("bookingTime");
		String CustomerInformation = request.getParameter("CustomerData");
		
		// 
		if (practiceRoom != null ) {
			if (practiceRoom.equals("CityMusicSchool1")) {//if the selected object matches the string CityMusicSchool1
				CS1 = true;//the boolean for CityMusicSchool1 is true and can be later worked with
			} else {
				CS1 = false;
			}
			if (request.getParameter("practiceRoom").equals("CityMusicSchool2")) {//if the input object equals the string CityMusicSchool2
				CS2 = true;// the boolean object for CityMusicSchool2 is true
			} else {
				CS2 = false;
			}
			if (request.getParameter("practiceRoom").equals("TheatreRoom1")) {//if the input object matches the TheatreRoom1
				TR1 = true;//the respective boolean TR1 is true
			} else {
				TR1 = false;
			}
			if (request.getParameter("practiceRoom").equals("TheatreRoom2")) {
				TR2 = true;
			} else {
				TR2 = false;
			}
			if (request.getParameter("practiceRoom").equals("PrivateMusicSchool1")) {
				PS1 = true;
			} else { 
				PS1 = false;
			}
			if (request.getParameter("practiceRoom").equals("PrivateMusicSchool2")) {
				PS2 = true;
			} else {
				PS2 = false;
			}
		}

		String Error = "No Room could be found"; // to be used below (line 67)
		BookingInformation0 = roomList.get(0);
		System.out.println("This is roomList index 0: " + roomList.get(0));
		BookingInformation1 = roomList.get(1);
		System.out.println("This is roomList index 1: " + roomList.get(1));
		BookingInformation2 = roomList.get(2);
		System.out.println("This is roomList index 2: " + roomList.get(2));
		BookingInformation3 = roomList.get(3);
		System.out.println("This is roomList index 3: " + roomList.get(3));
		BookingInformation4 = roomList.get(4);
		System.out.println("This is roomList index 4: " + roomList.get(4));
		BookingInformation5 = roomList.get(5);
		System.out.println("This is roomList index 5: " + roomList.get(5));
		
		
		if ((CS1 == true) && (CS2 == false) && (TR1 == false) && (TR2 == false) && (PS1 == false) && (PS2 == false)) { //if it the boolean CS1 is true (the user clicked CityMusicSchool1), then the variable BookingInformation will the first item in the Arraylist, i.e., CityMusicSchool1. This is the same with the following variables. 
			request.setAttribute("finalBookingInformation", BookingInformation0); //to be passed to a JSP file (checkOut.jsp)
			getServletContext().setAttribute("bookedRoom", BookingInformation0); //to be passed to a java file (Booking.java)
		} else if ((CS1 == false) && (CS2 == true) && (TR1 == false) && (TR2 == false) && (PS1 == false) && (PS2 == false)) {
			request.setAttribute("finalBookingInformation", BookingInformation1);
			getServletContext().setAttribute("bookedRoom", BookingInformation1);
		} else if ((CS1 == false) && (CS2 == false) && (TR1 == true) && (TR2 == false) && (PS1 == false) && (PS2 == false)) {
			request.setAttribute("finalBookingInformation", BookingInformation2);
			getServletContext().setAttribute("bookedRoom", BookingInformation2);
		} else if ((CS1 == false) && (CS2 == false) && (TR1 == false) && (TR2 == true) && (PS1 == false) && (PS2 == false)) {
			request.setAttribute("finalBookingInformation", BookingInformation3);
			getServletContext().setAttribute("bookedRoom", BookingInformation3);
		} else if ((CS1 == false) && (CS2 == false) && (TR1 == false) && (TR2 == false) && (PS1 == true) && (PS2 == false)) {
			request.setAttribute("finalBookingInformation", BookingInformation4);
			getServletContext().setAttribute("bookedRoom", BookingInformation4);
		} else if ((CS1 == false) && (CS2 == false) && (TR1 == false) && (TR2 == false) && (PS1 == false) && (PS2 == true)) {
			request.setAttribute("finalBookingInformation", BookingInformation5);
			getServletContext().setAttribute("bookedRoom", BookingInformation5);
		} else if ((CS1 == false) && (CS2 == false) && (TR1 == false) && (TR2 == false) && (PS1 == false) && (PS2 == false)) {
			request.setAttribute("finalBookingInformation", Error); //if none of the previous booleans is true, i.e., no room was selected, then an Error Message is displayed that as set at the top of the Method. 
			getServletContext().setAttribute("bookedRoom", Error);
		}
		//the variable with the chosen Room is then forwarded to the checkOut.jsp and displayed there. 
		//RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/checkOut.jsp");
        //dispatcher.forward(request, response);
		request.setAttribute("bookingTimePost", BookingTimePost);
		request.setAttribute("CustomerInformation", CustomerInformation);
		
		RequestDispatcher rs = request.getServletContext().getRequestDispatcher("/checkOut.jsp");
		rs.forward(request,response); 
			
	}
	
	public static String getRooms(RoomManagement room) {
		// this method allows one to get a Rooms String representation. Because there are two different ArrayLists of the rooms, it can be difficult to represent rooms properly if only working with one type. This method allows it to enter the RoomManagment
		// type from arrayRooms and get out the corresponding String type from roomLisr or the String type from arrayRooms, though the latter does not really call for a method.
		if (room.equals(RoomManagement.arrayRooms.get(0))) {
			StringRepresentation = RoomManagement.roomList.get(0);
			RoomRepresentation = RoomManagement.arrayRooms.get(0).toString();
		}
		if (room.equals(RoomManagement.arrayRooms.get(1))) {
			StringRepresentation = RoomManagement.roomList.get(1);
			RoomRepresentation = RoomManagement.arrayRooms.get(1).toString();
		}
		if (room.equals(RoomManagement.arrayRooms.get(2))) {
			StringRepresentation = RoomManagement.roomList.get(2);
			RoomRepresentation = RoomManagement.arrayRooms.get(2).toString();
		}
		if (room.equals(RoomManagement.arrayRooms.get(3))) {
			StringRepresentation = RoomManagement.roomList.get(3);
			RoomRepresentation = RoomManagement.arrayRooms.get(3).toString();
		}
		if (room.equals(RoomManagement.arrayRooms.get(4))) {
			StringRepresentation = RoomManagement.roomList.get(4);
			RoomRepresentation = RoomManagement.arrayRooms.get(4).toString();
		}
		if (room.equals(RoomManagement.arrayRooms.get(5))) {
			StringRepresentation = RoomManagement.roomList.get(5);
			RoomRepresentation = RoomManagement.arrayRooms.get(5).toString();
		}
		return StringRepresentation;
	}
	
}
