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
   
    public boolean updateProfile(int profileID,String profileName, String description){
        String update_user_profile = "update userprofile set profilename = ?, description = ? where profileID = ?;";
   
        try(Connection connection = DbConnection.init();
                
                PreparedStatement preparedStatement = connection.prepareStatement(update_user_profile))
        {
            preparedStatement.setString(1, profileName);
            preparedStatement.setString(2, description);
            preparedStatement.setInt(3, profileID);
            preparedStatement.executeUpdate();
            return true;
        }catch (SQLException e) {
        	return false;
        }
 }

    public boolean updateUserAccount(String username, String password, String name, String email, String profileName, String oldUserName, String oldProfileName) throws SQLException  {        
        if (!(oldProfileName.equalsIgnoreCase(profileName))) {
            
            if (usernameExist(username, profileName)) {
                return false;
            }
            
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
            if (!(usernameExist(username, profileName)) || oldUserName.equalsIgnoreCase(username) ) {
                String update_one_in_database = "update " + profileName+ " set username = ?, fullname = ?, password = ?, email = ? "
                        + "where username = ?;";
                try(Connection connection = DbConnection.init();
                        
                        PreparedStatement preparedStatement = connection.prepareStatement(update_one_in_database))
                {
                    preparedStatement.setString(1, username);
                    preparedStatement.setString(2, name);
                    preparedStatement.setString(3, password);
                    preparedStatement.setString(4, email);
                    preparedStatement.setString(5, oldUserName);
                    
                    preparedStatement.executeUpdate();
                    
                    
                    
                }
                return true;
            }else {
                return false;
            }
            
            
        }
       
    }
   
    public User readUser(String userName, String profileName) {
        User tempP = new SystemAdmin().getProfile(profileName);
        String SELECT_ONE_FOR_READ = "select * from "+ profileName + " inner join userprofile on "+ tempP.getProfileID() + 
                " = userprofile.profileID where username = ?;";
        User temp = new User();        
        try(Connection connection = DbConnection.init();
                
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ONE_FOR_READ))
        {
//            preparedStatement.setString(1, profileName);
            preparedStatement.setString(1, userName);
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String email = rs.getString("email");
                String name = rs.getString("fullname");
                temp = new User(id,username, name, password, email, tempP.getProfileID(),tempP.getProfileName());
                

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
                int profileID = Integer.parseInt(rs.getString("profileID"));
                String profilename = rs.getString("profilename");
                String description = rs.getString("description");
                allProfile.add(new User(profileID ,profilename,description));
                
    
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
            int profileID = Integer.parseInt(rs.getString("profileID"));
            String profilename = rs.getString("profilename");
            String description = rs.getString("description");
            temp = new User(profileID,profilename, description);
            
            

        }catch(SQLException e) {
            printSQLException (e);
        }
        return temp;
        
    }
    
    public List<User> viewAllUserAccount(){
        List<User> tempUser = new ArrayList<User>();
        List<User> tempProfile = getAllProfile();
        for (int i = 0 ; i < tempProfile.size(); i++) {
            String SELECT_USER_FROM_EACH_DATABASE= "select * from " + tempProfile.get(i).getProfileName()+" inner join userprofile on "
                    + tempProfile.get(i).getProfileID()+ " = userprofile.profileID";
            try(Connection connection = DbConnection.init();
                    //private static final String SELECT_ALL_USERACCOUNTS = "select * from useraccount inner join userprofile on useraccount.userprofile "
                      //      + "= userprofile.id order by useraccount.id;";                    
                    PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_FROM_EACH_DATABASE))
            {
//                
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    User temp ;
                    int id = rs.getInt("id");
                    String username = rs.getString("username");
                    String password = rs.getString("password");
                    String email = rs.getString("email");
                    String name = rs.getString("fullname");
                    int profileID = Integer.parseInt(rs.getString("profileID"));
                    String profileName = rs.getString("profileName");
                    String desc = rs.getString("description");
                            
                    temp = new User(id,username, name, password, email, profileID, profileName, desc);
                    
                    tempUser.add(temp);
                }
            }catch (SQLException e) {
                printSQLException (e);
            }

        }
        return tempUser;
    }
    
    public void insertNewUser(String username, String password, String name, String email, String profileName) throws SQLException {
        
        final String INSERT_USEERACCOUNT = "INSERT INTO " + profileName + "(`username`,`fullname`, `password`, email , `profileID`) VALUES"
                + "(?, ?, ?, ?, ?)";
        try (Connection connection = DbConnection.init();
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USEERACCOUNT)) 
        {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, password);
            preparedStatement.setString(4, email);
            int profileID = 0;
            if (profileName.equalsIgnoreCase("systemadmin")) 
                profileID = 1;
            else if (profileName.equalsIgnoreCase("reviewer"))
                profileID = 2;
            else if (profileName.equalsIgnoreCase("Conference"))
                profileID = 3;
            else if (profileName.equalsIgnoreCase("Author"))
                profileID = 4;
            
            
            preparedStatement.setInt(5, profileID);
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
