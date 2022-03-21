package repository;

import Entity.Cinema;
import Entity.Ticket;
import Entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminRepository {
    private Connection connection =
            Singleton.getInstance().getConnection();
    private PreparedStatement preparedStatement;
    public void activatingCinema(String name) throws SQLException {
        String sql="update cinema set active=? " +
                "where name=?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setBoolean(1,true);
        preparedStatement.setString(2,name);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }
    public void deactivatingCinema(String name) throws SQLException {
        String sql="update cinema set active=? " +
                "where name=?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setBoolean(1,false);
        preparedStatement.setString(2,name);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }
    public List<Cinema> allCinemr() throws SQLException {
        List<Cinema> list =new ArrayList<>();
        String sql ="select * from cinema";
        preparedStatement =connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.getResultSet();
        while (resultSet.next()){
            Cinema cinema = new Cinema();
            cinema.setName(resultSet.getString(2));
            cinema.setId(resultSet.getLong(1));
            cinema.setPasscode(resultSet.getInt(3));
            cinema.setAddres(resultSet.getString(4));
            cinema.setStatus(resultSet.getBoolean(5));
            list.add(cinema);
        }
        preparedStatement.close();
        return list;
    }
    public List<User> allUser() throws SQLException {
        List<User> list =new ArrayList<>();
        String sql ="select * from myuser";
        preparedStatement =connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.getResultSet();
        while (resultSet.next()){
            User user = new User();
            user.setId(resultSet.getInt(1));
            user.setName(resultSet.getString(2));
            user.setPassCode(resultSet.getInt(3));
            user.setBudget(resultSet.getInt(4));
            list.add(user);
        }
        preparedStatement.close();
        return list;
    }
    public List<Ticket> allTicket() throws SQLException {
        List<Ticket> list = new ArrayList<>();
        String sql = "select * from ticket";
        preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.getResultSet();
        while (resultSet.next()) {
            Ticket ticket = new Ticket();
            ticket.setId(resultSet.getInt(1));
            ticket.setCinemaName(resultSet.getString(2));
            ticket.setPrice(resultSet.getInt(3));
            ticket.setNumber(resultSet.getInt(4));
            ticket.setDate(resultSet.getDate(5));
            ticket.setMovieName(resultSet.getString(6));
            list.add(ticket);
        }
        preparedStatement.close();
        return list;
    }


}
