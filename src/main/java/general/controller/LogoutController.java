package general.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet ("/logout")
public class LogoutController extends HttpServlet{
    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
        logoutUser(request, response);
    }
    
    protected void logoutUser (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
        HttpSession session = request.getSession();
        session.removeAttribute("username");
        session.removeAttribute("profileName");
        session.invalidate();
        response.sendRedirect("index.jsp");
        
    }
    
    
}
