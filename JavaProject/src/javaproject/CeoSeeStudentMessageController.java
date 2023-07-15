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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author Acer
 */
public class CeoSeeStudentMessageController implements Initializable {

    @FXML
    private TextArea ViewMessage;


    @Override
    public void initialize(URL url, ResourceBundle rb) {

        
    }    

    @FXML
    private void ViewMessageFromStudent(ActionEvent event) {
        
                              ViewMessage.setText("");
        File f = null;
        FileInputStream readFile = null;
        DataInputStream readData = null;
        String View="";
        try {
            f = new File("maidul.bin");
            if(!f.exists()){
                ViewMessage.setText("No new Message");
            }
            else{
                
                readFile = new FileInputStream(f);

                readData = new DataInputStream(readFile);
             
                while(true){
               
               View = 
                           "Student ID:  "
                        + readData.readUTF()+"\n"+
                            "Student Name:  "
                        + readData.readUTF()+"\n"+
                            "Subject:  "
                        + readData.readUTF()+"\n"+
                         "Today's Date:  "
                        + readData.readUTF().concat(View)+"\n"+
                    
                         "Student Message: "+readData.readUTF()+"\n \n"
                        +"Next Message:\n";
               
               
                    ViewMessage.appendText(View);
                }
            }
        } catch (IOException ex) {
           
            Logger.getLogger(CeoSeeStudentMessageController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(readData != null) readData.close();
            } catch (IOException ex) {
                Logger.getLogger(CeoSeeStudentMessageController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
}
