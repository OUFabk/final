package view;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import view.ViewManager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class RegPage extends Stage {

    public Button admin;
    public Button patient;

    public RegPage() {

        admin = new Button("admin");
        patient = new Button("patient");
        HBox hbox1 = new HBox();
        hbox1.getChildren().addAll(admin, patient);
        hbox1.setSpacing(20);
        hbox1.setAlignment(Pos.CENTER);

        FlowPane flow = new FlowPane(hbox1);
        flow.setAlignment(Pos.CENTER);
           admin.setCursor(Cursor.HAND);

        admin.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    ViewManager.OpenLoginPage();
                    ViewManager.closeRegisterPage();
                } catch (IOException ex) {
                    Logger.getLogger(RegPage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });
        
        patient.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    ViewManager.OpenLoginPagePatient();
                    ViewManager.closeRegisterPage();
                } catch (IOException ex) {
                    Logger.getLogger(RegPage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });
        
        

        Scene scene = new Scene(flow, 200, 150);
        this.setScene(scene);
        this.setTitle("Rigester Page");
        this.setResizable(false);
        this.show();

    }
}
