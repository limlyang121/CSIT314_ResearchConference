package Reviewer.Entity;

import java.sql.SQLException;
import java.util.ArrayList;

import Paper.Entity.Paper;
import Reviewer.DAO.*;
import general.Entity.*;

public class Reviewer extends User {
    private int max_no_papers;
    private ReviewerDAO revDAO = new ReviewerDAO();
    
    public boolean updateMyAccountR(int myID, String username, String pasword, String name, String email, int maxPapers , String profileName) {
        if (this.getMyDAO().usernameExist(username, profileName) && revDAO.updateReviewer(myID, username, pasword, name, email, maxPapers, profileName))
            return true;
        else
            return false;
    }

    public Reviewer(int id, String username, String fullname, String password, String email, int profileID,
            String profileName, int max_no_papers) {
        super(id, username, fullname, password, email, profileID, profileName);
        this.max_no_papers = max_no_papers;
    }
    
    
    public ArrayList<Paper> papersToReview(int reviewer_id)throws SQLException{
        return revDAO.papersToReview(reviewer_id);
    }
    

    public Reviewer() {
        super();
    }

    public int getMax_no_papers() {
        return max_no_papers;
    }

    public void setMax_no_papers(int max_no_papers) {
        this.max_no_papers = max_no_papers;
    }

    

    
}