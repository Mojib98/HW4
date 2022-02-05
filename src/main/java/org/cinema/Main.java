package org.cinema;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        try {

        system system =new system();
    //    system.insertUser();
        system.Start();
    }catch (SQLException e){
            e.printStackTrace();
        }}
}
