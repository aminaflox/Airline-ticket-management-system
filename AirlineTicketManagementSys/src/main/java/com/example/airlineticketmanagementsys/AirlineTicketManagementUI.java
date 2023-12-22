package com.example.airlineticketmanagementsys;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class AirlineTicketManagementUI extends Application {

    private userDAO userDAO;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        userDAO = new userDAO();

        GridPane grid = createLoginForm(primaryStage);

        Scene scene = new Scene(grid, 300, 200);
        primaryStage.setTitle("Airline Ticket Management System - Login");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private GridPane createLoginForm(Stage primaryStage) {

        Label usernameLabel = new Label("Username:");
        TextField usernameField = new TextField();

        Label passwordLabel = new Label("Password:");
        PasswordField passwordField = new PasswordField();

        Button loginButton = new Button("Login");
        loginButton.setOnAction(e -> handleLogin(usernameField.getText(), passwordField.getText(), primaryStage));

        Button signUpButton = new Button("Sign Up");
        signUpButton.setOnAction(e -> showRegistrationForm(primaryStage));

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        GridPane.setConstraints(usernameLabel, 0, 0);
        GridPane.setConstraints(usernameField, 1, 0);
        GridPane.setConstraints(passwordLabel, 0, 1);
        GridPane.setConstraints(passwordField, 1, 1);
        GridPane.setConstraints(loginButton, 1, 2);
        GridPane.setConstraints(signUpButton, 1, 3);

        grid.getChildren().addAll(usernameLabel, usernameField, passwordLabel, passwordField, loginButton, signUpButton);

        return grid;
    }



    private void handleLogin(String username, String password,  Stage primaryStage) {
        if (userDAO.isLoginSuccessful(username, password)) {
            System.out.println("Login successful!");
            launchSearchPage(primaryStage);
        } else {
            showError("Login failed. Invalid credentials.");
        }
    }

    private void showRegistrationForm(Stage primaryStage) {
        GridPane registrationGrid = createRegistrationForm(primaryStage);

        Scene registrationScene = new Scene(registrationGrid, 300, 250);
        primaryStage.setScene(registrationScene);
    }

    private GridPane createRegistrationForm(Stage primaryStage) {
        // Create UI components
        Label usernameLabel = new Label("Username:");
        TextField usernameField = new TextField();

        Label emailLabel = new Label("Email:");
        TextField emailField = new TextField();

        Label firstnameLabel = new Label("First Name:");
        TextField firstnameField = new TextField();

        Label lastnameLabel = new Label("Last Name:");
        TextField lastnameField = new TextField();

        Label passwordLabel = new Label("Password:");
        PasswordField passwordField = new PasswordField();

        Button registerButton = new Button("Register");
        registerButton.setOnAction(e -> handleRegistration(
                usernameField.getText(),
                emailField.getText(),
                firstnameField.getText(),
                lastnameField.getText(),
                passwordField.getText(), primaryStage
        ));

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        GridPane.setConstraints(usernameLabel, 0, 0);
        GridPane.setConstraints(usernameField, 1, 0);
        GridPane.setConstraints(emailLabel, 0, 1);
        GridPane.setConstraints(emailField, 1, 1);
        GridPane.setConstraints(firstnameLabel, 0, 2);
        GridPane.setConstraints(firstnameField, 1, 2);
        GridPane.setConstraints(lastnameLabel, 0, 3);
        GridPane.setConstraints(lastnameField, 1, 3);
        GridPane.setConstraints(passwordLabel, 0, 4);
        GridPane.setConstraints(passwordField, 1, 4);
        GridPane.setConstraints(registerButton, 1, 5);

        grid.getChildren().addAll(
                usernameLabel, usernameField,
                emailLabel, emailField,
                firstnameLabel, firstnameField,
                lastnameLabel, lastnameField,
                passwordLabel, passwordField,
                registerButton
        );

        return grid;
    }

    private void handleRegistration(String username, String email, String firstname, String lastname, String password, Stage primaryStage) {
        user newUser = new user();
        newUser.setUsername(username);
        newUser.setEmail(email);
        newUser.setFirstName(firstname);
        newUser.setLastName(lastname);
        newUser.setPassword(password);

        if (userDAO.registerUser(newUser)) {
            System.out.println("Registration successful!");
            launchSearchPage(primaryStage);
        } else {
            showError("Registration failed. Please try again.");
        }
    }
    private void showError(String errorMessage) {
        System.out.println("Error: " + errorMessage);
    }


    private void launchSearchPage(Stage primaryStage) {
        SearchPageUI searchPageUI = new SearchPageUI();
        searchPageUI.start(primaryStage);
    }

    @Override
    public void stop() {
        userDAO.closeConnection();
    }
}
