package org.example.frontend.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.example.frontend.MainApp;

public class DashboardController {

    @FXML
    private Label welcomeLabel;

    @FXML
    public void initialize() {
        welcomeLabel.setText("Welcome to the Dashboard!");
    }

    @FXML
    private void showProfileView() {
        try {
            MainApp.showProfileView();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void showSortingView() {
        try {
            MainApp.showSortingView();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void goBack() {
        try {
            MainApp.showLoginView();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}