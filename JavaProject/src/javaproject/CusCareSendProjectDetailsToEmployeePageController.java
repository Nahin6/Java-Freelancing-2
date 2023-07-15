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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Acer
 */
public class CusCareSendProjectDetailsToEmployeePageController implements Initializable {

    @FXML
    private TextField username;
    @FXML
    private TextField orderId;
    @FXML
    private TextArea DetailMessage;
    @FXML
    private TextField ProblemSubject;
    @FXML
    private Label confrimLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void SendProjectDFetailsToEmployeeButton(ActionEvent event) {
        
                        
        File f = null;
        FileOutputStream wirteFile = null;
        DataOutputStream writeData = null;
        
        try {
            f = new File("ProjectDetails.bin");
            if(f.exists()) wirteFile = new FileOutputStream(f,true);
            else wirteFile = new FileOutputStream(f);
            writeData = new DataOutputStream(wirteFile);
            
              
             
               writeData.writeUTF(username.getText());
               writeData.writeUTF(orderId.getText());
              writeData.writeUTF(ProblemSubject.getText());
               writeData.writeUTF(DetailMessage.getText());
              
   
            
 
         username.setText(null); orderId.setText(null); 
         ProblemSubject.setText(null); DetailMessage.setText(null); 
        } catch (IOException ex) {
            Logger.getLogger(CusCareSendProjectDetailsToEmployeePageController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(writeData != null) writeData.close();
            } catch (IOException ex) {
                Logger.getLogger(CusCareSendProjectDetailsToEmployeePageController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        
        confrimLabel.setText("sent  Successfully!!");
    }
    
}
