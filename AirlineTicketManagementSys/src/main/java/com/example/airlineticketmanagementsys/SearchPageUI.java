package com.example.airlineticketmanagementsys;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import java.util.List;

public class SearchPageUI extends Application {
    private flightDAO flightDAO;
    private TableView<flight> flightTableView;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        flightDAO = new flightDAO();

        GridPane gridPane = createSearchPage(primaryStage);

        Scene scene = new Scene(gridPane, 600, 400);
        primaryStage.setTitle("Flight Search Page");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private GridPane createSearchPage(Stage primaryStage) {
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(20);
        gridPane.setHgap(15);

        Label departureLabel = new Label("Departure:");
        TextField departureField = new TextField();

        Label destinationLabel = new Label("Destination:");
        TextField destinationField = new TextField();

        Button searchButton = new Button("Search");
        searchButton.setOnAction(e -> handleSearch(departureField.getText(), destinationField.getText()));

        flightTableView = new TableView<>();  // Initialize TableView

        TableColumn<flight, Integer> flightNoCol = new TableColumn<>("Flight No");
        flightNoCol.setCellValueFactory(new PropertyValueFactory<>("flightNo"));

        TableColumn<flight, String> departureDateCol = new TableColumn<>("Departure Date");
        departureDateCol.setCellValueFactory(new PropertyValueFactory<>("departureDate"));

        TableColumn<flight, String> departfromCol = new TableColumn<>("Departure");
        departfromCol.setCellValueFactory(new PropertyValueFactory<>("departFrom"));

        TableColumn<flight, String> flightDestinationCol = new TableColumn<>("Destination");
        flightDestinationCol.setCellValueFactory(new PropertyValueFactory<>("arriveTo"));

        TableColumn<flight, String> airlineNameCol = new TableColumn<>("Airline");
        airlineNameCol.setCellValueFactory(new PropertyValueFactory<>("airlineName"));

        TableColumn<flight, String> departTimeCol = new TableColumn<>("Depart Time");
        departTimeCol.setCellValueFactory(new PropertyValueFactory<>("detartTime"));

        TableColumn<flight, String> arriveTimeCol = new TableColumn<>("Arrive Time");
        arriveTimeCol.setCellValueFactory(new PropertyValueFactory<>("arriveTime"));

        flightTableView.getColumns().addAll(flightNoCol, departureDateCol, departfromCol, flightDestinationCol, airlineNameCol, departTimeCol, arriveTimeCol);

        Button bookFlightButton = new Button("Book Selected Flight");
        bookFlightButton.setOnAction(e -> handleBooking());

        GridPane.setConstraints(departureLabel, 0, 0);
        GridPane.setConstraints(departureField, 1, 0);
        GridPane.setConstraints(destinationLabel, 0, 1);
        GridPane.setConstraints(destinationField, 1, 1);
        GridPane.setConstraints(searchButton, 1, 2);
        GridPane.setConstraints(flightTableView, 0, 3, 2, 1);
        GridPane.setConstraints(bookFlightButton, 1, 4);

        gridPane.getChildren().addAll(departureLabel, departureField, destinationLabel, destinationField, searchButton, flightTableView, bookFlightButton);

        return gridPane;
    }

    private void handleSearch(String departure, String destination) {
        List<flight> flights = flightDAO.searchFlights(departure, destination);

        flightTableView.getItems().clear();

        ObservableList<flight> flightList = FXCollections.observableArrayList(flights);

        flightTableView.setItems(flightList);
    }

    private void handleBooking() {
        flight selectedFlight = flightTableView.getSelectionModel().getSelectedItem();

        if (selectedFlight != null) {
            System.out.println("Booking flight: " + selectedFlight.getFlightNo());
        } else {
            System.out.println("No flight selected for booking.");
        }
    }
}
