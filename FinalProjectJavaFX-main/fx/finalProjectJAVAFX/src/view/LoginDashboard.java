/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author WAFAco
 */
public class LoginDashboard extends Stage{
    private Scene loginPatientDashboard;

    public LoginDashboard() throws IOException {
       
        FXMLLoader patientLoader = new FXMLLoader(getClass().getResource("/Views/PatientLoginPage.fxml"));
        Parent freeAppointmentsRoot = patientLoader.load();
        loginPatientDashboard = new Scene(freeAppointmentsRoot);
        
        
        this.setScene(loginPatientDashboard);
        this.setTitle("Patient Dashboard");
        
    }
    
    public void LoginToPatientDashboard() {
        this.setScene(loginPatientDashboard);
    }
//    public void LoginToPatientDashboard() {
//        this.setScene(loginPatientDashboard);
//    }
//        
}
