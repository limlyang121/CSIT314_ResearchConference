package Reviewer.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Paper.Entity.Paper;
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
    
    public ArrayList<Paper> papersToReview(int reviewer_id) throws SQLException{
        ArrayList<Paper> rev = new ArrayList<Paper>();
        
 String paperinfo = "Select paperidfk, Author, Coauthor from paperinfo where paperidfk = (Select paperidfk from reviews where rating is null and reviewer ='"+String.valueOf(reviewer_id)+"');";
        
        try (Connection connection = DbConnection.init();
                Statement statement1 = connection.createStatement();){
            
            ResultSet paper = statement1.executeQuery(paperinfo);
            while(paper.next()) {
                String papername = "Select paperName from paper where paper_id = '"+paper.getInt("paperidfk")+"';";
                String authorname = "Select fullname from author where id = '"+paper.getInt("Author")+"';";
                String coauthorname = "Select fullname from author where id = '"+paper.getInt("Coauthor")+"';";
                
                Statement statement2 = connection.createStatement();
                Statement statement3 = connection.createStatement();
                Statement statement4 = connection.createStatement();
                
                ResultSet paper_name = statement2.executeQuery(papername);
                paper_name.next();
                ResultSet author_name = statement3.executeQuery(authorname);
                author_name.next();
                ResultSet coauthor_name = statement4.executeQuery(coauthorname);
                coauthor_name.next();
                
                rev.add(new Paper(paper.getInt("paperidfk"),  paper_name.getString("paperName"), author_name.getString("fullname"),  coauthor_name.getString("fullname")));
                
            }
        }
        return rev;
        
    }
    
    
}
