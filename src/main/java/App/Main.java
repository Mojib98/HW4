package App;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        CinemaApp cinemaApp = new CinemaApp();
        cinemaApp.insertTicket();

    }
}
