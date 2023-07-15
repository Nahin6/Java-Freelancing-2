
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


public class CustomerCareDashboardController implements Initializable {

    @FXML
    private BorderPane CCborderPane;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    
      private void loadCustomerCareMultiPages(String ui) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource(ui+".fxml"));
            CCborderPane.setCenter(root);
        } catch (IOException ex) {
            Logger.getLogger(CustomerCareDashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void ReplyCustomerButton(ActionEvent event) {
              loadCustomerCareMultiPages("CusCareReplyToCustomerPage") ; 
    }

    @FXML
    private void SendUpdateToManager(ActionEvent event) {
          loadCustomerCareMultiPages("CusCareSendUpdateToManagerPage") ; 
    }

     @FXML
    private void ViewFreelancerQuery(ActionEvent event)  {
        loadCustomerCareMultiPages("CusCareViewFreelancerQueryPage") ; 
    }

    @FXML
    private void ViewComplainSuggestionButton(ActionEvent event) {
          loadCustomerCareMultiPages("CusCareViewComplainSuggestionPage") ; 
    }

    @FXML
    private void ClearViewOfCustomerCareButton(ActionEvent event) throws IOException {
            Parent scene2Parent = FXMLLoader.load(getClass().getResource("CustomerCareDashboard.fxml"));
            Scene s = new Scene(scene2Parent);
          
            
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            
            window.setScene(s);
            window.show();
    }

    @FXML
    private void CustomerCareLogOutBttonClick(ActionEvent event) throws IOException {
            Parent GoBackParent = FXMLLoader.load(getClass().getResource("UserLogin.fxml"));
            Scene s = new Scene(GoBackParent);
          
            
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            
            window.setScene(s);
            window.show();
    }


    
}
