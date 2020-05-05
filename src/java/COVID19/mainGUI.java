/**
 * @author Bryce Finch
 */
package COVID19;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Bryce
 */
public class mainGUI extends javax.swing.JFrame {
    
    public String selectedStatistic;
    public String selectedCountry;
    public String selectedProvence;
    public int startDateMonth;
    public int startDateDay;
    public int startDateYear;
    public int endDateMonth;
    public int endDateDay;
    public int endDateYear;
    public dataManager covidData;

    /**
     * Creates new form mainGUI
     */
    public mainGUI() {
        try{
            covidData = new dataManager();
            covidData.populateDatabase();
        }
        catch(Exception e){
            System.out.println(e);
        }
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        buttonGroup5 = new javax.swing.ButtonGroup();
        buttonGroup6 = new javax.swing.ButtonGroup();
        buttonGroup7 = new javax.swing.ButtonGroup();
        jScrollPane3 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        jLabel1 = new javax.swing.JLabel();
        startDateMonthText = new javax.swing.JTextField();
        endDateMonthText = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        submitButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        displayTable = new javax.swing.JTable();
        startDateDayText = new javax.swing.JTextField();
        startDateYearText = new javax.swing.JTextField();
        endDateDayText = new javax.swing.JTextField();
        endDateYearText = new javax.swing.JTextField();
        countryText = new javax.swing.JTextField();
        provinceText = new javax.swing.JTextField();
        confirmedButton = new javax.swing.JRadioButton();
        recoveredButton = new javax.swing.JRadioButton();
        deathsButton = new javax.swing.JRadioButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jScrollPane3.setViewportView(jEditorPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("COVID-19 Tracker");

        startDateMonthText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startDateMonthTextActionPerformed(evt);
            }
        });

        endDateMonthText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endDateMonthTextActionPerformed(evt);
            }
        });

        jLabel2.setText("Country:");

        jLabel3.setText("Province:");

        jLabel4.setText("Start Date (MM/DD/YYYY):");

        jLabel5.setText("End Date (MM/DD/YYYY):");

        jLabel6.setText("Statistics:");

        submitButton.setText("Submit");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        displayTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Dates", "Values"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(displayTable);

        startDateDayText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startDateDayTextActionPerformed(evt);
            }
        });

        startDateYearText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startDateYearTextActionPerformed(evt);
            }
        });

        endDateDayText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endDateDayTextActionPerformed(evt);
            }
        });

        endDateYearText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endDateYearTextActionPerformed(evt);
            }
        });

        countryText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                countryTextActionPerformed(evt);
            }
        });

        buttonGroup1.add(confirmedButton);
        confirmedButton.setText("Confirmed");
        confirmedButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmedButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(recoveredButton);
        recoveredButton.setText("Recovered");
        recoveredButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recoveredButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(deathsButton);
        deathsButton.setText("Deaths");
        deathsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deathsButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(endDateMonthText, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(endDateDayText, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(endDateYearText))
                            .addComponent(countryText, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(provinceText, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(startDateMonthText, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(startDateDayText, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(startDateYearText)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(submitButton)
                            .addComponent(deathsButton)
                            .addComponent(jLabel6)
                            .addComponent(confirmedButton)
                            .addComponent(recoveredButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(countryText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(confirmedButton))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(recoveredButton))
                                .addGap(8, 8, 8)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(provinceText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(deathsButton))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(startDateMonthText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(startDateDayText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(startDateYearText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(submitButton))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(endDateMonthText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(endDateYearText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(endDateDayText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel6))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(6, 6, 6))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Set All of the Values to the User Inputted Values
    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        Date startDate = new Date(Integer.parseInt(startDateYearText.getText()), Integer.parseInt(startDateMonthText.getText()), Integer.parseInt(startDateDayText.getText()));
        Date endDate = new Date( Integer.parseInt(endDateYearText.getText()), Integer.parseInt(endDateMonthText.getText()), Integer.parseInt(endDateDayText.getText()));
        List<Integer> output = covidData.searchDay(countryText.getText(),provinceText.getText(), startDate, endDate, selectedStatistic);
        
        populateTable(output);
    }//GEN-LAST:event_submitButtonActionPerformed

    private void startDateYearTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startDateYearTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_startDateYearTextActionPerformed

    private void startDateMonthTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startDateMonthTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_startDateMonthTextActionPerformed

    private void startDateDayTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startDateDayTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_startDateDayTextActionPerformed

    private void endDateMonthTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_endDateMonthTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_endDateMonthTextActionPerformed

    private void endDateDayTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_endDateDayTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_endDateDayTextActionPerformed

    private void endDateYearTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_endDateYearTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_endDateYearTextActionPerformed

    private void confirmedButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmedButtonActionPerformed
        if(confirmedButton.isSelected()){
            selectedStatistic = "confirmed";
            System.out.print("c");
        }
    }//GEN-LAST:event_confirmedButtonActionPerformed

    private void recoveredButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recoveredButtonActionPerformed
        if(recoveredButton.isSelected()){
            selectedStatistic = "recovered";
            System.out.print("r");
        }
    }//GEN-LAST:event_recoveredButtonActionPerformed

    private void deathsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deathsButtonActionPerformed
        if(deathsButton.isSelected()){
            selectedStatistic = "deaths";
            System.out.print("d");
        }
    }//GEN-LAST:event_deathsButtonActionPerformed

    private void countryTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_countryTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_countryTextActionPerformed
 
    // Populate Table
    public void populateTable(List<Integer> dataList) {

        DefaultTableModel model = (DefaultTableModel) displayTable.getModel();
        model.setRowCount(0);
        
        Date startDate = new Date(Integer.parseInt(startDateYearText.getText()), Integer.parseInt(startDateMonthText.getText()), Integer.parseInt(startDateDayText.getText()));
        
        System.out.println(dataList);
        System.out.println(startDate);
        
        for(Integer i: dataList){
            model.addRow(new Object[] {startDate.getDate() + "-" +startDate.getMonth() + "-" + startDate.getYear() ,i});
            long increment = startDate.getTime();
            startDate = new Date(increment + 86400000);
        }

        displayTable.setModel(model);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(mainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.ButtonGroup buttonGroup6;
    private javax.swing.ButtonGroup buttonGroup7;
    private javax.swing.JRadioButton confirmedButton;
    private javax.swing.JTextField countryText;
    private javax.swing.JRadioButton deathsButton;
    private javax.swing.JTable displayTable;
    private javax.swing.JTextField endDateDayText;
    private javax.swing.JTextField endDateMonthText;
    private javax.swing.JTextField endDateYearText;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField provinceText;
    private javax.swing.JRadioButton recoveredButton;
    private javax.swing.JTextField startDateDayText;
    private javax.swing.JTextField startDateMonthText;
    private javax.swing.JTextField startDateYearText;
    private javax.swing.JButton submitButton;
    // End of variables declaration//GEN-END:variables
}
