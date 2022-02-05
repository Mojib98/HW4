package org.cinema;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import java.sql.*;

public class User {
    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;

    public User()  {
       try {
           connection = Singleton.getObj().getConnection();
           String creatTableUsersql = "CREATE TABLE if not exists  user1(" +
                   "name varchar(20)," +
                   "pass integer ," +
                   "idu serial);";
           this.preparedStatement = connection.prepareStatement(creatTableUsersql);
           this.preparedStatement.execute();
           String createTableTickitUser = "CREATE TABLE IF NOT EXISTS ticketuser(" +
                   "userName varchar(20)," +
                   "cinema varchar(20)," +
                   "movieName varchar(20)," +
                   "number1 integer," +
                   "userid integer);";
           this.preparedStatement = connection.prepareStatement(createTableTickitUser);
           this.preparedStatement.execute();
       }
       catch (SQLException e){
           e.printStackTrace();
       }
    }

    public void insertTi(String name, String nameMovie, String cinemaName, int number) throws SQLException {
        try{
        int id = id(name);
        String sqlInsert = "INSERT INTO ticketuser(userName,cinema,movieName,number,userid) VALUES(?,?,?,?,?);";
        this.preparedStatement = connection.prepareStatement(sqlInsert);
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, nameMovie);
        preparedStatement.setString(3, cinemaName);
        preparedStatement.setInt(4, number);
        preparedStatement.setInt(5, id);
        preparedStatement.executeUpdate();
    }catch (SQLException e){
            e.printStackTrace();
        }}

    public int id(String name) throws SQLException {
        String returnId = "SELECT id FROM user1" +
                "WHERE name =?";
        this.preparedStatement = connection.prepareStatement(returnId);
        preparedStatement.setString(1, name);
        ResultSet result = preparedStatement.executeQuery();
        int s = result.getInt("id");
        return s;
    }

    public void removeTicket(String nameMovie, String name) throws SQLException {
        String deleteTicket = "DELETE FROM ticketuser " +
                "WHERE nameMovie = ? and id = ?";
        this.preparedStatement = connection.prepareStatement(deleteTicket);
        preparedStatement.setString(1,nameMovie);
        preparedStatement.setString(2, name);
        preparedStatement.executeQuery();
    }
    /*
        public int ids(String name) throws SQLException {
            String returnId = "SELECT id FROM user" +
                    "WHERE name =?";
            this.preparedStatement = connection.prepareStatement(returnId);
            preparedStatement.setString(1, name);
            ResultSet result = preparedStatement.executeQuery();
            int s = result.getInt("id");
            return s;
        }*/
    public void insertUser(String name , int passcode) throws SQLException {
        String sql ="INSERT INTO user1(name,pass) VALUES(?,?);";
        this.preparedStatement=connection.prepareStatement(sql);
        this.preparedStatement.setString(1,name);
        this.preparedStatement.setInt(2,passcode);
        this.preparedStatement.execute();

    }
    public boolean isUseridntify(String name,int passcode) throws SQLException {
        String sql="SELECT * FROM user1 " +
                "WHERE name =? and pass=?";
        this.preparedStatement=connection.prepareStatement(sql);
        this.preparedStatement.setString(1,name);
        this.preparedStatement.setInt(2,passcode);
        return this.preparedStatement.execute();
    }
}
