/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproject;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
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

/**
 * FXML Controller class
 *
 * @author Acer
 */
public class CustomerHIreFreelancerPageController implements Initializable {

    @FXML
    private TextArea SeeFreeLancerPostTxtArea;
    @FXML
    private TextField NameFxid;
    @FXML
    private TextField IDFxid;
    @FXML
    private TextField DesiredCatagroyFxid;
    @FXML
    private TextArea LeaveMsgForFreelancerTxtArea;
    @FXML
    private Label RequestConfirmationLabel;
    @FXML
    private TextField DesiredWorkFxid1;
    @FXML
    private TextField FreelancerName;

 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                        SeeFreeLancerPostTxtArea.setText("");
        File f = null;
        FileInputStream readFile = null;
        DataInputStream readData = null;
        String Service="";
        try {
            f = new File("PostADD.bin");
            if(!f.exists()){
                SeeFreeLancerPostTxtArea.setText("No new Post ");
            }
            else{
                
                readFile = new FileInputStream(f);

                readData = new DataInputStream(readFile);
             
                while(true){
               
               Service = 
                        "Hello iam: "+readData.readUTF()+"\n"
                        +"My Expertise is :  "
                        + readData.readUTF()+"\n"
                         +"I can do : "
                        + readData.readUTF()+"\n"
                         +"Details about me :\n "
                        + readData.readUTF()+"\n \n"
                        +"Next Post :\n";
                    SeeFreeLancerPostTxtArea.appendText(Service);
                }
            }
        } catch (IOException ex) {
           
            Logger.getLogger(CustomerBrowseWorkFromCompanyPageController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(readData != null) readData.close();
            } catch (IOException ex) {
                Logger.getLogger(CustomerBrowseWorkFromCompanyPageController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }    

    @FXML
    private void SendJobRequestButtonClick(ActionEvent event) {
        
                             File f = null;
        FileOutputStream wirteFile = null;
        DataOutputStream writeData = null;
        
        try {
            f = new File("HireFreelancer.bin");
            if(f.exists()) wirteFile = new FileOutputStream(f,true);
            else wirteFile = new FileOutputStream(f);
            writeData = new DataOutputStream(wirteFile);
           
            writeData.writeUTF(NameFxid.getText());
            writeData.writeUTF(IDFxid.getText());
              writeData.writeUTF(FreelancerName.getText());
            writeData.writeUTF(DesiredCatagroyFxid.getText());
                 writeData.writeUTF(DesiredWorkFxid1.getText());
            writeData.writeUTF(LeaveMsgForFreelancerTxtArea.getText());
            
            
        NameFxid.setText(null);  IDFxid.setText(null);
         FreelancerName.setText(null);  DesiredCatagroyFxid.setText(null); 
         DesiredWorkFxid1.setText(null);  LeaveMsgForFreelancerTxtArea.setText(null);
        } catch (IOException ex) {
            Logger.getLogger(CustomerBrowseWorkFromCompanyPageController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(writeData != null) writeData.close();
            } catch (IOException ex) {
                Logger.getLogger(CustomerBrowseWorkFromCompanyPageController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        
        RequestConfirmationLabel.setText(" Sent Successfully!!");
    }
    
}
