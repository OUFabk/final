/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import view.ViewManager;

/**
 * FXML Controller class
 *
 * @author WAFAco
 */
public class AppointmentsAdminDashboardController implements Initializable {


    @FXML
    private Button bookedapp;

    @FXML
    private Button buttonSearch;

    @FXML
    private TextField searchAdminDash;

    @FXML
    private Button addnewappoinment;

    @FXML
    private Button showallappoinment;

    @FXML
    private Button deleteappoinment;

    @FXML
    private Button updateappoinment;

    @FXML
    private Button pationtAdminDash;

    @FXML
    private Button AppointmentsAdminDash;
    
    
    @Override
  public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
  
      @FXML
    void showAllAppoinment(ActionEvent event) {

    }

    @FXML
    void deleteAppoinemnt(ActionEvent event) {

    }

    @FXML
    void updateAppoinment(ActionEvent event) {

    }

    @FXML
    void addNewAppoinment(ActionEvent event) {
    }

    @FXML
    void searchAppoinment(ActionEvent event) {

    }

    @FXML
    void logoutApHundler(ActionEvent event) {

    }

    @FXML
    void patiientHundler(ActionEvent event) {
        ViewManager.adminPage.changeSceneToPatient();
    }

    @FXML
    void appoinmentHundler(ActionEvent event) {
        ViewManager.adminPage.changeSceneToFreeAppointment();
    }

    @FXML
    void bookedAppoinmentHundler(ActionEvent event) {
    }
  
}
