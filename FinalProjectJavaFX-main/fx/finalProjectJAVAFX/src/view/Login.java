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
public class Login extends Stage{
    private Scene loginToAdminDashboard;
    private Scene loginToPatirntDashboard;

    public Login() throws IOException {
        FXMLLoader adminLoader = new FXMLLoader(getClass().getResource("/Views/logintoadmin.fxml"));
        Parent adminRoot = adminLoader.load();
        loginToAdminDashboard = new Scene(adminRoot);
        
        FXMLLoader PatientLoader = new FXMLLoader(getClass().getResource("/Views/PatientLoginPage.fxml"));
       Parent patientRoot = PatientLoader.load();
        loginToPatirntDashboard = new Scene(patientRoot);
        
        this.setScene(loginToAdminDashboard);
        this.setTitle("Admin Dashboard");

    }
    
     public void LoginToAdmin() {
        this.setScene(loginToAdminDashboard);
    }
    public void LoginToPatient() {
        this.setScene(loginToPatirntDashboard);
    }

    
}
