package org.cinema;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AdminDatabase {
    public Connection connection;
    PreparedStatement preparedStatement;

    public AdminDatabase() {
        connection = Singleton.getInstance().getConnection();
    }


}
