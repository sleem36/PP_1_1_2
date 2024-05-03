package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class Util {
    // реализуйте настройку соеденения с БД
    private static final String DB_URL = "jdbc:mysql://localhost/maven";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "";
    public Connection getConnection () {
        Connection connection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            System.out.println("Connection to User DB succesfull!");
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Connection ERROR!");
        }
        return connection;
    }
}
//    public static void main(String[] args) {
//        final String DB_URL = "jdbc:mysql://localhost/maven";
//        final String DB_USERNAME = "root";
//        final String DB_PASSWORD = "";
//
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
//            try (Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
//
//                System.out.println("Connection to Store DB succesfull!");
//            }
//        } catch (Exception ex) {
//            System.out.println("Connection failed...");
//
//            System.out.println(ex);
//
//        }
//    }
//}
