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


public class StudentDashboardController implements Initializable {

    @FXML
    private BorderPane StudentBorderPane;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }  
    
    
       private void loadStudentMultiPages(String ui) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource(ui+".fxml"));
            StudentBorderPane.setCenter(root);
        } catch (IOException ex) {
            Logger.getLogger(FreelancerDashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }



    @FXML
    private void OnlineClassButton(ActionEvent event) {
         loadStudentMultiPages("StudentOnlineClassPage") ; 
    }

    @FXML
    private void ChatWithCustomerCareButton(ActionEvent event) {
         loadStudentMultiPages("StudentChatWithCustomerCarePage") ; 
    }

    @FXML
    private void ChatWithTrainerButton(ActionEvent event) {
         loadStudentMultiPages("StudentChatWithTrainerPage") ; 
    }

    @FXML
    private void ViewResultButton(ActionEvent event) {
         loadStudentMultiPages("StudentViewResultPage") ; 
       
    }
    
    @FXML
    private void ContactWithCeo(ActionEvent event) {
        loadStudentMultiPages("StudentContactWithCeo");
        
    }

    
    
    @FXML
    private void ClearViewOfStudentButton(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(getClass().getResource("StudentDashboard.fxml"));
            Scene s = new Scene(scene2Parent);
          
            
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            
            window.setScene(s);
            window.show();
    }

    @FXML
    private void StudentLogOutBttonClick(ActionEvent event) throws IOException {
         Parent GoBackParent = FXMLLoader.load(getClass().getResource("UserLogin.fxml"));
            Scene s = new Scene(GoBackParent);
          
            
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            
            window.setScene(s);
            window.show();
    }


}
