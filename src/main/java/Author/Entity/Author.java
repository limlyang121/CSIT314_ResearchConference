package Author.Entity;

import java.io.File;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;

import general.Entity.*;
import Author.DAO.*;


public class Author extends User {
    
    private AuthorDAO authorDao = new AuthorDAO();

    public Author() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
    public ArrayList<String> readReviews(){
        return new ArrayList<String>();
    }
    
    public ArrayList<String> dropDownList(){
        return authorDao.dropdownlist();
    }
    
    public void deletePaper(String papername) {
        
    }
    
    public ArrayList<Blob>viewOwnPapers(String username){
        return new ArrayList<Blob>();
    }
    
    public boolean updateAccount(String username, String fullname, String password,  String email, String ProfileName) {
        return true;
    }
    
    public ArrayList<Author>getCoAuthors(){
        return new ArrayList<Author>();
    }
    
    public boolean updatePaper(File file, String name, String author) {
        return true;
    }
}
