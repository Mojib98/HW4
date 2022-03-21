package repository;

import Entity.Cinema;
import Entity.Ticket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CinemaRepository {
    private Connection connection =
            Singleton.getInstance().getConnection();
    private PreparedStatement preparedStatement;
    public void singUp(Cinema cinema) throws SQLException {
        String sql="insert into cinema(id, name, passcode, address, active) values (default,?,?,?,default)";
        preparedStatement= connection.prepareStatement(sql);
        preparedStatement.setString(1,cinema.getName());
        preparedStatement.setInt(2,cinema.getPasscode());
        preparedStatement.setString(3,cinema.getAddres());
//        preparedStatement.setBoolean(4,false);
        preparedStatement.execute();
        preparedStatement.close();
    }
    public void insertTicket(Ticket ticket) throws SQLException {
        String sql="insert into ticket(cinemaname, price, number, namemovie, date, time) VALUES (?,?,?,?,?,?)";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,ticket.getCinemaName());
        preparedStatement.setInt(2,ticket.getPrice());
        preparedStatement.setInt(3,ticket.getNumber());
        preparedStatement.setDate(5,ticket.getDate());
        preparedStatement.setTime(6,ticket.getTime());
        preparedStatement.setString(4,ticket.getMovieName());
        preparedStatement.execute();
        preparedStatement.close();
    }
    public void removeTicke(Ticket ticket){

    }
    public List<Ticket> myTicket(String name) throws SQLException {
        List<Ticket> list = new ArrayList<>();
        String sql = "select * from ticket " +
                "where cinemaname =?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,name);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Ticket ticket = new Ticket();
            ticket.setId(resultSet.getInt(1));
            ticket.setCinemaName(resultSet.getString(2));
            ticket.setPrice(resultSet.getInt(3));
            ticket.setNumber(resultSet.getInt(4));
            ticket.setDate(resultSet.getDate(6));
            ticket.setMovieName(resultSet.getString(5));
            list.add(ticket);
        }
        preparedStatement.close();
        return list;

    }
    public String findName(int id) throws SQLException {
        String sql = "select name from cinema where id=?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,id);
        ResultSet resultSet=preparedStatement.executeQuery();
        resultSet.next();
        return resultSet.getString(1);
    }

}
