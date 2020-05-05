/*
Created By: Palmer Pesta
Date Last Modified: 5/5/2020
Version: 1.2
Purpose: To store data in objects
CSS code modified from: https://www.w3schools.com/html/html_layout.asp on 4/18/2020
Javascript code modified from: https://blog.zingchart.com/jsp-chart-example/
 */
package COVID19;
import java.util.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.io.Serializable;
import java.util.ArrayList;


public class dataGatherer implements Serializable {
    private String country;
    private String providence;
    private String status; 
    private String date;
    private Date dateStart;
    private Date dateEnd;
    
    public dataGatherer() {
        country = "";
        providence = "";
        status = "";
        date = "";
    }
    
    /**
     * 
     * @param country The desired country of the user
     * @param providence The desired providence of the user
     * @param date The desired date range of the user
     * @param status The status of the patients
     */
    public dataGatherer(String country, String providence, String date, String status) {
        this.country = country;
        this.providence = providence;
        this.date = date;
        this.status = status;
        
        if (this.date != null){
            String[] dateList = date.split(" - ");
      
            this.dateStart = new Date(dateList[0]);
        
            this.dateEnd = new Date(dateList[1]);
            
        }
    }

    /**
     * 
     * @return listOfDates Which is a list of all dates within the date range
     */
    public ArrayList listOfDates(){
        ArrayList listOfDates = new ArrayList();
        
        LocalDate start1 = dateStart.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate end2 = dateEnd.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();


        for (LocalDate date2 = start1; date2.isBefore(end2) || date2.isEqual(end2); date2 = date2.plusDays(1)) {
            listOfDates.add(date2.toString().substring(5,10));
        }
    
        return listOfDates;
    }   
    
    /**
     * 
     * @return country Returns the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * 
     * @return providence Returns the Providence
     */
    public String getProvidence() {
        return providence;
    }

    /**
     * 
     * @return dateStart Returns the start date
     */
    public Date getDateStart() {
        return dateStart;
    }
    
    /**
     * 
     * @return dateStart Returns the end date
     */
    public Date getDateEnd() {
        return dateEnd;
    }

    /**
     * 
     * @return status Returns the status of the patients
     */
    public String getStatus() {
        return status;
    }
    
    /**
     * 
     * @param country Changes the country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * 
     * @param providence Changes the providence
     */
    public void setProvidence(String providence) {
        this.providence = providence;
    }

    /**
     * 
     * @param dateStart Changes the start date
     */
    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }
    
    /**
     * 
     * @param dateEnd Changes the end date
     */
    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    /**
     * 
     * @param status Changes the status
     */
    public void setStatus(String status) {
        this.status = status;
    }
    
}
