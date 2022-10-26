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
        assertFalse("Test Create New User", temp.InsertNewUser("admin", "admin", "YAY", "admin@gmail.com", "systemadmin"));
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
    

    
    
    

}
