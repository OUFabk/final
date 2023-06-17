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
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Appoinment;
import model.BookedApp;
import view.ViewManager;

/**
 * FXML Controller class
 *
 * @author Mahmoud
 */
public class BookedAppointmentsAdminController implements Initializable {
    @FXML
    private Button bookedapp;

    @FXML
    private Button buttonSearch;

    @FXML
    private Button showallabookedppoinment;

    @FXML
    private TextField searchAdminDash;

  
    @FXML
    private Button pationtAdminDash;

    @FXML
    private Button AppointmentsAdminDash;
   
    @FXML
    private TableView<BookedApp> tabelViewBookedAppp;

    @FXML
    private TableColumn<BookedApp, Integer> userId;

    @FXML
    private TableColumn<BookedApp, Integer> id;

    @FXML
    private TableColumn<BookedApp, Integer> appId;

    @FXML
    private TableColumn<BookedApp, String> status;

    @FXML
    private Button doctorComment;
    @FXML
    private TextArea dcommentTxt;



   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
        id.setCellValueFactory(new PropertyValueFactory<>("id"));

        
        appId.setCellValueFactory(new PropertyValueFactory<>("appointmentId"));
 
   
        userId.setCellValueFactory(new PropertyValueFactory<>("userId"));
 
   
        status.setCellValueFactory(new PropertyValueFactory<>("status"));
    
   
    }    
    
        @FXML
       void showAll(ActionEvent event) throws SQLException, ClassNotFoundException {
        ObservableList<BookedApp> bookedAp =
        FXCollections.observableArrayList(BookedApp.getAllBookedAppointments());
        tabelViewBookedAppp.setItems(bookedAp);  
    }
           @FXML
    void EventDcotorComment(ActionEvent event) {

    }

   

    @FXML
    void searchBookedAppoinment(ActionEvent event) {

    }

    @FXML
    void logoutBookedHundler(ActionEvent event) {

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
