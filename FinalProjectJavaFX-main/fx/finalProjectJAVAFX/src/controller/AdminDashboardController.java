/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Users;
import view.ViewManager;

/**
 * FXML Controller class
 *
 * @author Mahmoud
 */
public class AdminDashboardController implements Initializable {
    public static Users selectedUserToUpdate;
    public static Stage updateStage;
     @FXML
    private Button pationtAdminDash;

    @FXML
    private Button AppointmentsAdminDash;
    
    @FXML
    private Button bookedapp;

    @FXML
    private Button showallpatient;

    @FXML
    private Button addnewpatient;

    @FXML
    private Button updatepatient;

    @FXML
    private Button deletepatient;
    
    @FXML
    private Button buttonSearch;
    
    @FXML
    private TextField searchAdminDash;
        
    @FXML
    private TableView<Users> usersTableView;
    @FXML
    private TableColumn<Users, Integer> idCol;
    @FXML
    private TableColumn<Users, String> usernameCol;
    @FXML
    private TableColumn<Users, String> passwordCol;
     @FXML
    private TableColumn<Users, String> firstnameCol;
      @FXML
    private TableColumn<Users, String> lastnameCol;
    @FXML
    private TableColumn<Users, Integer> ageCol;
    @FXML
    private TableColumn<Users, String> emailCol;
    @FXML
    private TableColumn<Users, Integer> phoneCol;
    @FXML
    private TableColumn<Users, String> genderCol;
    @FXML
    private TableColumn<Users, String> roleCol;

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
    void patiientHundler(ActionEvent event) {
    }

    @FXML
    void appoinmentHundler(ActionEvent event) {
        ViewManager.adminPage.changeSceneToFreeAppointment();
    }

    @FXML
    void bookedAppoinmentHundler(ActionEvent event) {
          ViewManager.adminPage.changeSceneToBookedAppointment();
    }

    @FXML
    void searchHundler(ActionEvent event) {

    }

    @FXML
    void logoutHundler(ActionEvent event) throws IOException {
        ViewManager.closeLoginPage();
        ViewManager.closeAdminPage();
        ViewManager.OpenLoginPage();
    }


    @FXML
    void addNewPatient(ActionEvent event) {
        ViewManager.adminPage.RegisterPagePatient();
    }

    @FXML
    void updatePatient(ActionEvent event) throws IOException {
        
         //check if there is an user selected from the TableView
        if(usersTableView.getSelectionModel().getSelectedItem() != null){
        //store the selected user from the TableView in our global var user selectedUserToUpdate   
        selectedUserToUpdate = usersTableView.getSelectionModel().getSelectedItem();
        //load update page fxml
        FXMLLoader loaderUpdate = new FXMLLoader(getClass().getResource("/Views/Updatepatient.fxml"));
        Parent rootUpdate = loaderUpdate.load();     
        Scene updateUserScene = new Scene(rootUpdate); 
        //store loaded fxml in our global stage updateStage and show it
        updateStage = new Stage();
        updateStage.setScene(updateUserScene);
        updateStage.setTitle("Update user " + selectedUserToUpdate.getUsername() );
        updateStage.show();
        }
    }

    @FXML
    void deletePatient(ActionEvent event) {

         //check if there is an user selected from the TableView
        if(usersTableView.getSelectionModel().getSelectedItem() != null){
            //store the selected user from the TableView in new user object
            Users selectedUser = usersTableView.getSelectionModel().getSelectedItem();
            
            //show an confirmation alert and make the deletion on confirm event
            Alert deleteConfirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
            deleteConfirmAlert.setTitle("User delete");
            deleteConfirmAlert.setContentText("Are you sure to delete this user ?");
            deleteConfirmAlert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                try {
                    //delete the selected user from database table using delete method in our User model
                    selectedUser.delete();
                } catch (SQLException ex) {
                    Logger.getLogger(AdminDashboardController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(AdminDashboardController.class.getName()).log(Level.SEVERE, null, ex);
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
    void showAllPatinet(ActionEvent event) throws SQLException, ClassNotFoundException {
           ObservableList<Users> usersList =
        FXCollections.observableArrayList(Users.getAllUsers());
        usersTableView.setItems(usersList);  
    }


}
    
   
