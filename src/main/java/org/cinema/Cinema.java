package org.cinema;

import java.sql.*;

public class Cinema {
    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;
    private String insertto;
    private int cash;
    public  Cinema() throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/mojib", "mojib", "1");
        this.statement = connection.createStatement();
        String table = "CREATE TABLE IF NOT EXISTS cinema(" +
                "name varchar(20) primary key," +
                "passcode integer," +
                "address varchar(30)," +
                "cash_desk integer," +
                "id serial" +
                ");";
        this.preparedStatement =connection.prepareStatement(table);
        preparedStatement.execute();
    }
    public void insertCinema(String name,int passCode,String address) throws SQLException {
        this.insertto = "insert into cinema(name,passcode,address,cash_desk) values(?,?,?,?);";
        this.preparedStatement = connection.prepareStatement(insertto);
        this.preparedStatement.setString(1,name);
        this.preparedStatement.setInt(2,passCode);
        this.preparedStatement.setString(3,address);
        this.preparedStatement.setInt(4,0);
        int i = preparedStatement.executeUpdate();
        System.out.println(i);
    }
    public void showCinema() throws SQLException {
        String selectSql = "SELECT * FROM cinema";
        PreparedStatement preparedStatement = connection.prepareStatement(selectSql);
        ResultSet result = preparedStatement.executeQuery();
        while (result.next()){
            System.out.print(result.getString(1)+"\t");
            System.out.print(result.getString(3)+"\t");
            System.out.print(result.getInt(4)+"\t");
            System.out.print(result.getInt(5));
            System.out.println();
        }
    }
    public boolean Iscinamhave(String name,int passcode) throws SQLException {
        String sql="SELECT * FROM cinema " +
                "WHERE name =? and passcode=?";
        this.preparedStatement=connection.prepareStatement(sql);
        this.preparedStatement.setString(1,name);
        this.preparedStatement.setInt(2,passcode);
        boolean isHere =this.preparedStatement.execute();
        return  isHere;
    }


}
