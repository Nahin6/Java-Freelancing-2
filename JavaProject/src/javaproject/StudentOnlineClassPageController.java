/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproject;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author Acer
 */
public class StudentOnlineClassPageController implements Initializable {

    @FXML
    private TextArea Classlinks;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
                                    Classlinks.setText("");
        File f = null;
        FileInputStream readFile = null;
        DataInputStream readData = null;
        String classLinks="";
        try {
            f = new File("OnlineClass.bin");
            if(!f.exists()){
                Classlinks.setText("No new Replies from Customer Care ");
            }
            else{
                
                readFile = new FileInputStream(f);

                readData = new DataInputStream(readFile);
             
                while(true){
               
               classLinks = 
                      
                         "Today's Date:  "
                        + readData.readUTF().concat(classLinks)+"\n"+
                         "Today's Class topics:  "
                        + readData.readUTF()+"\n"+
                         "Class links: \n"+readData.readUTF()+"\n \n"
                        +"Next class:\n";
               
               
                    Classlinks.appendText(classLinks);
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
    
}
