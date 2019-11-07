package servlet;

import tables.UserInfo;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;

import connection2.DbConnection;
@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       
    }
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException,IOException {
        processRequest(request, response);
        
        PrintWriter out=response.getWriter();
        String firstname=request.getParameter("firstname");
        String lastname= request.getParameter("lastname");
        String country=request.getParameter("country");
        String phoneno=request.getParameter("phoneno");
        
        UserInfo u= new UserInfo();
        u.setFirstname(firstname);
        u.setLastname(lastname);
        u.setCountry(country);
        u.setPhoneno(phoneno);
        
        int status= DbConnection.AddUser(u);
        if (status>0) {
        	out.print("<p>Record saved successfully!</p>");  
            request.getRequestDispatcher("index.html").include(request, response);  
        }else{  
            out.println("Sorry! unable to save record");
        }
        
        out.close();
	}
	@Override
    public String getServletInfo() {
        return "Short description";
    }
}
