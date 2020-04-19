<%-- 
    Document   : index
    Created on : Apr 18, 2020, 3:00:37 PM
    Author     : Palmer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
Created By: Palmer Pesta
Date Last Modified: 4/18/2020
Version: 4/18/2020
Purpose: To display and input data from the user
CSS code modified from: https://www.w3schools.com/html/html_layout.asp on 4/18/2020
-->

<html lang="en">
<head>
<title>Covid-19 Database</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
* {
  box-sizing: border-box;
}

body {
  font-family: Arial, Helvetica, sans-serif;
}

/* Style the header */
header {
  background-color: #000080;
  padding: 30px;
  text-align: center;
  font-size: 35px;
  color: white;
}

/* Container for flexboxes */
section {
  display: -webkit-flex;
  display: flex;
}

/* Style the navigation menu */
nav {
  -webkit-flex: 1;
  -ms-flex: 1;
  flex: 1;
  background: #ccc;
  padding: 20px;
}

/* Style the list inside the menu */
nav ul {
  list-style-type: none;
  padding: 0;
}

/* Style the content */
article {
  background-color: #f1f1f1;
  padding: 0px;
  text-align: center;
  
}

form {
        display: flex;
        flex-direction: row;

    }

/* Style the footer */
footer {
  background-color: #000080;
  padding: 10px;
  text-align: center;
  color: white;
}

/* Responsive layout - makes the menu and the content (inside the section) sit on top of each other instead of next to each other */
@media (max-width: 600px) {
  section {
    -webkit-flex-direction: column;
    flex-direction: column;
  }
}
</style>
</head>


<body>

<header>Covid-19 Data Search</header>

<section>
    
  <nav>
      <p>Please enter the information you are looking for below:</p>
      
      <form>

          <p>Country:</p>
          <select>
              <option>N/A</option>
              <option>USA</option>
              <option>France</option>
              <option>Italy</option>
              <option></option>
              <option></option>
              <option></option>
              <option></option>
          </select>
          
          <p>Providence/State:</p>
          <select>
              <option>N/A</option>
              <option>Under 10</option>
              <option>11-20</option>
              <option>21-30</option>
              <option>31-40</option>
              <option>41-50</option>
              <option>51-60</option>
              <option>61-70</option>
              <option>71-80</option>
              <option>Over 80</option>
          </select>

          <p>Month:</p>
          <select>
              <option>N/A</option>
              <option>January</option>
              <option>February</option>
              <option>March</option>
              <option>April</option>
          </select>
          
          <p>Status:</p>
          <select>
              <option>N/A</option>
              <option>Active</option>
              <option>Recovered</option>
              <option>Deceased</option>
          </select>
          
      </form>
  </nav>
  
  
  
  <article>
      <img src="corona.jpg" width="400" height="225">
      
  </article>
  
</section>

<footer>
<p>Data Graph Here</p>
</footer>

</body>
</html>