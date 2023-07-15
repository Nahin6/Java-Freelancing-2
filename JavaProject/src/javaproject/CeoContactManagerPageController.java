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
public class CeoContactManagerPageController implements Initializable {

    @FXML
    private TextField QuerySubject;
    @FXML
    private TextArea DetailsMessage;
    @FXML
    private Text ConfirmMessage;
    @FXML
    private TextArea ManagerReply;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
                
                ManagerReply.setText("");
        File f = null;
        FileInputStream readFile = null;
        DataInputStream readData = null;
        String ManagerMessage="";
        try {
            f = new File("ContactManager.bin");
            if(!f.exists()){
                ManagerReply.setText("No new Application received ");
            }
            else{
                
                readFile = new FileInputStream(f);

                readData = new DataInputStream(readFile);
             
                while(true){
               
               ManagerMessage = 
                        "Reply Subject: "+readData.readUTF()+"\n"
                        +"Details Messages :\n "
                        + readData.readUTF()+"\n \n"
                        +"Next Message/Query :\n";
                    ManagerReply.appendText(ManagerMessage);
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
    private void SendMessageToManagerButton(ActionEvent event) {
        
              
        File f = null;
        FileOutputStream wirteFile = null;
        DataOutputStream writeData = null;
        
        try {
            f = new File("ContactManager.bin");
            if(f.exists()) wirteFile = new FileOutputStream(f,true);
            else wirteFile = new FileOutputStream(f);
            writeData = new DataOutputStream(wirteFile);
           
            writeData.writeUTF(QuerySubject.getText());
            writeData.writeUTF(DetailsMessage.getText());
            
            
        QuerySubject.setText(null);   DetailsMessage.setText(null);
        } catch (IOException ex) {
            Logger.getLogger(CeoGiveAnnouncementPageController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(writeData != null) writeData.close();
            } catch (IOException ex) {
                Logger.getLogger(CeoGiveAnnouncementPageController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        
        ConfirmMessage.setText("Message has been sent!!");
    }
    
}
