package Reviewer.Entity;

import general.Entity.*;

public class Reviewer extends User {
    private int max_no_papers;
    
    

    public Reviewer(int id, String username, String fullname, String password, String email, int profileID,
            String profileName, int max_no_papers) {
        super(id, username, fullname, password, email, profileID, profileName);
        this.max_no_papers = max_no_papers;
    }

    public int getMax_no_papers() {
        return max_no_papers;
    }

    public void setMax_no_papers(int max_no_papers) {
        this.max_no_papers = max_no_papers;
    }

    

    
}