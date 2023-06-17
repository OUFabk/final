/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.net.URL;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import model.Appoinment;
import view.ViewManager;

/**
 * FXML Controller class
 *
 * @author Mahmoud
 */
public class CreateAppoinmentController implements Initializable {

    @FXML
    private TextField appoinmentDay;

    @FXML
    private Button saveAppoinment;

    @FXML
    private Button bookedapp;

    @FXML
    private TextField appoinmentTime;

    @FXML
    private Button cancelAppoinment;

    @FXML
    private TextField appoinmentDate;

    @FXML
    private Button pationtAdminDash;

    @FXML
    private Button AppointmentsAdminDash;

    @FXML
    private ToggleGroup statusGroup;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    } 
     @FXML
    void SaveNewAppoinment(ActionEvent event) throws ClassNotFoundException, SQLException {
            String appoinment_date = appoinmentDate.getText();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            java.util.Date utilCreationDate = null;
            try {
                utilCreationDate = dateFormat.parse(appoinment_date);
            } catch (ParseException e) {
                e.printStackTrace();
            }           
            java.sql.Date sqlCreationDate = new java.sql.Date(utilCreationDate.getTime());
            
            String appoinemnt_day = appoinmentDay.getText();
            
           String appointmentTime = appoinmentTime.getText();
            SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
            java.util.Date utilAppointmentTime = null;
            try {
                utilAppointmentTime = timeFormat.parse(appointmentTime);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            java.sql.Time sqlAppointmentTime = new java.sql.Time(utilAppointmentTime.getTime());
            
            String statuss = ((RadioButton)statusGroup.getSelectedToggle()).getText();
            
            Appoinment app = new Appoinment(sqlCreationDate,appoinemnt_day,sqlAppointmentTime,statuss);
            app.save();
        
        //after saving should return to the back scene and show an alert
        ViewManager.adminPage.RegisterPageAppoinment();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Appoinment inserted");
        alert.setContentText("Appoinment inserted");
        alert.showAndWait();

            

    }

    @FXML
    void CancelNewAppoinment(ActionEvent event) {
        view.ViewManager.adminPage.changeSceneToFreeAppointment();
    }
    
}
