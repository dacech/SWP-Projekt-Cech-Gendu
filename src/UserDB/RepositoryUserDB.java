package UserDB;

import java.sql.*;

public class RepositoryUserDB implements IRepositoryUser {

    private String url = "jdbc:mysql://localhost/user_db";
    private String user = "root";

    //Johny
    private String pwd = "joniii999";
    //Cech
    //private String pwd = "Sky39###";

    private Connection _connection;

    public RepositoryUserDB() throws ClassNotFoundException {
        Class<?> c = Class.forName("com.mysql.cj.jdbc.Driver");
        if(c != null){

        }
    }

    @Override
    public void open() throws SQLException {
        this._connection = DriverManager.getConnection(url, user, pwd);

    }

    @Override
    public void close() throws SQLException {
        if ((this._connection != null) && (!this._connection.isClosed())){
            this._connection.close();

        }
    }

    @Override
    public boolean insertUser(User user) throws SQLException {
        PreparedStatement pStmt = this._connection.prepareStatement("insert into user values(null, ?, ?)");

        pStmt.setString(1, user.getUsername());
        pStmt.setString(2, user.getPassword());

        return pStmt.executeUpdate() == 1;
    }

    @Override
    public boolean removeUser(String username) throws SQLException {
        PreparedStatement pStmt = this._connection.prepareStatement("delete from user where username = ?");

        pStmt.setString(1, username);

        return pStmt.executeUpdate() == 1;
    }

    @Override
    public boolean changeUserData(String oldUsername, String newUsername, String newPassword) throws SQLException {
        //überprüfen ob es den neuen usernamen schon gibt
        PreparedStatement pStmt = this._connection.prepareStatement("update user set username = ?, password= ? where username = ?");

        pStmt.setString(1, newUsername);
        pStmt.setString(2, newPassword);
        pStmt.setString(3, oldUsername);

        return pStmt.executeUpdate() == 1;
    }

    @Override
    public boolean checkLoginData(String username, String password) throws SQLException {
        PreparedStatement pStmt = this._connection.prepareStatement("select * from user where username = ? and password = ?");

        User u = new User();
        pStmt.setString(1, username);
        pStmt.setString(2, password);

        ResultSet result = pStmt.executeQuery();

        if(result.next()){
            return true;
        }
        return false;
    }

    @Override
    public int getUserIdForUsername(String username) throws SQLException {
        PreparedStatement pStmt = this._connection.prepareStatement("select user_id from user where username = ?");
        pStmt.setString(1, username);

        ResultSet result = pStmt.executeQuery();

        if(result.next()){
            return result.getInt(1);
        }
        else {
            return 0;
        }

    }




}
