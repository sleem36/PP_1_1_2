package jm.task.core.jdbc.service;

import jm.task.core.jdbc.model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserService {
    void createUsersTable() throws ClassNotFoundException, SQLException;

    void dropUsersTable() throws ClassNotFoundException, SQLException;

    void saveUser(String name, String lastName, byte age) throws SQLException, ClassNotFoundException;

    void removeUserById(long id) throws ClassNotFoundException, SQLException;

    List<User> getAllUsers() throws SQLException;

    void cleanUsersTable() throws SQLException, ClassNotFoundException;
}
