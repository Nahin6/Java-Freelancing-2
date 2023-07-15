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
public class ManagerDashboardController implements Initializable {

    @FXML
    private BorderPane ManagerBorderPane;

    /**
     * Initializes the controller class.
     * 
     * 
     * 
     * 
     * 
     * 
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
      private void loadManagerMultiPages(String ui) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource(ui+".fxml"));
            ManagerBorderPane.setCenter(root);
        } catch (IOException ex) {
            Logger.getLogger(ManagerDashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    @FXML
    private void SendMonthlyProgessButton(ActionEvent event) {
        
        loadManagerMultiPages("ManagerSendMonthlyProgessPage") ; 
    }

    @FXML
    private void ViewAnnouncementButton(ActionEvent event) {
         loadManagerMultiPages("ManagerViewAnnouncementFromCeoPage") ; 
    }

    @FXML
    private void SendEmpListToCEObutton(ActionEvent event) {
         loadManagerMultiPages("ManagerSendEmpListToCeoPage") ; 
    }

    @FXML
    private void ContactCeoButton(ActionEvent event) {
         loadManagerMultiPages("ManagerContactCeoPage") ; 
    }

    @FXML
    private void ReceiveInfoFromCustomerCareButton(ActionEvent event) {
         loadManagerMultiPages("ManagerReceiveInfoFromCustomerCarePage") ; 
    }

    @FXML
    private void ClearViewOfManagerButton(ActionEvent event) throws IOException {
        
           Parent scene2Parent = FXMLLoader.load(getClass().getResource("ManagerDashboard.fxml"));
            Scene s = new Scene(scene2Parent);
          
            
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            
            window.setScene(s);
            window.show();
    }

    @FXML
    private void ManagerLogOutBttonClick(ActionEvent event) throws IOException {
        
            Parent GoBackParent = FXMLLoader.load(getClass().getResource("UserLogin.fxml"));
            Scene s = new Scene(GoBackParent);
          
            
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            
            window.setScene(s);
            window.show();
    }
    
}
