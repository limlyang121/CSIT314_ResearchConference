package Review.Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Review.Entity.Review;

@WebServlet("/PaperReview")
public class RatePaperFromReviewController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RatePaperFromReview (request, response);
    }
    
    protected void RatePaperFromReview(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int paperID = Integer.parseInt(request.getParameter("paperID"));
        
        ArrayList<Review> paperReview = new Review().getAllPaperReview(paperID);
        request.setAttribute("PaperReview", paperReview);
        request.setAttribute("paperID", paperID);
        RequestDispatcher dis = request.getRequestDispatcher("/ConferencePaperReview.jsp");
        dis.forward(request, response);
        
        
        
    }

}
