package customerPackage;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class Customer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public String lastName;
	public String firstName;
    public String eMail;
    public String customer;
   
    public Customer() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		lastName = request.getParameter("lName");
		firstName = request.getParameter("fName");
		eMail = request.getParameter("custEMail");
		customer = lastName + firstName + eMail;
		//PrintWriter out = response.getWriter(); Confirmation if the input data is read correctly, not used unless I code. 
		//out.print(customer);
		//request.setAttribute("Customer", customer);
		//request.getRequestDispatcher("site.jsp").forward(request, response);
		
		// redirect to bookingInterface.jsp
		if(eMail.contains("@")){ //validation of eMail address by checking if email has @
			response.sendRedirect(request.getContextPath() + "/bookingInterface.jsp"); //if eMail is valid-> redirection to bookingInterface.jsp
		} else {
			response.sendRedirect(request.getContextPath() + "/index.jsp"); //if eMail is not valid-> return to index.jsp for new input
		}
	}
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}