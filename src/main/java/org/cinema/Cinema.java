package org.cinema;

import repository.Singleton;

import java.sql.*;

public class Cinema {
    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;
    private String insertto;
    private int cash;
    public  Cinema() {
        String table = "CREATE TABLE IF NOT EXISTS cinema(" +
                "name varchar(20) primary key," +
                "passcode integer," +
                "address varchar(30)," +
                "cash_desk integer," +
                "id serial," +
                "isActive boolean" +
                ");";
        try {
       connection= Singleton.getInstance().getConnection();

        this.preparedStatement =connection.prepareStatement(table);
        preparedStatement.execute();
    }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void insertCinema(String name,int passCode,String address) {

        this.insertto = "insert into cinema(name,passcode,address,cash_desk) values(?,?,?,?,?);";
        try {
        this.preparedStatement = connection.prepareStatement(insertto);
        this.preparedStatement.setString(1,name);
        this.preparedStatement.setInt(2,passCode);
        this.preparedStatement.setString(3,address);
        this.preparedStatement.setInt(4,0);
        this.preparedStatement.setBoolean(5,false);
        int i = preparedStatement.executeUpdate();
        System.out.println(i);}
        catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void showCinema() {
        String selectSql = "SELECT * FROM cinema";
        try {
        PreparedStatement preparedStatement = connection.prepareStatement(selectSql);
        ResultSet result = preparedStatement.executeQuery();
        while (result.next()){
            System.out.print(result.getString(1)+"\t");
            System.out.print(result.getString(3)+"\t");
            System.out.print(result.getInt(4)+"\t");
            System.out.print(result.getInt(5));
            System.out.println();
        }}
        catch (SQLException e){
            e.printStackTrace();
        }
    }
    public boolean Iscinamhave(String name,int passcode){
        boolean isHere = false;
        try {
            String sql = "SELECT * FROM cinema " +
                    "WHERE name =? and passcode=?";
            this.preparedStatement = connection.prepareStatement(sql);
            this.preparedStatement.setString(1, name);
            this.preparedStatement.setInt(2, passcode);
            isHere = this.preparedStatement.execute();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return isHere;
    }
    public void  activeCinema(String name){
        showCinema();
        try {
        String active="UPDATE cinema set isActive = ? where nama =?";
        this.preparedStatement= connection.prepareStatement(active);
        this.preparedStatement.setBoolean(1,true);

            this.preparedStatement.setString(2,name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
