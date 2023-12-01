package customerPackage;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class CheckInCheckOut extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public String lastName;
	public String firstName;
    public String eMail;
    public String customer;
    public String dateTime;
    public boolean validEMail;
    
    public CheckInCheckOut() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//after the confirmation by the client, the doGet method just redirects the client back to the index.jsp page from the confirmation.jsp page.
    	response.sendRedirect(request.getContextPath() + "/index.jsp");
	}
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		//the doPost() method in the Customer.java Class/servlet will fetch the input data from the newApppointment.jsp site (New Booking form) and process it. First, all parameters form the jsp site will be assigned to constants or variables, and for control
		// purposes only, they will be printed out on the console. Next, the method checkEMail will be invoked. Depending on the returned result, the variables/constants are set as attributes and forwarded to the jsp site bookingInterface.jsp or a alert is caused
		// and the client is forwarded back to the newAppointment.jsp page because the eMail was invalid.
		
		lastName = request.getParameter("lName"); //gets input of lastName 
		firstName = request.getParameter("fName"); // gets input of firstName
		eMail = request.getParameter("custEMail"); //gets input of eMail
		customer = lastName + " " + firstName + " " + eMail; //creates customer
		dateTime = request.getParameter("dateTime"); //gets the correct date, I DOUBLECHECKED after I had a semantics error in the code
		System.out.println("lastname is: " + lastName + " firstname is: " + firstName + " email is: " + eMail + " customer data: " + customer + " on the day " + dateTime); // can be used for doublechecking
		
		String numberOfPeople = request.getParameter("numberOfPeople");
		String durationWish = request.getParameter("durationWish");
		System.out.println("durationWish: " + durationWish + " numberOfPeople: " + numberOfPeople);
		
		String pianoInRoom = request.getParameter("pianoInRoom");
		String wheelchairAccessibility = request.getParameter("wheelchairAccessibility");
		String brailleAid = request.getParameter("brailleAid");
		
		System.out.println("piano: " + pianoInRoom + " wheechairAccessibility: " + wheelchairAccessibility + " brailleAid: " + brailleAid);

		checkEMail(eMail);
		if(validEMail == true){ 
			request.setAttribute("dateTime", dateTime);
			request.setAttribute("customer", customer);
			request.setAttribute("numberOfPeople", numberOfPeople);
			request.setAttribute("durationWish", durationWish);
			request.setAttribute("pianoInRoom", pianoInRoom);
			request.setAttribute("wheelchairAccessibility", wheelchairAccessibility);
			request.setAttribute("brailleAid", brailleAid);
			request.getRequestDispatcher("/bookingInterface.jsp").forward(request, response); 
			
		} else if (validEMail == false){
			PrintWriter out = response.getWriter();
			   out.println("<script type=\"text/javascript\">");
			   out.println("alert('Email invalid, please retry');");
			   out.println("location='newAppointment.jsp';");
			   out.println("</script>");
		}
	}
	
	public boolean checkEMail(String EMail) {
		//the checkEMail method is a basic method to check whether a string contains to chars, namely the "@" and the ".". Valid email: myaddress@email.com Invalid email: myaddress@emails
		// If the email is valid, the boolean validEMail is set true and returned to the doPost method, if the eMail is invalid the boolean validEMail is set false and returned. 
		if (eMail.contains("@") && eMail.contains(".")) {
			validEMail = true;
		} else {
			validEMail = false;
		}
		return validEMail;
	}

}
