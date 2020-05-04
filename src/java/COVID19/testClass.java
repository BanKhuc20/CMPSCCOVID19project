/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package COVID19;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author vorpa
 */
public class testClass {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        dataManager test = new dataManager();
        
        test.populateDatabase();
        
        List<Integer> output;
        Date startDate = new Date(2020, 2, 24);
        Date endDate = new Date(2020, 3, 15);
        
        output = test.searchDay("United Kingdom", "", startDate, endDate, "confirmed");
        System.out.println(output);
    }
    
}
