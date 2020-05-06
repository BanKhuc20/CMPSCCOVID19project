/*
@author Palmer Pesta
Date Last Modified: 5/5/2020
@version 1.3
Purpose: To collect and send data for processing
CSS code modified from: https://www.w3schools.com/html/html_layout.asp on 4/18/2020
Javascript code modified from: https://blog.zingchart.com/jsp-chart-example/
 */
package COVID19;

import java.io.IOException;
import java.util.List;

public class managerDB {
    
    public static List<Integer> retrieve (dataGatherer user) throws IOException {
        // Creates the database object
         dataManager dataArray = new dataManager();
         dataArray.populateDatabase();

         // Creates a List of integers
         List<Integer> graphData;
            
         // Collects datapoints from the database
         graphData = dataArray.searchDay(user.getCountry(), user.getProvidence(), user.getDateStart(), user.getDateEnd(), user.getStatus().toLowerCase());
         
         // Returns datapoints
         return graphData;
    }
}
