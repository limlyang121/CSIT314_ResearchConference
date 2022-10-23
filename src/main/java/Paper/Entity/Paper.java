package Paper.Entity;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;

import Paper.DAO.PaperDAO;



public class Paper{
    
    private String papername;
    private int id;
    private String author;
    private String coauthor;
    private FileInputStream inputstream;
    private String status;
    private PaperDAO paperDao;
    
    public Paper(){
        paperDao = new PaperDAO();
    }
    
    public Paper(int id,String papername, String status) {
        this.id = id;
        this.papername = papername;
        this.status = status;
        paperDao = new PaperDAO();
    }
    
    public Paper(String papername, int id, String co_author) {
        this.id = id;
        this.papername = papername;
        this.coauthor = co_author;
        paperDao = new PaperDAO();
    }
    
    public Paper(String papername, String author, FileInputStream inputstream, String status){
        this.papername = papername;
        this.author = author;
        this.inputstream = inputstream;
        this.status = status;
        paperDao = new PaperDAO();
        
    }
    
    public Paper(String papername, String status){
        this.papername = papername;
        this.status = status;
        paperDao = new PaperDAO();
        
    }
    
    public Paper(String papername, String author, String status){
        this.papername = papername;
        this.author = author;
        this.status = status;
        paperDao = new PaperDAO();
        
    }
    
    public boolean createSubmission(String filename, ArrayList<String>authors, InputStream inputStream ) {
        return paperDao.createSubmission(filename, authors, inputStream);
    }
    
    public ArrayList<Paper> showMyPapers(String username)throws SQLException {
        return paperDao.showMyPapers(username);
    }
    
    public boolean deletePaper(int id) throws SQLException{
        return paperDao.deletePaper(id);
    }
    
    public boolean editPaper(int id, String papername, ArrayList<String> authors) throws SQLException{
        return paperDao.editPaper(id, papername, authors);
    }
    
    public Paper getpaperInfo(int id, String username) throws SQLException{
        return paperDao.getpaperInfo(id, username);
    }
    
    public String getPapername() {
        return papername;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public int getId() {
        return id;
    }
    
    public String getCoauthor() {
        return coauthor;
    }
    
    public String getStatus() {
        return status;
    }
    
    
}