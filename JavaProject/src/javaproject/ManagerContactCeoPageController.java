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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Acer
 */
public class ManagerContactCeoPageController implements Initializable {

    @FXML
    private TextField ManagersSubject;
    @FXML
    private TextArea ManagersDetailsMessage;
    @FXML
    private TextArea CeoMessages;
    @FXML
    private Text Confirmation;

  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
                CeoMessages.setText("");
        File f = null;
        FileInputStream readFile = null;
        DataInputStream readData = null;
        String CeoMessage="";
        try {
            f = new File("ContactManager.bin");
            if(!f.exists()){
                CeoMessages.setText("No new Application received ");
            }
            else{
                
                readFile = new FileInputStream(f);

                readData = new DataInputStream(readFile);
             
                while(true){
               
               CeoMessage = 
                        "Subject: "+readData.readUTF()+"\n"
                        +"Details Messages :\n "
                        + readData.readUTF()+"\n \n"
                        +"Next Message/Query :\n";
                    CeoMessages.appendText(CeoMessage);
                }
            }
        } catch (IOException ex) {
           
            Logger.getLogger(ManagerContactCeoPageController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(readData != null) readData.close();
            } catch (IOException ex) {
                Logger.getLogger(ManagerContactCeoPageController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
       
    }    

    @FXML
    private void SendMessageToCeoButton(ActionEvent event) {
        
                File f = null;
        FileOutputStream wirteFile = null;
        DataOutputStream writeData = null;
        
        try {
            f = new File("ContactCeo.bin");
            if(f.exists()) wirteFile = new FileOutputStream(f,true);
            else wirteFile = new FileOutputStream(f);
            writeData = new DataOutputStream(wirteFile);
           
            writeData.writeUTF(ManagersSubject.getText());
            writeData.writeUTF(ManagersDetailsMessage.getText());
            
            
        ManagersSubject.setText(null);   ManagersSubject.setText(null);
        } catch (IOException ex) {
            Logger.getLogger(ManagerContactCeoPageController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(writeData != null) writeData.close();
            } catch (IOException ex) {
                Logger.getLogger(ManagerContactCeoPageController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        
        Confirmation.setText("Message has been sent!!");
    }
    
}
