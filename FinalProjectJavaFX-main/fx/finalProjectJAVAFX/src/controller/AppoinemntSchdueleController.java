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
import model.AvailableAppoinemnt;
import model.ScheduleAppoinemnt;

/**
 * FXML Controller class
 *
 * @author WAFAco
 */
public class AppoinemntSchdueleController implements Initializable {

    
    @FXML
  private TableColumn<AvailableAppoinemnt, String> appoinmentStatus;
    @FXML
    private TableColumn<AvailableAppoinemnt, Time> appoinemntTime;
    @FXML
    private TableView<AvailableAppoinemnt> tableViewAppoinemnt;

    @FXML
    private TableColumn<AvailableAppoinemnt, String> appoinmentDay;

    @FXML
    private TableColumn<AvailableAppoinemnt, Date> appointmentDate;


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
        view.ViewManager.patientPage.changeSceneToAppoinbemntSchdule();
    }

    @FXML
    void avilableAppoinemntsEvent(ActionEvent event) {
    }

    @FXML
    void bookedAppoinmentEvent(ActionEvent event) {

    }

    @FXML
    void logOutEvent(ActionEvent event) {

    }

    @FXML
    void showAllAppoinment(ActionEvent event) throws SQLException, ClassNotFoundException {
         ObservableList<AvailableAppoinemnt> avilableApp =
        FXCollections.observableArrayList(AvailableAppoinemnt.getAllFreeAppoinment());
        tableViewAppoinemnt.setItems(avilableApp); 
    
}
}
