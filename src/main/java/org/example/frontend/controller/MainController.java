package org.example.frontend.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.example.backend.model.User;
import org.example.frontend.MainApp;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

public class MainController {

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    private final RestTemplate restTemplate = new RestTemplate();

    @FXML
    private void handleLogin() {
        String email = emailField.getText();
        String password = passwordField.getText();

        // Create headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Create request body
        String requestBody = String.format("{\"email\":\"%s\", \"password\":\"%s\"}", email, password);

        // Create request entity
        HttpEntity<String> request = new HttpEntity<>(requestBody, headers);

        // Send login request to the backend
        String url = "http://localhost:8080/users/login";
        try {
            ResponseEntity<User> response = restTemplate.exchange(url, HttpMethod.POST, request, User.class);

            if (response.getStatusCode().is2xxSuccessful()) {
                User loggedInUser = response.getBody();
                MainApp.setLoggedInUser(loggedInUser);
                MainApp.showDashboardView();
            } else {
                showAlert("Login Failed", "Invalid email or password. Please try again.");
            }
        } catch (HttpClientErrorException.Unauthorized e) {
            showAlert("Login Failed", "Invalid email or password. Please try again.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void showRegistrationView() {
        try {
            MainApp.showRegistrationView();
        } catch (Exception e) {
            e.printStackTrace();
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

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}