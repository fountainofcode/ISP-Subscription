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
public class Account {
    /*Defining attributes of Account class*/
    private int accountId;
    private int accountHolderId; // should be client id
    private String accountHolderName; //should be client name
    //private boolean paidCheck;
    private String paidDate;
    
    /*Default constructor*/
    public Account() {
        this.accountId = 0;
        this.accountHolderId = 0;
        this.accountHolderName = "";
      //  this.paidCheck = false;
        this.paidDate = "";
    }
    
    /*Getters and setters of Account class*/
    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getAccountHolderId() {
        return accountHolderId;
    }

    public void setAccountHolderId(int accountHolderId) {
        this.accountHolderId = accountHolderId;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    //public boolean isPaidCheck() {
      //  return paidCheck;
    //}

    //public void setPaidCheck(boolean paidCheck) {
      //  this.paidCheck = paidCheck;
    //}

    public String getPaidDate() {
        return paidDate;
    }

    public void setPaidDate(String paidDate) {
        this.paidDate = paidDate;
    }
    
    
}
