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
public class CusCareViewFreelancerQueryPageController implements Initializable {

    @FXML
    private TextArea FreelancerProblems;
    @FXML
    private TextField FreelancerID;
    @FXML
    private TextArea DescribeSolutionToFreelancer;
    @FXML
    private Text Conrfirm;

 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
                                             FreelancerProblems.setText("");
        File f = null;
        FileInputStream readFile = null;
        DataInputStream readData = null;
        String FreelancerProblem="";
        try {
            f = new File("FreelancerContactCusCare.bin");
            if(!f.exists()){
                FreelancerProblems.setText("No new Queries ");
            }
            else{
                
                readFile = new FileInputStream(f);

                readData = new DataInputStream(readFile);
             
                while(true){
               
               FreelancerProblem = 
                      
                       "Freelancer Name:  "
                        + readData.readUTF()+"\n"
                        +"Freelancer ID: "
                        + readData.readUTF()+"\n"+
                         "Problems faced: \n"+readData.readUTF()+"\n \n"
                        +"Next Query :\n";
               
               
                    FreelancerProblems.appendText(FreelancerProblem);
                }
            }
        } catch (IOException ex) {
           
            Logger.getLogger(CusCareViewFreelancerQueryPageController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(readData != null) readData.close();
            } catch (IOException ex) {
                Logger.getLogger(CusCareViewFreelancerQueryPageController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
       
    }    

    @FXML
    private void SendReplyToCustomereButton(ActionEvent event) {
                File f = null;
        FileOutputStream wirteFile = null;
        DataOutputStream writeData = null;
        
        try {
            f = new File("CusCareContactFreelancer.bin");
            if(f.exists()) wirteFile = new FileOutputStream(f,true);
            else wirteFile = new FileOutputStream(f);
            writeData = new DataOutputStream(wirteFile);
            
              
             
               writeData.writeUTF(FreelancerID.getText());
               writeData.writeUTF(DescribeSolutionToFreelancer.getText());
          
              
   
            
 
         FreelancerID.setText(null); DescribeSolutionToFreelancer.setText(null); 
    
        } catch (IOException ex) {
            Logger.getLogger(CusCareViewFreelancerQueryPageController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(writeData != null) writeData.close();
            } catch (IOException ex) {
                Logger.getLogger(CusCareViewFreelancerQueryPageController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        
        Conrfirm.setText("sent  Successfully!!");
        
    }
    
}
