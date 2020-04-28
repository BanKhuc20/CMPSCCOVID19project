<!--
Created By: Palmer Pesta
Date Last Modified: 4/20/2020
Version: 1.2
Purpose: To display and input data from the user about Covid-19
CSS code modified from: https://www.w3schools.com/html/html_layout.asp on 4/18/2020
Javascript code modified from: https://blog.zingchart.com/jsp-chart-example/
-->

<%@page import="java.util.Date"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.time.ZoneId"%>
<%@page import="java.time.ZoneId"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Covid-19 Database</title>


<!-- This connects to the zingchart website to process the javascript -->
<script type="text/javascript" src="https://cdn.zingchart.com/zingchart.min.js"></script>  
<link rel="stylesheet" href="https://code.jquery.com/ui/1.10.2/themes/smoothness/jquery-ui.css" />
    <script src="https://code.jquery.com/jquery-3.4.1.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

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
        flex-direction: column;

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

<style>
        #custom-handle-0,
        #custom-handle-1 {
            width: 75px;
            height: 1.6em;
            top: 50%;
            margin-top: -.8em;
            text-align: center;
            line-height: 1.6em;
            font-family: Verdana, Arial, sans-serif;
            font-size: 12px;
        }
    </style>
    
    <script type="text/javascript">
        $(function () {
            var minDate = new Date('2020-01-22');
            var maxDate = new Date('2020-3-23');
            var valueHi = new Date(new Date().toLocaleDateString());
            var valueLo = new Date(valueHi.getTime() - 56 * 86400000);
            var dateMin = new Date(minDate.getTime() + minDate.getTimezoneOffset() * 60 * 1000);
            var dateMax = new Date(maxDate.getTime() + maxDate.getTimezoneOffset() * 60 * 1000);
            var handle0 = $("#custom-handle-0");
            var handle1 = $("#custom-handle-1");
           

            $("#slider-range").slider({
                range: true,
                min: dateMin.getTime() / 1000,
                max: dateMax.getTime() / 1000,
                step: 86400,
                values: [dateMin.getTime() / 1000, valueHi.getTime() / 1000],
                create: function () {
                    handle0.text(dateMin.toLocaleDateString());
                    handle1.text(valueHi.toLocaleDateString());
                },

                slide: function (event, ui) {
                    $("#date").val((new Date(ui.values[0] * 1000).toDateString()) + " - " + (new Date(ui.values[1] * 1000)).toDateString());
                    handle0.text(new Date(ui.values[0] * 1000).toLocaleDateString());
                    handle1.text(new Date(ui.values[1] * 1000).toLocaleDateString());

                }
            });
            $("#date").val((new Date($("#slider-range").slider("values", 0) * 1000).toDateString()) + " - " + (new Date($("#slider-range").slider("values", 1) * 1000)).toDateString());
        });
    </script>

<script>
function populate(country,providence){
    var country = document.getElementById(country);
    var providence = document.getElementById(providence);
    providence.innerHTML = "";
    
    if(country.value == "Australia"){
        var optionArray = ["N/A", "Austrailian Capital Territory", "New South Wales", "Nothern Territory", "Queensland", "South Australia", "Tasmania", "Victoria", "Western Australia"];
    } 
    
    else if(country.value == "Canada"){
         var optionArray = ["N/A", "Alberta", "British Columbia", "Grand Princess", "Manitoba", "New Brunswick", "Newfoundland and Labrador", "Northwest Territories", "Nova Scotia", "Ontario", "Prince Edward Island", "Quebec", "Saskatchewan"];
    }
    
    else if(country.value == "China"){
        var optionArray = ["N/A", "Anhui", "Beijing", "Chongqing", "Fujian", "Gansu", "Guangdong", "Guangxi", "Guizhou", "Hainan", "Hebei", "Heilongjiang", "Henan", "Hong Kong", "Hubei", "Hunan", "Inner Mongolia", "Jiangsu", "Jiangxi", "Jilin", "Liaoning", "Macau", "Ningxia", "Qinghai", "Shaanxi", "Shandong", "Shanghai", "Shanxi", "Sichuan", "Tianjin", "Tibet", "Xinjiang", "Yunnan", "Zhejiang"];
    }
    
    else if(country.value == "Denmark"){
         var optionArray = ["Denmark", "Faroe Islands", "Greenland"];
    }
    
    else if(country.value == "France"){
         var optionArray = ["France", "French Guiana", "French Polynesia", "Guadeloupe", "Mayotte", "New Caledonia", "Reunion", "Saint Barthelemy", "St Martin"];
    }
    
    else if(country.value == "Netherlands"){
         var optionArray = ["Netherlands", "Aruba", "Curacao", "Sint Maarten"];
    }
    
    else if(country.value == "US"){
        var optionArray = ["N/A", "Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado", "Connecticut", "Delaware", "Florida", "Georgia", "Hawaii", "Idaho", "Illinois", "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts", "Michigan", "Minnesota", "Mississippi", "Missouri", "Montanna", "Nebraska", "Nevada", "New Hampshire", "New Jersey", "New Mexico", "New York", "North Carolinia", "North Dakota", "Ohio", "Oklahoma", "Oregon", "Pennsylvania", "Rhode Island", "South Carolina", "South Dakota", "Tennessee", "Texas", "United States Virgin Islands", "Utah", "Vermount", "Virginia", "Washingtion", "West Virginia", "Wisconsin", "Wyoming"];
    }
    
    else if(country.value == "United Kingdom"){
         var optionArray = ["United Kingdom", "Bermuda", "Cayman Islands", "Channel Islands", "Gibraltar", "Isle of Man", "Montserrat"];
    }
    
    else{
        var optionArray =["N/A"];
    }
    for(var option in optionArray){
        var state = optionArray[option];
	var newOption = document.createElement("option");
	newOption.value = state;
	newOption.innerHTML = state;
	providence.options.add(newOption);
        
    }
}
</script>
</head>


<body>

<header>Covid-19 Data Search</header>

<section>
    
  <nav>
      <p>Please enter the information you are looking for below:</p>
      
      <br/>
    
      <form name="inputData" action="index.jsp" method="POST">
      <p>
        <label for="date">Date range:</label>
        <input type="text" name="date" id="date" style="border: 0; color: #f6931f; font-weight: bold;" size="30" />
      </p>
      <div id="slider-range">
        <div id="custom-handle-0" class="ui-slider-handle"></div>
        <div id="custom-handle-1" class="ui-slider-handle"></div>
      </div>
      
      <br/>
      
      

          <p>Country:</p>
          <select id="country" name="country" onChange="populate(this.id, 'providence')">
              <option>N/A</option>
              <option value="US">US</option>
              <option value="France">France</option>
              <option value="Italy">Italy</option>
              <option value="Thailand">Thailand</option>
              <option value="Japan">Japan</option>
              <option value="Singapore">Singapore</option>
              <option value="Nepal">Nepal</option>
              <option value="Malaysia">Malaysia</option>
              <option value="Canada">Canada</option>
              <option value="Australia">Australia</option>
              <option value="Cambodia">Cambodia</option>
              <option value="Sri Lanka">Sri Lanka</option>
              <option value="Germany">Germany</option>
              <option value="Finland">Finland</option>
              <option value="United Arab Emirates">United Arab Emirates</option>
              <option value="Philippines">Philippines</option>
              <option value="India">India</option>
              <option value="Sweden">Sweden</option>
              <option value="Spain">Spain</option>
              <option value="Belgium">Belgium</option>
              <option value="Egypt">Egypt</option>
              <option value="Lebanon">Lebanon</option>
              <option value="Iraq">Iraq</option>
              <option value="Oman">Oman</option>
              <option value="Afghanistan">Afghanistan</option>
              <option value="Bahrain">Bahrain</option>
              <option value="Kuwait">Kuwait</option>
              <option value="Algeria">Algeria</option>
              <option value="Croatia">Croatia</option>
              <option value="Switzerland">Switzerland</option>
              <option value="Austria">Austria</option>
              <option value="Israel">Israel</option>
              <option value="Pakistan">Pakistan</option>
              <option value="Brazil">Brazil</option>
              <option value="Georgia">Georgia</option>
              <option value="Greece">Greece</option>
              <option value="North Macedonia">North Macedonia</option>
              <option value="Norway">Norway</option>
              <option value="Romania">Romania</option>
              <option value="Estonia">Estonia</option>
              <option value="San Marino">San Marino</option>
              <option value="Belarus">Belarus</option>
              <option value="Iceland">Iceland</option>
              <option value="Lithuania">Lithuania</option>
              <option value="Mexico">Mexico</option>
              <option value="New Zealand">New Zealand</option>
              <option value="Nigeria">Nigeria</option>
              <option value="Ireland">Ireland</option>
              <option value="Luxembourg">Luxembourg</option>
              <option value="Monaco">Monaco</option>
              <option value="Qatar">Qatar</option>
              <option value="Ecuador">Ecuador</option>
              <option value="Azerbaijan">Azerbaijan</option>
              <option value="Armenia">Armenia</option>
              <option value="Dominican Republic">Dominican Republic</option>
              <option value="Indonesia">Indonesia</option>
              <option value="Portugal">	Portugal</option>
              <option value="Andorra">Andorra</option>
              <option value="Latvia">Latvia</option>
              <option value="Morocco">Morocco</option>
              <option value="Saudi Arabia">Saudi Arabia</option>
              <option value="Senegal">Senegal</option>
              <option value="Argentina">Argentina</option>
              <option value="Chile">Chile</option>
              <option value="Jordan">Jordan</option>
              <option value="Ukraine">Ukraine</option>
              <option value="Hungary">Hungary</option>
              <option value="Liechtenstein">Liechtenstein</option>
              <option value="Poland">Poland</option>
              <option value="Tunisia">Tunisia</option>
              <option value="Bosnia and Herzegovina">Bosnia and Herzegovina</option>
              <option value="Slovenia">Slovenia</option>
              <option value="South Africa">South Africa</option>
              <option value="Bhutan">Bhutan</option>
              <option value="Cameroon">Cameroon</option>
              <option value="Colombia">Colombia</option>
              <option value="Costa Rica">Costa Rica</option>
              <option value="Peru">Peru</option>
              <option value="Serbia">Serbia</option>
              <option value="Slovakia">Slovakia</option>
              <option value="Togo">Togo</option>
              <option value="Malta">Malta</option>
              <option value="Martinique">Martinique</option>
              <option value="Bulgaria">Bulgaria</option>
              <option value="Maldives">Maldives</option>
              <option value="Bangladesh">Bangladesh</option>
              <option value="Paraguay">Paraguay</option>
              <option value="Albania">Albania</option>
              <option value="Cyprus">Cyprus</option>
              <option value="Brunei">Brunei</option>
              <option value="Burkina Faso">Burkina Faso</option>
              <option value="Holy See">Holy See</option>
              <option value="Mongolia">Mongolia</option>
              <option value="Panama">Panama</option>
              <option value="China">China</option>
              <option value="Korea, South">Korea, South</option>
              <option value="Denmark">Denmark</option>
              <option value="Taiwan*">Taiwan</option>
              <option value="Vietnam">Vietnam</option>
              <option value="Russia">Russia</option>
              <option value="Moldova">Moldova</option>
              <option value="Bolivia">Bolivia</option>
              <option value="Honduras">Honduras</option>
              <option value="United Kingdom">United Kingdom</option>
              <option value="Congo (Kinshasa)">Congo (Kinshasa)</option>
              <option value="Cote d'Ivoire">Cote d'Ivoire</option>
              <option value="Jamaica">Jamaica</option>
              <option value="Turkey">Turkey</option>
              <option value="Cuba">Cuba</option>
              <option value="Guyana">Guyana</option>
              <option value="Kazakhstan">Kazakhstan</option>
              <option value="Ethiopia">Ethiopia</option>
              <option value="Sudan">Sudan</option>
              <option value="Guinea">Guinea</option>
              <option value="Kenya">Kenya</option>
              <option value="Antigua and Barbuda">Antigua and Barbuda</option>
              <option value="Uruguay">Uruguay</option>
              <option value="Ghana">Ghana</option>
              <option value="Namibia">Namibia</option>
              <option value="Seychelles">Seychelles</option>
              <option value="Trinidad and Tobago">Trinidad and Tobago</option>
              <option value="Venezuela">Venezuela</option>
              <option value="Eswatini">Eswatini</option>
              <option value="Gabon">Gabon</option>
              <option value="Guatemala">Guatemala</option>
              <option value="Mauritania">Mauritania</option>
              <option value="Rwanda">Rwanda</option>
              <option value="Saint Lucia">Saint Lucia</option>
              <option value="Saint Vincent and the Grenadines">Saint Vincent and the Grenadines</option>
              <option value="Suriname">Suriname</option>
              <option value="Kosovo">Kosovo</option>
              <option value="Central African Republic">Central African Republic</option>
              <option value="Congo (Brazzaville)">Congo (Brazzaville)</option>
              <option value="Equatorial Guinea">Equatorial Guinea</option>
              <option value="Uzbekistan">Uzbekistan</option>
              <option value="Benin">Benin</option>
              <option value="Liberia">Liberia</option>
              <option value="Somalia">Somalia</option>
              <option value="Tanzania">Tanzania</option>
              <option value="Barbados">Barbados</option>
              <option value="Montenegro">Montenegro</option>
              <option value="Kyrgyzstan">Kyrgyzstan</option>
              <option value="Mauritius">Mauritius</option>
              <option value="Zambia">Zambia</option>
              <option value="Djibouti">Djibouti</option>
              <option value="Gambia, The">Gambia, The</option>
              <option value="Bahamas, The">Bahamas, The</option>
              <option value="Chad">Chad</option>
              <option value="El Salvador">El Salvador</option>
              <option value="Fiji">Fiji</option>
              <option value="Nicaragua">Nicaragua</option>
              <option value="Madagascar">Madagascar</option>
              <option value="Haiti">Haiti</option>
              <option value="Angola">Angola</option>
              <option value="Cabo Verde">Cabo Verde</option>
              <option value="Niger">Niger</option>
              <option value="Netherlands">Netherlands</option>
              <option value="Papua New Guinea">Papua New Guinea</option>
              <option value="Zimbabwe">Zimbabwe</option>
              <option value="East Timor">East Timor</option>
              <option value="Eritrea">Eritrea</option>
              <option value="Uganda">Uganda</option>
              <option value="Dominica">Dominica</option>
              <option value="Grenada">Grenada</option>
              <option value="Mozambique">Mozambique</option>
              <option value="Syria">Syria</option>
              <option value="Timor-Leste">Timor-Leste</option>
              <option value="Guadeloupe">Guadeloupe</option>
              <option value="Reunion">Reunion</option>
              <option value="French Guiana">French Guiana</option>
              <option value="Mayotte">Mayotte</option>
              <option value="Greenland">Greenland</option>
              <option value="Guam">Guam</option>
              <option value="Guernsey">Guernsey</option>
              <option value="Jersey">Jersey</option>
              <option value="Puerto Rico">Puerto Rico</option>
              <option value="Republic of the Congo">Republic of the Congo</option>
              <option value="The Bahamas">The Bahamas</option>
              <option value="The Gambia">The Gambia</option>
              
              
          </select>
          
          <br/>
    
          <!--This is determined by the Country-->
          <p>Providence/State:</p>
          <select id="providence" name="providence" ></select>
          
          <br/>

          <p>Status:</p>
          <select id="status" name="status">
              <option>N/A</option>
              <option>Active</option>
              <option>Recovered</option>
              <option>Deceased</option>
          </select>
          
          <input type="submit" value="Submit Form" />
          
          
      </form>
      

      <%

        String country = request.getParameter("country");
        String providence = request.getParameter("providence");
        String status = request.getParameter("status");  
        String date = request.getParameter("date");
        ArrayList graphNumData = new ArrayList();
        ArrayList listOfDates = new ArrayList();
        
        if (date != null){
            String[] dateList = date.split(" - ");
      
            Date dateStart = new Date(dateList[0]);
        
            Date dateEnd = new Date(dateList[1]);
            
            graphNumData.add(40);
            
            graphNumData.add(41);
            
         
 
            LocalDate start1 = dateStart.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate end2 = dateEnd.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();


            for (LocalDate date2 = start1; date2.isBefore(end2) || date2.isEqual(end2); date2 = date2.plusDays(1)) {
                listOfDates.add(date2.toString().substring(5,10));
                
            }
        
            //out.println("<p> " + country + " " + providence + " " + dateStart + " " + dateEnd + " " + status + "\n" + graphNumData.get(0) + "\n" + listOfDates.get(0) + " </p>");
            // graphNumData = graphData(country, providence, dateStart, dateEnd, status)
            
            

        }
      %>
  </nav>
  
  
  
  <article>
      <img src="corona.jpg" width="400" height="225">
      
  </article>
  
</section>

<footer>
    <div id="myChart"></div>

  <script>
    var graphDataArray = [];
    var dateArray = [];
    
    <% for (int i=0; i<graphNumData.size(); i++) { %>
        graphDataArray[<%= i %>] = <%= graphNumData.get(i) %>; 
    <% } %>

       
    //-----------------------------------------------------------------------------------------------
    <% for (int i=0; i<listOfDates.size(); i++) { %>
        dateArray[<%= i %>] = '<%= listOfDates.get(i) %>'; 
    <% } %>
    
    let myConfig = {
      type: 'bar',
      title: {
        text: "Covid-19 Data From John Hopkins",
        fontSize: 24,
        color: '#5d7d9a'
      },
      legend: {
        draggable: true,
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
          speed: 275,
          
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
      data: myConfig,
    });
  </script>
  
</footer>

</body>
</html>