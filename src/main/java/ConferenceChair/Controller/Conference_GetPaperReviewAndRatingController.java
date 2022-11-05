package ConferenceChair.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Review.Entity.Review;

/**
 * Servlet implementation class Conference_GetPaperReviewAndRatingController
 */
@WebServlet("/ConferenceChair_GetPaperReviewAndRating")
public class Conference_GetPaperReviewAndRatingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    GetPaperReviewAndRating (request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	 protected void GetPaperReviewAndRating(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        int paperID = Integer.parseInt(request.getParameter("paperID"));
	        
	        ArrayList<Review> paperReview = new Review().getAllPaperReview(paperID);
	        request.setAttribute("PaperReview", paperReview);
	        request.setAttribute("paperID", paperID);
	        RequestDispatcher dis = request.getRequestDispatcher("/ConferenceChair_PaperReview.jsp");
	        dis.forward(request, response);
	 }

}
