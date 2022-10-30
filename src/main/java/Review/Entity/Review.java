package Review.Entity;

import java.sql.SQLException;
import java.util.ArrayList;

import Review.DAO.ReviewDAO;

public class Review{
    int reviewid;
    int paperid;
    int rating;
    int authorid;
    String papername;
    String review;
    String reviewername;
    ReviewDAO revDAO;
    
    public Review() {
        revDAO = new ReviewDAO();
    }
    
    public Review(String review, int rating) {
        this.review = review;
        this.rating = rating;
    }
    
    public Review(int reviewid, int rating, String papername, String review) {
        this.reviewid = reviewid;
        this.rating = rating;
        this.papername = papername;
        this.review = review;
        
    }
    
    public Review(int paperid, String papername, String review, int rating, String reviewername) {
        this.paperid = paperid;
        this.papername = papername;
        this.review = review;
        this.rating = rating;
        this.reviewername = reviewername;
    }
    
    public boolean submitReview(String review, int rating, int paperid, int reviewerid) throws SQLException {
        return revDAO.submitReview(review, rating, paperid, reviewerid);
    }
    
    public ArrayList<Review> showMyReviews(int userid)throws SQLException{
        return revDAO.showMyReviews(userid);
    }
    
    public ArrayList<Review> showReviewsforAuthor(int userid){
        return revDAO.showReviewsforAuthor(userid);
    }
    
    public boolean editReview(int reviewid, String reviewcontent, int rating) {
        return revDAO.editReview(reviewid, reviewcontent, rating);
    }
    
    public boolean deleteReview(int id) {
        return revDAO.deleteReview(id);
    }
    
    public Review getInfoforEdit(int revid) {
        return revDAO.getInfoforEdit(revid);
    }
    
    public boolean AllocatePaper(int bidID) {
        return revDAO.allocatePaper(bidID);
    }
    
    public boolean UnAllocatePaper(int bidID) {
        return revDAO.UnAllocatePaper(bidID);
    }
    
    public boolean checkReviewerReachMaxPaper(int reviewerID) {
        return revDAO.checkReviewerReachMaxPaper(reviewerID);
    }
    
    public int getReviewid() {
        return reviewid;
    }
    
    public int getPaperid() {
        return paperid;
    }
    
    public int getRating() {
        return rating;
    }
    
    public int getAuthorid() {
        return authorid;
    }
    
    public String getPapername() {
        return papername;
    }
    
    public String getReview() {
        return review;
    }
    
    public String getReviewername() {
        return reviewername;
    }
}