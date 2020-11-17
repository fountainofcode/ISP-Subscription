/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLayer;

import java.sql.*;
import databaseLayer.Dbconnect;
import objectFactory.Account;
import businessLayer.BLUser;
import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import objectFactory.User;

/**
 *
 * @author Kriss
 */
public class BLAccount {

    private Dbconnect dbcon;
    private Account account;

    /*Default constructor*/
    public BLAccount() {
        this.dbcon = new Dbconnect();
        this.account = new Account();
    }

    /*Getter and setter*/
    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    /*Checking if username exists*/
    public boolean checkUserIdExist() throws Exception {
        try {
            Connection con = this.dbcon.connect();
            Statement stat = con.createStatement();

            /*To select*/
            String qrySelect = "select * from account where accountHolderId = '" + account.getAccountHolderId() + "'";
            stat.executeQuery(qrySelect);
            ResultSet rs = stat.getResultSet();

            if (rs.next()) {
                /*Set the account from sql to the java "user" object*/
                this.account.setAccountHolderId(Integer.parseInt(rs.getString("accountHolderId")));

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

    /*Select particualr account all info*/
    public ResultSet selectParticularAccount() throws Exception {
        try {
            Connection con = this.dbcon.connect();
            Statement stat1 = con.createStatement();

            /*To select*/
            String qryAccountSelect = "select * from account where accountHolderName = " + account.getAccountHolderName();

            stat1.executeQuery(qryAccountSelect);
            ResultSet rs1 = stat1.getResultSet();
            return rs1;
        }//end try
        catch (Exception ex) {
            throw ex;
        }//end catch
    }//end selectParticularAccount()

    /*Select account all info with Subscription*/
    public ResultSet selectAccountWithSubscription() throws Exception {
        try {
            Connection con = this.dbcon.connect();
            Statement stat1 = con.createStatement();

            /*To select*/
            String qryAccountSelect = "SELECT account.accountId, account.accountHolderId, account.accountHolderName, subscription.subscripId, subscription.subscripName, account.paidDate\n"
                    + "FROM account\n"
                    + "INNER JOIN subscription\n"
                    + "ON account.accountHolderId=subscription.clientId\n"
                    + "ORDER BY account.accountHolderName ASC;";

            stat1.executeQuery(qryAccountSelect);
            ResultSet rs1 = stat1.getResultSet();
            return rs1;
        }//end try
        catch (Exception ex) {
            throw ex;
        }//end catch
    }//end selectParticularAccount()

    /*Select account all info with Subscription*/
    public ResultSet selectParticularAccountWithSubscription(String username) throws Exception {
        try {
            BLUser bluser = new BLUser();
            User user = new User();

            Connection con = this.dbcon.connect();
            Statement stat1 = con.createStatement();

            /*To select*/
            String qryAccountSelect = "SELECT account.accountId, account.accountHolderId, account.accountHolderName, subscription.subscripId, subscription.subscripName, account.paidDate\n"
                    + "FROM account\n"
                    + "INNER JOIN subscription ON \n"
                    + "account.accountHolderId=subscription.clientId \n"
                    + "INNER JOIN user ON \n"
                    + "account.accountHolderId=user.userId\n"
                    + "Where user.username= '" + username + "'\n"
                    + "ORDER BY account.accountHolderName ASC";

            stat1.executeQuery(qryAccountSelect);
            ResultSet rs1 = stat1.getResultSet();
            return rs1;
        }//end try
        catch (Exception ex) {
            throw ex;
        }//end catch
    }//end selectParticularAccountWithSubscription()

    /*Insert account's all info*/
    public void insertAccount() throws Exception {
        try {
            Connection con = this.dbcon.connect();
            PreparedStatement stat1;

            /*To insert*/
            String qryAccountInsert = "Insert into account (accountHolderId, accountHolderName, paidDate) values (?, ?, ?)";
            stat1 = con.prepareStatement(qryAccountInsert);

            /*Set all the details from the account class variables to account table attributes*/
            stat1.setInt(1, this.account.getAccountHolderId());
            stat1.setString(2, this.account.getAccountHolderName());
            stat1.setString(3, this.account.getPaidDate());

            stat1.executeUpdate();
            stat1.close();
            this.dbcon.disconnect();

        }//end try
        catch (Exception ex) {
            throw ex;
        }//end catch
    }//end insertAccount()

    
    /*Update paidDateofAccount*/
    public void updatePaidDateofAccount(int accountId) throws Exception {
        try {
            Connection con = this.dbcon.connect();
            PreparedStatement stat1;

            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            Calendar cal = Calendar.getInstance();
            String date = dateFormat.format(cal.getTime()).toString();
            System.out.println(date);
            
            /*To update*/
            String qryAccountUpdate = "Update account set paidDate = ? where accountId = " + accountId;
            stat1 = con.prepareStatement(qryAccountUpdate);
            
            /*Set all the details from the account class variables to account table attributes*/
            stat1.setString(1, date);

            stat1.executeUpdate();
            stat1.close();
            this.dbcon.disconnect();

        }//end try
        catch (Exception ex) {
            throw ex;
        }//end catch
    }//end updatePaidDateofAccount()


    /*Delete Account's attribute values*/
    public void deleteAccount() throws Exception {
        try {
            Connection con = this.dbcon.connect();
            PreparedStatement stat1;

            /*To delete*/
            String qryUserDelete = "Delete from account where accountId = ?";
            stat1 = con.prepareStatement(qryUserDelete);
            stat1.executeUpdate(qryUserDelete);

            /*Set all the details from the services class variables to services table attributes*/
            stat1.setInt(1, this.account.getAccountId());

            stat1.close();
            this.dbcon.disconnect();
        }//end try
        catch (Exception ex) {
            throw ex;
        }//end catch
    }//end deleteAccount()

}
