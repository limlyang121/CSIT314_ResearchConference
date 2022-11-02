package Review.Entity;

import static org.junit.Assert.assertTrue;

import java.sql.SQLException;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Bid.Entity.Bid;

public class ReviewTest {
    private Review myReview;

    @Before
    public void setUp() throws Exception {
        this.myReview = new Review();
    }

    @After
    public void tearDown() throws Exception {
        this.myReview = null;
    }

    @Test
    public void AllocatePaperTest() throws SQLException {
        
        assertTrue("Allocate Paper Success", myReview.AllocatePaper(101) );
    }
    
    @Test
    public void UnAllocatePaperTest() throws SQLException {
        
        assertTrue("Allocate Paper Success", myReview.UnAllocatePaper(101));
    }
    
    @Test
    public void UpdatePaper() throws SQLException {
        
        assertTrue("Allocate Paper Success", myReview.UnAllocatePaper(101));
    }

}
