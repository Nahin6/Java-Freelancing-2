/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproject;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
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
public class CeoGiveAnnouncementPageController implements Initializable {

    @FXML
    private TextArea AnnouncementFXID;
    @FXML
    private Text Message;

    /**
     * Initializes the controller class.
    */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void PostAnnouncementButton(ActionEvent event) {
        
        
      
        File f = null;
        FileOutputStream wirteFile = null;
        DataOutputStream writeData = null;
        
        try {
            f = new File("Announcement.bin");
            if(f.exists()) wirteFile = new FileOutputStream(f,true);
            else wirteFile = new FileOutputStream(f);
            writeData = new DataOutputStream(wirteFile);
           
            writeData.writeUTF(AnnouncementFXID.getText());
            
            
        AnnouncementFXID.setText(null);
        } catch (IOException ex) {
            Logger.getLogger(CeoGiveAnnouncementPageController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(writeData != null) writeData.close();
            } catch (IOException ex) {
                Logger.getLogger(CeoGiveAnnouncementPageController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        
        Message.setText("Announcement has been posted!!");
        
    }
    
}
