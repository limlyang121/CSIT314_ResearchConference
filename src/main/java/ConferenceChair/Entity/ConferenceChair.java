package ConferenceChair.Entity;

import ConferenceChair.DAO.ConferenceChairDAO;
import general.Entity.*;

public class ConferenceChair  extends User{
    private ConferenceChairDAO myDAO;

    public ConferenceChair() {
        super();
        myDAO = new ConferenceChairDAO();
    }

    public ConferenceChair(int id, String username, String fullname, String password, String email, int profileID,
            String profileName, String description) {
        super(id, username, fullname, password, email, profileID, profileName, description);
        myDAO = new ConferenceChairDAO();
    }
    
    

    
    
}
