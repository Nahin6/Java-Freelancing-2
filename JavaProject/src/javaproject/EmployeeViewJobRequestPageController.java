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
public class EmployeeViewJobRequestPageController implements Initializable {

    @FXML
    private TextArea JobReceived;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
                

                JobReceived.setText("");
        File f = null;
        FileInputStream readFile = null;
        DataInputStream readData = null;
        String job="";
        try {
            f = new File("SentOffer.bin");
            if(!f.exists()){
                JobReceived.setText("No new Post ");
            }
            else{
                
                readFile = new FileInputStream(f);

                readData = new DataInputStream(readFile);
             
                while(true){
               
               job = 
                        "Customer Name: "+readData.readUTF()+"\n"
                        +
                        "Customer Number: "+readData.readUTF()+"\n"
                        +
                        "Customer Email: "+readData.readUTF()+"\n"
                        + "Service need for: "+readData.readUTF()+"\n"
                        +"Details Message :\n "
                        + readData.readUTF()+"\n \n"
                        +"Next Job Request :\n";
                    JobReceived.appendText(job);
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
