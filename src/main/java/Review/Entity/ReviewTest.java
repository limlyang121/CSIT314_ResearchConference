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
    public void SubmitReviewTest() throws SQLException {
        myReview = new Review();
        assertTrue("Success Submit review", myReview.submitReview("Test Review", 2, 1, 3) );
    }
    
    @Test
    public void EditReviewTest() throws SQLException {
        assertTrue("Success Submit review", myReview.editReview(61, "Edit Comment Test", 2) );
    }
    
    @Test
    public void DeleteReviewTest() throws SQLException {
        assertTrue ("Delete Review Test ",myReview.deleteReview(121) );
    }
    
    

}
