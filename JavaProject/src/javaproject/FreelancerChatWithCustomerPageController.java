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


public class FreelancerChatWithCustomerPageController implements Initializable {

    @FXML
    private TextField Name;
    @FXML
    private TextField id;
    @FXML
    private TextArea problem;
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
        String solution="";
        try {
            f = new File("CusCareContactFreelancer.bin");
            if(!f.exists()){
                CusCareReply.setText("No new Replies from Customer Care ");
            }
            else{
                
                readFile = new FileInputStream(f);

                readData = new DataInputStream(readFile);
             
                while(true){
               
               solution = 
                      
                       "Freelancer ID:  "
                        + readData.readUTF()+"\n"+
                         "Your Solution in Details: \n"+readData.readUTF()+"\n \n"
                        +"Next:\n";
               
               
                    CusCareReply.appendText(solution);
                }
            }
        } catch (IOException ex) {
           
            Logger.getLogger(FreelancerChatWithCustomerPageController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(readData != null) readData.close();
            } catch (IOException ex) {
                Logger.getLogger(FreelancerChatWithCustomerPageController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
       
    }    

    @FXML
    private void SendMessageToCusCareButton(ActionEvent event) {
        
                                
        File f = null;
        FileOutputStream wirteFile = null;
        DataOutputStream writeData = null;
        
        try {
            f = new File("FreelancerContactCusCare.bin");
            if(f.exists()) wirteFile = new FileOutputStream(f,true);
            else wirteFile = new FileOutputStream(f);
            writeData = new DataOutputStream(wirteFile);
            
              
             
               writeData.writeUTF(Name.getText());
               writeData.writeUTF(id.getText());
               writeData.writeUTF(problem.getText());
          
              
   
            
 
         Name.setText(null); id.setText(null); 
         problem.setText(null); 
        } catch (IOException ex) {
            Logger.getLogger(FreelancerChatWithCustomerPageController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(writeData != null) writeData.close();
            } catch (IOException ex) {
                Logger.getLogger(FreelancerChatWithCustomerPageController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        
        Conrfirm.setText("sent  Successfully!!");
    }
    
}
