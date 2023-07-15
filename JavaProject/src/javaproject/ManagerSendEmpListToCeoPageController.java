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
public class ManagerSendEmpListToCeoPageController implements Initializable {

    @FXML
    private TextField EmpId;
    @FXML
    private TextField EmpName;
    @FXML
    private TextField EmpSalary;
    @FXML
    private TextField EmpPost;
    @FXML
    private Label SuccessMessage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void StoreEmpInfoButton(ActionEvent event) {
        
            Employee emp = new Employee(  
               
             
                
                 Integer.parseInt(EmpId.getText()),
                 Integer.parseInt(EmpSalary.getText()) ,
                    EmpName.getText(),
                     EmpPost.getText()
                );
       EmpId.setText(null);  EmpSalary.setText(null);    
       EmpName.setText(null);  EmpPost.setText(null);     
       
    
        File f = new File("EmployeeList.bin");
        ObjectOutputStream oos=null;
        try {
            if(f.exists())
               oos = new AppendableObjectOutputStream(new FileOutputStream(f,true));
           else
               oos = new ObjectOutputStream(new FileOutputStream(f,true));
          
         
          oos.writeObject(emp);
            oos.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        SuccessMessage.setText("Information Stored Successfully" );
    }
    
}
