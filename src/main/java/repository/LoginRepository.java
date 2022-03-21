package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginRepository {
    private Connection connection =
            Singleton.getInstance().getConnection();
    private PreparedStatement preparedStatement;
    public boolean cinema(int id,int passcdoe) throws SQLException {
        String sql="select count(*) from cinema " +
                "where id=? and passcode=? and active=?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,id);
        preparedStatement.setInt(2,passcdoe);
        preparedStatement.setBoolean(3,true);
        ResultSet resultSet = preparedStatement.getResultSet();
        if (resultSet.getInt(1)==1){
            return true;
        }else return false;
    }
    public boolean user(int id,int passcdoe) throws SQLException {
        String sql="select count(*) from myuser " +
                "where id=? and passcode=?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,id);
        preparedStatement.setInt(2,passcdoe);
        ResultSet resultSet = preparedStatement.getResultSet();
        if (resultSet.getInt(1)==1){
            return true;
        }else return false;
    }
}
