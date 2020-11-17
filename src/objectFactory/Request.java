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
public class Request {
    	/*Different attributes of Request*/
	private String currentDate; //System date- Auto generating
	private int requestId;
	private String requestSubject;
	private String requestDescrip;
        private int clientId;
	
	/*Default constructor*/
	public Request() {
		this.currentDate = "";
		this.requestId = 0;
		this.requestSubject = "";
		this.requestDescrip = "";
                this.clientId = 0;
	}

	/*Getters of Request*/
	public String getCurrentDate() {
		return currentDate;
	}

    public int getClientId() {
        return clientId;
    }

    	public int getRequestId() {
		return requestId;
	}

	public String getRequestSubject() {
		return requestSubject;
	}

	public String getRequestDescrip() {
		return requestDescrip;
	}

	/*Setters of Request*/
	public void setCurrentDate(String currentDate) {
		this.currentDate = currentDate;
	}

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public void setRequestSubject(String requestSubject) {
		this.requestSubject = requestSubject;
	}

	public void setRequestDescrip(String requestDescrip) {
		this.requestDescrip = requestDescrip;
	}

		

}
