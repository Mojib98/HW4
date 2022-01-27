package org.cinema;
import java.util.Date;
import java.sql.Time;
import javax.xml.crypto.Data;
import java.sql.*;

public class Ticket {
    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;
    private String insertto;


    public Ticket() throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/mojib", "mojib", "1");
        this.statement = connection.createStatement();
        String table = "create table if not exists ticket(" +
                "nameMovie varchar(20), " +
                "cinema varchar(20)," +
                "dates date," +
                "number integer " +
                ");";
        this.preparedStatement = connection.prepareStatement(table);
        this.preparedStatement.execute();

    }

    public void isertTicket(String name, String cinema, java.sql.Date date, int number) throws SQLException {
        this.insertto = "insert into ticket(nameMovie,cinema,times,number) values(?,?,?,?);";
        try{
        this.preparedStatement = connection.prepareStatement(insertto);
        this.preparedStatement.setString(1, name);
        this.preparedStatement.setString(2, cinema);
        this.preparedStatement.setDate(3,  date);
       // this.preparedStatement.setDate(4,  time);
        this.preparedStatement.setInt(4, number);
        this.preparedStatement.executeUpdate();
    }catch (SQLException e){
            e.printStackTrace();
        }}



    public void removeTicket(String cinema,String name) throws SQLException {
        try {
        if (isCheckTime(cinema,name)) {
            String sql = "DELETE FROM ticket " +
                    "WHERE cinema =? and nameMovie = ?";
            this.preparedStatement = connection.prepareStatement(sql);
            this.preparedStatement.setString(1, cinema);
            this.preparedStatement.setString(2, name);
            this.preparedStatement.executeUpdate();
        }
        else
            System.out.println("cant remove");

    }catch (SQLException e ){
            e.printStackTrace();
        }}
    public boolean isCheckTime(String cinema,String name) throws SQLException {
        String sql ="SELECT date from ticket " +
                "where movieName and cinema =?;";
        try {
        this.preparedStatement = connection.prepareStatement(sql);
        this.preparedStatement.setString(1, name);
        this.preparedStatement.setString(2, cinema);
        ResultSet resultSet= this.preparedStatement.executeQuery();
        Date date=resultSet.getDate("date");
        Date date1=new Date();
        if(date.after(date1))
            return false;
        else
            return true;
    }catch (SQLException e){
            e.printStackTrace();
        }
    }

}
