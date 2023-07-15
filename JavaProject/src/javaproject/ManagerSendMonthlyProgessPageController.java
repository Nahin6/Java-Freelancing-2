/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Acer
 */
public class ManagerSendMonthlyProgessPageController implements Initializable {

    @FXML
    private TextField MonthTxtId;
    @FXML
    private TextField CustomerRegTxtId;
    @FXML
    private TextField FreelancerRegTxtId;
    @FXML
    private TextField InvestmentTxtId;
    @FXML
    private TextField NumOfOrderTxtId;
    @FXML
    private TextField NumOfDeliverdOrderTxtId;
    @FXML
    private Label StoreInfoSuccess;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
    }    

    @FXML
    private void StoreMonthlyProgressButtonOnClick(ActionEvent event) {
        
            ManagerMonthlyProgress SendProgress = new ManagerMonthlyProgress(  
                 MonthTxtId.getText(),
                 Integer.parseInt(CustomerRegTxtId.getText())  ,
                 Integer.parseInt(FreelancerRegTxtId.getText()),
                 Integer.parseInt(InvestmentTxtId.getText()),
                 Integer.parseInt(NumOfOrderTxtId.getText()),
                 Integer.parseInt(NumOfDeliverdOrderTxtId.getText())
                
                );
       MonthTxtId.setText(null); 
       CustomerRegTxtId.setText(null);  
       FreelancerRegTxtId.setText(null);     
       InvestmentTxtId.setText(null);
       NumOfOrderTxtId.setText(null);
       NumOfDeliverdOrderTxtId.setText(null);
    
        File f = new File("MonthlyProgress.bin");
        ObjectOutputStream oos=null;
        try {
            if(f.exists())
               oos = new AppendableObjectOutputStream(new FileOutputStream(f,true));
           else
               oos = new ObjectOutputStream(new FileOutputStream(f,true));
          
         
          oos.writeObject(SendProgress);
            oos.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        StoreInfoSuccess.setText("Information Stored Successfully" );
    }
    
}
