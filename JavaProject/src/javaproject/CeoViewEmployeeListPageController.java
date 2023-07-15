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
public class CeoViewEmployeeListPageController implements Initializable {

    @FXML
    private TableView<Employee> tableFromEmployee;
    @FXML
    private TableColumn<Employee, String> EmpId;
    @FXML
    private TableColumn<Employee, String> EmpName;
    @FXML
    private TableColumn<Employee, String> EmpPost;
    @FXML
    private TableColumn<Employee, String> EmpSalary;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      EmpId.setCellValueFactory(new PropertyValueFactory<Employee, String>("id"));
        EmpSalary.setCellValueFactory(new PropertyValueFactory<Employee, String>("salary"));
         EmpName.setCellValueFactory(new PropertyValueFactory<Employee, String>("name"));
         EmpPost.setCellValueFactory(new PropertyValueFactory<Employee, String>("post"));
       
         
    }    

    @FXML
    private void CheckEmpListCeoButton(ActionEvent event) {
        
                                        ObjectInputStream ois=null;
        ObservableList<Employee> emp = FXCollections.observableArrayList();
         try {
            Employee list;
            ois = new ObjectInputStream(new FileInputStream("EmployeeList.bin"));
            while(true){
                list = (Employee) ois.readObject();
                emp.add(list);
            }
            
        } catch (Exception ex) {            
            try {
                tableFromEmployee.setItems(emp);
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
