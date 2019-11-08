package servlet;

import tables.UserInfo;
import connection2.DbConnection;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;


@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       
    }
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException,IOException {
		processRequest(request, response);
		
		PrintWriter out = response.getWriter();
		out.println("<h1>Update User</h1>");
		String sid=request.getParameter("id");
		int id = Integer.parseInt(sid);
		UserInfo u = DbConnection.SelectUserByID(id);
		
		out.print("<form action='UpdateServlet2' method='post'>");  
        out.print("<table>");  
        out.print("<tr><td></td><td><input type='hidden' name='id' value='"+u.getId()+"'/></td></tr>");  
        out.print("<tr><td>First Name:</td><td><input type='text' name='firstname' value='"+u.getFirstname()+"'/></td></tr>");  
        out.print("<tr><td>Last Name:</td><td><input type='text' name='lastname' value='"+u.getLastname()+"'/></td></tr>");  
        out.print("<tr><td>Address:</td><td><input type='text' name='country' value='"+u.getCountry()+"'/></td></tr>");  
        out.print("<tr><td>Phone No:</td><td><input type='text' name='phone' value='"+u.getPhoneno()+"'/></td></tr>");  
          
        out.print("<tr><td colspan='2'><input type='submit' value='Update'/></td></tr>");  
        out.print("</table>");  
        out.print("</form>");  
          
        out.close();  
	}
	 	@Override
	   	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        processRequest(request, response);
	    }
}
