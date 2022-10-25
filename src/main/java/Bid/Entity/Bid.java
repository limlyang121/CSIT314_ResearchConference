package Bid.Entity;
import java.sql.SQLException;

import Bid.DAO.*;


public class Bid{
    private int bid_id;
    private int paper_id;
    private int reviewer_id;
    private BidDAO dao;
    
    
    public Bid(){
        dao = new BidDAO();
    }
    
    
    public boolean bidPaper(int paper_id, int reviewer_id)throws SQLException {
        return dao.bidPaper(paper_id, reviewer_id);
    }
    
}