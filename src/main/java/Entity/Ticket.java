package Entity;

import java.sql.Timestamp;

public class Ticket {
    private String cinemaName;
    private int price,number,id;
    private Timestamp timestamp;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCinemaName() {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public Ticket() {
    }

    public Ticket(String cinemaName, int price, int number, Timestamp timestamp) {
        this.cinemaName = cinemaName;
        this.price = price;
        this.number = number;
        this.timestamp = timestamp;
    }
}
