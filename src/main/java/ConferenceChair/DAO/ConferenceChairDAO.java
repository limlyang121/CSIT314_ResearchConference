package ConferenceChair.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dbconnection.DbConnection;

public class ConferenceChairDAO {

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
}
