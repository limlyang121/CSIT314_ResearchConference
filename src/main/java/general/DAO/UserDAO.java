package general.DAO;

import dbconnection.DbConnection;
import general.Entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import Author.Entity.Author;
import ConferenceChair.Entity.ConferenceChair;
import Reviewer.Entity.Reviewer;
import SystemAdmin.entity.SystemAdmin;

public class UserDAO  {
    
  //  private static final String SELECT_USERACCOUNT_FOR_LOGIN = "select 1 from ? where username = ? and password = ?;";
    
    public boolean updateMyAccount(int myID, String username, String password, String name ,String email, String profileName) {
        String updateMyAccount = "update "+ profileName +" set username = ?, fullname = ?, password = ?, email = ? where id = ?;";
        
        try(Connection connection = DbConnection.init();
                
                PreparedStatement preparedStatement = connection.prepareStatement(updateMyAccount))
        {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, password);
            preparedStatement.setString(4, email);
            preparedStatement.setInt(5, myID);
            
            preparedStatement.executeUpdate();
            return true;
            
            
        }catch (SQLException e) {
            return false;
        }

    }
    
    public boolean login(String username, String password, String profileName) {
        boolean loginSuccessful = false;
        String SELECT_USERACCOUNT_FOR_LOGIN = "select 1 from " + profileName +" where username = ? and password = ?;";
        
        
        try(Connection connection = DbConnection.init();
       
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USERACCOUNT_FOR_LOGIN))
        {
//            preparedStatement.setString(1, profileName);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet rs = preparedStatement.executeQuery();
            loginSuccessful = rs.next();
        }catch (SQLException e) {
            printSQLException (e);
        }
        
        return loginSuccessful;
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
