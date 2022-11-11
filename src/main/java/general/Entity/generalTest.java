package general.Entity;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import SystemAdmin.entity.SystemAdmin;


public class generalTest {
    private User temp;

    @Before
    public void setUp() throws Exception {
        temp = new User();
    }

    @After
    public void tearDown() throws Exception {
        temp = null;
    }

    @Test
    public void loginTest() {
        assertTrue("Test User Login",temp.login("admin", "admin", "systemadmin"));

    }
    
    @Test
    public void readUserTest() {
        temp = new User();
        User myAcc = new User(1,"admin", "AdminTest", "admin",  "adminTest@gmail.com", 1, "systemadmin");
        User expected = temp.getMyInfo("admin", "systemadmin");
        
        
        
        assertEquals("Test if same account" , myAcc, expected);
    }
    
    @Test
    public void updateMyAccountTest() {
        
        assertTrue ("Test Update my Account ", temp.updateMyAccount(99, "admin999", "AdminTest", "admin999", "adminTest@gmail.com", "systemadmin", "A" ));

    }
    
    
    
}
