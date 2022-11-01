package Bid.Entity;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


class bidTest {
    private Bid myBid ;

    @Before
    public void setUp() throws Exception {
        this.myBid = new Bid();
    }

    @After
    public void tearDown() throws Exception {
        this.myBid = null;
    }

    @Test
    public void BidPaperTest() throws SQLException {
        
        assertTrue("Bid Paper Success", myBid.bidPaper(1, 99));
        
    }
    
    @Test
    public void RejectBidTest() throws SQLException {
        
        
        assertTrue("Bid Paper Success", myBid.RejectBid(1));
        
    }
    
    

}
