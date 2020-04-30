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
    
    /**
     *
     * @throws java.io.IOException
     */
    public dataManager() throws IOException{
        confirmedGlobal = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_global.csv";
        deathsGlobal = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_deaths_global.csv";
        recoveredGlobal = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_recovered_global.csv";
        currentDir = System.getProperty("user.dir");
        
        getCSV('c');
        getCSV('d');
        getCSV('r');
        
        confirmed = generateCSVArray('c');
        deaths = generateCSVArray('d');
        recovered = generateCSVArray('r');
        
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
                String[] values = line.split(",");
                data.add(Arrays.asList(values));
            }
        }
        return (ArrayList) data;
    }
    
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
            
            columns = "";            
            for(int i = 4; i < confirmed.get(0).size(); i++){
                columns = columns + ",recovered_" + (i - 3) + " int";
            }
            
            stmt.execute("CREATE TABLE recovered ("
                    + "Province varchar(255),"
                    + "Country varchar(255),"
                    + "Lat varchar(255),"
                    + "Long varchar(255)"
                    + columns + ")");
            
            columns = "";
            for(int i = 4; i < confirmed.get(0).size(); i++){
                columns = columns + ",deaths_" + (i - 3) + " int";
            }
            stmt.execute("CREATE TABLE deaths ("
                    + "Province varchar(255),"
                    + "Country varchar(255),"
                    + "Lat varchar(255),"
                    + "Long varchar(255)"
                    + columns + ")");

            stmt.close();
        
            con.close();
        }
        catch (Exception e) 
        {
            System.out.println(e);
        }
        
    }
    
    private List<List<Integer>> searchCountry(String termCountry){
        List<List<Integer>> output = new ArrayList();
        List<Integer> row = new ArrayList();
        try
        {
            Connection con = DriverManager.getConnection(url,user,password);     
                
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM Customers"
                    + "WHERE country='"+ termCountry + "';");
            
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
        
        return(output);
    }
    
    private ArrayList searchProv(String termCountry, String termProv){
        List<String> output = new ArrayList();

        return (ArrayList) output;
    }
    
    public ArrayList searchDay(String termCountry, String termProv, Date startDate, Date endDate){
        List<String> output = new ArrayList();

        return (ArrayList) output;
    }
}
