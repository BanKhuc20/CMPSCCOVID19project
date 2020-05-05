/*
Created By: Palmer Pesta
Date Last Modified: 5/5/2020
Version: 1.3
Purpose: To collect and send data for processing
CSS code modified from: https://www.w3schools.com/html/html_layout.asp on 4/18/2020
Javascript code modified from: https://blog.zingchart.com/jsp-chart-example/
 */
package COVID19;

// Imports
import java.util.ArrayList;
import java.util.List;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;


public class controller extends HttpServlet {
        
    @Override
    protected void doPost(HttpServletRequest request, 
                          HttpServletResponse response) 
                          throws ServletException, IOException {

        // Sets default url to index.jsp
        String url = "/index.jsp";

        // get current action
        String action = request.getParameter("action");
        if (action == null) {
            action = "join";  // default action
        }

        // perform action and set URL to appropriate page
        if (action.equals("join")) {
            url = "/index.jsp";    // the "join" page
        }
        // If action equals add then the program will take you to the graphOutput.jsp page
        else if (action.equals("add")) {                
            // get parameters from the request
            String country = request.getParameter("country");
            String providence = request.getParameter("providence");
            String status = request.getParameter("status");  
            String date = request.getParameter("date"); 

            // store data in User object and save User object in database
            dataGatherer user = new dataGatherer(country, providence, date, status);
           
           // Creates a dataManager object for storage
            dataManager dataArray = new dataManager();
            dataArray.populateDatabase();

            // Creates a List of integers
            List<Integer> graphData;
            
           // Collects datapoints from the database
            graphData = dataArray.searchDay(country, providence, user.getDateStart(), user.getDateEnd(), status.toLowerCase());
            ArrayList dates = user.listOfDates();
            
            // Sends the graphData and the list of dates to the graphing page (graphOutput.jsp)
            request.setAttribute("graphData", graphData);
            request.setAttribute("dates", dates);

            // Finally takes the user to the second page
            url = "/graphOutput.jsp";  
        }
        
        // forward request and response objects to specified URL
        getServletContext()
            .getRequestDispatcher(url)
            .forward(request, response);
    }    
    
    @Override
    protected void doGet(HttpServletRequest request, 
                          HttpServletResponse response) 
                          throws ServletException, IOException {
        doPost(request, response);
    }    
}
