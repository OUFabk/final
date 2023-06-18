/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Date;
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
import model.Appoinment;
import model.ScheduleAppoinemnt;

/**
 * FXML Controller class
 *
 * @author WAFAco
 */
public class AvilableAppoinemntController implements Initializable {
     @FXML
  private TableColumn<ScheduleAppoinemnt, String> appoinmentStatus;
    @FXML
    private TableColumn<ScheduleAppoinemnt, Time> appoinemntTime;
    @FXML
    private TableView<ScheduleAppoinemnt> tableViewAppoinemnt;

    @FXML
    private TableColumn<ScheduleAppoinemnt, String> appoinmentDay;

    @FXML
    private TableColumn<ScheduleAppoinemnt, Date> appointmentDate;

    @FXML
    private Button logout;

    @FXML
    private Button avilableAppoinments;

    @FXML
    private Button bookedAppoinment;

    @FXML
    private Button appoinmentSchedule;



    @FXML
    private Button showallappoinment;



    @FXML
    private Button pationtAdminDash;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       if (appointmentDate != null) {
        appointmentDate.setCellValueFactory(new PropertyValueFactory<>("appointmentDate"));
    }
    if (appoinmentDay != null) {
        appoinmentDay.setCellValueFactory(new PropertyValueFactory<>("appointmentDay"));
    }
    if (appoinemntTime != null) {
        appoinemntTime.setCellValueFactory(new PropertyValueFactory<>("appointmentTime"));
    }
    if (appoinmentStatus != null) {
        appoinmentStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
    }
    }    
    
        @FXML
    void personalInformationEvent(ActionEvent event) {
        view.ViewManager.patientPage.changeSceneToPatient();
    }

    @FXML
    void appoinScudeualEvent(ActionEvent event) {

    }

    @FXML
    void avilableAppoinemntsEvent(ActionEvent event) {
       view.ViewManager.patientPage.changeSceneToAvailableAppoinbemntS();

    }

    @FXML
    void bookedAppoinmentEvent(ActionEvent event) {

    }

    @FXML
    void logOutEvent(ActionEvent event) {

    }



    @FXML
    void showAllAppoinment(ActionEvent event) throws SQLException, ClassNotFoundException {
        ObservableList<ScheduleAppoinemnt> shudtList =
        FXCollections.observableArrayList(ScheduleAppoinemnt.getAllAppoinment());
        tableViewAppoinemnt.setItems(shudtList);  
    }
    
}
