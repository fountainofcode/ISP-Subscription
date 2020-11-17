/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLayer;

import java.sql.*;
import databaseLayer.Dbconnect;
import objectFactory.User;
import objectFactory.Client;
import objectFactory.OfficeStaff;

/**
 *
 * @author Kriss
 */
public class BLUser {

    private Dbconnect dbcon;
    private User user;
    private Client client;
    private OfficeStaff officeStaff;

    /*Default constructor of Business Layer of the User*/
    public BLUser() {
        this.dbcon = new Dbconnect();
        this.user = new User();
        this.client = new Client();
        this.officeStaff = new OfficeStaff();
    }

    /*Making getter and setter of User and Client in Business Layer*/
    public User getUser() {
        return this.user;
    }

    public void setUser(User usr) {
        this.user = usr;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public OfficeStaff getOfficeStaff() {
        return officeStaff;
    }

    public void setOfficeStaff(OfficeStaff officeStaff) {
        this.officeStaff = officeStaff;
    }

    /*Checking login and if true, then Getting data from the table*/
    public boolean checkLogin() throws Exception {
        try {
            Connection con = this.dbcon.connect();
            Statement stat = con.createStatement();

            /*To select*/
            String qrySelect = "select * from user where username = '" + user.getUsername() + "' and password = '" + user.getPassword() + "'";
            stat.executeQuery(qrySelect);
            ResultSet rs = stat.getResultSet();

            if (rs.next()) {
                /*Set the user's username and password from sql to the java "user" object*/
                this.user.setUsername(rs.getString("username"));
                this.user.setPassword(rs.getString("password"));
                this.user.setUserType(rs.getString("userType"));
                this.user.setUserId(rs.getInt("userId"));

                rs.close();
                stat.close();
                this.dbcon.disconnect();
                return true;
            } else {
                rs.close();
                stat.close();
                this.dbcon.disconnect();
                return false;
            }
        } catch (Exception ex) {
            throw ex;
        }
    }

    /*Checking if username exists*/
    public boolean checkUsernameExist() throws Exception {
        try {
            Connection con = this.dbcon.connect();
            Statement stat = con.createStatement();

            //*To select
            String qrySelect = "select * from user where username = '" + user.getUsername() + "'";
            stat.executeQuery(qrySelect);
            ResultSet rs = stat.getResultSet();

            if (rs.next()) {
                //*Set the user's username and password from sql to the java "user" object*
                this.user.setUsername(rs.getString("username"));

                rs.close();
                stat.close();
                this.dbcon.disconnect();
                return true;
            } else {
                rs.close();
                stat.close();
                this.dbcon.disconnect();
                return false;
            }
        } catch (Exception ex) {
            throw ex;
        }
    }
    
    /*New Checking if username exists*/
    /*public boolean newCheckUsernameExist(String username) throws Exception {
        try {
            Connection con = this.dbcon.connect();
            Statement stat = con.createStatement();

            /*To select*
            String qrySelect = "select * from user where username = '" + username + "'";
            stat.executeQuery(qrySelect);
            ResultSet rs = stat.getResultSet();

            if (rs.next()) {
                /*Set the user's username and password from sql to the java "user" object*
                this.user.setUsername(rs.getString("username"));

                rs.close();
                stat.close();
                this.dbcon.disconnect();
                return true;
            } else {
                rs.close();
                stat.close();
                this.dbcon.disconnect();
                return false;
            }
        } catch (Exception ex) {
            throw ex;
        }
    }


    /*Select client userId from username info*/
    public ResultSet selectUserIdFromUsername(String username) throws Exception {
        try {
            Connection con = this.dbcon.connect();
            Statement stat1 = con.createStatement();

            /*To select*/
            String qryUserIdFromUsernameSelect = "select userId from user where username = '" + username + "'";
            stat1.executeQuery(qryUserIdFromUsernameSelect);
            ResultSet rs1 = stat1.getResultSet();
            return rs1;

        }//end try
        catch (Exception ex) {
            throw ex;
        }//end catch
    }//end selectUserIdFromUsername()

    /*Select (user, client)'s info*/
    public ResultSet selectClientProfile() throws Exception {
        try {
            Connection con = this.dbcon.connect();
            Statement stat1 = con.createStatement();

            /*To select*/
            String qryClientSelect = "select c.*, u.username, u.userType from client c inner join user u on u.userId = c.userId";// where c.userId = " + user.getUserId();
            stat1.executeQuery(qryClientSelect);
            ResultSet rs1 = stat1.getResultSet();
            return rs1;

        }//end try
        catch (Exception ex) {
            throw ex;
        }//end catch
    }//end selectClientProfile()

    /*Select Particular (user, client)'s info*/
    public ResultSet selectParticularClientProfile(int num) throws Exception {
        try {
            Connection con = this.dbcon.connect();
            Statement stat1 = con.createStatement();

            /*To select*/
            String qryClientSelect = "SELECT c . * , u.username, u.password\n"
                    + "FROM client c\n"
                    + "INNER JOIN user u ON u.userId = c.userId\n"
                    + "WHERE u.userId =" + num;

            stat1.executeQuery(qryClientSelect);
            ResultSet rs1 = stat1.getResultSet();
            return rs1;

        }//end try
        catch (Exception ex) {
            throw ex;
        }//end catch
    }//end selectClientProfile()

    /*Select Particular (user, officeStaff)'s info*/
    public ResultSet selectParticularOfficeStaffProfile(int num) throws Exception {
        try {
            Connection con = this.dbcon.connect();
            Statement stat1 = con.createStatement();

            /*To select*/
            String qryOfficeStaffSelect = "SELECT o.* , u.username, u.password, u.userType\n"
                    + "FROM officeStaff o\n"
                    + "INNER JOIN user u ON u.userId = o.userId\n"
                    + "WHERE u.userId =" + num;

            stat1.executeQuery(qryOfficeStaffSelect);
            ResultSet rs1 = stat1.getResultSet();
            return rs1;

        }//end try
        catch (Exception ex) {
            throw ex;
        }//end catch
    }//end selectOfficeStaffProfile()

    
    /*Select (user, OfficeStaff)'s all info*/
    public ResultSet selectOfficeStaffProfile() throws Exception {
        try {
            Connection con = this.dbcon.connect();
            Statement stat1 = con.createStatement();

            /*To select*/
            String qryOfficeStaffSelect = "select o.*, u.username, u.userType from officeStaff o inner join user u on u.userId = o.userId";// where o.userId = " + user.getUserId();
            stat1.executeQuery(qryOfficeStaffSelect);

            ResultSet rs1 = stat1.getResultSet();
            return rs1;

        }//end try
        catch (Exception ex) {
            throw ex;
        }//end catch
    }//end selectOfficeStaffProfile()

    /*Insert (user, client)'s all info*/
    public void insertClientProfile() throws Exception {
        try {
            Connection con = this.dbcon.connect();
            PreparedStatement stat1, stat2, stat3;

            /*To insert*/
            String qryClientInsert = "Insert into client (userId, firstName, middleName, lastName, blockCode, streetName, cityCode, cityName, telephone, email, status) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            stat2 = con.prepareStatement(qryClientInsert);

            
            /*Set all the details from the client class variables to client table attributes*/
            stat2.setInt(1, this.client.getUserId());
            stat2.setString(2, this.client.getFirstName());
            stat2.setString(3, this.client.getMiddleName());
            stat2.setString(4, this.client.getLastName());
            stat2.setString(5, this.client.getBlockCode());
            stat2.setString(6, this.client.getStreetName());
            stat2.setString(7, this.client.getCityCode());
            stat2.setString(8, this.client.getCityName());
            stat2.setString(9, this.client.getTelephone());
            stat2.setString(10, this.client.getEmail());
            stat2.setString(11, this.client.getStatus());

            stat2.executeUpdate();

            stat2.close();
            this.dbcon.disconnect();

        }//end try
        catch (Exception ex) {
            throw ex;
        }//end catch
    }//end insertClientProfile()

    /*Insert (user and officeStaff)'s all info*/
    public void insertOfficeStaffProfile() throws Exception {
        try {
            Connection con = this.dbcon.connect();
            PreparedStatement stat1, stat2, stat3;

            /*To insert*/
            String qryOfficeStaffInsert = "Insert into officeStaff (userId, firstName, middleName, lastName, blockCode, streetName, cityCode, cityName, telephone, email, status, designation) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            stat3 = con.prepareStatement(qryOfficeStaffInsert);

            /*Set all the details from the OfficeStaff class variables to officestaff table attributes*/
            stat3.setInt(1, this.officeStaff.getUserId());
            stat3.setString(2, this.officeStaff.getFirstName());
            stat3.setString(3, this.officeStaff.getMiddleName());
            stat3.setString(4, this.officeStaff.getLastName());
            stat3.setString(5, this.officeStaff.getBlockCode());
            stat3.setString(6, this.officeStaff.getStreetName());
            stat3.setString(7, this.officeStaff.getCityCode());
            stat3.setString(8, this.officeStaff.getCityName());
            stat3.setString(9, this.officeStaff.getTelephone());
            stat3.setString(10, this.officeStaff.getEmail());
            stat3.setString(11, this.officeStaff.getStatus());
            stat3.setString(12, this.officeStaff.getDesignation());

            stat3.executeUpdate();

            stat3.close();
            this.dbcon.disconnect();

        }//end try
        catch (Exception ex) {
            throw ex;
        }//end catch
    }//end insertOfficeStaffProfile()

    /*Insert (user and officeStaff)'s all info*/
    public void insertUserProfile() throws Exception {
        try {
            Connection con = this.dbcon.connect();
            PreparedStatement stat1, stat2, stat3;

            /*To insert*/
            String qryUserInsert = "Insert into user (username, password, userType) values (?, ?, ?)";
            
            stat1 = con.prepareStatement(qryUserInsert);
            
            /*Set all the details from the user class variables to user table attributes*/
            stat1.setString(1, this.user.getUsername());
            stat1.setString(2, this.user.getPassword());
            stat1.setString(3, this.user.getUserType());

            stat1.executeUpdate();

            stat1.close();
            this.dbcon.disconnect();

        }//end try
        catch (Exception ex) {
            throw ex;
        }//end catch
    }//end insertOfficeStaffProfile()

    /*Update user's and client's profile*/
    public void updateClientProfile(int num) throws Exception {
        try {
            Connection con = this.dbcon.connect();
            PreparedStatement stat1, stat2, stat3;

            /*To update*/
            String qryUserUpdate = "Update user set userId = ?, username = ?, password = ?, userType = ? where userId = " + num;
            String qryClientUpdate = "Update client set userId = ?, firstName = ?, middleName = ?, lastName = ?, blockCode = ?, streetName = ?, cityCode = ?, cityName = ?, telephone = ?, email = ?, status = ? where userId = " + num;

            stat1 = con.prepareStatement(qryUserUpdate);
            stat2 = con.prepareStatement(qryClientUpdate);

            /*Set all the details from the user class variables to user table attributes*/
            stat1.setInt(1, this.user.getUserId());
            stat1.setString(2, this.user.getUsername());
            stat1.setString(3, this.user.getPassword());
            stat1.setString(4, this.user.getUserType());

            /*Set all the details from the Client class variables to client table attributes*/
            stat2.setInt(1, this.client.getUserId());
            stat2.setString(2, this.client.getFirstName());
            stat2.setString(3, this.client.getMiddleName());
            stat2.setString(4, this.client.getLastName());
            stat2.setString(5, this.client.getBlockCode());
            stat2.setString(6, this.client.getStreetName());
            stat2.setString(7, this.client.getCityCode());
            stat2.setString(8, this.client.getCityName());
            stat2.setString(9, this.client.getTelephone());
            stat2.setString(10, this.client.getEmail());
            stat2.setString(11, this.client.getStatus());
            
            stat1.executeUpdate();
            stat2.executeUpdate();

            stat1.close();
            stat2.close();
            //stat3.close();
            this.dbcon.disconnect();
        }//end try
        catch (Exception ex) {
            throw ex;
        }//end catch
    }//end updateClientProfile()

    /*Update user's and officeStaff's profile*/
    public void updateOfficeStaffProfile(int num) throws Exception {
        try {
            Connection con = this.dbcon.connect();
            PreparedStatement stat1, stat3;

            /*To update*/
            String qryUserUpdate = "Update user set userId = ?, username = ?, password = ?, userType = ? where userId = " + num;
            String qryOfficeStaffUpdate = "Update officeStaff set userId = ?, firstName = ?, middleName = ?, lastName = ?, blockCode = ?, streetName = ?, cityCode = ?, cityName = ?, telephone = ?, email = ?, status = ?, designation = ? where userId = " + num;

            stat1 = con.prepareStatement(qryUserUpdate);
            stat3 = con.prepareStatement(qryOfficeStaffUpdate);

            /*Set all the details from the user class variables to user table attributes*/
            stat1.setInt(1, this.user.getUserId());
            stat1.setString(2, this.user.getUsername());
            stat1.setString(3, this.user.getPassword());
            stat1.setString(4, this.user.getUserType());

            /*Set all the details from the OfficeStaff class variables to officestaff table attributes*/
            stat3.setInt(1, this.officeStaff.getUserId());
            stat3.setString(2, this.officeStaff.getFirstName());
            stat3.setString(3, this.officeStaff.getMiddleName());
            stat3.setString(4, this.officeStaff.getLastName());
            stat3.setString(5, this.officeStaff.getBlockCode());
            stat3.setString(6, this.officeStaff.getStreetName());
            stat3.setString(7, this.officeStaff.getCityCode());
            stat3.setString(8, this.officeStaff.getCityName());
            stat3.setString(9, this.officeStaff.getTelephone());
            stat3.setString(10, this.officeStaff.getEmail());
            stat3.setString(11, this.officeStaff.getStatus());
            stat3.setString(12, this.officeStaff.getDesignation());
            
            stat1.executeUpdate();
            stat3.executeUpdate();

            stat1.close();
            stat3.close();
            this.dbcon.disconnect();
        }//end try
        catch (Exception ex) {
            throw ex;
        }//end catch
    }//end updateOfficeStaffProfile()

    /*Delete user's attribute values and client's profile*/
    public void deleteClientProfile(int num) throws Exception {
        try {
            Connection con = this.dbcon.connect();
            PreparedStatement stat1, stat2;

            /*To insert*/
            String qryUserDelete = "Delete from user where userId = ?";
            String qryClientDelete = "Delete from client where userId = ?";

            stat1 = con.prepareStatement(qryUserDelete);
            stat2 = con.prepareStatement(qryClientDelete);

            /*Set all the details from the user class variables to user table attributes*/
            stat1.setInt(1, num);
            /*Set all the details from the client class variables to client table attributes*/
            stat2.setInt(1, num);

            stat1.executeUpdate();
            stat2.executeUpdate();


            stat1.close();
            stat2.close();
            this.dbcon.disconnect();
        }//end try
        catch (Exception ex) {
            throw ex;
        }//end catch
    }//end deleteClientProfile()

    /*Delete user's attribute values and OfficeStaff's profile*/
    public void deleteOfficeStaffProfile(int num) throws Exception {
        try {
            Connection con = this.dbcon.connect();
            PreparedStatement stat1, stat2, stat3;

            /*To insert*/
            String qryUserDelete = "Delete from user where userId = ?";
            String qryOfficeStaffDelete = "Delete from officeStaff where userId = ?";

            stat1 = con.prepareStatement(qryUserDelete);
            stat3 = con.prepareStatement(qryOfficeStaffDelete);

            /*Set all the details from the user class variables to user table attributes*/
            stat1.setInt(1, num);
            /*Set all the details from the client class variables to client table attributes*/
            stat3.setInt(1, num);
            
            stat1.executeUpdate();
            stat3.executeUpdate();

            stat1.close();
            stat3.close();
            this.dbcon.disconnect();
        }//end try
        catch (Exception ex) {
            throw ex;
        }//end catch
    }//end deleteOfficeStaffProfile()

}
