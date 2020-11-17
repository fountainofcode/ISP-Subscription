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
public class Rating {
    
	/*Different attributes*/
	//private int ratingId;
	private String ratingName;
        private int ratedBy; //the clientId so that he/she cannot rate again
        
        private int countExcellent;
        private int countGood;
        private int countSatisfactory;
        private int countNotbad;
        private int countBad;
	
        private float percentage;
	
	/*Default constructor*/
	public Rating() {
		//this.ratingId = 0;
		this.ratingName = "";
		this.ratedBy = 0;
                this.percentage = 0;
                
                this.countExcellent = 0;
                this.countGood = 0;
                this.countSatisfactory = 0;
                this.countNotbad = 0;
                this.countBad = 0;
        }

	/*Getters and Setters*/
	public int getRatedBy() {
		return ratedBy;
	}

	public String getRatingName() {
		return ratingName;
	}

	public float getPercentage() {
		return percentage;
	}
	
	public void setRatedBy(int ratedBy) {
		this.ratedBy = ratedBy;
	}

    	public void setRatingName(String ratingName) {
		this.ratingName = ratingName;
	}

	public void setPercentage(float percentage) {
		this.percentage = percentage;
	}
	
    public int getCountExcellent() {
        return countExcellent;
    }

    public void setCountExcellent(int countExcellent) {
        this.countExcellent = countExcellent;
    }

    public int getCountGood() {
        return countGood;
    }

    public void setCountGood(int countGood) {
        this.countGood = countGood;
    }

    public int getCountSatisfactory() {
        return countSatisfactory;
    }

    public void setCountSatisfactory(int countSatisfactory) {
        this.countSatisfactory = countSatisfactory;
    }

    public int getCountNotbad() {
        return countNotbad;
    }

    public void setCountNotbad(int countNotbad) {
        this.countNotbad = countNotbad;
    }

    public int getCountBad() {
        return countBad;
    }

    public void setCountBad(int countBad) {
        this.countBad = countBad;
    }
        

}
