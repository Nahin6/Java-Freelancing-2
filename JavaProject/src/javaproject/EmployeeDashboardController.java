/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproject;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Acer
 */
public class EmployeeDashboardController implements Initializable {

    @FXML
    private BorderPane EmpBorderPane;

  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
     private void loadEmployeeMultiPages(String ui) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource(ui+".fxml"));
            EmpBorderPane.setCenter(root);
        } catch (IOException ex) {
            Logger.getLogger(EmployeeDashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void PostServicesButton(ActionEvent event) {
         loadEmployeeMultiPages("EmployeePostAvailableServicesforCustomerPage") ; 
    }
    @FXML
    private void ViewJobReqButton(ActionEvent event) {
         loadEmployeeMultiPages("EmployeeViewJobRequestPage") ; 
    }

    @FXML
    private void ContactCustomerButton(ActionEvent event) {
         loadEmployeeMultiPages("EmployeeContactCustomerPage") ; 
    }

    @FXML
    private void SendCompleteProject(ActionEvent event) {
         loadEmployeeMultiPages("EmployeeSendCompleteProjectPage") ; 
    }

    @FXML
    private void CeoAnnounmentButton(ActionEvent event) {
         loadEmployeeMultiPages("EmployeeGetCeoAnnouncmentPage") ; 
    }

    @FXML
    private void ClearViewOfEmployeeButton(ActionEvent event) throws IOException {
        
            Parent scene2Parent = FXMLLoader.load(getClass().getResource("EmployeeDashboard.fxml"));
            Scene s = new Scene(scene2Parent);
          
            
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            
            window.setScene(s);
            window.show();
    }

    @FXML
    private void EmpLogOutBttonClick(ActionEvent event) throws IOException {
        
              Parent GoBackParent = FXMLLoader.load(getClass().getResource("UserLogin.fxml"));
            Scene s = new Scene(GoBackParent);
          
            
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            
            window.setScene(s);
            window.show();
    }


    
}
