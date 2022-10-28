package Bid.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Bid.Entity.Bid;
import dbconnection.DbConnection;

public class BidDAO{
    
    public boolean bidPaper(int paper_id, int reviewer_id) throws SQLException{
        String bid = "Insert into bid (reviewName, paperidfk) values  (?, ?);";
        int rs = 0;
        
        try(Connection connection = DbConnection.init();
                
                PreparedStatement preparedStatement = connection.prepareStatement(bid);)
        {

            preparedStatement.setInt(1, reviewer_id);
            preparedStatement.setInt(2, paper_id);
            rs = preparedStatement.executeUpdate();
        }
        
        catch (SQLException ex) {
            ex.printStackTrace();
            throw ex;
        }      
     
               
        return true;
    }
    
    
    public  List<Bid> getAllBid() {
        
        String getBid = "select * from bid;";
        List<Bid> allBid = new ArrayList<Bid>();
        
        try(Connection connection = DbConnection.init();
                
                PreparedStatement preparedStatement = connection.prepareStatement(getBid);)
        {
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()) {
                int bidID = rs.getInt("bid_id");
                int reviewerID = rs.getInt("reviewName");
                int paperIDFK = rs.getInt("paperidfk");
                String allocatedStatus = rs.getString("allocateStatus");
                
                Bid temp = new Bid(bidID, reviewerID, paperIDFK, allocatedStatus);
                
                allBid.add(temp);
            }
            
        }catch (SQLException e) {
            return null;
        }
        
        
        return allBid;
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