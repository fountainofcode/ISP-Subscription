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
public class Feedback {
    /*Different attributes*/
	private String currentDate; //System date- Auto generating
	private int feedbackId;
	private String feedbackRemarks;
        private int clientId;
	
	/*Default constructor*/
	public Feedback() {
		this.currentDate = "";
		this.feedbackId = 0;
		this.feedbackRemarks = "";
                this.clientId = 0;
	}

	/*Getters*/
        
    public int getClientId() {
	return clientId;
    }

	public String getCurrentDate() {
		return currentDate;
	}

	public int getFeedbackId() {
		return feedbackId;
	}

	public String getFeedbackRemarks() {
		return feedbackRemarks;
	}

	/*Setters*/
        
    public void setClientId(int clientId) {
        this.clientId = clientId;
    }
	public void setCurrentDate(String currentDate) {
		this.currentDate = currentDate;
	}

	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}

	public void setFeedbackRemarks(String feedbackRemarks) {
		this.feedbackRemarks = feedbackRemarks;
	}


    
}
