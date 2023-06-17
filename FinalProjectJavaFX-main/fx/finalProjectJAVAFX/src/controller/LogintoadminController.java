package controller;

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
import view.AdminDashboard;
import view.ViewManager;

public class LogintoadminController implements Initializable {

    @FXML
    private Button backToPationtButton;

    @FXML
    private Button loginAdminButton;

    @FXML
    private PasswordField passwordTFAD;

    @FXML
    private TextField usernameTFAD;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    void loginAdminEvent(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
        if (!usernameTFAD.getText().isEmpty() && !passwordTFAD.getText().isEmpty()) {
            String username = usernameTFAD.getText();
            String password = passwordTFAD.getText();

            Connection c = null;
            PreparedStatement ps = null;
            ResultSet rs = null;

            try {
                c = DB.getInstance().getConnection();
                String sql = "SELECT COUNT(id) FROM users WHERE username = ? AND password = ? AND role='ADMIN'";
                ps = c.prepareStatement(sql);
                ps.setString(1, username);
                ps.setString(2, password);
                rs = ps.executeQuery();

                while (rs.next()) {
                    int count = rs.getInt(1);
                    if (count == 1) {
                  Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Registration Success");
                        alert.setHeaderText(null);
                        alert.setContentText("You have successfully registered as a Admin.");
                        alert.showAndWait();
                        ViewManager.openAdminPage();
//                        showErrorMessage("valid credentials", "Successful.");
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
    void backRegister(ActionEvent event) throws IOException{
        ViewManager.closeLoginPage();
       ViewManager.OpenRegisterPage();
    }

    private void showErrorMessage(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
