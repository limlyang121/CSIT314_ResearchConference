package SystemAdmin.entity;

import general.Entity.*;

import java.sql.SQLException;
import java.util.List;

import SystemAdmin.DAO.SystemAdminDAO;;


public class SystemAdmin extends User {
    private SystemAdminDAO myDAO;
    
    public List<User> viewAllUser(){
        
        return myDAO.viewAllUserAccount();
    }
    
    public boolean updateProfile(int profileID, String profileName, String description)throws SQLException   {
        return myDAO.updateProfile(profileID, profileName, description);
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
        return myDAO.updateUserAccount(username, password, name, email, profileName, oldUserName, oldProfileName);

    }
    
    public User getProfile(String profilename) {
        return myDAO.getProfile(profilename);
    }
    
    

    public List<User> viewAllProfile(){
        
        return myDAO.getAllProfile();
    }
    
    public User readUser(String userName,String profileName) {
        return myDAO.readUser(userName ,profileName);
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
    
    
    
    

    
    public SystemAdmin(int id, String username, String fullname, String password, String email, int profileID) {
        super(id, username, fullname, password, email, profileID);
        myDAO = new SystemAdminDAO();
    }

    public SystemAdmin(int ID,String username, String fullname, String password, String email, int profileID,
            String profileName, String description, SystemAdminDAO myDAO) {
        super(ID, username, fullname, password, email, profileID, profileName, description);
        myDAO = new SystemAdminDAO();
    }
    
    

    public SystemAdmin(int id,String username, String fullname, String password, String email, int profileID,
            String profileName, SystemAdminDAO myDAO) {
        super(id, username, fullname, password, email, profileID, profileName);
        myDAO = new SystemAdminDAO();
    }

    
    

    
    
    
    


    
}
