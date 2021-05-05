package com.steve.self_facebook.utilities;

import java.sql.*;

public class ConnectionManager {
    private static Connection con;
    public static Connection getConnection()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
           // con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Facebook_db","root","Joy2Dworld");
            con = DriverManager.getConnection("jdbc:mysql://localhost/Facebook_db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","Joy2Dworld");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

}
