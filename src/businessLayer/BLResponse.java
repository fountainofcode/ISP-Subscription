/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLayer;

import java.sql.*;
import databaseLayer.Dbconnect;
import objectFactory.Response;

/**
 *
 * @author Kriss
 */
public class BLResponse {

    private Dbconnect dbcon;
    private Response response;

    /*Default constructor*/
    public BLResponse() {
        this.dbcon = new Dbconnect();
        this.response = new Response();
    }

    /*Getter and setter*/
    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    /*Select the MaxResponseId*/
    public ResultSet selectMaxResponseId() throws Exception {
        try {
            Connection con = this.dbcon.connect();
            Statement stat1 = con.createStatement();

            /*To select*/
            String qryResponseSelect = "select max(responseId) as max_id from response";
            stat1.executeQuery(qryResponseSelect);
            ResultSet rs1 = stat1.getResultSet();
            return rs1;
        }//end try
        catch (Exception ex) {
            throw ex;
        }//end catch
    }//end selectMaxResponseId()
    
    /*Insert Response*/
    public void insertResponse() throws Exception {
        try {
            Connection con = this.dbcon.connect();
            PreparedStatement stat1;

            /*To insert*/
            String qryInsert = "Insert into response (currentDate, responseId, responseSubject, responseDescrip, clientId, requestId) values (?, ?, ?, ?, ?, ?)";
            stat1 = con.prepareStatement(qryInsert);

            stat1.setString(1, this.response.getCurrentDate());
            stat1.setInt(2, this.response.getResponseId());
            stat1.setString(3, this.response.getResponseSubject());
            stat1.setString(4, this.response.getResponseDescrip());
            stat1.setInt(5, this.response.getClientId());
            stat1.setInt(6, this.response.getRequestId());
            
            stat1.executeUpdate();
            stat1.close();
            this.dbcon.disconnect();

        }//end try
        catch (Exception ex) {
            throw ex;
        }//end catch
    }//end insertResponse()

    /*Update response*/
    /*public void updateResponse(int num_id) throws Exception {
        try {
            Connection con = this.dbcon.connect();
            PreparedStatement stat1;

            /*To update*/
      /*      String qryUpdate = "Update response set currentDate = ?, responseId = ?, responseSubject = ?, responseDescrip = ?, clientId = ?, requestId = ? where responseId = " + num_id;
            stat1 = con.prepareStatement(qryUpdate);

            stat1.setString(1, this.response.getCurrentDate());
            stat1.setInt(2, this.response.getResponseId());
            stat1.setString(3, this.response.getResponseSubject());
            stat1.setString(4, this.response.getResponseDescrip());
            stat1.setInt(5, this.response.getClientId());
            stat1.setInt(6, this.response.getRequestId());
            
            int res = stat1.executeUpdate();
            stat1.close();
            this.dbcon.disconnect();

        }//end try
        catch (Exception ex) {
            throw ex;
        }//end catch
    }//end updateupdateResponse()
*/

}
