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
public class CeoDashboardController implements Initializable {

    @FXML
    private BorderPane CeoborderPane;

 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
    }    
    
    
        private void loadCoeMultiPages(String ui) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource(ui+".fxml"));
            CeoborderPane.setCenter(root);
        } catch (IOException ex) {
            Logger.getLogger(CeoDashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void CeoGiveAnnouncementaButtonOnClick(ActionEvent event) {
        
              loadCoeMultiPages("CeoGiveAnnouncementPage") ; 
    }

    @FXML
    private void CeoLaodProgressButtononClick(ActionEvent event) {
              loadCoeMultiPages("CeoLaodMonthlyProgessPage") ; 
    }

    @FXML
    private void CeoContactManagerButton(ActionEvent event) {
              loadCoeMultiPages("CeoContactManagerPage") ; 
    }

  

      @FXML
    private void CeoViewEmployeeListButton(ActionEvent event) {
        
         loadCoeMultiPages("CeoViewEmployeeListPage") ;
    }
    
    @FXML
    private void SeeStudentMessage(ActionEvent event) {
        loadCoeMultiPages("CeoSeeStudentMessage");
        
    }  
    
    
    @FXML
    private void ClearViewOfCeoButton(ActionEvent event) throws IOException {
        
          Parent scene2Parent = FXMLLoader.load(getClass().getResource("CeoDashboard.fxml"));
            Scene s = new Scene(scene2Parent);
          
            
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            
            window.setScene(s);
            window.show();
    }

    @FXML
    private void CeoLogOutBttonClick(ActionEvent event) throws IOException {
        
            Parent GoBackParent = FXMLLoader.load(getClass().getResource("UserLogin.fxml"));
            Scene s = new Scene(GoBackParent);
          
            
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            
            window.setScene(s);
            window.show();
    }

   

  
    
}
