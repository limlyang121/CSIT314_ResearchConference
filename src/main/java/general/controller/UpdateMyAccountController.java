package general.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Reviewer.Entity.Reviewer;
import SystemAdmin.entity.SystemAdmin;
import general.Entity.User;

@WebServlet (urlPatterns = {"/selfUpdateForm", "/selfUpdate"})
public class UpdateMyAccountController extends HttpServlet {
    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
        selfUpdateForm (request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
        selfUpdate(request,response);
    }
    
    
    protected void selfUpdateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
        String username = request.getParameter("username");
        String profileName = request.getParameter("profileName");
       
        
        User temp = new SystemAdmin().readUser(username, profileName);
        
        request.setAttribute("myAccount", temp);
        
        RequestDispatcher dis = request.getRequestDispatcher("myUserUpdate.jsp");
        dis.forward(request, response);
    }
    
    protected void selfUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException   {
        HttpSession session = request.getSession();
        String profileName = request.getParameter("profileName");
        int myID = Integer.parseInt(request.getParameter("id"));
        String username = request.getParameter("myusername");
        String name = request.getParameter("myname");
        String email = request.getParameter("myemail");
        String password = request.getParameter("mypassword");
        String oldUsername = request.getParameter("oldusername");
        User temp ;
        
        

        boolean success = false;
        if (profileName.equalsIgnoreCase("reviewer")) {
            int maxPaper = Integer.parseInt(request.getParameter("maxPaper")) ;
            Reviewer tempA = new Reviewer();
            if (tempA.checkUserNameSame(username, oldUsername) || !(tempA.usernameExist(username, profileName)) )
                success =tempA.updateMyAccountR(myID, username, password, name, email, maxPaper,profileName);

        }else {
            temp = new User();
            if (temp.checkUserNameSame(username, oldUsername) || !(temp.usernameExist(username, profileName)) )
                success = temp.updateMyAccount(myID, username, password, name, email, profileName);
        }

        if (success) {
            session.setAttribute("username", username);            
            session.setAttribute("message", "Successfully Updated");
            if (profileName.equalsIgnoreCase("conference")) {
                response.sendRedirect("HomePageConference.jsp");
            }else if (profileName.equalsIgnoreCase("Author"))
                response.sendRedirect("HomePageAuthor.jsp");
            else if (profileName.equalsIgnoreCase("Reviewer")){
                response.sendRedirect("HomePageReviewer.jsp");
            }
                
        }else {
            session.setAttribute("message", "Fail to Update");
            response.sendRedirect("selfUpdateForm?username="+oldUsername+"&profileName="+profileName);
        }
        
    }
}
