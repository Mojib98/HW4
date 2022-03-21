package repository;

import Entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class UserRepository {
    private Connection connection =
            Singleton.getObj().getConnection();
    private PreparedStatement preparedStatement;

    public void insertUser(User user) throws SQLException {
        String sql ="INSERT INTO myuser(id, name, passcode, budget) VALUES(default,?,?,?);";
        this.preparedStatement=connection.prepareStatement(sql);
        this.preparedStatement.setString(1,user.getName());
        this.preparedStatement.setInt(2,user.getPassCode());
        this.preparedStatement.setInt(3,user.getBudget());
        this.preparedStatement.execute();
        preparedStatement.close();

    }
    public void buying(int iduser,int idTicket,int number) throws SQLException {
        String sql ="insert into user_ticket(iduser, idticket, number) VALUES (?,?,?)";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,iduser);
        preparedStatement.setInt(2,idTicket);
        preparedStatement.setInt(2,number);
        preparedStatement.execute();
        preparedStatement.close();
    }
    public void cancell(int userId,int ticketId) throws SQLException {
        String sql ="delete from user_ticket where iduser=? and idticket";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,userId);
        preparedStatement.setInt(2,ticketId);
        preparedStatement.execute();
        preparedStatement.close();
        }
}
