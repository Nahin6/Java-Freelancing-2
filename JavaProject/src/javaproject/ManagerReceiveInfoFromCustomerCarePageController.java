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
public class ManagerReceiveInfoFromCustomerCarePageController implements Initializable {

    @FXML
    private TextArea CusCareInfo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                                     CusCareInfo.setText("");
        File f = null;
        FileInputStream readFile = null;
        DataInputStream readData = null;
        String ReceiveInfo="";
        try {
            f = new File("CusCareToManager.bin");
            if(!f.exists()){
                CusCareInfo.setText("No new Information from Customer care ");
            }
            else{
                
                readFile = new FileInputStream(f);

                readData = new DataInputStream(readFile);
             
                while(true){
               
               ReceiveInfo = 
                      
                       "Today's Date:  "
                        + readData.readUTF()+"\n"
                        +"Total Complain got: "
                        + readData.readUTF()+"\n"+
                         "Problem solved: "+readData.readUTF().concat(ReceiveInfo)+"\n \n"
                        +"Next Day :\n";
               
               
                    CusCareInfo.appendText(ReceiveInfo);
                }
            }
        } catch (IOException ex) {
           
            Logger.getLogger(ManagerReceiveInfoFromCustomerCarePageController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(readData != null) readData.close();
            } catch (IOException ex) {
                Logger.getLogger(CusCareViewComplainSuggestionPageController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }    
    
}
