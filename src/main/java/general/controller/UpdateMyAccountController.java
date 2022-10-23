package general.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import SystemAdmin.entity.SystemAdmin;
import general.Entity.User;

@WebServlet (urlPatterns = {"/conferenceUpdateForm", "/conferenceUpdate"})
public class UpdateMyAccountController extends HttpServlet {
    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
        conferenceUpdateForm (request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {

    }
    
    
    protected void conferenceUpdateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
        String username = request.getParameter("username");
        String profileName = request.getParameter("profileName");
       
        
        User temp = new SystemAdmin().readUser(username, profileName);
        
        request.setAttribute("myAccount", temp);
        
        RequestDispatcher dis = request.getRequestDispatcher("myUserUpdate.jsp");
        dis.forward(request, response);
        
        
        
    }
}
