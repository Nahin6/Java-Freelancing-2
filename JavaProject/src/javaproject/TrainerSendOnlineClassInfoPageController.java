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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Acer
 */
public class TrainerSendOnlineClassInfoPageController implements Initializable {

    @FXML
    private TextArea ClassLink;
    @FXML
    private Text Conrfirm;
    @FXML
    private DatePicker Date;
    @FXML
    private TextField Topic;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void PostLinkToSutdentButton(ActionEvent event) {
                                        
        File f = null;
        FileOutputStream wirteFile = null;
        DataOutputStream writeData = null;
        
        try {
            f = new File("OnlineClass.bin");
            if(f.exists()) wirteFile = new FileOutputStream(f,true);
            else wirteFile = new FileOutputStream(f);
            writeData = new DataOutputStream(wirteFile);
            
              
             
               writeData.writeUTF(Date.getValue().toString());
               writeData.writeUTF(Topic.getText());
               writeData.writeUTF(ClassLink.getText());
  
        
              
   
            
 
         Date.setValue(null); ClassLink.setText(null);  Topic.setText(null); 
    
        } catch (IOException ex) {
            Logger.getLogger(TrainerSendOnlineClassInfoPageController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(writeData != null) writeData.close();
            } catch (IOException ex) {
                Logger.getLogger(TrainerSendOnlineClassInfoPageController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        
        Conrfirm.setText("Posted  Successfully!!");
    }
    
}
