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

@WebServlet("/UpdateServlet2")
public class UpdateServlet2 extends HttpServlet {
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
      
    }
	
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException,IOException {
		
        processRequest(request, response);
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();
        String sid=request.getParameter("id");
        int id= Integer.parseInt(sid);
        String firstname=request.getParameter("firstname");
        String lastname= request.getParameter("lastname");
        String country=request.getParameter("country");
        String phoneno=request.getParameter("phone");
        
        UserInfo u= new UserInfo();
        u.setId(id);
        u.setFirstname(firstname);
        u.setLastname(lastname);
        u.setCountry(country);
        u.setPhoneno(phoneno);
        
        int status = DbConnection.UpdateUser(u);
        if(status>0){  
            response.sendRedirect("ViewServlet");  
        }else{  
            out.println("Sorry! unable to update record");  
        }  
          
        out.close();  
        
    }
}
