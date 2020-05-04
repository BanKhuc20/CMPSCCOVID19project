/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package COVID19;

import java.io.*;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/**
 * @author vorpa
 */
public class dataManager {
    
    private final String confirmedGlobal;
    private final String deathsGlobal;
    private final String recoveredGlobal;
    private final String currentDir;
    private final List<List<String>> confirmed;
    private final List<List<String>> deaths;
    private final List<List<String>> recovered;
    private String className;
    private String url;
    private String user;
    private String password;
    private Date tableDate;
    
    /**
     *
     * @throws java.io.IOException
     */
    public dataManager() throws IOException{
        confirmedGlobal = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_global.csv";
        deathsGlobal = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_deaths_global.csv";
        recoveredGlobal = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_recovered_global.csv";
        currentDir = System.getProperty("user.dir");
        tableDate = new Date(2020,1,22);
        
        confirmed = generateCSVArray('c');
        deaths = generateCSVArray('d');
        recovered = generateCSVArray('r');
        
        getCSV('c');
        getCSV('d');
        getCSV('r');
        
        password = null;
        user = null;
        url = null;
        className = null;
         try
        {
            ResourceBundle resources;
            InputStream in = null;

            in = ClassLoader.getSystemResourceAsStream("db.properties");

            resources = new PropertyResourceBundle(in);

            in.close();

            className = resources.getString("jdbc.driver");
            url = resources.getString("jdbc.url");
            System.out.println(url);
            user = resources.getString("jdbc.user");
            password = resources.getString("jdbc.password");
        }
        catch (Exception exp)
        {
            System.out.println("Couldn't load resources." + exp);
            System.exit(-1);
        }
        
        try
        {
            Class.forName(className);
        }
        catch (Exception e) 
        {
            System.out.println("Failed to load  driver.");
        }
        
    }
    
    
    /**
     * Fetches data from database. Saves to CSV file in the current directory. always defaults to confirmed CSV file if not specified.
     * @param dataType 'c' - loads confirmed cases;
     *                              'd' - loads confirmed deaths;
     *                              'r' - loads confirmed recovered;
     */
    private void getCSV(char dataType){
        String url;
        switch(dataType){
            case 'c': url = confirmedGlobal; break;
            case 'd': url = deathsGlobal; break;
            case 'r': url = recoveredGlobal; break;
            default: url = confirmedGlobal; break;
        }
        try (BufferedInputStream in = new BufferedInputStream(new URL(url).openStream());
                FileOutputStream fileOutputStream = new FileOutputStream(currentDir + "/data" + dataType + ".csv")) {
                    byte dataBuffer[] = new byte[1024];
                    int bytesRead;
                    while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                        fileOutputStream.write(dataBuffer, 0, bytesRead);
                    }
        } catch (IOException e) {
            System.out.print(e);
        }
    }
    
    /**
     * @param dataType
     * @return Parse CSV file as Array. Each row is represented as a List. Returns a list of lists(rows). List one is headings.
     * @throws FileNotFoundException
     * @throws IOException 
     */
    private ArrayList generateCSVArray(char dataType) throws FileNotFoundException, IOException{
        @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
        List<List<String>> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("data" + dataType + ".csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",(?! )");
                data.add(Arrays.asList(values));
            }
        }
        return (ArrayList) data;
    }
    
    /**
     * 
     * Populates the SQL database with information form csv files. Database should be named COVID19data. Should generally be run before anything is done...
     */
    public void populateDatabase(){
        
        try
        {
            Connection con = DriverManager.getConnection(url,user,password);     
                
            Statement stmt = con.createStatement();
            
            String columns = "";
            for(int i = 4; i < confirmed.get(0).size(); i++){
                columns = columns + ",confirmed_" + (i - 3) + " int";
            }
            
            stmt.execute("CREATE TABLE confirmed ("
                    + "Province varchar(255),"
                    + "Country varchar(255),"
                    + "Lat varchar(255),"
                    + "Long varchar(255)"
                    + columns + ")");
            
            String rowEntry = "";
            for(int i = 1; i < confirmed.size(); i++){
                rowEntry = "";
                for(int j = 0; j < 4; j++){                    
                    rowEntry = rowEntry + "'" + confirmed.get(i).get(j).replaceAll("'", "''") + "',";
                }
                
                for(int j = 4; j < confirmed.get(i).size(); j++){
                    rowEntry = rowEntry +  confirmed.get(i).get(j) + ",";
                }
                
                rowEntry = rowEntry.replaceAll(",$", "");

                stmt.execute("INSERT INTO confirmed"
                        + " VALUES (" + rowEntry + ")");
            }
            
            System.out.print("Confirmed Table Updated");
            
            columns = "";            
            for(int i = 4; i < recovered.get(0).size(); i++){
                columns = columns + ",recovered_" + (i - 3) + " int";
            }
            
            stmt.execute("CREATE TABLE recovered ("
                    + "Province varchar(255),"
                    + "Country varchar(255),"
                    + "Lat varchar(255),"
                    + "Long varchar(255)"
                    + columns + ")");
            
            rowEntry = "";
            for(int i = 1; i < recovered.size(); i++){
                rowEntry = "";
                for(int j = 0; j < 4; j++){                    
                    rowEntry = rowEntry + "'" + recovered.get(i).get(j).replaceAll("'", "''") + "',";
                }
                
                for(int j = 4; j < recovered.get(i).size(); j++){
                    rowEntry = rowEntry +  confirmed.get(i).get(j) + ",";
                }
                
                rowEntry = rowEntry.replaceAll(",$", "");

                stmt.execute("INSERT INTO recovered"
                        + " VALUES (" + rowEntry + ")");
            }

            System.out.print("Recovered Table Updated");
            
            columns = "";
            for(int i = 4; i < deaths.get(0).size(); i++){
                columns = columns + ",deaths_" + (i - 3) + " int";
            }
            
            stmt.execute("CREATE TABLE deaths ("
                    + "Province varchar(255),"
                    + "Country varchar(255),"
                    + "Lat varchar(255),"
                    + "Long varchar(255)"
                    + columns + ")");
            
            rowEntry = "";
            for(int i = 1; i < deaths.size(); i++){
                rowEntry = "";
                for(int j = 0; j < 4; j++){                    
                    rowEntry = rowEntry + "'" + deaths.get(i).get(j).replaceAll("'", "''") + "',";
                }
                
                for(int j = 4; j < deaths.get(i).size(); j++){
                    rowEntry = rowEntry +  deaths.get(i).get(j) + ",";
                }
                
                rowEntry = rowEntry.replaceAll(",$", "");

                stmt.execute("INSERT INTO deaths"
                        + " VALUES (" + rowEntry + ")");
            }
            
            System.out.print("Deaths Table Updated");
            
            stmt.close();
        
            con.close();
        }
        catch (Exception e) 
        {
            System.out.println(e);
        }
        
    }
    
    /**
     * Searches database for country with a specific name and status. Very unspecific and should not be used usually
     * @param termCountry - country being searched
     * @param status - status of the patients being searched
     * @return List<List<Integer>> containing all matching rows.
     */
    public List<List<Integer>> searchCountry(String termCountry, String status){
        List<List<Integer>> output = new ArrayList();
        List<Integer> row = new ArrayList();
        try
        {
            Connection con = DriverManager.getConnection(url,user,password);     
                
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM " + status.toLowerCase()
                    + " WHERE country='"+ termCountry + "'");
            
            ResultSetMetaData rsmd = rs.getMetaData();
            int numberOfColumns = rsmd.getColumnCount();
            
            while (rs.next()){
                row.clear();
                for (int i = 5; i <= numberOfColumns; i++)
                {
                    row.add(rs.getInt(i));
                }
                output.add(row);
            }
            
            stmt.close();
        
            con.close();
        }
        catch (Exception e) 
        {
            System.out.println(e);
        }
        
        return output;
    }
    
    /**
     * Searches database for matching country and province/state. Some countries may not have provinces/states. You should use and empty string for 
     * termProv when searching for them
     * @param termCountry
     * @param termProv
     * @param status
     * @return ArrayList containing all of the confirmed/deaths/recovered for every day. First index corresponds with 1/22/2020 and iterates upwards until current date.
     */
    public ArrayList searchProv(String termCountry, String termProv, String status){
        List<Integer> output = new ArrayList();
        try
        {
            Connection con = DriverManager.getConnection(url,user,password);     
                
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM " + status.toLowerCase()
                    + " WHERE country='"+ termCountry + "' AND province='" + termProv + "'");
            
            ResultSetMetaData rsmd = rs.getMetaData();
            int numberOfColumns = rsmd.getColumnCount();
            
            while (rs.next()){
                for (int i = 5; i <= numberOfColumns; i++)
                {
                    output.add(rs.getInt(i));
                }
            }
            
            stmt.close();
        
            con.close();
        }
        catch (Exception e) 
        {
            System.out.println(e);
        }
        
        return (ArrayList) output;
    }
    
    /**
     * Searches a range of a values corresponding to a series of dates
     * @param termCountry
     * @param termProv
     * @param startDate
     * @param endDate
     * @param status
     * @return List<Integer> containing the values from start date to end date of a specific province
     */
    public List<Integer> searchDay(String termCountry, String termProv, Date startDate, Date endDate, String status){
        List<Integer> results = new ArrayList();
        List<Integer> output = new ArrayList();
        
        results = searchProv(termCountry, termProv, status);
        
        long startDiff = tableDate.getTime() - startDate.getTime();
        
        int dropStart = Math.round(Math.abs(startDiff / (1000*60*60*24)));

        long endDiff = tableDate.getTime() - endDate.getTime();
        
        int dropEnd = Math.round(Math.abs(endDiff / (1000*60*60*24)));
        
        if(!results.isEmpty()){
            output = results.subList(dropStart, dropEnd);
        }
        return output;
    }
}