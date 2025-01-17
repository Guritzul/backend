package org.example;

import org.example.backend.BackendApplication;
import org.example.frontend.MainApp;
import org.springframework.boot.SpringApplication;
import javafx.application.Application;

public class ApplicationStarter {

    public static void main(String[] args) {
        // Start the backend in a new thread
        Thread backendThread = new Thread(() -> SpringApplication.run(BackendApplication.class, args));
        backendThread.start();

        // Start the frontend in a new thread
        Thread frontendThread = new Thread(() -> Application.launch(MainApp.class, args));
        frontendThread.start();
    }
}