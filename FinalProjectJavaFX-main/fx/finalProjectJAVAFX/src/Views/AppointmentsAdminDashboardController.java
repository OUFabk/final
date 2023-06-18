/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Appoinment;

/**
 * FXML Controller class
 *
 * @author WAFAco
 */
public class AppointmentsAdminDashboardController implements Initializable {
     public static Appoinment selectedAppoinmentToUpdate;
        public static Stage updateStage;
        
    @FXML
    private Button showallappoinment;
    @FXML
    private Button deleteappoinment;
    @FXML
    private Button updateappoinment;
    @FXML
    private Button addnewappoinment;
    @FXML
    private Button buttonSearch;
    @FXML
    private TextField searchAdminDash;
    @FXML
    private Button pationtAdminDash;
    @FXML
    private Button AppointmentsAdminDash;
    @FXML
    private Button bookedapp;
    @FXML
    private TableColumn<Appoinment, String> appoinmentStatus;
    @FXML
    private TableColumn<Appoinment, Time> appoinemntTime;
    @FXML
    private TableView<Appoinment> tableViewAppoinemnt;

    @FXML
    private TableColumn<Appoinment, String> appoinmentDay;

    @FXML
    private TableColumn<Appoinment, Date> appointmentDate;


    /**
     * Initializes the controller class.
     */
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
    private void showAllAppoinment(ActionEvent event) throws SQLException, ClassNotFoundException {
         ObservableList<Appoinment> accountList =
        FXCollections.observableArrayList(Appoinment.getAllAppoinment());
        tableViewAppoinemnt.setItems(accountList);  
    }

    @FXML
    private void deleteAppoinemnt(ActionEvent event) {
        if(tableViewAppoinemnt.getSelectionModel().getSelectedItem() != null){
            //store the selected user from the TableView in new user object
            Appoinment selectedAppoinemnt = tableViewAppoinemnt.getSelectionModel().getSelectedItem();
            
            //show an confirmation alert and make the deletion on confirm event
            Alert deleteConfirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
            deleteConfirmAlert.setTitle("User delete");
            deleteConfirmAlert.setContentText("Are you sure to delete this user ?");
            deleteConfirmAlert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                try {
                    //delete the selected user from database table using delete method in our User model
                    selectedAppoinemnt.delete();
                } catch (SQLException ex) {
                    Logger.getLogger(AppointmentsAdminDashboardController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(AppointmentsAdminDashboardController.class.getName()).log(Level.SEVERE, null, ex);
                }
            Alert deletedSuccessAlert = new Alert(Alert.AlertType.INFORMATION);
            deletedSuccessAlert.setTitle("User deleted");
            deletedSuccessAlert.setContentText("User deleted");
            deletedSuccessAlert.show();  
            }
            });
        
        }else{
        Alert warnAlert = new Alert(Alert.AlertType.WARNING);
        warnAlert.setTitle("Select an user");
        warnAlert.setContentText("Please select an user from the table view");
        warnAlert.show();  
        }
    }

    @FXML
    private void updateAppoinment(ActionEvent event) throws IOException {
         if(tableViewAppoinemnt.getSelectionModel().getSelectedItem() != null){
        //store the selected user from the TableView in our global var user selectedUserToUpdate   
        selectedAppoinmentToUpdate = tableViewAppoinemnt.getSelectionModel().getSelectedItem();
        //load update page fxml
        FXMLLoader loaderUpdate = new FXMLLoader(getClass().getResource("/Views/UpdateOldAppoinment.fxml"));
        Parent rootUpdate = loaderUpdate.load();     
        Scene updateAppoinmenttScene = new Scene(rootUpdate); 
        //store loaded fxml in our global stage updateStage and show it
        updateStage = new Stage();
        updateStage.setScene(updateAppoinmenttScene);
        updateStage.setTitle("Update Account " + selectedAppoinmentToUpdate.getStatus());
        updateStage.show();
        }
    }

    @FXML
    private void addNewAppoinment(ActionEvent event) {
        view.ViewManager.adminPage.RegisterPageAppoinment();
    }

    @FXML
    private void searchAppoinment(ActionEvent event) {
    }

    @FXML
    private void logoutApHundler(ActionEvent event) {
    }

    @FXML
    private void patiientHundler(ActionEvent event) {
        view.ViewManager.adminPage.changeSceneToPatient();
    }

    @FXML
    private void appoinmentHundler(ActionEvent event) {
    }

    @FXML
    private void bookedAppoinmentHundler(ActionEvent event) {
        view.ViewManager.adminPage.changeSceneToBookedAppointment();
    }
    
}
