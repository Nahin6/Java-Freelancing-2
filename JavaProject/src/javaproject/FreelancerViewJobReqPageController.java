/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproject;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author Acer
 */
public class FreelancerViewJobReqPageController implements Initializable {

    @FXML
    private TextArea JobReceivedFromCustomer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     
                JobReceivedFromCustomer.setText("");
        File f = null;
        FileInputStream readFile = null;
        DataInputStream readData = null;
        String jobForFreelancer="";
        try {
            f = new File("HireFreelancer.bin");
            if(!f.exists()){
                JobReceivedFromCustomer.setText("No new job request ");
            }
            else{
                
                readFile = new FileInputStream(f);

                readData = new DataInputStream(readFile);
             
                while(true){
               
               jobForFreelancer = 
                        "Customer Name: "+readData.readUTF()+"\n"
                        +
                        "Customer ID: "+readData.readUTF()+"\n"
                        +
                        "Your Name: "+readData.readUTF()+"\n"
                        + "Desire Service Catagory: "+readData.readUTF()+"\n"+
                        "Desire Work: "+readData.readUTF()+"\n"+
                        "Details Message :\n "
                        + readData.readUTF()+"\n \n"
                        +"Next Job Request :\n";
                    JobReceivedFromCustomer.appendText(jobForFreelancer);
                }
            }
        } catch (IOException ex) {
           
            Logger.getLogger(EmployeeViewJobRequestPageController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(readData != null) readData.close();
            } catch (IOException ex) {
                Logger.getLogger(EmployeeViewJobRequestPageController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }    
    
}
