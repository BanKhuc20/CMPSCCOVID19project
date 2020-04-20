<!--
Created By: Palmer Pesta
Date Last Modified: 4/19/2020
Version: 1.1
Purpose: To display and input data from the user about Covid-19
CSS code modified from: https://www.w3schools.com/html/html_layout.asp on 4/18/2020
Javascript code modified from: https://blog.zingchart.com/jsp-chart-example/
-->

<!DOCTYPE html>
<html lang="en">
<head>
<title>Covid-19 Database</title>


<!-- This connects to the zingchart website to process the javascript -->
<script type="text/javascript" src="https://cdn.zingchart.com/zingchart.min.js"></script>  

<!-- Generates the layout using CSS -->
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


<script>
function populate(s1,s2){
    var s1 = document.getElementById(s1);
    var s2 = document.getElementById(s2);
    s2.innerHTML = "N/A";
    
    if(s1.value == "Australia"){
        var optionArray = ["N/A", "Austrailian Capital Territory", "New South Wales", "Nothern Territory", "Queensland", "South Australia", "Tasmania", "Victoria", "Western Australia"]
    } 
    
    else if(s1.value == "Canada"){
         var optionArray = ["N/A", "Alberta", "British Columbia", "Grand Princess", "Manitoba", "New Brunswick", "Newfoundland and Labrador", "Northwest Territories", "Nova Scotia", "Ontario", "Prince Edward Island", "Quebec", "Saskatchewan"]
    }
    
    else if(s1.value == "China"){
        var optionArray = ["N/A", "Anhui", "Beijing", "Chongqing", "Fujian", "Gansu", "Guangdong", "Guangxi", "Guizhou", "Hainan", "Hebei", "Heilongjiang", "Henan", "Hong Kong", "Hubei", "Hunan", "Inner Mongolia", "Jiangsu", "Jiangxi", "Jilin", "Liaoning", "Macau", "Ningxia", "Qinghai", "Shaanxi", "Shandong", "Shanghai", "Shanxi", "Sichuan", "Tianjin", "Tibet", "Xinjiang", "Yunnan", "Zhejiang"]
    }
    
    else if(s1.value == "Denmark"){
         var optionArray = ["Denmark", "Faroe Islands", "Greenland"]
    }
    
    else if(s1.value == "France"){
         var optionArray = ["France", "French Guiana", "French Polynesia", "Guadeloupe", "Mayotte", "New Caledonia", "Reunion", "Saint Barthelemy", "St Martin"]
    }
    
    else if(s1.value == "Netherlands"){
         var optionArray = ["Netherlands", "Aruba", "Curacao", "Sint Maarten"]
    }
    
    else if(s1.value == "US"){
        var optionArray = ["N/A", "Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado", "Connecticut", "Delaware", "Florida", "Georgia", "Hawaii", "Idaho", "Illinois", "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts", "Michigan", "Minnesota", "Mississippi", "Missouri", "Montanna", "Nebraska", "Nevada", "New Hampshire", "New Jersey", "New Mexico", "New York", "North Carolinia", "North Dakota", "Ohio", "Oklahoma", "Oregon", "Pennsylvania", "Rhode Island", "South Carolina", "South Dakota", "Tennessee", "Texas", "United States Virgin Islands", "Utah", "Vermount", "Virginia", "Washingtion", "West Virginia", "Wisconsin", "Wyoming"];
    }
    
    else if(s1.value == "United Kingdom"){
         var optionArray = ["United Kingdom", "Bermuda", "Cayman Islands", "Channel Islands", "Gibraltar", "Isle of Man", "Montserrat"]
    }
    
    else{
        var optionArray =["N/A"];
    }
    for(var option in optionArray){
        var pair = optionArray[option];
	var newOption = document.createElement("option");
	newOption.value = pair;
	newOption.innerHTML = pair;
	s2.options.add(newOption);
        
    }
}
</script>
</head>


<body>

<header>Covid-19 Data Search</header>

<section>
    
  <nav>
      <p>Please enter the information you are looking for below:</p>
      
      <form>

          <p>Country:</p>
          <select id="country" name="country" onChange="populate(this.id, 'providence')">
              <option>N/A</option>
              <option value="USA">US</option>
              <option value="France">France</option>
              <option>Italy</option>
              <option>Thailand</option>
              <option>Japan</option>
              <option>Singapore</option>
              <option>Nepal</option>
              <option>Malaysia</option>
              <option>Canada</option>
              <option>Australia</option>
              <option>Cambodia</option>
              <option>Sri Lanka</option>
              <option>Germany</option>
              <option>Finland</option>
              <option>United Arab Emirates</option>
              <option>Philippines</option>
              <option>India</option>
              <option>Sweden</option>
              <option>Spain</option>
              <option>Belgium</option>
              <option>Egypt</option>
              <option>Lebanon</option>
              <option>Iraq</option>
              <option>Oman</option>
              <option>Afghanistan</option>
              <option>Bahrain</option>
              <option>Kuwait</option>
              <option>Algeria</option>
              <option>Croatia</option>
              <option>Switzerland</option>
              <option>Austria</option>
              <option>Israel</option>
              <option>Pakistan</option>
              <option>Brazil</option>
              <option>Georgia</option>
              <option>Greece</option>
              <option>North Macedonia</option>
              <option>Norway</option>
              <option>Romania</option>
              <option>Estonia</option>
              <option>San Marino</option>
              <option>Belarus</option>
              <option>Iceland</option>
              <option>Lithuania</option>
              <option>Mexico</option>
              <option>New Zealand</option>
              <option>Nigeria</option>
              <option>Ireland</option>
              <option>Luxembourg</option>
              <option>Monaco</option>
              <option>Qatar</option>
              <option>Ecuador</option>
              <option></option>
              <option></option>
              <option></option>
              <option></option>
              <option></option>
              <option></option>
              <option></option>
              <option></option>
              <option></option>
              <option></option>
              <option></option>
              <option></option>
              <option></option>
              <option></option>
              <option></option>
              <option></option>
              <option></option>
          </select>
    
          <!--This is determined by the Country-->
          <p>Providence/State:</p>
          <select id="providence" name="providence" ></select>

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
          
          <input type="submit" value="Submit Form" />
      </form>
      <%
          
      %>
  </nav>
  
  
  
  <article>
      <img src="corona.jpg" width="400" height="225">
      
  </article>
  
</section>

<footer>
    <div id="myChart"></div>

  <script>
    let myConfig = {
      type: 'bar',
      title: {
        text: 'Covid-19 Data Generated from John Hopkins',
        fontSize: 24,
      },
      legend: {
        draggable: true,
      },
      scaleX: {
        // Set scale label
        label: { text: 'Date Range' },
        // Convert text on scale indices
        labels: [ 'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
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
          speed: 275,
        }
      },
      series: [
        {
          // Plot 1 values, linear data
          values: [23,20,27,29,25,17,15],
          text: 'Week 1',
        },
        {
          // Plot 2 values, linear data
          values: [35,42,33,49,35,47,35],
          text: 'Week 2'
        },
        {
          // Plot 2 values, linear data
          values: [15,22,13,33,44,27,31],
          text: 'Week 3'
        }
      ]
    };

    // Render Method[3]
    zingchart.render({
      id: 'myChart',
      data: myConfig,
    });
  </script>
</footer>

</body>
</html>