package com.example.airlineticketmanagementsys;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;

public class BookPageUI extends Application {
    private BookDAO bookDAO;
    private TextField flightNumberField;
    private TextField userIdField;
    private TextField userNameField;

    public static void main(String[] args) {
        launch(args);
    }
    private Connection getDatabaseConnection() {
        try {
            String url = "jdbc:postgresql://localhost:5432/atms";
            String username = "postgres";
            String password = "mina2002";
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to connect to the database", e);
        }
    }

    @Override
    public void start(Stage primaryStage) {
        // Assume you have a database connection
        Connection connection = getDatabaseConnection();

        // Initialize BookDAO with the database connection
        bookDAO = new BookDAO(connection);

        GridPane gridPane = createBookPage(primaryStage);

        Scene scene = new Scene(gridPane, 400, 300);
        primaryStage.setTitle("Book Flight Page");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private GridPane createBookPage(Stage primaryStage) {
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(20);
        gridPane.setHgap(15);

        Label flightNumberLabel = new Label("Flight Number:");
        flightNumberField = new TextField();

        Label userIdLabel = new Label("User ID:");
        userIdField = new TextField();

        Label userNameLabel = new Label("User Name:");
        userNameField = new TextField();

        Button bookButton = new Button("Book Flight");
        bookButton.setOnAction(e -> handleBooking());

        GridPane.setConstraints(flightNumberLabel, 0, 0);
        GridPane.setConstraints(flightNumberField, 1, 0);
        GridPane.setConstraints(userIdLabel, 0, 1);
        GridPane.setConstraints(userIdField, 1, 1);
        GridPane.setConstraints(userNameLabel, 0, 2);
        GridPane.setConstraints(userNameField, 1, 2);
        GridPane.setConstraints(bookButton, 1, 3);

        gridPane.getChildren().addAll(flightNumberLabel, flightNumberField, userIdLabel, userIdField, userNameLabel, userNameField, bookButton);

        return gridPane;
    }

    private void handleBooking() {
        try {
            // Get user inputs
            int flightNumber = Integer.parseInt(flightNumberField.getText());
            int userId = Integer.parseInt(userIdField.getText());
            String userName = userNameField.getText();

            // Create a book object with the current date
            book booking = new book();
            booking.setBookingDate(LocalDate.now());
            booking.setFlightN(flightNumber);
            booking.setUserId(userId);
            booking.setUserName(userName);

            // Attempt to book the flight
            boolean bookingSuccess = bookDAO.bookFlight(booking);

            if (bookingSuccess) {
                System.out.println("Flight booked successfully!");
            } else {
                System.out.println("Failed to book the flight.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter valid numbers for Flight Number and User ID.");
        }
    }


}
