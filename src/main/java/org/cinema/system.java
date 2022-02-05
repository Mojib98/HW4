package org.cinema;

import javax.xml.crypto.Data;
import java.sql.*;
import java.util.Date;
import java.util.Scanner;

@SuppressWarnings("ALL")
public class system {
    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;
    private User user;
    private Ticket ticket;
    private Cinema cinama;
    private Sell sell;
    private Admin admin;
    private String name;
    private Scanner scanner;
    Date date;
    int countCinema;

    public system() throws SQLException {
      try{
          countCinema =Singleton.getInstance().getInstance();
        this.admin = new Admin();
        this.user = new User();
        this.cinama = new Cinema();
        this.date = new Date();
        this.sell = new Sell();
        this.ticket = new Ticket();
        this.scanner = new Scanner(java.lang.System.in);
        this.countCinema = 0;
    }catch (SQLException e){
          e.printStackTrace();
      }
    }

    public void Start() throws SQLException {

        // private boolean ture;
        boolean isStaer = true;
        while (isStaer) {
            java.lang.System.out.println("if you want sing up please insert 2 else insert other number");
            int su = scanner.nextInt();
            if (su == 2)
                singUp();
                java.lang.System.out.println("please insert your name");
            this.name = scanner.next();
            java.lang.System.out.println("please insert your passcode");
            int pass = scanner.nextInt();
            java.lang.System.out.println("please insert your type between 'u','c'or'a'");
            char t = scanner.next().charAt(0);
            switch (t) {
                case 'a':
                    if (name.equals("admin") && pass == 1) {
                        admin();
                        break;
                    }
                    java.lang.System.out.println("wrong");
                    break;
                case 'c':
                    if (cinama.Iscinamhave(this.name, pass))
                        cinema1();
                    break;

                case 'u':
                    if (user.isUseridntify(this.name, pass))
                        user();
                    break;

                default:
                    continue;
            }

        }


    }

    public void singUpCinema() throws SQLException {
        try{
        java.lang.System.out.println("please insert your name");
        String name = scanner.next();
        System.out.println();
        java.lang.System.out.println("plese insert your passCode");
        int pass = scanner.nextInt();
        java.lang.System.out.println("please insert your address");
        String address = scanner.next();
        java.lang.System.out.println("thank you for sing up please wait our operator idenify your");
        admin.addTo(name, address, pass);
        this.countCinema++;
    }catch (SQLException e){
            e.printStackTrace();
        }

    public void checkCinema() throws SQLException {

            admin.checkCinema();
        }

    public void showCinema()
        {
            admin.showCinema();
        }

    public void insertUser() throws SQLException {

        try {


        java.lang.System.out.println("pleas insert your name");
        String name = scanner.next();
        java.lang.System.out.println("please insert your pass");
        int pass = scanner.nextInt();
        user.insertUser(name, pass);
    }catch (SQLException e){
            e.printStackTrace();
        }}

    public boolean checkUser(String name, int pass) throws SQLException {
        boolean is = user.isUseridntify(name, pass);
        return is;
    }

    public void user() throws SQLException {
        boolean isR = true;
        while (isR) {
            java.lang.System.out.println("for see ticket by name insert 1");
            java.lang.System.out.println("for see ticket by date inser 2");
            java.lang.System.out.println("buying insert 3");
            java.lang.System.out.println("for remove your ticket insert 4");
            java.lang.System.out.println("for see your ticket insert 5");
            int s = scanner.nextInt();
            switch (s) {
                case 1:
                    sell.showAllTicket();
                    java.lang.System.out.println("please insert name");
                    String p = scanner.next();
                    sell.showByName(p);
                    break;
                case 2:
                    sell.showAllTicket();

                case 3:
                    sell.showAllTicket();
                    java.lang.System.out.println("please insert movie");
                    String c = scanner.next();
                    System.out.println("plesse insert cinem name");
                    String cinem=scanner.next();
                    java.lang.System.out.println("please insert number");
                    int n = scanner.nextInt();
                    sell.sellingTicket(this.name,c,cinem,n);
                    break;
                case 4:
                    System.out.println("please insert cinema");
                    String a = scanner.next();
                    java.lang.System.out.println("please insert number");
                    int x = scanner.nextInt();
                    sell.cnacellSell(a, this.name, x);
                case 5:

                    java.lang.System.out.println("please insert movie name");
                    String mv = scanner.next();
                    user.removeTicket(mv, this.name);
                case 6:
                    isR = false;

            }
        }
    }

    public void admin() throws SQLException {
        boolean d = true;
        while (d) {
            java.lang.System.out.println("for see all cinema insert 1");
            java.lang.System.out.println("for check insert 2");
            java.lang.System.out.println("exit 3");
            int s = scanner.nextInt();
            switch (s) {
                case 1:
                    showCinema();
                    break;
                case 2:
                    checkCinema();
                    break;
                case 3:
                    d = false;
                    break;
                default:
                    continue;

            }
        }
    }

    public void cinema1() throws SQLException {
        boolean isrun = true;
        while (isrun) {
            java.lang.System.out.println("for insert ticket press 1");
            java.lang.System.out.println("for remove ticket press 2");
            java.lang.System.out.println("for exit press 3");
            int s = scanner.nextInt();
            if (s == 1) {
                java.lang.System.out.println("insert movie name");
                String movie = scanner.next();
                java.lang.System.out.println("insert number");
                int num = scanner.nextInt();
                java.lang.System.out.println("please insert day of month");
                int d = scanner.nextInt();

                java.lang.System.out.println("please insert hours");
                int h = scanner.nextInt();
                java.lang.System.out.println("please insert min");
                int min = scanner.nextInt();
                this.date.setDate(d);
                this.date.setHours(h);
                this.date.setMinutes(min);
                long time = date.getTime();
                java.sql.Date date1 = new java.sql.Date(time);
                ticket.isertTicket(movie, this.name, date1, num);

            } else if (s == 2) {
                java.lang.System.out.println("please insert movie name");
                String movie = scanner.next();
                ticket.removeTicket(movie, this.name);
                break;
            } else if (s == 3) {
                isrun = false;

            } else continue;

        }
    }

    private void singUp() throws SQLException {
        System.out.println("if you cinema insert 1");
        System.out.println("if you user insert 2");
        int select = scanner.nextInt();
        if (select == 1) {
            if (this.countCinema < 5) {
                try {
                    singUpCinema();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else
                System.out.println("you cant");

        } else if (select == 2) {
            System.out.println("please insert your name");
            String name = scanner.next();
            System.out.println("plese isnser your passcode");
            int pass = scanner.nextInt();
            user.insertUser(name, pass);
            System.out.println("thanks");
        } else
            System.out.println("wrong");
    }
}
