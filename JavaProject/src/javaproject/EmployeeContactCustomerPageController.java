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
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Acer
 */
public class EmployeeContactCustomerPageController implements Initializable {

    @FXML
    private TextArea MessageToCustomer;
    @FXML
    private Text Conrfirm;
    @FXML
    private TextArea CustomerMessages;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                       

                CustomerMessages.setText("");
        File f = null;
        FileInputStream readFile = null;
        DataInputStream readData = null;
        String Concern="";
        try {
            f = new File("EmpContact.bin");
            if(!f.exists()){
                CustomerMessages.setText("No new Customer Messages ");
            }
            else{
                
                readFile = new FileInputStream(f);

                readData = new DataInputStream(readFile);
             
                while(true){
               
               Concern = 
                    
                        "Customer Name: "+readData.readUTF()+"\n"
                        + "Order ID: "+readData.readUTF()+"\n"
                        +"Details Message :\n "
                        + readData.readUTF()+"\n \n"
                        +"Next Received Concern:\n";
                    CustomerMessages.appendText(Concern);
                }
            }
        } catch (IOException ex) {
           
            Logger.getLogger(EmployeeContactCustomerPageController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(readData != null) readData.close();
            } catch (IOException ex) {
                Logger.getLogger(EmployeeContactCustomerPageController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }    

    @FXML
    private void SendMessageToCustomerButton(ActionEvent event) {
        File f = null;
        FileOutputStream wirteFile = null;
        DataOutputStream writeData = null;
        
        try {
            f = new File("CusContact.bin");
            if(f.exists()) wirteFile = new FileOutputStream(f,true);
            else wirteFile = new FileOutputStream(f);
            writeData = new DataOutputStream(wirteFile);
           

                writeData.writeUTF(MessageToCustomer.getText());
            
            
     
        MessageToCustomer.setText(null);  
        } catch (IOException ex) {
            Logger.getLogger(EmployeeContactCustomerPageController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(writeData != null) writeData.close();
            } catch (IOException ex) {
                Logger.getLogger(EmployeeContactCustomerPageController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        
        Conrfirm.setText(" Sent Successfully!!");
    }
    
}
