/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLayer;

import java.sql.*;
import databaseLayer.Dbconnect;
import objectFactory.Subscription;
import objectFactory.User;
import objectFactory.Services;

/**
 *
 * @author Kriss
 */
public class BLSubscription {

    private Dbconnect dbcon;
    private User user;
    private Services services;
    private Subscription subscription;

    public BLSubscription() {
        this.dbcon = new Dbconnect();
        this.user = new User();
        this.services = new Services();
        this.subscription = new Subscription();
    }

    /*Making getter and setter of subscription in Business Layer*/
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Services getServices() {
        return services;
    }

    public void setServices(Services services) {
        this.services = services;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }

    /*Select all Subscription all info*/
    public ResultSet selectAllSubscription() throws Exception {
        try {
            Connection con = this.dbcon.connect();
            Statement stat1 = con.createStatement();

            /*To select*/
            String qryAllSubscriptionSelect = "select * from Subscription";
            stat1.executeQuery(qryAllSubscriptionSelect);
            ResultSet rs1 = stat1.getResultSet();
            return rs1;

        }//end try
        catch (Exception ex) {
            throw ex;
        }//end catch
    }//end selectAllServices()

    /*Select User's Subscription*/
    public ResultSet selectUserSubscription() throws Exception {
        try {
            Connection con = this.dbcon.connect();
            Statement stat = con.createStatement();

            /*To select*/
            String qrySelect = "select * from subscription where clientId = " + subscription.getClientId() ;
            stat.executeQuery(qrySelect);
            ResultSet rs1 = stat.getResultSet();
            return rs1;

        }//end try
        catch (Exception ex) {
            throw ex;
        }//end catch
    }

    
    /*Checking if client exists(or is subscribed)(or in subscription)*/
    public boolean checkClientIdExist() throws Exception {
        try {
            Connection con = this.dbcon.connect();
            Statement stat = con.createStatement();

            /*To select*/
            String qrySelect = "select * from subscription where clientId = '" + subscription.getClientId() + "'";
            stat.executeQuery(qrySelect);
            ResultSet rs = stat.getResultSet();

            if (rs.next()) {
                /*Set the user's username and password from sql to the java "user" object*/
                this.subscription.setClientId(rs.getInt("clientId"));

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

    /*Checking if serviceId exists of that client already*/
    public boolean checkServiceIdExistParticularClient(int num_id, int client_id) throws Exception {
        try {
            Connection con = this.dbcon.connect();
            Statement stat = con.createStatement();

            /*To select*/
            String qrySelect = "select serviceId, clientId from subscription where clientId = " + client_id + " and serviceId = " + num_id;
            stat.executeQuery(qrySelect);
            ResultSet rs = stat.getResultSet();

            if (rs.next()) {
                /*Set the user's username and password from sql to the java "user" object*/
                this.subscription.setClientId(rs.getInt("clientId"));

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

    /*Insert Subscription all info*/
    public void insertSubscription() throws Exception {
        try {
            Connection con = this.dbcon.connect();
            PreparedStatement stat1;

            /*To insert*/
            String qrySubscriptionInsert = "Insert into Subscription (subscripName, serviceId, clientId, expiryDate) values (?, ?, ?, ?)";
            stat1 = con.prepareStatement(qrySubscriptionInsert);

            /*Set all the details from the subscription class variables to subscription table attributes*/
            //stat1.setInt(1, this.subscription.getServiceId());
            stat1.setString(1, this.subscription.getSubscripName());
            stat1.setInt(2, this.subscription.getServiceId());
            stat1.setInt(3, this.subscription.getClientId());
            stat1.setString(4, this.subscription.getExpiryDate());
            //stat1.setString(5, this.subscription.getDuePaid());

            stat1.executeUpdate();
            stat1.close();
            this.dbcon.disconnect();

        }//end try
        catch (Exception ex) {
            throw ex;
        }//end catch
    }//end insertSubscription()

    /*Update due paid for Subscription*/
    public void updateDuePaidSubscription(int num_id) throws Exception {
        try {
            Connection con = this.dbcon.connect();
            PreparedStatement stat1;

            /*To insert*/
            String qryDuePaidSubscriptionUpdate = "Update Subscription set duePaid = ? where clientId = " + num_id;

            stat1 = con.prepareStatement(qryDuePaidSubscriptionUpdate);

            /*Set all the details from the subscription class variables to subscription table attributes*/
            stat1.setString(1, this.subscription.getDuePaid());

            stat1.executeUpdate();
            stat1.close();
            this.dbcon.disconnect();

        }//end try
        catch (Exception ex) {
            throw ex;
        }//end catch
    }//end updateDuePaidSubscription()

    
}
