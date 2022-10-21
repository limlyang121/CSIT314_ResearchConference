package SystemAdmin.entity;

import general.Entity.*;

import java.sql.SQLException;
import java.util.List;

import SystemAdmin.DAO.SystemAdminDAO;;


public class SystemAdmin extends User {
    private String profileName;
    private String description;
    private SystemAdminDAO myDAO;
    
    public List<User> viewAllUser(){
        
        return myDAO.viewAllUserAccount();
    }
    
    public boolean updateProfile(String profileName, String description)throws SQLException   {
        return myDAO.updateProfile(profileName, description);
    }
    
    public boolean insertNewProfile(String profileName, String description)throws SQLException  {
        if (!myDAO.userProfileExist(profileName)){
            myDAO.insertNewProfile(profileName, description);
            return true;
        }else {
            return false;
        }
    }
    
    public boolean updateUser(String username, String password, String name, String email, String profileName, String oldUserName, String oldProfileName)throws SQLException {
        if (!(myDAO.usernameExist(username, profileName)) || oldProfileName.equalsIgnoreCase(profileName) ) {
            return myDAO.updateUserAccount(username, password, name, email, profileName, oldUserName, oldProfileName);
        }else {
            return false;
        }
    }
    
    public User getProfile(String profilename) {
        return myDAO.getProfile(profilename);
    }
    
    

    public List<User> viewAllProfile(){
        
        return myDAO.getAllProfile();
    }
    
    public User readUser(String username, String profileName) {
        return myDAO.readUser(username, profileName);
    }
    
    public boolean InsertNewUser(String username, String passowrd, String name, String email, String profileName )throws SQLException {
        if (!myDAO.usernameExist(username, profileName)) {
            myDAO.insertNewUser(username, passowrd, name, email, profileName);
            return true;
        }else {
            return false;
        }
    }
    

    public SystemAdmin() {
        super();
        myDAO = new SystemAdminDAO();
    }
    
    public SystemAdmin(String profileName, String description) {
        super();
        this.profileName = profileName;
        this.description = description;
    }



    public SystemAdmin(String username, String fullname, String password, String email, String profileName) {
        super(username, fullname, password, email);
        this.profileName = profileName;
        myDAO = new SystemAdminDAO();
    }



    @Override
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
