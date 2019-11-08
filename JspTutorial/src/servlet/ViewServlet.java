package servlet;
import tables.UserInfo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connection2.DbConnection;

import javax.servlet.annotation.WebServlet;

@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        
         PrintWriter out=response.getWriter();
         
         List<UserInfo> list = DbConnection.getAllUsers();
         out.println("<a href='index.html'>Add User</a>");
         out.print("<h1>User List Page: </h1>");
         out.print("<table border='1' cellpadding='4' width='100%'>");  
         out.print("<tr><th>Id</th><th>First Name</th><th>Last Name</th><th>Country</th><th>Phone</th>");
         for (UserInfo u:list) {
        	 out.print("<tr><td>"+u.getId()+"</td><td>"+u.getFirstname()+"</td><td>"+u.getLastname()+"</td><td>"+u.getCountry()+"</td>"
        	 		+ "<td>"+u.getPhoneno()+"</td><td><a href='UpdateServlet?id="+u.getId()+"'>edit</a></td><td><a href='DeleteServlet?id="+u.getId()+"'>Delete</a></td></tr>");
         }
         out.print("</table>");
         
           
         out.close();  
         
	}
	
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
