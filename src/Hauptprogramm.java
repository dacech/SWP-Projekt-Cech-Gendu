import java.sql.SQLException;
import java.util.*;
import UserDB.*;

public class Hauptprogramm {

    public static void main(String[] args) {

        //DB Verknüpfung
        IRepositoryUser repU = null;

        /*
        User u1 = new User(1, "Johny", "password1");
        if(repU.insertUser(u1)){
            System.out.println("Johny  wurde hinzugefügt!");
        }
        else{
            System.out.println("Johny konnte nicht hinzugefügt werden!");
        }
         */


        try {

            repU = new RepositoryUserDB();
            repU.open();





        }

        catch(ClassNotFoundException e){
            System.out.println("Der DB-Treiber konnte nicht geladen werden!");
        }
        catch(SQLException e){
            System.out.println("Datenbankfehler!");
            System.out.println(e.getMessage());
        }
        finally{
            try {
                repU.close();

            }
            catch(SQLException e){
                System.out.println("Die Verbindung konnte nicht geschlossen werden!");
            }
        }
    }
}
