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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class TrainerUploadResultPageController implements Initializable {

    @FXML
    private TextField StudName;
    @FXML
    private TextField StudID;
    @FXML
    private TextField Subject;
    @FXML
    private TextField Marks;
    @FXML
    private Label Conrfirm;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
    }    

    @FXML
    private void UploadResultButton(ActionEvent event) {
        
                
                File f = null;
        FileOutputStream wirteFile = null;
        DataOutputStream writeData = null;
        
        try {
            f = new File("UploadResult.bin");
            if(f.exists()) wirteFile = new FileOutputStream(f,true);
            else wirteFile = new FileOutputStream(f);
            writeData = new DataOutputStream(wirteFile);
            
              
             
               writeData.writeUTF(StudName.getText());
               writeData.writeUTF(StudID.getText());
               writeData.writeUTF(Subject.getText());
               writeData.writeUTF(Marks.getText());
          
              
   
            
 
         StudName.setText(null); StudID.setText(null); 
         Subject.setText(null); Marks.setText(null); 
        } catch (IOException ex) {
            Logger.getLogger(TrainerUploadResultPageController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(writeData != null) writeData.close();
            } catch (IOException ex) {
                Logger.getLogger(TrainerUploadResultPageController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        
        Conrfirm.setText("Uploaded  Successfully!!");
    }
    
}
