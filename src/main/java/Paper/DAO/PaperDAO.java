package Paper.DAO;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dbconnection.DbConnection;
import Paper.Entity.*;

public class PaperDAO{
    
    public boolean createSubmission(String filename, ArrayList<String>authors, InputStream inputStream ) {
        int rs = 0;
        int result = 0;
        if (inputStream != null) {
            // fetches input stream of the upload file for the blob column
            System.out.print("Not null");
        }
        
        String Submission_Paper = "INSERT INTO paper (paperName, fileContent, Status) values (?, ?, ?);";
        String Submission_PaperInfo = "INSERT INTO paperinfo (paperidfk, Author) values (?, ?);";
        
        try(Connection connection = DbConnection.init();
                
                PreparedStatement preparedStatement = connection.prepareStatement(Submission_Paper);
                PreparedStatement preparedStatement2 = connection.prepareStatement(Submission_PaperInfo))
        {
            
     
            preparedStatement.setString(1, filename);
            preparedStatement.setBlob(2, inputStream);
            preparedStatement.setString(3, "Pending");
            rs = preparedStatement.executeUpdate();
           
           // Submission_PaperInfo_success = rs.next();
            Statement statement1 = connection.createStatement();
            Statement statement2 = connection.createStatement();
            for(String author: authors) {
                String getAuthorID = "Select id from author where username = '"+author+"';";
                ResultSet id = statement1.executeQuery(getAuthorID);
                id.next();
                String getPaperID = "Select paper_id from paper where paperName = '"+filename+"';";
                ResultSet paperid = statement2.executeQuery(getPaperID);
                paperid.next();
                preparedStatement2.setInt(1, paperid.getInt("paper_id"));
                preparedStatement2.setInt(2, id.getInt("id"));
                result = preparedStatement2.executeUpdate();
                //Submission_Paper_success= result.next();
            }
            
            
        }catch (SQLException e) {
            printSQLException (e);
        }
        
        if(rs == 0 && result == 0){
            return true;
        }
        
        else {
            return false;
        }
        
    }
    
    public ArrayList<Paper> showMyPapers(String username) throws SQLException {
            
            ArrayList<Paper> listPaper = new ArrayList<>();
             
            try (Connection connection = DbConnection.init()) {
                
                String getauthorid = "Select id from author where username = '"+username+"'";
                Statement statement1 = connection.createStatement();
                ResultSet authid = statement1.executeQuery(getauthorid);
                authid.next();
                String paperidfk = "SELECT DISTINCT paperidfk FROM paperinfo where Author = '"+authid.getInt("id")+"';";
                Statement statement2 = connection.createStatement();
                ResultSet papidfk = statement2.executeQuery(paperidfk);
                
                while (papidfk.next()) {
                    String getPaper = "Select paper_id, paperName, Status from paper where paper_id='"+papidfk.getInt("paperidfk")+"'";
                    Statement statement3 = connection.createStatement();
                    ResultSet paper = statement3.executeQuery(getPaper);
                    paper.next();
                    String name = paper.getString("paperName");
                    String Status = paper.getString("Status");
                    int paper_id = paper.getInt("paper_id");
                    listPaper.add(new Paper(paper_id, name, Status));
                }          
                 
            } catch (SQLException ex) {
                ex.printStackTrace();
                throw ex;
            }      
             
            return listPaper;
        }
    
    
    public boolean deletePaper(int id) throws SQLException{
        int rs1 = 0;
        int rs2 = 0;
        int rs3 = 0;
        int rs4 = 0;
        int rs5 = 0;
    
        String deleteAllocation = "Delete from allocation where paperidfk = ?;";
        String deletebid = "Delete from bid where paperidfk = ?;";
        String deletereviews = "Delete from reviews where paperidfk = ?;";
        String paperinfo = "Delete from paperinfo where paperidfk = ?;";
        String paper = "Delete from paper where paper_id = ?;";
        
        try (Connection connection = DbConnection.init();
                PreparedStatement preparedStatement1 = connection.prepareStatement(deleteAllocation);
                PreparedStatement preparedStatement2 = connection.prepareStatement(deletebid);
                PreparedStatement preparedStatement3 = connection.prepareStatement(deletereviews);
                PreparedStatement preparedStatement4 = connection.prepareStatement(paperinfo);
                PreparedStatement preparedStatement5 = connection.prepareStatement(paper);){
             
            preparedStatement1.setInt(1, id);
            preparedStatement2.setInt(1, id);
            preparedStatement3.setInt(1, id);
            preparedStatement4.setInt(1, id);
            preparedStatement5.setInt(1, id);
            rs1 = preparedStatement1.executeUpdate();
            rs2 = preparedStatement2.executeUpdate();
            rs3 = preparedStatement3.executeUpdate();
            rs4 = preparedStatement4.executeUpdate();
            rs5 = preparedStatement5.executeUpdate();
            
        }
        
        if(rs1 == 0 && rs2 == 0 && rs3 == 0 && rs4 == 0 && rs5 == 0){
            return true;
        }
        
        else {
            return false;
        }
        
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