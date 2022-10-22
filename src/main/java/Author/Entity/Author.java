<<<<<<< Updated upstream
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
    
    public ArrayList<String> dropDownList() throws SQLException{
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
=======
package Author.Entity;

import general.Entity.*;


public class Author extends User {
    private String profileName;
    private String description;
    

    public Author(String profileName, String description) {
        super();
        this.profileName = profileName;
        this.description = description;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
    
    
    
    
}
>>>>>>> Stashed changes
