package UserDB;

import java.sql.SQLException;

public interface IRepositoryUser {

    void open() throws SQLException;
    void close() throws SQLException;
    boolean insertUser (User user) throws SQLException;
    boolean removeUser(String username) throws SQLException;
    boolean changeUserData(String oldUsername, String newUsername, String newPassword) throws SQLException;
    boolean checkLoginData(String username, String password) throws SQLException;
    int getUserIdForUsername(String username) throws SQLException;

}
