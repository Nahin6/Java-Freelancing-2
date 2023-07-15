/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproject;


import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author USER
 */
public class UserLoginController implements Initializable {
     
    
    @FXML
    private Label label;
    @FXML
    private TextField userPassword;
   
    @FXML
    private TextField userName;
    
    @FXML
    private ComboBox allUserInComboBox;
    @FXML
    private Label loginLabel;
    
    
    /*private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }*/
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         allUserInComboBox.getItems().addAll("CEO","Manager","Trainer",
                 "Customer Care Executive","Employee","Customer","Freelancer","Student");
        allUserInComboBox.setValue("Select your Designation");
    }  
  

    @FXML
    private void clickLogInButtonOnAction(ActionEvent event) {
        
         String name = userName.getText().toString();
        String password = userPassword.getText().toString();
        String users = allUserInComboBox.getValue().toString();
        
        
        File logindata = null;
        FileInputStream loginInput = null;
        BufferedInputStream BufferInput = null;
        DataInputStream DataInput = null;
        String str="";
        try {
            logindata = new File("login.bin");
            if(!logindata.exists()){
                loginLabel.setText("Account Does not Exits!!");
            }
            else{
                
                loginInput = new FileInputStream(logindata);
               
                DataInput = new DataInputStream(loginInput);
               
                while(true){
                    
                      String DataName=  DataInput.readUTF();
                       String DataPass= DataInput.readUTF();
                      String UserType=  DataInput.readUTF();
                      
                      if(DataName.equals(name) && DataPass.equals(password) && UserType.equals(users))
                      {
                        
                          
                         if(UserType.equals("CEO"))
                          {
                               Parent scene2Parent = FXMLLoader.load(getClass().getResource("CeoDashboard.fxml"));
                          Scene scene2 = new Scene(scene2Parent);
                       Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
                           window.setScene(scene2);
                            window.show();
                              
                          }
                          
                          else if(UserType.equals("Manager"))
                          {
                                   Parent scene2Parent = FXMLLoader.load(getClass().getResource("ManagerDashboard.fxml"));
                          Scene scene2 = new Scene(scene2Parent);
                       Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
                            window.setScene(scene2);
                         window.show();
                              
                          }    
                          else if(UserType.equals("Customer Care Executive"))
                          {
                                   Parent scene2Parent = FXMLLoader.load(getClass().getResource("CustomerCareDashboard.fxml"));
                          Scene scene2 = new Scene(scene2Parent);
                       Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
                   window.setScene(scene2);
                      window.show();
                              
                          }
                          
                       
                          else if(UserType.equals("Employee"))
                          {
                           Parent scene2Parent = FXMLLoader.load(getClass().getResource("EmployeeDashboard.fxml"));
                          Scene scene2 = new Scene(scene2Parent);
                         Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
                   window.setScene(scene2);
                      window.show();
                              
                          }
                          else if(UserType.equals("Customer"))
                          {
                           Parent scene2Parent = FXMLLoader.load(getClass().getResource("CustomerDashboard.fxml"));
                          Scene scene2 = new Scene(scene2Parent);
                          Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
                          window.setScene(scene2);
                          window.show();
                              
                          }
                          
                          
                            else if(UserType.equals("Freelancer"))
                          {
                           Parent scene2Parent = FXMLLoader.load(getClass().getResource("FreelancerDashboard.fxml"));
                          Scene scene2 = new Scene(scene2Parent);
                          Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
                          window.setScene(scene2);
                          window.show();
                              
                          }
                               else if(UserType.equals("Student"))
                          {
                           Parent scene2Parent = FXMLLoader.load(getClass().getResource("StudentDashboard.fxml"));
                          Scene scene2 = new Scene(scene2Parent);
                          Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
                          window.setScene(scene2);
                          window.show();
                              
                          }
                          
                                  else if(UserType.equals("Trainer"))
                          {
                           Parent scene2Parent = FXMLLoader.load(getClass().getResource("TrainerDashboard.fxml"));
                          Scene scene2 = new Scene(scene2Parent);
                          Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
                          window.setScene(scene2);
                          window.show();
                              
                          }
                                                 
                          break;
                      }
                    
                }
           
            }
        } catch (Exception ex) {
            loginLabel.setText("Login Failed!");

        } finally {
          
        }   
    
    }

    @FXML
    private void clickSignUpButtonOnAction(ActionEvent event) throws IOException {
         Parent GoBackParent = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
            Scene s = new Scene(GoBackParent);
          
            
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            
            window.setScene(s);
            window.show();
    }
}

