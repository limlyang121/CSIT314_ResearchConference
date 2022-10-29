package Review.DAO;

import java.sql.Connection;
import Review.Entity.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Bid.Entity.Bid;
import Reviewer.Entity.Reviewer;
import dbconnection.DbConnection;
import general.Entity.User;

public class ReviewDAO{
    
    public boolean submitReview(String review, int rating, int paperid, int reviewerid)throws SQLException{
        int rs = 0;
        String insertreview = "Update reviews set reviewContent = ? , rating = ? where paperidfk = ? and reviewer = ?;";
 try(Connection connection = DbConnection.init();
                
                PreparedStatement preparedStatement = connection.prepareStatement(insertreview);)
        {
                 preparedStatement.setString(1, review);
                 preparedStatement.setInt(2, rating);
                 preparedStatement.setInt(3, paperid);
                 preparedStatement.setInt(4, reviewerid);
                 rs = preparedStatement.executeUpdate();
        }
        return true;
    }
    
    public boolean allocatePaper(int bidID) {
        String allocate_paper = "insert into reviews (`bid_id`, `paperidfk`, `reviewer`) values (?, ?, ?);";
        Bid myBid = new Bid().getBidInfoByID(bidID);
        try(Connection connection = DbConnection.init();
                
                PreparedStatement preparedStatement = connection.prepareStatement(allocate_paper))
        {
            preparedStatement.setInt(1, bidID);
            preparedStatement.setInt(2, myBid.getPaper_id());
            preparedStatement.setInt(3, myBid.getReviewer_id());
            preparedStatement.executeUpdate();
            return true;
        }catch (SQLException e) {
            return false;
        }
        
        
    }
    
    public boolean unAllocatePaper(int paperID, int reviewerID) {
        String unallocate_paper = "delete from reviews where paperidfk = ? and reviewer = ?;";
        
        try(Connection connection = DbConnection.init();
                
                PreparedStatement preparedStatement = connection.prepareStatement(unallocate_paper))
        {
            preparedStatement.setInt(1, paperID);
            preparedStatement.setInt(2, reviewerID);
            preparedStatement.executeUpdate();
            return true;
        }catch (SQLException e) {
            return false;
        }
    }
    
    public boolean checkReviewerReachMaxPaper(int reviewerID) {
        String checkReviewerMaxPaper = "select * from reviewer "
                + "inner join reviews on reviewer.id = reviews.reviewer where reviewer.id = ?;";
        try(Connection connection = DbConnection.init();
                
                PreparedStatement preparedStatement = connection.prepareStatement(checkReviewerMaxPaper))
        {
            User temp = new User().getInfoByID(reviewerID, "reviewer");
            preparedStatement.setInt(1, reviewerID);
            int currentPaper = 0;
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                currentPaper++;
            }
            
            if (currentPaper >= ((Reviewer)temp).getMax_no_papers()) {
                return false;
            }else
                return true;
        }catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    
    public ArrayList<Review> showMyReviews(int userid)throws SQLException{
        ArrayList<Review> rev = new ArrayList<>();
        String getreview = "Select review_id, reviewContent, paperidfk, rating from reviews where reviewer = ? and reviewContent is not null;";
        String getpapername = "Select paperName from paper where paper_id = ?;";
        
  try(Connection connection = DbConnection.init();
                
                PreparedStatement preparedStatement1 = connection.prepareStatement(getreview);
                PreparedStatement preparedStatement2 = connection.prepareStatement(getpapername))
        {
                preparedStatement1.setInt(1, userid);
                ResultSet rs = preparedStatement1.executeQuery();
                
                while(rs.next()) {
                    preparedStatement2.setInt(1, rs.getInt("paperidfk"));
                    ResultSet rs2 = preparedStatement2.executeQuery();
                    rs2.next();
                    rev.add(new Review(rs.getInt("review_id"), rs.getInt("rating"), rs2.getString("paperName"), rs.getString("reviewContent")));
                }
        }
        return rev;
    }
    
    
    
}