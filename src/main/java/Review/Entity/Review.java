package Review.Entity;

import java.sql.SQLException;

import Review.DAO.ReviewDAO;

public class Review{
    int paperid;
    int rating;
    int authorid;
    String review;
    ReviewDAO revDAO;
    
    public Review() {
        revDAO = new ReviewDAO();
    }
    
    public boolean submitReview(String review, int rating, int paperid, int reviewerid) throws SQLException {
        return revDAO.submitReview(review, rating, paperid, reviewerid);
    }
    
    public boolean AllocatePaper(int bidID) {
        return revDAO.allocatePaper(bidID);
    }
    
    public boolean checkReviewerReachMaxPaper(int reviewerID) {
        return revDAO.checkReviewerReachMaxPaper(reviewerID);
    }
}