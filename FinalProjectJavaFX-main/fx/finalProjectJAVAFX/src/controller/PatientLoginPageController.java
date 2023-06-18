/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.DB;
import view.ViewManager;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import view.AdminDashboard;
import view.Login;

/**
 * FXML Controller class
 *
 * @author WAFAco
 */
public class PatientLoginPageController implements Initializable {

    @FXML
    private PasswordField password;

    @FXML
    private Button loginAsAdminButton;

    @FXML
    private Button registerButton;

    @FXML
    private Button loginButton;

    @FXML
    private TextField username;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    void loginToDashboard(ActionEvent event) throws SQLException, IOException, ClassNotFoundException {

        if (!username.getText().isEmpty() && !password.getText().isEmpty()) {
            String usernamee = username.getText();
            String passwordd = password.getText();

            Connection c = null;
            PreparedStatement ps = null;
            ResultSet rs = null;

            try {
                c = DB.getInstance().getConnection();
                String sql = "SELECT COUNT(id) FROM users WHERE username = ? AND password = ? AND role='patient'";
                ps = c.prepareStatement(sql);
                ps.setString(1, usernamee);
                ps.setString(2, passwordd);
                rs = ps.executeQuery();

                while (rs.next()) {
                    int count = rs.getInt(1);
                    if (count == 1) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Registration Success");
                        alert.setHeaderText(null);
                        alert.setContentText("You have successfully registered as a patient.");
                        alert.showAndWait();
                        ViewManager.OpenPatientDashboard();
//                        
                    } else {
                        showErrorMessage("Invalid credentials", "Please enter valid username and password.");
                    }
                }
            } catch (SQLException e) {
                // Handle the SQL exception
                showErrorMessage("Database Error", "An error occurred while accessing the database.");
            } finally {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (c != null) {
                    c.close();
                }
            }
        } else {
            // Handle the case when username or password is empty
            showErrorMessage("Missing credentials", "Please enter both username and password.");
        }
    }

    private void showErrorMessage(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    void registerEvent(ActionEvent event) throws IOException {
       ViewManager.closeLoginPagePatient();
       ViewManager.OpenRegisterPage();

    }

    @FXML
    void loginAsAdmin(ActionEvent event) throws IOException {
        ViewManager.closeLoginPagePatient();
        ViewManager.OpenLoginPage();
    }

}
