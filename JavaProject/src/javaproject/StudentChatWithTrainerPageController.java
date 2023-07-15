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
public class StudentChatWithTrainerPageController implements Initializable {

    @FXML
    private TextField Name;
    @FXML
    private TextField StudID;
    @FXML
    private TextArea DetailMessage;
    @FXML
    private Label Confirm;
    @FXML
    private TextField TopicOfProblem;
    @FXML
    private TextArea Replies;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
                      
                                                     Replies.setText("");
        File f = null;
        FileInputStream readFile = null;
        DataInputStream readData = null;
        String TrainerReply="";
        try {
            f = new File("ReplyToStudent.bin");
            if(!f.exists()){
                Replies.setText("No new Replies from Customer Care ");
            }
            else{
                
                readFile = new FileInputStream(f);

                readData = new DataInputStream(readFile);
             
                while(true){
               
               TrainerReply = 
                      
                      
                         "Hello :  "
                        + readData.readUTF()+"\n"+
                         "Here is your Problems solution: \n"+readData.readUTF()+"\n \n"
                        +"Next:\n";
               
               
                    Replies.appendText(TrainerReply);
                }
            }
        } catch (IOException ex) {
           
            Logger.getLogger(StudentChatWithTrainerPageController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(readData != null) readData.close();
            } catch (IOException ex) {
                Logger.getLogger(StudentChatWithTrainerPageController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
    }    

    @FXML
    private void SendMessageToTrainerButton(ActionEvent event) {
        
                                              
        File f = null;
        FileOutputStream wirteFile = null;
        DataOutputStream writeData = null;
        
        try {
            f = new File("StudToTrainer.bin");
            if(f.exists()) wirteFile = new FileOutputStream(f,true);
            else wirteFile = new FileOutputStream(f);
            writeData = new DataOutputStream(wirteFile);
            
              
             
               writeData.writeUTF(Name.getText());
               writeData.writeUTF(StudID.getText());
               writeData.writeUTF(TopicOfProblem.getText());
               writeData.writeUTF(DetailMessage.getText());
                  
              
   
            
 
         Name.setText(null); StudID.setText(null); 
         DetailMessage.setText(null);  TopicOfProblem.setText(null); 
        } catch (IOException ex) {
            Logger.getLogger(StudentChatWithTrainerPageController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(writeData != null) writeData.close();
            } catch (IOException ex) {
                Logger.getLogger(StudentChatWithTrainerPageController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        
        Confirm.setText("sent  Successfully!!");
    }
    
}
