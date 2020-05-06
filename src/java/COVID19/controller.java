/*
@author Palmer Pesta
Date Last Modified: 5/5/2020
@version 1.3
Purpose: To collect and send data for processing
CSS code modified from: https://www.w3schools.com/html/html_layout.asp on 4/18/2020
Javascript code modified from: https://blog.zingchart.com/jsp-chart-example/
 */
package COVID19;

// Imports
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = {"/controller"})
public class controller extends HttpServlet {
    
     protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }
       
    @Override
    protected void doGet(HttpServletRequest request, 
                          HttpServletResponse response) 
                          throws ServletException, IOException {
                          
            // get parameters from the request
            String country = request.getParameter("country");
            String providence = request.getParameter("providence");
            String status = request.getParameter("status");  
            String date = request.getParameter("date"); 

            // store data in User object and save User object in database
            dataGatherer user = new dataGatherer(country, providence, date, status);
            
            // Retrieves data points
            List<Integer> dataArray = managerDB.retrieve(user);
            
            // Sends data
            request.setAttribute("data", dataArray); 
            
            // Collects all dates in date range
            ArrayList dateList = user.listOfDates();
            
            // Sends collection of dates
            request.setAttribute("dateList", dateList);
            
            // Sends user to the graphOutput.jsp
            String url = "/graphOutput.jsp";
            
            getServletContext()
                    .getRequestDispatcher(url)
                    .forward(request, response);
        }
        
/**
 * 
 * @param request Servlet request
 * @param response Servlet Response
 * @throws ServletException If an error occurs
 * @throws IOException If in IO error occurs
 */
    @Override
    protected void doPost(HttpServletRequest request, 
                          HttpServletResponse response) 
                          throws ServletException, IOException {
        processRequest(request, response);
    }    
}
