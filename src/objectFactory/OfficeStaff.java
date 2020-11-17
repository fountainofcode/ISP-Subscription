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
public class OfficeStaff {
    /*Different attributes of Operator user*/
	private int userId;
	private String firstName; 
	private String middleName;
	private String lastName;
	private String blockCode;
	private String streetName;
	private String cityCode;
	private String cityName;
	private String telephone;
	private String email;
	private String status;
	private String designation;
	
	/*Default constructor of Operator user*/
	public OfficeStaff() {
		this.userId = 0;
		this.firstName = "";
		this.middleName = "";
		this.lastName = "";
		this.blockCode = "";
		this.streetName = "";
		this.cityCode = "";
		this.cityName = "";
		this.telephone = "";
		this.email = "";
		this.status = "active";
		this.designation = "";
	}

	/*Getters of other users*/
	public int getUserId() {
		return userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getBlockCode() {
		return blockCode;
	}

	public String getStreetName() {
		return streetName;
	}

	public String getCityCode() {
		return cityCode;
	}

	public String getCityName() {
		return cityName;
	}

	public String getTelephone() {
		return telephone;
	}

	public String getEmail() {
		return email;
	}

	public String getStatus() {
		return status;
	}

	public String getDesignation() {
		return designation;
	}

	/*Setters of other users*/
	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setBlockCode(String blockCode) {
		this.blockCode = blockCode;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}


    
}
