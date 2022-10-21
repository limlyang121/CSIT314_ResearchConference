package Reviewer.Entity;

import general.Entity.*;

public class Reviewer extends User {
    private String profileName;
    private String description;
    private int max_no_papers;

    public Reviewer(String profileName, String description) {
        super();
        this.profileName = profileName;
        this.description = description;
    }

    public Reviewer(String username, String password, String profileName) {
        super(username, password);
        this.profileName = profileName;
    }
    
    

    public Reviewer(String username, String fullname, String password, String email, String profileName) {
        super(username, fullname, password, email);
        this.profileName = profileName;
    }

    public Reviewer(String username, String password, String profileName, String description, int max_no_papers) {
        super(username, password);
        this.profileName = profileName;
        this.description = description;
        this.max_no_papers = max_no_papers;
    }

    @Override
    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    

    
}