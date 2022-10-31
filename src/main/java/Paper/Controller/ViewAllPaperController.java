package Paper.Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Paper.Entity.Paper;

@WebServlet ("/viewAllPaper")
public class ViewAllPaperController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ViewAllPaper (request, response);
    }
    
    protected void ViewAllPaper(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Paper temp = new Paper();
        ArrayList<Paper> allPaper = temp.getAllPapers();
        request.setAttribute("paperInfo", allPaper);
        RequestDispatcher dis = request.getRequestDispatcher("/ConferenceViewPaper.jsp");
        dis.forward(request, response);
        
    }
}
