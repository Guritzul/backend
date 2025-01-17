package org.example.frontend.controller;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.example.backend.model.User;
import org.example.frontend.MainApp;
import org.springframework.web.client.RestTemplate;

public class RegistrationController {

    @FXML
    private TextField firstNameField;

    @FXML
    private TextField lastNameField;

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    private final RestTemplate restTemplate = new RestTemplate();

    @FXML
    private void goBackToLogin() {
        try {
            MainApp.showLoginView();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleRegister() {
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String email = emailField.getText();
        String password = passwordField.getText();

        // Create a user object
        User user = new User(email, password);
        user.setFirstName(firstName);
        user.setLastName(lastName);

        // Send registration request to the backend
        String url = "http://localhost:8080/users/register";
        User response = restTemplate.postForObject(url, user, User.class);

        if (response != null) {
            System.out.println("Registration successful: " + response.getEmail());
            // Redirect to login page
            try {
                MainApp.showLoginView();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Registration failed");
        }
    }
}