package general.Entity;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


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
}
