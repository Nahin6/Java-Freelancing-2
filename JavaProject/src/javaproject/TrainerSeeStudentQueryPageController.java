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
public class TrainerSeeStudentQueryPageController implements Initializable {

    @FXML
    private TextArea StudentProblems;
    @FXML
    private TextField StudName;
    @FXML
    private TextArea DescribeSolution;
    @FXML
    private Text Conrfirm;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                
                                                     StudentProblems.setText("");
        File f = null;
        FileInputStream readFile = null;
        DataInputStream readData = null;
        String prb="";
        try {
            f = new File("StudToTrainer.bin");
            if(!f.exists()){
                StudentProblems.setText("No new Replies from Customer Care ");
            }
            else{
                
                readFile = new FileInputStream(f);

                readData = new DataInputStream(readFile);
             
                while(true){
               
               prb = 
                      
                       "Student Name:  "
                        + readData.readUTF()+"\n"+
                         "Student ID:  "
                        + readData.readUTF()+"\n"+
                         "Problem got in:  "
                        + readData.readUTF()+"\n"+
                         "Problems Details: \n"+readData.readUTF()+"\n \n"
                        +"Next:\n";
               
               
                    StudentProblems.appendText(prb);
                }
            }
        } catch (IOException ex) {
           
            Logger.getLogger(TrainerSeeStudentQueryPageController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(readData != null) readData.close();
            } catch (IOException ex) {
                Logger.getLogger(TrainerSeeStudentQueryPageController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }    

    @FXML
    private void SendReplyToStudentButton(ActionEvent event) {
        
                File f = null;
        FileOutputStream wirteFile = null;
        DataOutputStream writeData = null;
        
        try {
            f = new File("ReplyToStudent.bin");
            if(f.exists()) wirteFile = new FileOutputStream(f,true);
            else wirteFile = new FileOutputStream(f);
            writeData = new DataOutputStream(wirteFile);
            
              
             
               writeData.writeUTF(StudName.getText());
               writeData.writeUTF(DescribeSolution.getText());
            
          
              
   
            
 
         StudName.setText(null); DescribeSolution.setText(null); 
     
        } catch (IOException ex) {
            Logger.getLogger(TrainerSeeStudentQueryPageController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(writeData != null) writeData.close();
            } catch (IOException ex) {
                Logger.getLogger(TrainerSeeStudentQueryPageController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        
        Conrfirm.setText("sent  Successfully!!");
    }
    
}
