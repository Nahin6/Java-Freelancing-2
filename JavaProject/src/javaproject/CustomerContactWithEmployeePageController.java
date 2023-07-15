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
public class CustomerContactWithEmployeePageController implements Initializable {

    @FXML
    private TextField Name;
    @FXML
    private TextField orderId;
    @FXML
    private TextArea DetailMessage;
    @FXML
    private Text Conrfirm;
    @FXML
    private TextArea EmployeeMessages;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         EmployeeMessages.setText("");
        File f = null;
        FileInputStream readFile = null;
        DataInputStream readData = null;
        String mm="";
        try {
            f = new File("CusContact.bin");
            if(!f.exists()){
                EmployeeMessages.setText("No new  Messages ");
            }
            else{
                
                readFile = new FileInputStream(f);

                readData = new DataInputStream(readFile);
             
                while(true){
               
               mm = 
                    
                       
                        "Employee's Reply :\n "
                        + readData.readUTF()+" \n\n"
                        +"Next Reply:\n\n";
                    EmployeeMessages.appendText(mm);
                }
            }
        } catch (IOException ex) {
           
            Logger.getLogger(CustomerContactWithEmployeePageController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(readData != null) readData.close();
            } catch (IOException ex) {
                Logger.getLogger(CustomerContactWithEmployeePageController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
      
    }    

    @FXML
    private void SendMessageToEmployeeButton(ActionEvent event) {
        
        File f = null;
        FileOutputStream wirteFile = null;
        DataOutputStream writeData = null;
        
        try {
            f = new File("EmpContact.bin");
            if(f.exists()) wirteFile = new FileOutputStream(f,true);
            else wirteFile = new FileOutputStream(f);
            writeData = new DataOutputStream(wirteFile);
           

                writeData.writeUTF(Name.getText());
            writeData.writeUTF(orderId.getText());
                writeData.writeUTF(DetailMessage.getText());
            
            
     
        Name.setText(null);  orderId.setText(null);DetailMessage.setText(null);
        } catch (IOException ex) {
            Logger.getLogger(CustomerContactWithEmployeePageController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(writeData != null) writeData.close();
            } catch (IOException ex) {
                Logger.getLogger(CustomerContactWithEmployeePageController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        
        Conrfirm.setText(" Sent Successfully!!");
    }
    
}
