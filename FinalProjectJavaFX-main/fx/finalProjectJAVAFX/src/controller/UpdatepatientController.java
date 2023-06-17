/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import model.Users;
import view.ViewManager;

/**
 * FXML Controller class
 *
 * @author Mahmoud
 */
public class UpdatepatientController implements Initializable {
    private Users oldUser;

     @FXML
    private TextField usernameTF;

    @FXML
    private ToggleGroup genderGroup;

    @FXML
    private RadioButton maleRadio;

    @FXML
    private RadioButton adminRadio;

    @FXML
    private Button cancelNewPatient;

    @FXML
    private TextField password;

    @FXML
    private TextField emailTF;

    @FXML
    private TextField lastNameTF;

    @FXML
    private TextField phone;

    @FXML
    private RadioButton femaleRadio;

    @FXML
    private RadioButton patientRadio;

    @FXML
    private TextField firstNameTF;

    @FXML
    private ToggleGroup roleGroup;

    @FXML
    private TextField age;

    @FXML
    private Button UpdateOldPatient;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
            //get selected user data from UsersManagmentController updatedUser var
        this.oldUser = controller.AdminDashboardController.selectedUserToUpdate;
        
        //set text field's data the same as updatedUser data
        usernameTF.setText(oldUser.getUsername());
        password.setText(oldUser.getPassword());
        firstNameTF.setText(oldUser.getFirstname());
        lastNameTF.setText(oldUser.getLastname());
        age.setText(String.valueOf(oldUser.getAge()));
        emailTF.setText(oldUser.getEmail());
        phone.setText(String.valueOf(oldUser.getPhone()));  // Convert int to String

        if (oldUser.getGender().equals("female")) {
            genderGroup.selectToggle(femaleRadio);
        }
        
        if (oldUser.getRole().equals("admin")) {
            roleGroup.selectToggle(adminRadio);
        }
        
    }    
    
      @FXML
    void UpdatePatint(ActionEvent event) throws SQLException, ClassNotFoundException {
          String username = usernameTF.getText();
            String passwordd = password.getText();
            String firstname = firstNameTF.getText();
            String lastname = lastNameTF.getText();
            String ageText = age.getText();
             int ageInt = Integer.parseInt(ageText);
            String email = emailTF.getText();
            String phoneText = phone.getText();
            int phoneInt = Integer.parseInt(phoneText);  
            String gender = ((RadioButton)genderGroup.getSelectedToggle()).getText();
            String role = ((RadioButton)roleGroup.getSelectedToggle()).getText();
            
           
       
          Users newUser = new Users(username,passwordd,firstname,lastname,ageInt,email,phoneInt,gender,role);
              newUser.setId(oldUser.getId());
              newUser.update();
            ViewManager.adminPage.RegisterPagePatient();
           Alert alert = new Alert(Alert.AlertType.INFORMATION);
           alert.setTitle("User updated");
           alert.setContentText("User updated");
            alert.showAndWait();
       
        
    }

    @FXML
    void cancelPatient(ActionEvent event) {
        controller.AdminDashboardController.updateStage.close();
    }

    
}
