package ConferenceChair.Entity;

import general.Entity.*;

public class ConferenceChair  extends User{
    private String profileName;
    private String description;
    
    
    
    public ConferenceChair(String username, String fullname, String password, String email, String profileName) {
        super(username, fullname, password, email);
        this.profileName = profileName;
    }

    

    public ConferenceChair(String profileName, String description) {
        super();
        this.profileName = profileName;
        this.description = description;
    }



    public ConferenceChair(String username, String password, String profileName) {
        super(username, password);
        this.profileName = profileName;
    }

    public ConferenceChair(String username, String fullname, String password, String email, String profileName,
            String description) {
        super(username, fullname, password, email);
        this.profileName = profileName;
        this.description = description;
    }

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
