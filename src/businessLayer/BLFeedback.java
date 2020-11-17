/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLayer;

import java.sql.*;
import databaseLayer.Dbconnect;
import objectFactory.Feedback;

/**
 *
 * @author Kriss
 */
public class BLFeedback {

    private Dbconnect dbcon;
    private Feedback feedback;

    /*Default constructor*/
    public BLFeedback() {
        this.dbcon = new Dbconnect();
        this.feedback = new Feedback();
    }

    /*Getter and setter*/
    public Feedback getFeedback() {
        return feedback;
    }

    public void setFeedback(Feedback feedback) {
        this.feedback = feedback;
    }

    /*Select feedback all info*/
    public ResultSet selectFeedback() throws Exception {
        try {
            Connection con = this.dbcon.connect();
            Statement stat1 = con.createStatement();

            /*To select*/
            String qryFeedbackSelect = "select * from feedback";

            stat1.executeQuery(qryFeedbackSelect);
            ResultSet rs1 = stat1.getResultSet();
            return rs1;

        }//end try
        catch (Exception ex) {
            throw ex;
        }//end catch
    }//end selectFeedback()
    
    /*Select the MaxRequestId*/
    public ResultSet selectMaxFeedbackId() throws Exception {
        try {
            Connection con = this.dbcon.connect();
            Statement stat1 = con.createStatement();

            /*To select*/
            String qryRequestSelect = "select max(feedbackId) as max_id from feedback";
            stat1.executeQuery(qryRequestSelect);
            ResultSet rs1 = stat1.getResultSet();
            return rs1;
        }//end try
        catch (Exception ex) {
            throw ex;
        }//end catch
    }//end selectRequest()
    

    /*Insert feedback's all info*/
    public void insertFeedback() throws Exception {
        try {
            Connection con = this.dbcon.connect();
            PreparedStatement stat1;

            /*To insert*/
            String qryFeedbackInsert = "Insert into feedback (currentDate, clientId, feedbackRemarks) values (?, ?, ?)";
            stat1 = con.prepareStatement(qryFeedbackInsert);
            
            /*Set all the details from the feedback class variables to feedback table attributes*/
            stat1.setString(1, this.feedback.getCurrentDate());
            stat1.setInt(2, this.feedback.getClientId());
            stat1.setString(3, this.feedback.getFeedbackRemarks());

            stat1.executeUpdate();
            stat1.close();
            this.dbcon.disconnect();

        }//end try
        catch (Exception ex) {
            throw ex;
        }//end catch
    }//end insertFeedback()

    /*Update Feedback*/
    public void updateFeedback() throws Exception {
        try {
            Connection con = this.dbcon.connect();
            PreparedStatement stat1;

            /*To update*/
            String qryFeedbackUpdate = "Update feedback set currentDate = ?, feedbackId = ?, feedbackRemarks = ? where feedbackId = ?";
            stat1 = con.prepareStatement(qryFeedbackUpdate);
            stat1.executeUpdate(qryFeedbackUpdate);

            //while(rs.next()) {
            /*Set all the details from the feedback class variables to feedback table attributes*/
            stat1.setString(1, this.feedback.getCurrentDate());
            stat1.setInt(2, this.feedback.getFeedbackId());
            stat1.setString(3, this.feedback.getFeedbackRemarks());

            stat1.close();
            this.dbcon.disconnect();
        }//end try
        catch (Exception ex) {
            throw ex;
        }//end catch
    }//end updateFeedback()

    /*Delete Feedback's attribute values*/
    public void deleteFeedback() throws Exception {
        try {
            Connection con = this.dbcon.connect();
            PreparedStatement stat1;

            /*To delete*/
            String qryUserDelete = "Delete from feedback where feedbackId = ?";
            stat1 = con.prepareStatement(qryUserDelete);
            stat1.executeUpdate(qryUserDelete);

            /*Set all the details from the services class variables to services table attributes*/
            stat1.setInt(1, this.feedback.getFeedbackId());

            stat1.close();
            this.dbcon.disconnect();
        }//end try
        catch (Exception ex) {
            throw ex;
        }//end catch
    }//end deleteFeedback()

}
