/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproject;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class SignUpController implements Initializable {

    @FXML
    private TextField userPassword;
    @FXML
    private TextField userName;
    @FXML
    private ComboBox allUserInCombox;
    @FXML
    private Label RegLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        allUserInCombox.getItems().addAll("CEO","Manager","Trainer",
        "Customer Care Executive","Employee","Customer","Freelancer","Student");
        allUserInCombox.setValue("Select your Designation");
    }    

    
    
    @FXML
    private void registerButtonOnClick(ActionEvent event) {
        File f = null;
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        DataOutputStream dos = null;
        
        try {
            f = new File("login.bin");
            if(f.exists()) fos = new FileOutputStream(f,true);
            else fos = new FileOutputStream(f);
            
            bos = new BufferedOutputStream(fos);
            dos = new DataOutputStream(bos);
         
            
           
            dos.writeUTF(userName.getText());
            dos.writeUTF(userPassword.getText());
            dos.writeUTF( allUserInCombox.getValue().toString());
            
             userName.setText(null);  allUserInCombox.setValue(null);  userPassword.setText(null);
            
           RegLabel.setText("Account Created Successfully ");

        } catch (Exception ex) {
    
        } finally {
            try {
                if(dos != null) dos.close();
            } catch (Exception ex) {
                
            }
        }      
    }

    @FXML
    private void BackToLoginPage(ActionEvent event) throws IOException {
          Parent GoBackParent = FXMLLoader.load(getClass().getResource("UserLogin.fxml"));
            Scene s = new Scene(GoBackParent);
          
            
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            
            window.setScene(s);
            window.show();
    }

    @FXML
    private void go(ActionEvent event) throws IOException {
              Parent GoBackParent = FXMLLoader.load(getClass().getResource("StudentChatWithCustomerCarePage.fxml"));
            Scene s = new Scene(GoBackParent);
          
            
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            
            window.setScene(s);
            window.show();
        
    }

}
