package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl extends Util implements UserService {
    Connection connection = getConnection();

    public void createUsersTable() throws ClassNotFoundException, SQLException {
        Util s = new Util();
        try (Statement statement = s.getConnection().createStatement()) {
            String SQL = "CREATE TABLE maven.Users " +
                    "(id INTEGER not NULL AUTO_INCREMENT, " +
                    " name VARCHAR(45), " +
                    " lastName VARCHAR (45), " +
                    " age INTEGER, " +
                    " PRIMARY KEY (id))";
            statement.executeUpdate(SQL);
        }
    }

    public void dropUsersTable() throws ClassNotFoundException, SQLException {
        Util s = new Util();
        try (Statement statement = s.getConnection().createStatement()) {
            String SQL = "DROP TABLE maven.Users";
            statement.executeUpdate(SQL);
        } catch (SQLException e) {
            e.getStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) throws SQLException, ClassNotFoundException {
        Util s = new Util();
        String query = "INSERT INTO maven.Users (name, lastName, age) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = s.getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setInt(3, age);
            int affectedRows = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.getStackTrace();
        }
    }

    public void removeUserById(long id) throws ClassNotFoundException, SQLException {
        Util s = new Util();
        String query = "DELETE FROM Users WHERE id = " + id;
        try (PreparedStatement preparedStatement = s.getConnection().prepareStatement(query)) {
            int affectedRows = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.getStackTrace();
        }
    }

    public List<User> getAllUsers() throws SQLException {
        Util s = new Util();
        List<User> users = new ArrayList<>();
        String sql = "SELECT name, lastName, age FROM Users";
        try (Statement statement = s.getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                User user = new User();
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("lastName"));
                user.setAge(resultSet.getByte("age"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.getStackTrace();
        }
        return users;
    }

    public void cleanUsersTable() throws SQLException, ClassNotFoundException {
        Util s = new Util();
        try (Statement statement = s.getConnection().createStatement()) {
            String sql = "DELETE FROM Users";
            statement.executeUpdate(sql);
        }
    }
}
