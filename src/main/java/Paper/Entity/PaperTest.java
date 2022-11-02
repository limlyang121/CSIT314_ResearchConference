package Paper.Entity;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;


public class PaperTest {
    private Paper myPaper;
    
    @Before
    public void setUp() throws Exception {
        myPaper = new Paper();
    }

    @After
    public void tearDown() throws Exception {
        this.myPaper = null;
    }

    @Test
    public void RatePaperTest() {
        myPaper = new Paper();
        assertTrue ("Rate paper Success ", myPaper.AcceptRejectPaper(10, "Accept"));
    }
    
    @Test
    public void EditPaperTest() {
        ArrayList<String> au = new ArrayList<String>();
        au.add("author9");
        au.add("author98");
        myPaper  = new Paper();
        
        assertTrue("Edit Paper Success", myPaper.editPaper(93, "Test Paper", au));
    }
    
    @Test
    public void DeletePaperTest() {
        myPaper  = new Paper();
        
        assertTrue("Edit Paper Success", myPaper.deletePaper(92));
    }
    
    
    

}
