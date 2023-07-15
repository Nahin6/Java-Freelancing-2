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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Acer
 */
public class CustomerComplainSuggestionPageController implements Initializable {

    @FXML
    private TextArea CustomerCoplainBox;
    @FXML
    private TextField CustomerUserName;
    @FXML
    private ComboBox RatingComboBox;
    @FXML
    private Label ConfirmLabel;

  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            RatingComboBox.getItems().addAll("1 Star","2 Star","3 Star",
                 "4 Star","5 Star");
        RatingComboBox.setValue("Ratings");
    }    

    @FXML
    private void SendCompainSuggestionButton(ActionEvent event) {
        
                
        File f = null;
        FileOutputStream wirteFile = null;
        DataOutputStream writeData = null;
        
        try {
            f = new File("ComplainSuggestion.bin");
            if(f.exists()) wirteFile = new FileOutputStream(f,true);
            else wirteFile = new FileOutputStream(f);
            writeData = new DataOutputStream(wirteFile);
            
              
             
               writeData.writeUTF(CustomerUserName.getText());
               writeData.writeUTF(RatingComboBox.getValue().toString());
               writeData.writeUTF(CustomerCoplainBox.getText());
            
              
   
            
         RatingComboBox.setValue(null);
         CustomerUserName.setText(null); 
         CustomerCoplainBox.setText(null); 
        } catch (IOException ex) {
            Logger.getLogger(CusCareSendUpdateToManagerPageController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(writeData != null) writeData.close();
            } catch (IOException ex) {
                Logger.getLogger(CusCareSendUpdateToManagerPageController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        
        ConfirmLabel.setText("sent  Successfully!!");
    }
    
}
