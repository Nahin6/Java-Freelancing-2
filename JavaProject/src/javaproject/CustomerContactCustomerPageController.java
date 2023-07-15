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
import
        javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Acer
 */
public class CustomerContactCustomerPageController implements Initializable {

    @FXML
    private TextField Name;
    @FXML
    private TextField Username;
    @FXML
    private TextArea DetailMessageToCusCare;
    @FXML
    private Text Conrfirm;
    @FXML
    private TextArea CusCareReply;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
                
                                CusCareReply.setText("");
        File f = null;
        FileInputStream readFile = null;
        DataInputStream readData = null;
        String Service="";
        try {
            f = new File("CusCareReply.bin");
            if(!f.exists()){
                CusCareReply.setText("No new Reply ");
            }
            else{
                
                readFile = new FileInputStream(f);

                readData = new DataInputStream(readFile);
             
                while(true){
               
               Service = 
                        "Hello: "+readData.readUTF()+"\n"
                         +"Here are some suggestion about your problems : "+"\n"
                        + readData.readUTF()+"\n \n"
                        +"Next Post :\n";
                    CusCareReply.appendText(Service);
                }
            }
        } catch (IOException ex) {
           
            Logger.getLogger(CusCareReplyToCustomerPageController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(readData != null) readData.close();
            } catch (IOException ex) {
                Logger.getLogger(CusCareReplyToCustomerPageController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
       
    }    

    @FXML
    private void SendMessageToCsutomerCareButton(ActionEvent event) {
        
                                     File f = null;
        FileOutputStream wirteFile = null;
        DataOutputStream writeData = null;
        
        try {
            f = new File("ContactCusCare.bin");
            if(f.exists()) wirteFile = new FileOutputStream(f,true);
            else wirteFile = new FileOutputStream(f);
            writeData = new DataOutputStream(wirteFile);
           
        
               writeData.writeUTF(Name.getText());
               writeData.writeUTF(Username.getText());
               writeData.writeUTF(DetailMessageToCusCare.getText());
   
            
            
         Name.setText(null); 
         Username.setText(null);  DetailMessageToCusCare.setText(null);
        } catch (IOException ex) {
            Logger.getLogger(CustomerContactCustomerPageController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(writeData != null) writeData.close();
            } catch (IOException ex) {
                Logger.getLogger(CustomerContactCustomerPageController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        
        Conrfirm.setText(" Sent Successfully!!");
    }
    
}
