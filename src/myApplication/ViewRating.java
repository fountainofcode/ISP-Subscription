/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package myApplication;

import businessLayer.BLRating;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import objectFactory.Rating;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author Kriss
 */
public class ViewRating {
    private objectFactory.Rating rating;
    private businessLayer.BLRating blrating;
    private objectFactory.User user;

        
    public void setRating(Rating rating){
        this.rating = rating;
    }
    
     public void drawPi_chart() {   
        try {
            Rating rating = new Rating();
            BLRating blrating = new BLRating();
            
            blrating.setRating(this.rating);
            rating = blrating.selectRating();
            
            DefaultPieDataset pieDataset = new DefaultPieDataset();
            
            pieDataset.setValue("Excellent", new Integer(rating.getCountExcellent()));
            pieDataset.setValue("Good", new Integer(rating.getCountGood()));
            pieDataset.setValue("Satisfactory", new Integer(rating.getCountSatisfactory()));
            pieDataset.setValue("Not Bad", new Integer(rating.getCountNotbad()));
            pieDataset.setValue("Bad", new Integer(rating.getCountBad()));
            
            JFreeChart chart = ChartFactory.createPieChart("Rating Pie chart", pieDataset, true, true, true);
            PiePlot p = (PiePlot)chart.getPlot();
            //p.setForegroundAlpha(TOP_ALIGNMENT);
            ChartFrame frame = new ChartFrame("Pie Chart", chart);
            frame.setVisible(true);
            frame.setSize(450, 500);
            
            //DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            //Date date = new Date();
            //System.out.println(dateFormat.format(date));
            
        }// end try
        
        catch(Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Exception", JOptionPane.INFORMATION_MESSAGE);
        }//end catch
        
    }//end ViewRating function 

    
}
