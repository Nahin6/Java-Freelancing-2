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
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Acer
 */
public class SignUpPageController implements Initializable {

    @FXML
    private TextField FirstName;
    @FXML
    private TextField LastName;
    @FXML
    private TextField UserName;
    @FXML
    private TextField PhoneNo;
    @FXML
    private TextField Password;
    @FXML
    private ComboBox DesigNationComboBox;
    @FXML
    private Text ConfirmMessage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
         DesigNationComboBox.getItems().addAll("CEO","Manager ","Trainer ",
                 "Customer Care Executive","Financial Officer","Customer","Freelancer","Student");
        DesigNationComboBox.setValue("Select your Designation"); 
    }    

    @FXML
    private void SignUpButtonOnClick(ActionEvent event) {
        
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
            
            
           
            dos.writeUTF(FirstName.getText());
            dos.writeUTF(LastName.getText());
            dos.writeUTF(UserName.getText());
            dos.writeUTF(PhoneNo.getText().toString());
            dos.writeUTF(Password.getText().toString());
            dos.writeUTF(DesigNationComboBox.getValue().toString());
            
            
           FirstName.setText(null);  DesigNationComboBox.setValue(null);  Password.setText(null);  PhoneNo.setText(null);
            LastName.setText(null);  UserName.setText(null);
            
             ConfirmMessage.setText("Accont Create Successfully");

        } catch (Exception ex) {
    
        } finally {
            try {
                if(dos != null) dos.close();
            } catch (Exception ex) {
                
            }
        } 
    }

    @FXML
    private void BackToLoginButton(ActionEvent event) throws IOException {
        
         Parent scene2Parent = FXMLLoader.load(getClass().getResource("DashBoard.fxml"));
            Scene s = new Scene(scene2Parent);
          
            
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            
            window.setScene(s);
            window.show();
    }
    
}
