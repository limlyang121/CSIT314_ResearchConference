package Bid.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bid.Entity.Bid;

@WebServlet("/conferenceBidPage")
public class viewAllBidController extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        viewReviewerBid(request, response);
    }
    
    protected void viewReviewerBid(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Bid temp = new Bid();
        List<Bid> tempList = temp.getAllBid();
        request.setAttribute("bidInfo", tempList);
        
        RequestDispatcher dis = request.getRequestDispatcher("ConferenceBidPage.jsp");
        dis.forward(request, response);
    }
}
