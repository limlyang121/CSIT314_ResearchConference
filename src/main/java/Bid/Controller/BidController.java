package Bid.Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bid.Entity.Bid;



@WebServlet ("/bidPaper")
public class BidController extends HttpServlet{
    int paperid = 0;
    int userid = 0;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        paperid = Integer.parseInt(request.getParameter("paperid"));
        userid = Integer.parseInt(request.getParameter("userid"));
        bidPaper(request, response);
    }
    
    private void bidPaper(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Bid bid = new Bid();
 
        try {
            
            boolean result = bid.bidPaper(paperid, userid);
            if(result){response.sendRedirect("ShowAllPaperstoBid?userid="+String.valueOf(userid));}
            return;
 
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
    }
    
    
    
}