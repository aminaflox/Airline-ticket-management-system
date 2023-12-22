package com.example.airlineticketmanagementsys;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookDAO {
    private Connection connection;
    public BookDAO(Connection connection) {
        this.connection = connection;
    }
    public boolean bookFlight(book booking) {
        String query = "INSERT INTO \"book\" ( flightN, userId, userName) VALUES ( ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(2, booking.getFlightN());
            preparedStatement.setInt(3, booking.getUserId());
            preparedStatement.setString(4, booking.getUserName());

            int rowsAffected = preparedStatement.executeUpdate();

            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

