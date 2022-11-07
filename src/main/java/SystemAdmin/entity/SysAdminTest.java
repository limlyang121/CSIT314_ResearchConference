package SystemAdmin.entity;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import general.Entity.User;

public class SysAdminTest {
    private SystemAdmin temp;

    @Before
    public void setUp() throws Exception {
        this.temp = new SystemAdmin();
    }

    @After
    public void tearDown() throws Exception {
        this.temp = null;
    }

    @Test
    public void createNewUserTest() throws SQLException {
        temp = new SystemAdmin();
        //Since already in Database
        assertFalse("Test Create New User", temp.createNewUser("admin", "admin", "YAY", "admin@gmail.com", "systemadmin"));
        //assertTrue("Test Create New User", temp.InsertNewUser("ONORE", "Onore", "YY", "ONORE@gmail.com", "systemadmin"));        
        
    }
    
    @Test
    public void updateUserTest() throws SQLException {
        temp = new SystemAdmin();
        temp.setUsername("admin");
        temp.setEmail("tosomeRandomemail@mail.com");
        temp.setFullname("AdminLongName");
        temp.setProfileName("systemadmin");
        assertTrue("Test Update user", temp.updateUser("admin", "admin", "AdminTest", "adminTest@gmail.com", "systemadmin", "admin", "systemadmin"));
        
        assertFalse("Test Update user with existing username", temp.updateUser("reviewer", "reviewer", "Reviewertest", "adminTest@gmail.com", "reviewer", "reviewer", "systemadmin"));
        
    }
    
    @Test
    public void readUser() throws SQLException {
        User myAcc = new User(1,"reviewer", "Reviewer", "reviewer",  "reviewer1@asda.com", 2, "Reviewer");
        User expected = temp.getMyInfo("reviewer", "reviewer");
        
        
        
        assertEquals("Test if same account" , myAcc, expected);
    }
    
    @Test
    public void createNewProfile() throws SQLException {
        
        assertTrue("Test create new Profile", temp.createNewProfile("Test", "Test Build"));
        
        //Second this since profile exist
        assertFalse("Test create new Profile", temp.createNewProfile("Test", "Test Build"));
        
    }
    
    @Test
    public void updateProfile() throws SQLException {
        
        assertTrue("Test create new Profile", temp.updateProfile(5, "TestUpdate", "Snap"));
        
        //Second this since profile exist
        //assertFalse("Test create new Profile", temp.createNewProfile("Test", "Test Build"));
        
    }
    
    
    
    
    
    
    

    
    
    

}
