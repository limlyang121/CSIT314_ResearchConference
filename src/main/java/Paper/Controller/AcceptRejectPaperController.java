package Paper.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Paper.Entity.Paper;


@WebServlet ("/RatePaper")
public class AcceptRejectPaperController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AcceptRejectPaper (request, response);
    }
    
    protected void AcceptRejectPaper(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Paper tempPaper = new Paper();
        
        String paperStatus = request.getParameter("ratePaper");
        int paperID = Integer.parseInt(request.getParameter("paperID"));
        HttpSession session = request.getSession();

        
        if (tempPaper.AcceptRejectPaper(paperID, paperStatus)) 
            session.setAttribute("message", "Successfully Rate the Paper");
        else
            session.setAttribute("message", "Fail to Rate the Paper");
            
            
        response.sendRedirect("ViewPaperByStatus?status=All");
        
    }
}
