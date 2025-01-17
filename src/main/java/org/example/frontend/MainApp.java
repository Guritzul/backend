package org.example.frontend;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.backend.model.User;
import org.example.frontend.controller.ProfileController;

public class MainApp extends Application {

    private static Stage primaryStage;
    private static final double WIDTH = 1280; // 16:9 aspect ratio
    private static final double HEIGHT = 720; // 16:9 aspect ratio
    private static User loggedInUser;

    @Override
    public void start(Stage primaryStage) throws Exception {
        MainApp.primaryStage = primaryStage;
        primaryStage.setWidth(WIDTH);
        primaryStage.setHeight(HEIGHT);
        primaryStage.setResizable(false); // Disable resizing
        showLoginView();
    }

    public static void showLoginView() throws Exception {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/fxml/MainView.fxml"));
        Scene scene = new Scene(loader.load(), WIDTH, HEIGHT);
        scene.getStylesheets().add(MainApp.class.getResource("/css/styles.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.setTitle("Login");
        primaryStage.show();
    }

    public static void showRegistrationView() throws Exception {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/fxml/RegistrationView.fxml"));
        Scene scene = new Scene(loader.load(), WIDTH, HEIGHT);
        scene.getStylesheets().add(MainApp.class.getResource("/css/styles.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.setTitle("Register");
        primaryStage.show();
    }

    public static void showDashboardView() throws Exception {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/fxml/DashboardView.fxml"));
        Scene scene = new Scene(loader.load(), WIDTH, HEIGHT);
        scene.getStylesheets().add(MainApp.class.getResource("/css/styles.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.setTitle("Dashboard");
        primaryStage.show();
    }

    public static void showProfileView() throws Exception {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/fxml/ProfileView.fxml"));
        Scene scene = new Scene(loader.load(), WIDTH, HEIGHT);
        scene.getStylesheets().add(MainApp.class.getResource("/css/styles.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.setTitle("Profile");

        ProfileController controller = loader.getController();
        controller.setUserDetails(loggedInUser);

        primaryStage.show();
    }

    public static void showSortingView() throws Exception {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/fxml/SortingView.fxml"));
        Scene scene = new Scene(loader.load(), WIDTH, HEIGHT);
        scene.getStylesheets().add(MainApp.class.getResource("/css/styles.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.setTitle("Sorting Visualization");
        primaryStage.show();
    }

    public static void setLoggedInUser(User user) {
        loggedInUser = user;
    }

    public static void main(String[] args) {
        launch(args);
    }
}