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
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import model.Users;
import view.ViewManager;
/**
 * FXML Controller class
 *
 * @author WAFAco
 */
public class RegisterPatientController implements Initializable {

     @FXML
    private TextField usernameTF;

    @FXML
    private Button bookedapp;

    @FXML
    private ToggleGroup genderGroup;

    @FXML
    private Button pationtAdminDash;

    @FXML
    private Button AppointmentsAdminDash;

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
    private TextField firstNameTF;

    @FXML
    private ToggleGroup roleGroup;

    @FXML
    private TextField age;

    @FXML
    private Button saveNewPatient;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
     @FXML
    void patiientHundler(ActionEvent event) {
        view.ViewManager.adminPage.changeSceneToPatient();
    }

    @FXML
    void appoinmentHundler(ActionEvent event) {
        view.ViewManager.adminPage.changeSceneToFreeAppointment();

    }

    @FXML
    void bookedAppoinmentHundler(ActionEvent event) {
        view.ViewManager.adminPage.changeSceneToBookedAppointment();

    }


    @FXML
   private void savePatint(ActionEvent event) throws ClassNotFoundException, SQLException {
        
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
            
            
        
            Users user = new Users(username,passwordd,firstname,lastname,ageInt,email,phoneInt,gender,role);
            user.save();
            ViewManager.adminPage.RegisterPagePatient();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("User Insterd");
            alert.setContentText("User Insterd");
            alert.showAndWait();
       
    }

    @FXML
     void cancelPatient(ActionEvent event) {
                ViewManager.adminPage.changeSceneToPatient();
    }
    
    
}
