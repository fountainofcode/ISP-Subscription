/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLayer;

import java.sql.*;
import databaseLayer.Dbconnect;
import objectFactory.Response;
import objectFactory.Request;
import objectFactory.User;
import businessLayer.BLUser;

/**
 *
 * @author Kriss
 */
public class BLRequestResponse {

    private Dbconnect dbcon;
    private Response response;
    private Request request;

    /*Default constructor*/
    public BLRequestResponse() {
        this.dbcon = new Dbconnect();
        this.request = new Request();
        this.response = new Response();
    }

    /*Getter and setter*/
    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    /*Select all client's request, response*/
    public ResultSet selectAllRequestResponse() throws Exception {
        try {
            Connection con = this.dbcon.connect();
            Statement stat1 = con.createStatement();

            /*To select*/
            String qryResponseSelect = "select * from response";

            stat1.executeQuery(qryResponseSelect);
            ResultSet rs1 = stat1.getResultSet();
            return rs1;

        }//end try
        catch (Exception ex) {
            throw ex;
        }//end catch
    }//end selectAllRequestResponse()

    /*Select particular client's request, response*/
    public ResultSet selectParticularClientRequestResponse(String username) throws Exception {
        try {
            Connection con = this.dbcon.connect();
            Statement stat1 = con.createStatement();

            String qryParticularClientRequestResponseSelect = "SELECT req.clientId, req.currentDate reqDate, "
                    + " req.requestId, req.requestSubject, req.requestDescrip, "
                    + "res.currentDate resDate, res.responseId, res.responseSubject, res.responseDescrip, "
                    + "concat(c.firstName, ' ', c.middleName, ' ', c.lastName) clientName "
                    + "FROM request req "
                    + "INNER JOIN response res ON res.requestId = req.requestId "
                    + "INNER JOIN client c ON c.userId = req.clientId "
                    + "INNER JOIN user u ON u.userId = c.userId "
                    + "WHERE u.userName = '" + username + "'";

            stat1.executeQuery(qryParticularClientRequestResponseSelect);
            ResultSet rs1 = stat1.getResultSet();
            return rs1;

        }//end try
        catch (Exception ex) {
            throw ex;
        }//end catch
    }//end selectParticularClientRequestResponse()

    /*Insert response's all info*/
    public void insertResponse() throws Exception {
        try {
            Connection con = this.dbcon.connect();
            PreparedStatement stat1;

            /*To insert*/
            String qryResponseInsert = "Insert into response (currentDate, responseId, responseSubject, responseDescrip, clientId, requestId) values (?, ?, ?, ?, ?, ?)";
            stat1 = con.prepareStatement(qryResponseInsert);
            stat1.executeUpdate(qryResponseInsert);

            /*Set all the details from the response class variables to response table attributes*/
            stat1.setString(1, this.response.getCurrentDate());
            stat1.setInt(2, this.response.getResponseId());
            stat1.setString(3, this.response.getResponseSubject());
            stat1.setString(4, this.response.getResponseDescrip());
            stat1.setInt(5, this.response.getClientId());
            stat1.setInt(6, this.response.getRequestId());

            stat1.close();
            this.dbcon.disconnect();

        }//end try
        catch (Exception ex) {
            throw ex;
        }//end catch
    }//end insertResponse()

    /*Update Response*/
    public void updateResponse() throws Exception {
        try {
            Connection con = this.dbcon.connect();
            PreparedStatement stat1;

            /*To update*/
            String qryResponseUpdate = "Update response set currentDate = ?, responseId = ?, responseSubject = ?, responseDescrip = ? where responseId = ?";
            stat1 = con.prepareStatement(qryResponseUpdate);
            stat1.executeUpdate(qryResponseUpdate);

            //while(rs.next()) {
            /*Set all the details from the response class variables to response table attributes*/
            stat1.setString(1, this.response.getCurrentDate());
            stat1.setInt(2, this.response.getResponseId());
            stat1.setString(3, this.response.getResponseSubject());
            stat1.setString(4, this.response.getResponseDescrip());
            stat1.setInt(5, this.response.getClientId());
            stat1.setInt(6, this.response.getRequestId());

            stat1.close();
            this.dbcon.disconnect();
        }//end try
        catch (Exception ex) {
            throw ex;
        }//end catch
    }//end updateResponse()

    /*Delete Response's attribute values*/
    public void deleteResponse() throws Exception {
        try {
            Connection con = this.dbcon.connect();
            PreparedStatement stat1;

            /*To delete*/
            String qryUserDelete = "Delete from response where responseId = ?";
            stat1 = con.prepareStatement(qryUserDelete);
            stat1.executeUpdate(qryUserDelete);

            /*Set all the details from the services class variables to services table attributes*/
            stat1.setInt(1, this.response.getResponseId());

            stat1.close();
            this.dbcon.disconnect();
        }//end try
        catch (Exception ex) {
            throw ex;
        }//end catch
    }//end deleteResponse()

}
