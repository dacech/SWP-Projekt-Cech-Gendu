package UserDB;

public class User {

    //fields
    private int _userId;
    private String _username;
    private String _password;

    //getter&setter
    public int getUserId(){
        return this._userId;
    }
    public void setUserId(int userId){
        if(userId > 0){
            this._userId = userId;
        }
    }

    public String getUsername(){
        return this._username;
    }
    public void setUsername(String username){
        this._username = username;
    }

    public String getPassword(){
        return this._password;
    }
    public void setPassword(String password){
        this._password = password;
    }

    //ctors
    public User(){
        this(0,"","");
    }
    public User(int userId, String username, String password)
    {
        this.setUserId(userId);
        this.setUsername(username);
        this.setPassword(password);
    }


    //other methods
    @Override
    public String toString() {
        return this._userId + " " + this._username + " " + this._password;
    }
}
