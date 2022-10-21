package SystemAdmin.DAO;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import SystemAdmin.entity.*;
import Author.Entity.*;
import Reviewer.Entity.*;
import ConferenceChair.Entity.*;
import general.Entity.*;
import dbconnection.DbConnection;


public class SystemAdminDAO {  
    
    public void insertNewProfile(String profileName, String description)throws SQLException   {
           String insert_new_profile = "insert into userprofile (`profilename`, `description`) VALUES"
                   + " (?, ?)";
           try(Connection connection = DbConnection.init();
                   
                   PreparedStatement preparedStatement = connection.prepareStatement(insert_new_profile))
           {
               preparedStatement.setString(1, profileName);
               preparedStatement.setString(2, description);
               preparedStatement.executeUpdate();
           }
    }
   
    public boolean updateProfile(String profileName, String description){
        String update_user_profile = "update userprofile set profilename = ?, description = ? where profilename = ?;";
   
        try(Connection connection = DbConnection.init();
                
                PreparedStatement preparedStatement = connection.prepareStatement(update_user_profile))
        {
            preparedStatement.setString(1, profileName);
            preparedStatement.setString(2, description);
            preparedStatement.setString(3, profileName);
            preparedStatement.executeUpdate();
            return true;
        }catch (SQLException e) {
        	return false;
        }
 }

    public boolean updateUserAccount(String username, String password, String name, String email, String profileName, String oldUserName, String oldProfileName) throws SQLException  {        
        if (!(oldProfileName.equalsIgnoreCase(profileName))) {
            
            String delete_one_from_db = "delete from " +oldProfileName + " where username = ?;";
            try(Connection connection = DbConnection.init();
                    
                    PreparedStatement preparedStatement = connection.prepareStatement(delete_one_from_db))
            {
                preparedStatement.setString(1, oldUserName);
                preparedStatement.executeUpdate();
                insertNewUser (username, password, name, email, profileName);
                return true;
            }
        }else {
            String update_one_in_database = "update " + profileName+ " set username = ?, fullname = ?, password = ?, email = ?, profilename = ? "
                    + "where username = ?;";
            try(Connection connection = DbConnection.init();
                    
                    PreparedStatement preparedStatement = connection.prepareStatement(update_one_in_database))
            {
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, name);
                preparedStatement.setString(3, password);
                preparedStatement.setString(4, email);
                preparedStatement.setString(5, profileName);
                preparedStatement.setString(6, oldUserName);
                
                preparedStatement.executeUpdate();
                
                return true;
                
                
            }
            
        }
       
    }
    
    public User readUser(String tempUsername, String profileName) {
        String SELECT_ONE_FOR_READ = "select * from "+ profileName + " where username = ?;";
        User temp = new User();
        
        try(Connection connection = DbConnection.init();
                
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ONE_FOR_READ))
        {
//            preparedStatement.setString(1, profileName);
            preparedStatement.setString(1, tempUsername);
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()) {
                String userName = rs.getString("username");
                String password = rs.getString("password");
                String email = rs.getString("email");
                String name = rs.getString("fullname");
                String profilename = rs.getString("profilename");
                if (profileName.equalsIgnoreCase("systemAdmin")) {
                    temp = new SystemAdmin(userName, name, password, email, profilename);
                }else if (profileName.equalsIgnoreCase("Reviewer")){
                    temp = new Reviewer(userName, name, password, email, profilename);
                }else if (profileName.equalsIgnoreCase("Author")){
                    temp = new Author(userName, name, password, email, profilename);
                }else if (profileName.equalsIgnoreCase("Conference")){
                    temp = new ConferenceChair(userName, name, password, email, profilename);
                }

                

            }
            
        }catch (SQLException e) {
            printSQLException (e);
        }
        

        return temp;

        
        
    }
    
    public List<User> getAllProfile(){
        List<User> allProfile = new ArrayList<User>();  
        String SELECT_ALL_USER_DATABASE = "select * from userprofile ;";
        try(Connection connection = DbConnection.init();
                
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USER_DATABASE))
        {
//            preparedStatement.setString(1, profileName);
            
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                
                String profilename = rs.getString("profilename");
                String description = rs.getString("description");
                allProfile.add(new User(profilename,description));
                
    
            }
        }catch (SQLException e) {
            printSQLException (e);
        }
           return allProfile;
    }
    
    public User getProfile(String profileName) {
        User temp = new User();
        String select_one_profile = "select * from userprofile where profilename = ? ;";
        try(Connection connection = DbConnection.init();
                PreparedStatement preparedStatement = connection.prepareStatement(select_one_profile))
        {
            preparedStatement.setString(1, profileName);
            ResultSet rs = preparedStatement.executeQuery();
            
            rs.next();
            
            String profilename = rs.getString("profilename");
            String description = rs.getString("description");
            temp = new User(profilename, description);

        }catch(SQLException e) {
            printSQLException (e);
        }
        return temp;
        
    }
    
    public List<User> viewAllUserAccount(){
        List<User> tempUser = new ArrayList<User>();
        List<User> tempProfile = getAllProfile();
        for (int i = 0 ; i < tempProfile.size(); i++) {
            String SELECT_USER_FROM_EACH_DATABASE= "select * from " + tempProfile.get(i).getProfileName()+" ;";
            try(Connection connection = DbConnection.init();
                    
                    PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_FROM_EACH_DATABASE))
            {
//                
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    User temp ;
                    String username = rs.getString("username");
                    String password = rs.getString("password");
                    String email = rs.getString("email");
                    String name = rs.getString("fullname");
                    String profileName = rs.getString("profileName");
                            
                    temp = new User(username, name, password, email, profileName);
                    
                    tempUser.add(temp);
                }
            }catch (SQLException e) {
                printSQLException (e);
            }

        }
        return tempUser;
    }
    
    public void insertNewUser(String username, String password, String name, String email, String profileName) throws SQLException {
        final String INSERT_USEERACCOUNT = "INSERT INTO " + profileName + "(`username`,`fullname`, `password`, email , `profileName`) VALUES"
                + "(?, ?, ?, ?, ?)";
        try (Connection connection = DbConnection.init();
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USEERACCOUNT)) 
        {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, password);
            preparedStatement.setString(4, email);
            preparedStatement.setString(5, profileName);
            preparedStatement.executeUpdate(); 
        }
    }
    
    public boolean userProfileExist(String profilename) {
        final String check_profilename_exist = "select 1 from userprofile where profilename = ?";
        boolean profileExist = false;
        
        try (Connection connection = DbConnection.init();
                PreparedStatement preparedStatement = connection.prepareStatement(check_profilename_exist )) 
        {
            preparedStatement.setString(1, profilename);
            ResultSet rs = preparedStatement.executeQuery();
            profileExist = rs.next();
            
        }catch (SQLException e) {
            printSQLException (e);
        }
        
        return profileExist;
    }
    
    public boolean usernameExist(String username, String profileName) {
        final String CHECK_USERNAME_EXIST_ID = "select 1 from " + profileName +" where username = ? ;";
        
        boolean usernameExist = false;
        try (Connection connection = DbConnection.init();
                PreparedStatement preparedStatement = connection.prepareStatement(CHECK_USERNAME_EXIST_ID )) 
        {
            preparedStatement.setString(1, username);
            ResultSet rs = preparedStatement.executeQuery();
            usernameExist = rs.next();
            
        }catch (SQLException e) {
            printSQLException (e);
        }
        
        return usernameExist;
    }
    

//    public List<UserAccount> searchUserAccount(String searchName){
//        List<UserAccount> userAccounts = new ArrayList<>();
//        try(Connection connection = DbConnection.init();
//                PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_USERACCOUNT_BY_NAME))
//        {
//            preparedStatement.setString(1, searchName);
//            ResultSet rs =preparedStatement.executeQuery();
//            while (rs.next()) {
//                int id = rs.getInt(1);
//                String name = rs.getString("name");
//                String username = rs.getString("username");
//                String password = rs.getString("password");
//                String status = rs.getString("status");
//                int profileID = rs.getInt("userprofile");
//                String profile = rs.getString("profile");
//                String description = rs.getString("description");
//                
//                 
//                UserProfile tempP = new UserProfile (profileID, profile, description);
//                UserAccount temp = new UserAccount(id ,name ,username, password, status, tempP);
//                userAccounts.add(temp);
//                
//                
//            }
//            
//        
//        }catch(SQLException e) {
//            printSQLException(e);
//        }
//                
//        return userAccounts;
//    }
 
    
    private void printSQLException(SQLException ex) 
    {
        for (Throwable e : ex) 
        {
            if (e instanceof SQLException) 
            {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) 
                {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
    
}
