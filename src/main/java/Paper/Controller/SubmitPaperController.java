package Paper.Controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Author.DAO.*;
import Author.Entity.Author;
import general.Entity.Paper;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.servlet.*;

@WebServlet ("/SubmissionPaper")
@MultipartConfig(maxFileSize = 16177215)    // upload file's size up to 16MB
public class SubmitPaperController extends HttpServlet{
    String username = "";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        listAuthor(request, response);
        username = request.getParameter("username");
        
    }
 
    private void listAuthor(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Author dao = new Author();
 
        try {
 
            List<String> dropdown = dao.dropDownList();
            request.setAttribute("listAuthor", dropdown);
            RequestDispatcher dispatcher = request.getRequestDispatcher("SubmissionPaper.jsp");
            dispatcher.forward(request, response);
 
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException{
        
        // gets values of text fields
        String filename = request.getParameter("fileName");
        String co_author = request.getParameter("authors");
        
        System.out.print(username);
        InputStream inputStream = null; // input stream of the upload file
         
        // obtains the upload file part in this multipart request
        Part filePart = request.getPart("paper");
        inputStream = filePart.getInputStream();
        ArrayList<String> authors = new ArrayList<String>();
        authors.add(co_author);
        authors.add(username);
        
        Paper paper = new Paper();
        boolean success = paper.createSubmission(filename, authors, inputStream);
       
        if(success){response.sendRedirect("ShowMyPapers.jsp");}
        return;
    }
    
 
}