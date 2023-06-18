/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.ShowPatient;

/**
 * FXML Controller class
 *
 * @author WAFAco
 */
public class DashboardPatientController implements Initializable {

       @FXML
    private TableColumn<ShowPatient, Integer> phoneCol;

    @FXML
    private TableColumn<ShowPatient, String> usernameCol;

    @FXML
    private TableColumn<ShowPatient, Integer> ageCol;

    @FXML
    private Button appoinmentSchedule;

    @FXML
    private TableColumn<ShowPatient, String> lastnameCol;

    @FXML
    private TableColumn<ShowPatient, String> genderCol;

    @FXML
    private Button pationtAdminDash;

    @FXML
    private TableColumn<ShowPatient, String> passwordCol;

    @FXML
    private Button logout;

    @FXML
    private Button avilableAppoinments;

    @FXML
    private TableColumn<ShowPatient, Integer> idCol;

    @FXML
    private Button bookedAppoinment;

    @FXML
    private Button showallpatient;

    @FXML
    private TableColumn<ShowPatient, String> firstnameCol;

    @FXML
    private TableColumn<ShowPatient, String> emailCol;

    @FXML
    private TableView<ShowPatient> usersTableView;

    @FXML
    private TableColumn<ShowPatient, String> roleCol;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       idCol.setCellValueFactory(new PropertyValueFactory("id"));
            usernameCol.setCellValueFactory(new PropertyValueFactory("username"));
            passwordCol.setCellValueFactory(new PropertyValueFactory("password"));
            firstnameCol.setCellValueFactory(new PropertyValueFactory("firstname"));
            lastnameCol.setCellValueFactory(new PropertyValueFactory("lastname"));
            ageCol.setCellValueFactory(new PropertyValueFactory("age"));
            emailCol.setCellValueFactory(new PropertyValueFactory("email"));
            phoneCol.setCellValueFactory(new PropertyValueFactory("phone"));
            genderCol.setCellValueFactory(new PropertyValueFactory("gender"));
            roleCol.setCellValueFactory(new PropertyValueFactory("role"));
    }    
    @FXML
    void personalInformationEvent(ActionEvent event) {

    }

    @FXML
    void appoinScudeualEvent(ActionEvent event) {
        view.ViewManager.patientPage.changeSceneToAppoinbemntSchdule();
    }

    @FXML
    void avilableAppoinemntsEvent(ActionEvent event) {
         view.ViewManager.patientPage.changeSceneToAvailableAppoinbemntS();
    }

    @FXML
    void bookedAppoinmentEvent(ActionEvent event) {

    }

    @FXML
    void logOutEvent(ActionEvent event) throws IOException {
         view.ViewManager.closeLoginPagePatient();
       view.ViewManager.ClosePatientDashboard();
       view.ViewManager.OpenLoginPagePatient();
    }

    @FXML
    void showAllAppoinment(ActionEvent event) throws SQLException, ClassNotFoundException {
         ObservableList<ShowPatient> usersList =
        FXCollections.observableArrayList(ShowPatient.getAllPatient());
        usersTableView.setItems(usersList);  
    }

}
