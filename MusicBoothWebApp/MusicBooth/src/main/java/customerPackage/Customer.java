package customerPackage;

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


public class Customer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public String lastName;
	public String firstName;
    public String eMail;
    public String customer;
    Room Room = new Room();
    ArrayList<String> roomList = roomPackage.Room.roomList;   
    public Customer() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		lastName = request.getParameter("lName"); //gets input of lastName 
		firstName = request.getParameter("fName"); // gets input of firstName
		eMail = request.getParameter("custEMail"); //gets input of eMail
		customer = lastName + firstName + eMail; //creates customer
		
		
		// redirect to bookingInterface.jsp
		if(eMail.contains("@") && eMail.contains(".")){ //validation of eMail address by checking if email has @ and a .. Valid email: myaddress@email.com Invalid email: myaddress@email
			response.sendRedirect(request.getContextPath() + "/bookingInterface.jsp"); //if eMail is valid-> redirection to bookingInterface.jsp
		} else {
			response.sendRedirect(request.getContextPath() + "/index.jsp"); //if eMail is not valid-> return to index.jsp for new input
		}
	}
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}