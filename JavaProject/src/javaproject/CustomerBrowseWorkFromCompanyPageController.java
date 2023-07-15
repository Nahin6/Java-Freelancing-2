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
public class CustomerBrowseWorkFromCompanyPageController implements Initializable {

    @FXML
    private TextArea ViewServices;
    @FXML
    private TextField NameFx;
    @FXML
    private TextField NumberFx;
    @FXML
    private TextField EmailFx;
    @FXML
    private TextField Service;
    @FXML
    private TextArea DetailMessage;
    @FXML
    private Text ConfirmMessage;

   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        

                ViewServices.setText("");
        File f = null;
        FileInputStream readFile = null;
        DataInputStream readData = null;
        String Service="";
        try {
            f = new File("PostService.bin");
            if(!f.exists()){
                ViewServices.setText("No new Post ");
            }
            else{
                
                readFile = new FileInputStream(f);

                readData = new DataInputStream(readFile);
             
                while(true){
               
               Service = 
                        "Offered Service: "+readData.readUTF()+"\n"
                        +"Details about the service :\n "
                        + readData.readUTF()+"\n \n"
                        +"Next Post :\n";
                    ViewServices.appendText(Service);
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
    private void SendOfferButton(ActionEvent event) {
        
               File f = null;
        FileOutputStream wirteFile = null;
        DataOutputStream writeData = null;
        
        try {
            f = new File("SentOffer.bin");
            if(f.exists()) wirteFile = new FileOutputStream(f,true);
            else wirteFile = new FileOutputStream(f);
            
            writeData = new DataOutputStream(wirteFile);
           
            writeData.writeUTF(NameFx.getText());
            writeData.writeUTF(NumberFx.getText());
            writeData.writeUTF(EmailFx.getText());
            writeData.writeUTF(Service.getText());
            writeData.writeUTF(DetailMessage.getText());
            
            
        NameFx.setText(null);  NumberFx.setText(null);  
        EmailFx.setText(null);  Service.setText(null);DetailMessage.setText(null);
        } catch (IOException ex) {
            Logger.getLogger(CustomerBrowseWorkFromCompanyPageController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(writeData != null) writeData.close();
            } catch (IOException ex) {
                Logger.getLogger(CustomerBrowseWorkFromCompanyPageController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        
        ConfirmMessage.setText(" Sent Successfully!!");
    }
    
}
