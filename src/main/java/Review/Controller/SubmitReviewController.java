package Review.Controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Review.Entity.Review;

@WebServlet ("/submitReview")
public class SubmitReviewController extends HttpServlet{
    int paperid = 0;
    int userid = 0;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        paperid = Integer.parseInt(request.getParameter("paperid"));
        userid = Integer.parseInt(request.getParameter("userid"));
      
        response.sendRedirect("SubmitReview.jsp");
    }
    
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException{
        
        // gets values of text fields
        String content = request.getParameter("review");
        int rating = Integer.parseInt(request.getParameter("rating"));
        
        try {
        
       Review rev = new Review();
       boolean success = rev.submitReview(content, rating, paperid, userid);
       
       if(success){response.sendRedirect("ShowOtherReviews?paperid="+String.valueOf(paperid)+"&"+"userid="+String.valueOf(userid));}
       return;
        
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
    }
    
}