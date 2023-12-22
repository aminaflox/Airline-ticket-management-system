package com.example.airlineticketmanagementsys;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class flightDAO {
    private Connection connection;

    public class DatabaseConnection {
        public static Connection getConnection() throws SQLException {
            String url = "jdbc:postgresql://localhost:5432/atms";
            String username = "postgres";
            String password = "*";
            return DriverManager.getConnection(url, username, password);
        }
    }

    public flightDAO() {
        try {
            this.connection = DatabaseConnection.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<flight> searchFlights(String departFrom, String arriveTo) {
        List<flight> flights = new ArrayList<>();
        String query = "SELECT * FROM \"flight\" WHERE \"departFrom\" = ? AND \"arriveTo\" = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, departFrom);
            preparedStatement.setString(2, arriveTo);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    flight flight = new flight();
                    flight.setFlightNo(resultSet.getInt("flightNo"));
                    flight.setArrivalDate(resultSet.getDate("arrivalDate"));
                    flight.setDepartureDate(String.valueOf(resultSet.getDate("departureDate")));
                    flight.setDepartFrom(resultSet.getString("departFrom"));
                    flight.setArriveTo(resultSet.getString("arriveTo"));
                    flight.setAirlineName(resultSet.getString("airlineName"));
                    flight.setDetartTime(resultSet.getTime("detartTime"));
                    flight.setArriveTime(resultSet.getTime("arriveTime"));
                    flight.setTime(resultSet.getString("time"));

                    flights.add(flight);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return flights;
    }
}

