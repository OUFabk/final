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
public class PatientDashboard extends Stage{
    private Scene pationtDashboard;
    private Scene appointSchudule;
    private Scene availableAppoinemnt;
    
    
        public PatientDashboard() throws IOException{
        FXMLLoader PateintLoader = new FXMLLoader(getClass().getResource("/Views/DashboardPatient.fxml"));
        Parent patientRoot = PateintLoader.load();
        pationtDashboard = new Scene(patientRoot);
        
        FXMLLoader SchuduleLoader = new FXMLLoader(getClass().getResource("/Views/AvilableAppoinemnt.fxml"));
        Parent SchuduleRoot = SchuduleLoader.load();
        appointSchudule = new Scene(SchuduleRoot);
        
        FXMLLoader availableLoader = new FXMLLoader(getClass().getResource("/Views/AppoinemntSchduele.fxml"));
        Parent abailableRoot = availableLoader.load();
        availableAppoinemnt = new Scene(abailableRoot);
        
        this.setScene(pationtDashboard);
        this.setTitle("Patient Dashboard");
        
}
        
        public void changeSceneToPatient() {
        this.setScene(pationtDashboard);
    }
        
        public void changeSceneToAppoinbemntSchdule() {
        this.setScene(appointSchudule);
    }
         public void changeSceneToAvailableAppoinbemntS() {
        this.setScene(availableAppoinemnt);
    }
}
