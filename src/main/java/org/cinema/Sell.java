/*
package org.cinema;

import repository.Singleton;

import javax.xml.crypto.Data;
import java.sql.*;
import java.sql.ResultSet;

public class Sell {
    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;
    User user;

    public Sell() {
        this.connection = Singleton.getInstance().getConnection();
        this.user = new User();
    }

    public void showAllTicket() {
        String sql = "SELECT * FROM ticket";
        try {
            this.preparedStatement = connection.prepareStatement(sql);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                System.out.print(result.getString(1) + "\t");
                System.out.print(result.getString(2) + "\t");
                System.out.print(result.getDate(3) + "\t");
                System.out.print(result.getInt(4));
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void showByDate(Data date) {
        String sql = "SELECT * FROM ticket" +
                "WHERE time = ?";
        try {
            this.preparedStatement = connection.prepareStatement(sql);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                System.out.print(result.getString(1) + "\t");
                System.out.print(result.getString(2) + "\t");
                System.out.print(result.getDate(3) + "\t");
                System.out.print(result.getInt(4));
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void showByName(String name) throws SQLException {
        String sql = "SELECT * FROM ticket " +
                "WHERE name =?";
        try {
            this.preparedStatement = connection.prepareStatement(sql);
            this.preparedStatement.setString(1, name);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                System.out.print(result.getString(1) + "\t");
                System.out.print(result.getString(2) + "\t");
                System.out.print(result.getDate(3) + "\t");
                System.out.print(result.getInt(4));
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void showDateAndName() {
    }

    public void cnacellSell(String cinema, String name, int number) throws SQLException {
        String sql = "SELECT number from ticket" +
                "where cinema =? and namemovie =?;";
        try {
            this.preparedStatement = connection.prepareStatement(sql);
            this.preparedStatement.setString(1, cinema);
            this.preparedStatement.setString(2, name);
            ResultSet resultSet = this.preparedStatement.executeQuery();
            int s = resultSet.getInt("number");
            s += number;
            String sql1 = "UPDATE ticket" +
                    "number =?" +
                    "where name =? and cinema =?";
            this.preparedStatement.setInt(1, s);
            this.preparedStatement.setString(2, cinema);
            this.preparedStatement.setString(3, name);
            this.preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void sellingTicket(String userNmaw, String name, String cinema, int number) throws SQLException {
        String sql = "SELECT  number from ticket" +
                "where namemovie =? and cinema=?;";
        try {

            this.preparedStatement = connection.prepareStatement(sql);
            this.preparedStatement.setString(1, name);
            this.preparedStatement.setString(2, cinema);
            //this.preparedStatement.setString(2, cinema);
            ResultSet resultSet = this.preparedStatement.executeQuery();
            resultSet.next();
            int s = resultSet.getInt(1);
            s -= number;
            String sql1 = "UPDATE ticket" +
                    "number =?" +
                    "where name =? and cinema =?";
            this.preparedStatement.setInt(1, s);
            this.preparedStatement.setString(2, cinema);
            this.preparedStatement.setString(3, name);
            this.preparedStatement.execute();
            this.user.insertTi(userNmaw, name, cinema, number);

        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}*/
