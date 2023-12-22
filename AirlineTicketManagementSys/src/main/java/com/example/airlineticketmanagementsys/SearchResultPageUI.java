package com.example.airlineticketmanagementsys;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

public class SearchResultPageUI {

    public void showResults(List<flight> flights) {
        Stage primaryStage = new Stage();

        // Create the grid pane for the search result page
        GridPane resultGrid = createResultPage(flights);

        // Set up the new scene
        Scene resultScene = new Scene(resultGrid, 800, 600);

        // Set the new scene to the primary stage
        primaryStage.setTitle("Flight Search Results");
        primaryStage.setScene(resultScene);
        primaryStage.show();
    }

    private GridPane createResultPage(List<flight> flights) {
        // Create the table view for displaying flight results
        TableView<flight> tableView = new TableView<>();
        tableView.setItems(javafx.collections.FXCollections.observableArrayList(flights));

        // Create table columns
        TableColumn<flight, Integer> flightNoCol = new TableColumn<>("Flight No");
        flightNoCol.setCellValueFactory(new PropertyValueFactory<>("flightNo"));

        TableColumn<flight, Date> arrivalDateCol = new TableColumn<>("Arrival Date");
        arrivalDateCol.setCellValueFactory(new PropertyValueFactory<>("arrivalDate"));

        TableColumn<flight, Date> departureDateCol = new TableColumn<>("Departure Date");
        departureDateCol.setCellValueFactory(new PropertyValueFactory<>("departureDate"));

        TableColumn<flight, String> departFromCol = new TableColumn<>("Depart From");
        departFromCol.setCellValueFactory(new PropertyValueFactory<>("departFrom"));

        TableColumn<flight, String> arriveToCol = new TableColumn<>("Arrive To");
        arriveToCol.setCellValueFactory(new PropertyValueFactory<>("arriveTo"));

        TableColumn<flight, String> airlineNameCol = new TableColumn<>("Airline Name");
        airlineNameCol.setCellValueFactory(new PropertyValueFactory<>("airlineName"));

        TableColumn<flight, Time> departTimeCol = new TableColumn<>("Depart Time");
        departTimeCol.setCellValueFactory(new PropertyValueFactory<>("detartTime"));

        TableColumn<flight, Time> arriveTimeCol = new TableColumn<>("Arrive Time");
        arriveTimeCol.setCellValueFactory(new PropertyValueFactory<>("arriveTime"));

        TableColumn<flight, String> timeCol = new TableColumn<>("Time");
        timeCol.setCellValueFactory(new PropertyValueFactory<>("time"));

        // Add columns to the table
        tableView.getColumns().addAll(
                flightNoCol, arrivalDateCol, departureDateCol,
                departFromCol, arriveToCol, airlineNameCol,
                departTimeCol, arriveTimeCol, timeCol
        );

        // Create grid pane and set layout
        GridPane resultGrid = new GridPane();
        resultGrid.setPadding(new Insets(10, 10, 10, 10));
        resultGrid.setVgap(8);
        resultGrid.setHgap(10);

        // Add components to grid
        GridPane.setConstraints(tableView, 0, 0);

        resultGrid.getChildren().addAll(tableView);

        return resultGrid;
    }
}

