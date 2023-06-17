package view;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AdminDashboard extends Stage {
    private Scene patientDashboard;
    private Scene freeAppointments;
    private Scene bookedAppointments;
    private Scene registerPationt;
    private Scene addAppoinment;
    


    public AdminDashboard() throws IOException {
        // Load AdminDashboard FXML file
        FXMLLoader adminLoader = new FXMLLoader(getClass().getResource("/Views/AdminDashboard.fxml"));
        Parent adminRoot = adminLoader.load();
        patientDashboard = new Scene(adminRoot);

        // Load FreeAppointments FXML file
        FXMLLoader freeAppointmentsLoader = new FXMLLoader(getClass().getResource("/Views/AppointmentsAdminDashboard.fxml"));
        Parent freeAppointmentsRoot = freeAppointmentsLoader.load();
        freeAppointments = new Scene(freeAppointmentsRoot);

        // Load BookedAppointments FXML file
        FXMLLoader bookedAppointmentsLoader = new FXMLLoader(getClass().getResource("/Views/BookedAppointmentsAdmin.fxml"));
        Parent bookedAppointmentsRoot = bookedAppointmentsLoader.load();
        bookedAppointments = new Scene(bookedAppointmentsRoot);
        
        FXMLLoader registerPationtLoader = new FXMLLoader(getClass().getResource("/Views/registerPatient.fxml"));
        Parent registerPationtRoot = registerPationtLoader.load();
        registerPationt = new Scene(registerPationtRoot);
        
        FXMLLoader registerAppoinmenttLoader = new FXMLLoader(getClass().getResource("/Views/createAppoinment.fxml"));
        Parent registerAppoinmenttRoot = registerAppoinmenttLoader.load();
        addAppoinment = new Scene(registerAppoinmenttRoot);

        // Set Main Scene in Admin Dashboard (PatientDashboard Scene)
        this.setScene(patientDashboard);
        this.setTitle("Admin Dashboard");
    }

 

   
    public void changeSceneToPatient() {
        this.setScene(patientDashboard);
    }
    public void changeSceneToFreeAppointment() {
        this.setScene(freeAppointments);
    }
    
    public void changeSceneToBookedAppointment() {
        this.setScene(bookedAppointments);
    }
     public void RegisterPagePatient() {
        this.setScene(registerPationt);
    }
      public void RegisterPageAppoinment() {
        this.setScene(addAppoinment);
    }
    
    

}
