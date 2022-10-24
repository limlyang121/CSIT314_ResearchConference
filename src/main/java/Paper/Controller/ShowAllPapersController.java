package Paper.Controller;
import java.io.IOException;

import java.sql.SQLException;
import java.util.ArrayList;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Paper.Entity.*;


@WebServlet(urlPatterns="/ShowAllPapers")
public class ShowAllPapersController extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        listPaper(request,response);
    }
    
    
    private void listPaper(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Paper paper = new Paper();
 
        try {
           
            ArrayList<Paper> listPaper = paper.showAllPapers();
            request.setAttribute("listPaper", listPaper);
            RequestDispatcher dispatcher = request.getRequestDispatcher("BidForPapers.jsp");
            dispatcher.forward(request, response);
 
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
    }
}