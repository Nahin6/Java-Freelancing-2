/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproject;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Acer
 */
public class CusCareSendUpdateToManagerPageController implements Initializable {
    @FXML
    private DatePicker Date;
    @FXML
    private TextField ComplainGot;
    @FXML
    private TextField ProblemSolved;
    @FXML
    private Label ConfirmLabel;
 

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void SendInfoToManagerButton(ActionEvent event) {
        
        File f = null;
        FileOutputStream wirteFile = null;
        DataOutputStream writeData = null;
        
        try {
            f = new File("CusCareToManager.bin");
            if(f.exists()) wirteFile = new FileOutputStream(f,true);
            else wirteFile = new FileOutputStream(f);
            writeData = new DataOutputStream(wirteFile);
            
              
               writeData.writeUTF(Date.getValue().toString());
               writeData.writeUTF(ComplainGot.getText());
               writeData.writeUTF(ProblemSolved.getText());
            
              
   
            
         Date.setValue(null);
         ComplainGot.setText(null); 
         ComplainGot.setText(null); 
        } catch (IOException ex) {
            Logger.getLogger(CusCareSendUpdateToManagerPageController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(writeData != null) writeData.close();
            } catch (IOException ex) {
                Logger.getLogger(CusCareSendUpdateToManagerPageController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        
        ConfirmLabel.setText(" Information sent  Successfully!!");
    }
    
}
