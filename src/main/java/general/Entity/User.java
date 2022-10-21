package general.Entity;

import general.DAO.*;

public class User {
	private String username;
	private String fullname;
	private String password;
	private String email;
	private UserDAO myDAO;
	
	public boolean login(String username, String password,String profileName) {
	    return myDAO.login(username, password, profileName);
	}
	
	public User() {
        super();
        myDAO = new UserDAO();
    }



    public User(String username, String password) {
        super();
        this.username = username;
        this.password = password;
        myDAO = new UserDAO();
    }

    public User(String username, String fullname, String password, String email) {
		super();
		this.username = username;
		this.fullname = fullname;
		this.password = password;
		this.email = email;
		myDAO = new UserDAO();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getProfileName() {
        return "";
    }

	
	
	
	
	
	
	
	
}
