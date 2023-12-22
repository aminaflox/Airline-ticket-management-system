package com.example.airlineticketmanagementsys;

import java.time.LocalDate;
import java.util.Date;

public class book {
    public int getBookId() {
        return bookId;
    }
    public void setBookId(int bookId) {
        this.bookId = bookId;
    }
    public Date getBookingDate() {
        return bookingDate;
    }
    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public int getFlightN() {
        return flightN;
    }
    public void setFlightN(int flightN) {
        this.flightN = flightN;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }


    private int bookId;
    private Date bookingDate;
    private int userId;
    private int flightN;
    private String userName;

    public void setBookingDate(LocalDate now) {
    }
}
