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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Acer
 */
public class FreelancerPostAddPageController implements Initializable {

    @FXML
    private TextField ServiceCatagroy;
    @FXML
    private TextArea DetailAboutYourSkill;
    @FXML
    private Text ConfirmMessage;
    @FXML
    private TextField FreelancerName;
    @FXML
    private TextField JobSkill;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void PostAddButton(ActionEvent event) {
        
                     File f = null;
        FileOutputStream wirteFile = null;
        DataOutputStream writeData = null;
        
        try {
            f = new File("PostADD.bin");
            if(f.exists()) wirteFile = new FileOutputStream(f,true);
            else wirteFile = new FileOutputStream(f);
            writeData = new DataOutputStream(wirteFile);
           
            writeData.writeUTF(FreelancerName.getText());
            writeData.writeUTF(ServiceCatagroy.getText());
              writeData.writeUTF(JobSkill.getText());
            writeData.writeUTF(DetailAboutYourSkill.getText());
            
            
        ServiceCatagroy.setText(null);  DetailAboutYourSkill.setText(null);
         FreelancerName.setText(null);  JobSkill.setText(null);
        } catch (IOException ex) {
            Logger.getLogger(FreelancerPostAddPageController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(writeData != null) writeData.close();
            } catch (IOException ex) {
                Logger.getLogger(FreelancerPostAddPageController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        
        ConfirmMessage.setText(" posted Successfully!!");
    }
    
}
