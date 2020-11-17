/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package objectFactory;

/**
 *
 * @author Kriss
 */
public class User {
    /*Different attributes of User*/
	private int userId;
	private String username;
	private String password;
        private String userType;
	
	/*Default constructor of User*/
	public User() {
		this.userId = 0;
		this.username = "";
		this.password = "";
                this.userType = "";
	}

	/*Getters of User*/
	public int getUserId() {
		return userId;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
        
        public String getUserType() {
		return userType;
	}

	/*Setters of User*/
	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setUserType(String userType) {
		this.userType = userType;
	}
	
}
