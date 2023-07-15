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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class StudentContactWithCeoController implements Initializable {

    @FXML
    private TextField id;
    @FXML
    private TextField name;
    @FXML
    private TextField subject;
    @FXML
    private DatePicker Date;
    @FXML
    private TextArea message;
    @FXML
    private Label Confirmation;

 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
   
    }    

    @FXML
    private void SendButton(ActionEvent event) {
               File f = null;
        FileOutputStream wirteFile = null;
        DataOutputStream writeData = null;
        
        try {
            f = new File("maidul.bin");
            if(f.exists()) wirteFile = new FileOutputStream(f,true);
            else wirteFile = new FileOutputStream(f);
            writeData = new DataOutputStream(wirteFile);
            
              
               writeData.writeUTF(id.getText());
               writeData.writeUTF(name.getText());
                writeData.writeUTF(subject.getText());
               writeData.writeUTF(Date.getValue().toString());
               writeData.writeUTF(message.getText());
  
        
              
   
            
 
         Date.setValue(null); id.setText(null);  name.setText(null); subject.setText(null); message.setText(null); 
    
        } catch (IOException ex) {
            Logger.getLogger(StudentContactWithCeoController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(writeData != null) writeData.close();
            } catch (IOException ex) {
                Logger.getLogger(StudentContactWithCeoController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        
   
        Confirmation.setText("Message Send Successfully");
    }
    
}
