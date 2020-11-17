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
public class Response {
    /*Different attributes of Response*/
	private String currentDate; //System date- Auto generating
	private int responseId;
	private String responseSubject;
	private String responseDescrip;
        private int clientId;
        private int requestId;
	
	/*Default constructor*/
	public Response() {
		this.currentDate = "";
		this.responseId = 0;
		this.responseSubject = "";
		this.responseDescrip = "";
                this.clientId = 0;
                this.requestId = 0;
	}

	/*Getters of Response*/
	public String getCurrentDate() {
		return currentDate;
	}

    public int getClientId() {
        return clientId;
    }

    public int getRequestId() {
        return requestId;
    }

    	public int getResponseId() {
		return responseId;
	}

	public String getResponseSubject() {
		return responseSubject;
	}

	public String getResponseDescrip() {
		return responseDescrip;
	}


	/*Setters of Response*/
	public void setCurrentDate(String currentDate) {
		this.currentDate = currentDate;
	}

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }
    
    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    	public void setResponseId(int responseId) {
		this.responseId = responseId;
	}

	public void setResponseSubject(String responseSubject) {
		this.responseSubject = responseSubject;
	}

	public void setResponseDescrip(String responseDescrip) {
		this.responseDescrip = responseDescrip;
	}

	

}
