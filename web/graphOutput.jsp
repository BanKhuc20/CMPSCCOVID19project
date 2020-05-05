
<!--
Created By: Palmer Pesta
Date Last Modified: 5/5/2020
Version: 1.2
Purpose: To display the data of the Corona Virus
CSS code modified from: https://www.w3schools.com/html/html_layout.asp on 4/18/2020
Javascript code modified from: https://blog.zingchart.com/jsp-chart-example/
-->

<%@page import="java.util.ArrayList"%>
<!-- This connects to the zingchart website to process the javascript -->
<script type="text/javascript" src="https://cdn.zingchart.com/zingchart.min.js"></script>  
<link rel="stylesheet" href="https://code.jquery.com/ui/1.10.2/themes/smoothness/jquery-ui.css" />
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Corona Virus Graph</title>
        
    </head>
    <body>

         <div id="myChart"></div>
        
         <%
             ArrayList graphData = (ArrayList)request.getAttribute("graphData"); // Recieves variable from controller file
             ArrayList dates = (ArrayList)request.getAttribute("dates"); // Recieves variable from controller file
             
             ArrayList graphNumData = new ArrayList(); // Hard codes data points due to graphData and dates being null
             graphNumData.add(40);
             graphNumData.add(50);
             graphNumData.add(45);
             graphNumData.add(60);
             graphNumData.add(30);
             graphNumData.add(80);
             graphNumData.add(20);
             graphNumData.add(30);
             
             
             ArrayList listOfDates = new ArrayList();
             listOfDates.add("01-01");
             listOfDates.add("01-02");
             listOfDates.add("01-03");
             listOfDates.add("01-04");
             listOfDates.add("01-05");
             listOfDates.add("01-06");
             listOfDates.add("01-07");
             listOfDates.add("01-08");
         %>

         <!--This graphs the datapoints -->
  <script>
    var graphDataArray = [];
    var dateArray = [];
     // This cycles through the data values and sets then eqaul to a new array in javascript
    <% for (int i=0; i< graphNumData.size(); i++) { %>
        graphDataArray[<%= i %>] = <%= graphNumData.get(i) %>; 
    <% } %>
       
    //-----------------------------------------------------------------------------------------------
    //This cycles through dates to produce a list of dates to be graphed on the x-axis
    <% for (int i=0; i< listOfDates.size(); i++) { %>
        dateArray[<%= i %>] = '<%= listOfDates.get(i) %>'; 
    <% } %>
    
    let myConfig = {
      type: 'bar',
      title: {
        text: "Covid-19 Data From John Hopkins",
        fontSize: 24,
        color: '#000080'
      },
      legend: {
        draggable: true
      },
      scaleX: {
        // Set scale label
        label: { text: 'Date Range' },
        // Convert text on scale indices
        labels: dateArray
      },
      scaleY: {
        // Scale label with unicode character
        label: { text: 'Number of Cases' }
      },
      plot: {
        // Animation docs here:
        // https://www.zingchart.com/docs/tutorials/styling/animation#effect
        animation: {
          effect: 'ANIMATION_EXPAND_BOTTOM',
          method: 'ANIMATION_STRONG_EASE_OUT',
          sequence: 'ANIMATION_BY_NODE',
          speed: 275
          
        }
      },
      series: [
        {
          // Plot 1 values, linear data
          values: graphDataArray,
          text: 'Data',
          backgroundColor: '#000080'
        }
      ]
    };
    // Render Method[3]
    zingchart.render({
      id: 'myChart',
      data: myConfig
    });
  </script>
  
    <form action="index.jsp" method="get">
        <input type="hidden" name="action" value="join">
        <input type="submit" value="Return">
    </form>
    </body>
</html>
