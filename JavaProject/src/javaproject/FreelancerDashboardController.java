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
 * 
 * 
 * 
 * 
 * 
 */
public class FreelancerDashboardController implements Initializable {

    @FXML
    private BorderPane FreeLancerBorderPane;

 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
    private void loadFreelancerMultiPages(String ui) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource(ui+".fxml"));
            FreeLancerBorderPane.setCenter(root);
        } catch (IOException ex) {
            Logger.getLogger(FreelancerDashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void PostAddButton(ActionEvent event) {
        loadFreelancerMultiPages("FreelancerPostAddPage") ; 
    }

    @FXML
    private void ViewJobReqButton(ActionEvent event) {
         loadFreelancerMultiPages("FreelancerViewJobReqPage") ; 
    }

    @FXML
    private void SubmitProjectButton(ActionEvent event) {
         loadFreelancerMultiPages("FreelancerSubmitProjectPage") ; 
    }

    private void ChatWithCustomerButton(ActionEvent event) {
         loadFreelancerMultiPages("FreelancerChatWithCustomerPage") ; 
    }

    @FXML
    private void ContactCustomerCare(ActionEvent event) {
         loadFreelancerMultiPages("FreelancerContactCustomerCarePage") ; 
    }

    @FXML
    private void ClearViewOfFreelancerButton(ActionEvent event) throws IOException {
        
         Parent scene2Parent = FXMLLoader.load(getClass().getResource("FreelancerDashboard.fxml"));
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
