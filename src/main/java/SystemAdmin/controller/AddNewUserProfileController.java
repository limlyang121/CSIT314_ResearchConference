package SystemAdmin.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Author.Entity.Author;
import ConferenceChair.Entity.ConferenceChair;
import Reviewer.Entity.Reviewer;
import SystemAdmin.entity.SystemAdmin;
import general.Entity.User;
import SystemAdmin.entity.*;

@WebServlet (urlPatterns = {"/newUserProfileForm", "/newUserProfile"})
public class AddNewUserProfileController extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try {
            newUserProfile(request, response);
        } catch (SQLException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        newUserProfileForm(request,response);
    }
    
    
    
    protected void newUserProfileForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        RequestDispatcher dis = request.getRequestDispatcher("UserProfileForm.jsp");
        dis.forward(request, response);
    }
    
    protected void newUserProfile(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
        String profilename = request.getParameter("profilename");
        String description = request.getParameter("description");
        
        SystemAdmin temp = new SystemAdmin();
        
        HttpSession session = request.getSession();
        
        if (temp.insertNewProfile(profilename, description)) {
            session.setAttribute("message", "Successfully create a Profile");
            response.sendRedirect("HomePageAdmin.jsp");
        }else {
            session.setAttribute("message", "Failed to create a Profile");
            response.sendRedirect("HomePageAdmin.jsp");
        }
        
        
        
    }
}
