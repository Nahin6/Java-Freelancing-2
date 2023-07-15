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
public class DashBoardController implements Initializable {

   
  
  
    @FXML
    private TextField UserName;
    @FXML
    private TextField Password;
    @FXML
    private ComboBox DesigNationComboBox;
    @FXML
    private Text AlertMessage;
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        DesigNationComboBox.getItems().addAll("CEO","Manager ","Trainer ",
                 "Customer Care Executive","Financial Officer","Customer","Freelancer","Student");
        DesigNationComboBox.setValue("Select your Designation"); 
    }    

    @FXML
    private void LoginButton(ActionEvent event) {
        
          String id = UserName.getText().toString();
        String pass = Password.getText().toString();
        String type = DesigNationComboBox.getValue().toString();
        
        
        File f = null;
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        DataInputStream dis = null;
        String str="";
        try {
            f = new File("login.bin");
            if(!f.exists()){
                AlertMessage.setText("Account Does not Exits!!");
            }
            else{
                
                fis = new FileInputStream(f);
               
                dis = new DataInputStream(fis);
               
                while(true){
                    
                      String ID =  dis.readUTF();
                       String PASS= dis.readUTF();
                      String TYPE=  dis.readUTF();
                      
                      if(ID.equals(id) && PASS.equals(pass) && TYPE.equals(type))
                          
                          
                      {
                         
                          
                          if(TYPE.equals("CEO"))
                          {
                               Parent scene2Parent = FXMLLoader.load(getClass().getResource("CeoDashboard.fxml"));
                          Scene scene2 = new Scene(scene2Parent);
                       Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
                   window.setScene(scene2);
                      window.show();
                              
                          }
                          
                          else if(TYPE.equals("Manager"))
                          {
                                   Parent scene2Parent = FXMLLoader.load(getClass().getResource("ManagerDashboard.fxml"));
                          Scene scene2 = new Scene(scene2Parent);
                       Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
                   window.setScene(scene2);
                      window.show();
                              
                          }    
                          else if(TYPE.equals("Customer Care Executive"))
                          {
                                   Parent scene2Parent = FXMLLoader.load(getClass().getResource("CustomerCareDashboard.fxml"));
                          Scene scene2 = new Scene(scene2Parent);
                       Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
                   window.setScene(scene2);
                      window.show();
                              
                          }
                          
                       
                          else if(TYPE.equals("Financial Officer"))
                          {
                           Parent scene2Parent = FXMLLoader.load(getClass().getResource("FinancialOfficerDashboard.fxml"));
                          Scene scene2 = new Scene(scene2Parent);
                         Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
                   window.setScene(scene2);
                      window.show();
                              
                          }
                          else if(TYPE.equals("Customer"))
                          {
                           Parent scene2Parent = FXMLLoader.load(getClass().getResource("CustomerDashboard.fxml"));
                          Scene scene2 = new Scene(scene2Parent);
                          Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
                          window.setScene(scene2);
                          window.show();
                              
                          }
                              else if(TYPE.equals("Freelancer"))
                          {
                           Parent scene2Parent = FXMLLoader.load(getClass().getResource("FreelancerDashboard.fxml"));
                          Scene scene2 = new Scene(scene2Parent);
                          Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
                          window.setScene(scene2);
                          window.show();
                              
                          }
                               else if(TYPE.equals("Student"))
                          {
                           Parent scene2Parent = FXMLLoader.load(getClass().getResource("StudentDashboard.fxml"));
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
            AlertMessage.setText("Login Failed!");

        } finally {
          
        }
        
    }

    
    
    
    
    
    
    
    
    
    
    @FXML
    private void SignUpButton(ActionEvent event) throws IOException {
        
                Parent GoBackParent = FXMLLoader.load(getClass().getResource("SignUpPage.fxml"));
            Scene s = new Scene(GoBackParent);
          
            
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            
            window.setScene(s);
            window.show();
    }

    
}
