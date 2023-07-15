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
public class CusCareReplyToCustomerPageController implements Initializable {

    @FXML
    private TextArea CustomerProblems;
    @FXML
    private TextField CusUsername;
    @FXML
    private TextArea DescribeSolution;
    @FXML
    private Text Conrfirm;

   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
                                CustomerProblems.setText("");
        File f = null;
        FileInputStream readFile = null;
        DataInputStream readData = null;
        String Service="";
        try {
            f = new File("ContactCusCare.bin");
            if(!f.exists()){
                CustomerProblems.setText("No new Query from customer ");
            }
            else{
                
                readFile = new FileInputStream(f);

                readData = new DataInputStream(readFile);
             
                while(true){
               
               Service = 
                        "Customer Name: "+readData.readUTF()+"\n"
                        +"Customer USerame :  "
                        + readData.readUTF()+"\n"
                         +"Details Messages : "+"\n"
                        + readData.readUTF()+"\n \n"
                        +"Next Post :\n";
                    CustomerProblems.appendText(Service);
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
    private void SendReplyToCustomereButton(ActionEvent event) {
        
                                             File f = null;
        FileOutputStream wirteFile = null;
        DataOutputStream writeData = null;
        
        try {
            f = new File("CusCareReply.bin");
            if(f.exists()) wirteFile = new FileOutputStream(f,true);
            else wirteFile = new FileOutputStream(f);
            writeData = new DataOutputStream(wirteFile);
           
              writeData.writeUTF(CusUsername.getText());
               writeData.writeUTF(DescribeSolution.getText());
            
              
   
            
            
         CusUsername.setText(null); 
         DescribeSolution.setText(null); 
        } catch (IOException ex) {
            Logger.getLogger(CusCareReplyToCustomerPageController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(writeData != null) writeData.close();
            } catch (IOException ex) {
                Logger.getLogger(CusCareReplyToCustomerPageController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        
        Conrfirm.setText(" Sent Successfully!!");
    }
    
}
