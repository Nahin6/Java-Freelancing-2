/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproject;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author Acer
 */
public class EmployeeSendCompleteProjectPageController implements Initializable {
     private ArrayList<String> FileType, StoreFileType;  

    @FXML
    private TextArea UploadedFileFxid;
    @FXML
    private Text SendConfirmationlabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                      FileType = new ArrayList<String>();
                
            // FileType.addAll("*.txt","*.doc","*.docx","*.pdf","*.DOCX","*.DOC","*.TXT");
       FileType.add("*.txt");
        FileType.add("*.doc");
        FileType.add("*.docx");
        FileType.add("*.TXT");
        FileType.add("*.DOC");
        FileType.add("*.DOCX");
         FileType.add("*.pdf");

        StoreFileType = new ArrayList<String>();
        StoreFileType.add("*.*");
    }    

    @FXML
    private void UploadFileButton(ActionEvent event) {
               FileChooser openFile = new FileChooser();
        openFile.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text files", FileType));
        openFile.getExtensionFilters().add(new FileChooser.ExtensionFilter("All files", StoreFileType));
 
        File f = openFile.showOpenDialog(null);
        if(f != null){
            try {
                Scanner ScanFile = new Scanner(f);
                String UpFile="";
                while(ScanFile.hasNextLine()){
                    UpFile+=ScanFile.nextLine()+"\n";
                }
                UploadedFileFxid.setText(UpFile);
            } catch (FileNotFoundException ex) {
                
            }
        }
    }

    @FXML
    private void SendToCustomerButton(ActionEvent event) {
            File f = null;
        FileOutputStream writeFile = null;
        DataOutputStream writeData = null;
        
        try {
            f = new File("uploadProject.bin");
            if(f.exists()) writeFile = new FileOutputStream(f,true);
            else writeFile = new FileOutputStream(f);
            writeData = new DataOutputStream(writeFile);
           
            writeData.writeUTF(UploadedFileFxid.getText());
            
                UploadedFileFxid.setText(null);
        } catch (IOException ex) {
            Logger.getLogger(EmployeeSendCompleteProjectPageController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(writeData != null) writeData.close();
            } catch (IOException ex) {
                Logger.getLogger(EmployeeSendCompleteProjectPageController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 

        
    
        
        SendConfirmationlabel.setText("Successsfully Sent!!");
    }
    
}
