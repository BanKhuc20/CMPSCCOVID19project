/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package COVID19;

import java.io.IOException;

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
    }
    
}
