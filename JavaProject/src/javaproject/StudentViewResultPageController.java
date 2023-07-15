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
public class StudentViewResultPageController implements Initializable {

    @FXML
    private TextArea Result;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
              
                      
                                                     Result.setText("");
        File f = null;
        FileInputStream readFile = null;
        DataInputStream readData = null;
        String results="";
        try {
            f = new File("UploadResult.bin");
            if(!f.exists()){
                Result.setText("No Result uploaded yet ");
            }
            else{
                
                readFile = new FileInputStream(f);

                readData = new DataInputStream(readFile);
             
                while(true){
               
               results = 
                      
                      
                         "Student Name :  "
                        + readData.readUTF()+"\n"+
                       "Student ID :  "
                        + readData.readUTF()+"\n"+
                       "Subject :  "
                        + readData.readUTF()+"\n"+
                         "Mark got: "+readData.readUTF()+"\n \n"
                        +"Next:\n";
               
               
                    Result.appendText(results);
                }
            }
        } catch (IOException ex) {
           
            Logger.getLogger(StudentViewResultPageController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(readData != null) readData.close();
            } catch (IOException ex) {
                Logger.getLogger(StudentViewResultPageController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }    
    
}
