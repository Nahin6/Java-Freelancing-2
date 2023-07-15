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
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Acer
 */
public class CustomerDashboardController implements Initializable {

    @FXML
    private BorderPane CustomerBorderPane;

    /**
     * Initializes the controller class.
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    
     private void loadCustomerMultiPages(String ui) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource(ui+".fxml"));
            CustomerBorderPane.setCenter(root);
        } catch (IOException ex) {
            Logger.getLogger(CustomerDashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    

    @FXML
    private void BrowseWorkButton(ActionEvent event) {
               loadCustomerMultiPages("CustomerBrowseWorkFromCompanyPage") ; 
    }

    @FXML
    private void ContactWithEmpButton(ActionEvent event) {
         loadCustomerMultiPages("CustomerContactWithEmployeePage") ; 
    }

    @FXML
    private void ReceiveProjectEmpButton(ActionEvent event) {
         loadCustomerMultiPages("CustomerReceiveProjectFromEmployeePage") ; 
    }

    @FXML
    private void HIreFreelancerButton(ActionEvent event) {
         loadCustomerMultiPages("CustomerHIreFreelancerPage") ; 
    }

    @FXML
    private void ReceiveFreelancerProjectButton(ActionEvent event) {
         loadCustomerMultiPages("CustomerReceiveFreelancerProjectPage") ; 
    }

    @FXML
    private void ContactCustomerButton(ActionEvent event) {
         loadCustomerMultiPages("CustomerContactCustomerPage") ; 
    }

    @FXML
    private void ComplainSuggestionButton(ActionEvent event) {
         loadCustomerMultiPages("CustomerComplainSuggestionPage") ; 
    }

    @FXML
    private void ClearViewOfCustomerButton(ActionEvent event) throws IOException {
        
                Parent scene2Parent = FXMLLoader.load(getClass().getResource("CustomerDashboard.fxml"));
            Scene s = new Scene(scene2Parent);
          
            
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            
            window.setScene(s);
            window.show();
    }

    @FXML
    private void CustomerLogOutBttonClick(ActionEvent event) throws IOException {
        
              Parent GoBackParent = FXMLLoader.load(getClass().getResource("UserLogin.fxml"));
            Scene s = new Scene(GoBackParent);
          
            
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            
            window.setScene(s);
            window.show();
    }
    
}
