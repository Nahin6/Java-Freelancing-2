/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproject;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Acer
 */
public class CeoLaodMonthlyProgessPageController implements Initializable {

    @FXML
    private TableView<ManagerMonthlyProgress> tableFromEmployee;
    @FXML
    private TableColumn<ManagerMonthlyProgress, String> monthColumn;
    @FXML
    private TableColumn<ManagerMonthlyProgress, String> NewCusRegColumn;
    @FXML
    private TableColumn<ManagerMonthlyProgress, String> NewFreelancerRegColumn;
    @FXML
    private TableColumn<ManagerMonthlyProgress, String> InvestColumn;
    @FXML
    private TableColumn<ManagerMonthlyProgress, String> orderGotColumn;
    @FXML
    private TableColumn<ManagerMonthlyProgress, String> OrderDeliverdColumn;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
           monthColumn.setCellValueFactory(new PropertyValueFactory<ManagerMonthlyProgress, String>("Month"));
         NewCusRegColumn.setCellValueFactory(new PropertyValueFactory<ManagerMonthlyProgress, String>("CusReg"));
         NewFreelancerRegColumn.setCellValueFactory(new PropertyValueFactory<ManagerMonthlyProgress, String>("FreelancerReg"));
         InvestColumn.setCellValueFactory(new PropertyValueFactory<ManagerMonthlyProgress, String>("TotalInvestment"));
         orderGotColumn.setCellValueFactory(new PropertyValueFactory<ManagerMonthlyProgress, String>("ordrGot"));
         OrderDeliverdColumn.setCellValueFactory(new PropertyValueFactory<ManagerMonthlyProgress, String>("ordrDelivered"));
       
    }    

    @FXML
    private void CheckMonthlyUpdateCeoButton(ActionEvent event) {
        
                                ObjectInputStream ois=null;
        ObservableList<ManagerMonthlyProgress> pp = FXCollections.observableArrayList();
         try {
            ManagerMonthlyProgress progress;
            ois = new ObjectInputStream(new FileInputStream("MonthlyProgress.bin"));
            while(true){
                progress = (ManagerMonthlyProgress) ois.readObject();
                pp.add(progress);
            }
            
        } catch (Exception ex) {            
            try {
                tableFromEmployee.setItems(pp);
                if(ois!=null)
                    ois.close();
            } 
            catch (IOException e) {
                e.printStackTrace();
            }
            ex.printStackTrace();
        }
    }
    
}
