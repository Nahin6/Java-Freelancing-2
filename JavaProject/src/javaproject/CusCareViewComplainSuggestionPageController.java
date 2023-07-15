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
public class CusCareViewComplainSuggestionPageController implements Initializable {

    @FXML
    private TextArea CustomerCoplainBoxFxId;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                                          CustomerCoplainBoxFxId.setText("");
        File f = null;
        FileInputStream readFile = null;
        DataInputStream readData = null;
        String ComplainSuggestion="";
        try {
            f = new File("ComplainSuggestion.bin");
            if(!f.exists()){
                CustomerCoplainBoxFxId.setText("No new Information from Customer care ");
            }
            else{
                
                readFile = new FileInputStream(f);

                readData = new DataInputStream(readFile);
             
                while(true){
               
               ComplainSuggestion = 
                      
                       "Customer username :  "
                        + readData.readUTF()+"\n"
                        +"given ratings : "
                        + readData.readUTF()+"\n"+
                         "Complain/Suggestion got: \n"+readData.readUTF().concat(ComplainSuggestion)+"\n \n"
                        +"Next Day :\n";
               
               
                    CustomerCoplainBoxFxId.appendText(ComplainSuggestion);
                }
            }
        } catch (IOException ex) {
           
            Logger.getLogger(CusCareViewComplainSuggestionPageController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(readData != null) readData.close();
            } catch (IOException ex) {
                Logger.getLogger(ManagerReceiveInfoFromCustomerCarePageController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }    
    
}
