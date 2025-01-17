package org.example.frontend.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.example.backend.model.User;
import org.example.frontend.MainApp;

public class ProfileController {

    @FXML
    private Label userDetailsLabel;

    @FXML
    public void initialize() {
        // Initialization logic if needed
    }

    public void setUserDetails(User user) {
        if (user != null) {
            userDetailsLabel.setText("Email: " + user.getEmail() + "\nName: " + user.getFirstName() + " " + user.getLastName());
        }
    }

    @FXML
    private void goBackToDashboard() {
        try {
            MainApp.showDashboardView();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}