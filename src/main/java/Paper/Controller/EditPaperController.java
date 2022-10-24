package Paper.Controller;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Author.Entity.Author;
import Paper.Entity.*;


@WebServlet ("/EditPaper")
public class EditPaperController extends HttpServlet{
    int id = 0;
    String username = "";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        id = Integer.parseInt(request.getParameter("paperid"));
        username = request.getParameter("username");
        listAuthor(request, response);
    }
    
    
    private void listAuthor(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Author dao = new Author();
        Paper paper = new Paper();
 
        try {
 
            List<String> dropdown = dao.dropDownList();
            Paper newpaper = paper.getpaperInfo(id, username);
            request.setAttribute("listAuthor", dropdown);
            request.setAttribute("paperinfo", newpaper);
            RequestDispatcher dispatcher = request.getRequestDispatcher("EditPaper.jsp");
            dispatcher.forward(request, response);
 
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Paper paper = new Paper();
        // gets values of text fields
        String filename = request.getParameter("fileName");
        String co_author = request.getParameter("authors");
        ArrayList<String> authors = new ArrayList<String>();
        authors.add(co_author);
        authors.add(username);
 
        try {
            
            boolean result = paper.editPaper(id, filename, authors);
            if(result){response.sendRedirect("ShowMyPapers?username="+username);}
            return;
 
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
    }
}