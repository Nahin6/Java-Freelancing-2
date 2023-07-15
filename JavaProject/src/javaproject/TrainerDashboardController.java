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


public class TrainerDashboardController implements Initializable {

    @FXML
    private BorderPane TrainerPage;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    
    
          private void loadTrainerMultiPages(String ui) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource(ui+".fxml"));
            TrainerPage.setCenter(root);
        } catch (IOException ex) {
            Logger.getLogger(TrainerDashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void SendOnlineClassButton(ActionEvent event) {
            loadTrainerMultiPages("TrainerSendOnlineClassInfoPage") ; 
    }

    @FXML
    private void SeeStudentQueryButton(ActionEvent event) {
         loadTrainerMultiPages("TrainerSeeStudentQueryPage") ; 
    }

    @FXML
    private void UploadResultButton(ActionEvent event) {
         loadTrainerMultiPages("TrainerUploadResultPage") ; 
    }

   @FXML
    private void ContactCustomerCareButton(ActionEvent event) {
          loadTrainerMultiPages("TrainerContactCustomerCarePage") ; 
        
    }
    
        @FXML
    private void SendOfflineClassButton(ActionEvent event) {
        loadTrainerMultiPages("TrainerOfflineClass") ; 
    }

    @FXML
    private void ClearViewOfTrainerButton(ActionEvent event) throws IOException {
        
           Parent scene2Parent = FXMLLoader.load(getClass().getResource("TrainerDashboard.fxml"));
            Scene s = new Scene(scene2Parent);
          
            
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            
            window.setScene(s);
            window.show();
    }

    @FXML
    private void TrainerLogOutBttonClick(ActionEvent event) throws IOException {
        
            Parent GoBackParent = FXMLLoader.load(getClass().getResource("UserLogin.fxml"));
            Scene s = new Scene(GoBackParent);
          
            
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            
            window.setScene(s);
            window.show();
    }


 
    
}
