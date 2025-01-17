Application Overview:
This application is a Java-based project that integrates Spring Boot for the backend and JavaFX for the frontend. It includes user authentication, registration, and sorting visualization features.

Features:
-User Authentication: Users can log in and register.
-User Management: Admins can manage users, including upgrading users to admin roles.
-Sorting Visualization: Users can visualize sorting algorithms like Quick Sort and Bubble Sort.
-Profile Management: Users can view and update their profile information.

Technologies Used:

-Java: The primary programming language.
-Spring Boot: For building the backend REST API.
-JavaFX: For building the frontend user interface.
-Maven: For project management and dependency management.
-Spring Security: For securing the application.
-JPA/Hibernate: For database interaction.

Project Structure:
src
└── main
    ├── java
    │   └── org
    │       └── example
    │           ├── backend
    │           │   ├── controller
    │           │   │   └── UserController.java
    │           │   ├── model
    │           │   │   ├── Role.java
    │           │   │   └── User.java
    │           │   ├── repository
    │           │   │   └── UserRepository.java
    │           │   ├── security
    │           │   │   └── SecurityConfig.java
    │           │   ├── service
    │           │   │   ├── CustomUserDetailsService.java
    │           │   │   └── UserService.java
    │           │   └── BackendApplication.java
    │           ├── frontend
    │           │   ├── controller
    │           │   │   ├── DashboardController.java
    │           │   │   ├── MainController.java
    │           │   │   ├── ProfileController.java
    │           │   │   ├── RegistrationController.java
    │           │   │   └── SortingController.java
    │           │   ├── MainApp.java
    │           │   └── model
    │           │       └── User.java
    │           └── ApplicationStarter.java
    └── resources
        ├── css
        │   └── styles.css
        └── fxml
            ├── DashboardView.fxml
            ├── MainView.fxml
            ├── ProfileView.fxml
            ├── RegistrationView.fxml
            └── SortingView.fxml

Getting Started
Prerequisites
Java 17 or higher
Maven 3.6.0 or higher
Installation
Clone the repository:  
git clone https://github.com/your-username/your-repo.git
cd your-repo
Build the project using Maven:  
mvn clean install

Running the Application:
1.Start the application:  
2.mvn spring-boot:run
3.The backend will be available at http://localhost:8080.  
4.The frontend will launch as a JavaFX application.  

Usage:
-Login: Use the login form to authenticate.
-Register: Use the registration form to create a new account.
-Dashboard: Access the dashboard to navigate to different features.
-Profile: View and update your profile information.
-Sorting Visualization: Visualize sorting algorithms and submit comments.

API Endpoints
User Endpoints:

-POST /users/register: Register a new user.
-POST /users/login: Login a user.
-GET /users/me: Get the authenticated user's details.
-PUT /users/me: Update the authenticated user's details.
-GET /users: Get all users (Admin only).
-DELETE /users/{id}: Delete a user (Admin only).
-POST /users/upgrade/{id}: Upgrade a user to admin (Admin only).

Contributing:
1.Fork the repository.
2.Create a new branch (git checkout -b feature-branch).
3.Make your changes.
4.Commit your changes (git commit -m 'Add some feature').
5.Push to the branch (git push origin feature-branch).
6.Open a pull request.

License
  This project is licensed under the MIT License - see the LICENSE file for details.  

Acknowledgments
Thanks to the Spring Boot and JavaFX communities for their excellent documentation and support.


Feel free to customize this documentation to better fit your project's specifics.
            
