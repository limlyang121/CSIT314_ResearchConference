package Reviewer.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Paper.Entity.Paper;
import Review.Entity.*;


@WebServlet(urlPatterns="/ShowmyReviews")
public class ShowMyReviewsController extends HttpServlet{
    
    int reviewer_id;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        reviewer_id = Integer.parseInt(request.getParameter("userid"));
        listPaper(request,response);
    }
    
    
    private void listPaper(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Review rev = new Review();
 
        try {
           
            ArrayList<Review> listPaper = rev.showMyReviews(reviewer_id);
            request.setAttribute("listPaper", listPaper);
            RequestDispatcher dispatcher = request.getRequestDispatcher("ShowMyReviews.jsp");
            dispatcher.forward(request, response);
 
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
    }
    
    
    
}