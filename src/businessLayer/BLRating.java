/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLayer;

import java.sql.*;
import databaseLayer.Dbconnect;
import objectFactory.Rating;

/**
 *
 * @author Kriss
 */
public class BLRating {
    /*Attributes*/

    private Dbconnect dbcon;
    private Rating rating;

    /*Default constructor*/
    public BLRating() {
        this.dbcon = new Dbconnect();
        this.rating = new Rating();
    }

    /*Getter and setter*/
    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    /*Getting data from the table*/
    public Rating selectRating() throws Exception {
        try {
            Connection con = this.dbcon.connect();
            Statement stat = con.createStatement();

            /*To select*/
            String qrySelectExcellent = "select count(ratingName) ratingName from rating where ratingName = 'Excellent'";
            stat.executeQuery(qrySelectExcellent);
            ResultSet rs = stat.getResultSet();
            while (rs.next()) {
                this.rating.setCountExcellent(rs.getInt("ratingName"));
            }
            rs.close();

            String qrySelectGood = "select count(ratingName) ratingName from rating where ratingName = 'Good'";
            stat.executeQuery(qrySelectGood);
            rs = stat.getResultSet();
            while (rs.next()) {
                this.rating.setCountGood(rs.getInt("ratingName"));
            }
            rs.close();
            
            String qrySelectSatisfactory = "select count(ratingName) ratingName from rating where ratingName = 'Satisfactory'";
            stat.executeQuery(qrySelectSatisfactory);
            rs = stat.getResultSet();
            while (rs.next()) {
                this.rating.setCountSatisfactory(rs.getInt("ratingName"));
            }
            rs.close();
            
            String qrySelectNotbad = "select count(ratingName) ratingName from rating where ratingName = 'Not bad'";
            stat.executeQuery(qrySelectNotbad);
            rs = stat.getResultSet();
            while (rs.next()) {
                this.rating.setCountNotbad(rs.getInt("ratingName"));
            }
            rs.close();
            
            String qrySelectBad = "select count(ratingName) ratingName from rating where ratingName = 'Bad'";
            stat.executeQuery(qrySelectBad);
            rs = stat.getResultSet();
            while (rs.next()) {
                this.rating.setCountBad(rs.getInt("ratingName"));
            }
            rs.close();
            
            return rating;

        }// end try
        catch (Exception ex) {
            throw ex;
        }//end catch

    }//end selectRating()

    /*Insert feedback's all info*/
    public void insertRating() throws Exception {
        try {
            Connection con = this.dbcon.connect();
            PreparedStatement stat1;

            /*To insert*/
            String qryRatingInsert = "Insert into rating (ratingName) values (?)";
            stat1 = con.prepareStatement(qryRatingInsert);
            
            /*Set all the details from the feedback class variables to feedback table attributes*/
            stat1.setString(1, this.rating.getRatingName());

            stat1.executeUpdate();
            stat1.close();
            this.dbcon.disconnect();

        }//end try
        catch (Exception ex) {
            throw ex;
        }//end catch
    }//end insertFeedback()

}
