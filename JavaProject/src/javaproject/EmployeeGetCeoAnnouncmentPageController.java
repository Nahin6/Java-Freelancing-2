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
public class EmployeeGetCeoAnnouncmentPageController implements Initializable {

    @FXML
    private TextArea ViewAnnouncementFXID;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
                
                  ViewAnnouncementFXID.setText("");
        File f = null;
        FileInputStream readFile = null;
        DataInputStream readData = null;
        String ViewAnnouncement="";
    try {
            f = new File("Announcement.bin");
            if(!f.exists()){
                ViewAnnouncementFXID.setText("No new Announcement");
            }
            else{
                
                readFile = new FileInputStream(f);

                readData = new DataInputStream(readFile);
             
                while(true){
               
               ViewAnnouncement = 
                       readData.readUTF()+"\n"+"Next Announcement: "+"\n";
                      
                    ViewAnnouncementFXID.appendText(ViewAnnouncement);
                }
            }
        } catch (IOException ex) {
           
            Logger.getLogger(EmployeeGetCeoAnnouncmentPageController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(readData != null) readData.close();
            } catch (IOException ex) {
                Logger.getLogger(EmployeeGetCeoAnnouncmentPageController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }    
    
}
