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
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Acer
 */
public class EmployeePostAvailableServicesforCustomerPageController implements Initializable {

    @FXML
    private TextField ServiceCatagroy;
    @FXML
    private TextArea DetailAboutService;
    @FXML
    private Text ConfirmMessage;

   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void PostAvailableServiceButton(ActionEvent event) {
        
              File f = null;
        FileOutputStream wirteFile = null;
        DataOutputStream writeData = null;
        
        try {
            f = new File("PostService.bin");
            if(f.exists()) wirteFile = new FileOutputStream(f,true);
            else wirteFile = new FileOutputStream(f);
            writeData = new DataOutputStream(wirteFile);
           
            writeData.writeUTF(ServiceCatagroy.getText());
            writeData.writeUTF(DetailAboutService.getText());
            
            
        ServiceCatagroy.setText(null);  DetailAboutService.setText(null);
        } catch (IOException ex) {
            Logger.getLogger(CeoGiveAnnouncementPageController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(writeData != null) writeData.close();
            } catch (IOException ex) {
                Logger.getLogger(EmployeePostAvailableServicesforCustomerPageController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        
        ConfirmMessage.setText(" posted Successfully!!");
    }
    
}
