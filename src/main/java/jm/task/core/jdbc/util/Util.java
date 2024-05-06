package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class Util {
    // реализуйте настройку соеденения с БД
    private static final String DB_URL = "jdbc:mysql://localhost/maven";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "";
    public static Connection getConnection () {
        Connection connection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
           // System.out.println("Connection to User DB succesfull!");
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Connection ERROR!");
        }
        return connection;
    }
}
