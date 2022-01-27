package org.cinema;

import javax.swing.*;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Admin {
    private String[] cinames;
    private String[] address;
    private int[] passcode;
    private int index;
    private Cinema cinama;
    Scanner scanner;
    private JProgressBar preparedStatement;

    public Admin() throws SQLException {
        this.cinames = new String[5];
        this.address = new String[5];
        this.passcode = new int[5];
        this.index = 0;
        this.cinama = new Cinema();
        this.scanner = new Scanner(System.in);
    }

    private void addCinema(String name,String address,int passcode ) throws SQLException {
        cinama.insertCinema(name,passcode,address);
    }

    public void checkCinema() throws SQLException {
        for (int i = 0; i < this.index; i++) {
            System.out.println(cinames[i]);
            System.out.println("if want insert please y else n");
            char s = scanner.next().charAt(0);
            System.out.println();
            if (s == 'y') {
                addCinema(this.cinames[i],this.address[i],passcode[i]);
            } else
                continue;
        }
        this.cinames = new String[5];
        this.passcode = new int[5];
        this.address = new String[5];
        this.index = 0;
    }

    public void addTo(String name,String address,int passcode) {
        this. address[index]=address;
        this.passcode[index]=passcode;
        this.cinames[index] = name;
        this.index++;
    }
    public void showCinema() throws SQLException {
        cinama.showCinema();
    }
    public boolean isHaveCinema(String name,int pass) throws SQLException {
        boolean isHave= cinama.Iscinamhave(name, pass);
        return isHave;
    }

}
