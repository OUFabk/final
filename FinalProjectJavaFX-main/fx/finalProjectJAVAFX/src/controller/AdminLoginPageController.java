/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.DB;
import model.Users;
import view.AdminDashboard;
import view.ViewManager;

/**
 * FXML Controller class
 *
 * @author WAFAco
 */
public class AdminLoginPageController implements Initializable {

    @FXML
    private TextField usernameAdmin;

    @FXML
    private Button backToPationtButton;

    @FXML
    private PasswordField passwordAdmin;

    @FXML
    private Button loginAdminButton;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    
    @FXML
    void usernameHundler(ActionEvent event) {
        
    }

    @FXML
    void passwordHundler(ActionEvent event) {
    }

    @FXML
void loginAdmin(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
    if (!usernameAdmin.getText().isEmpty() && !passwordAdmin.getText().isEmpty()) {
        String username = usernameAdmin.getText();
        String password = passwordAdmin.getText();
        
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            c = DB.getInstance().getConnection();
            String sql = "SELECT COUNT(1) FROM users WHERE username = ? AND password = ? AND role='ADMIN'";
            ps = c.prepareStatement(sql);
            ps.setString(2, username); // Set username parameter at index 2
            ps.setString(3, password); // Set password parameter at index 3
            rs = ps.executeQuery();

            if (rs.next()) {
                int count = rs.getInt(1);
                if (count == 1) {
                    // Login successful, proceed to admin dashboard
                    ViewManager.adminPage.changeSceneToPatient();
                } else {
                    // Invalid login credentials
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

@FXML
void backRegister(ActionEvent event) {

}

private void showErrorMessage(String title, String message) {
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle(title);
    alert.setHeaderText(null);
    alert.setContentText(message);
    alert.showAndWait();
}

}
