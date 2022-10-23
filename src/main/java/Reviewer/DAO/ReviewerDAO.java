package Reviewer.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dbconnection.DbConnection;

public class ReviewerDAO {
    public boolean updateReviewer(int myID, String username, String password, String name ,String email,int maxPapers ,String profileName) {
        String updateMyAccount = "update "+ profileName +" set username = ?, fullname = ?, password = ?, email = ?,max_no_paper = ? where id = ?;";
        
        try(Connection connection = DbConnection.init();
                
                PreparedStatement preparedStatement = connection.prepareStatement(updateMyAccount))
        {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, password);
            preparedStatement.setString(4, email);
            preparedStatement.setInt(5, maxPapers);
            preparedStatement.setInt(6, myID);
            
            preparedStatement.executeUpdate();
            return true;
            
            
        }catch (SQLException e) {
            return false;
        }

    }
    
    
}
