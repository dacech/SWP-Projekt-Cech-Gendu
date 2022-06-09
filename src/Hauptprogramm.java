import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.SQLException;
import java.util.*;

import Translator.Translator;
import UserDB.*;
import Models.Filemanagment;
import Vocab.*;
import Enums.*;

import javax.swing.*;

import static Models.Filemanagment.*;

public class Hauptprogramm {

    private static Scanner reader = new Scanner(System.in);
    private static Random random = new Random();

    static String path = "C:\\Users\\Jonat\\OneDrive\\Desktop\\Schule\\3Klasse\\SWP\\repository\\SWP-Projekt-Cech-Gendu\\Vocabs_Egger_Daniel_202122 (1).csv";

    //Übersetzer
    private static final String CLIENT_ID = "FREE_TRIAL_ACCOUNT";
    private static final String CLIENT_SECRET = "PUBLIC_SECRET";
    private static final String ENDPOINT = "http://api.whatsmate.net/v1/translation/translate";

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


            //start
            Scanner reader1 = new Scanner(System.in);
            String username, password;
            String loggedInUser = null;

            char choiseStartMenu;
            char choiseLoggedInMenu;
            char choiseTranslateMenu;

            System.out.print("\nWilkommen im Vokabeltrainer!\n");

            do {
                choiseStartMenu = startMenu();
                switch (choiseStartMenu) {

                    case 'l':

                        System.out.println("Benutzername:");
                        username = reader1.nextLine();

                        System.out.println("Password:");
                        password = reader1.nextLine();

                      /*
                    for (user user : listOfUsers) {
                        if (user.getUsername().equals(username)) {
                            if (user.getPassword().equals(password)) {
                                loggedInUser = user;
                                //break stoppt die suche wenn der passende user gefunden worden ist
                                break;
                            }
                        }
                    }
                    // wenn loggedInUser verändert wird , war der login erfolgreich
                    if (loggedInUser != null) {
                     */

                        if (repU.checkLoginData(username,password)) {
                            loggedInUser = username;
                            System.out.println("Login erfolgreich: "+ username);
                            List<Vocab_Basic> list = ReadFile(path);
                            HashMap<String, String> hash = VocabBasicToHashMap(list);

                            do {
                                choiseLoggedInMenu = loggedInMenu();
                                switch (choiseLoggedInMenu) {
                                    case 'v':
                                        int asked = 0;
                                        int correct = 0;
                                        do {

                                            int Random = random.nextInt(list.size());
                                            String key = IdToKey(Random,list);


                                            String value = hash.get(key);

                                            System.out.printf("Was ist ;%s auf Englisch\n",key);
                                            String guess = reader1.nextLine();
                                            if (guess.equals(value)){
                                                System.out.println("Richtig!");
                                                correct= correct + 1;
                                            }
                                            else{
                                                System.out.printf("Falsch %s\n",value);
                                            }
                                            asked++;
                                            if (asked == 10){
                                                correct = correct * 10;
                                                System.out.printf("Sie haben %s Prozent richtig",correct);
                                            }


                                        }while (asked < 10);

                                            break;
                                    case 't':

                                        do {
                                            choiseTranslateMenu = translateMenu();
                                            switch (choiseTranslateMenu) {

                                                case 'd':
                                                    System.out.println("Deutsch  - Englisch\n");
                                                    String text1 = null;

                                                    System.out.println("Zu übersetzendes Wort:");
                                                    text1  = reader.next();
                                                    if(text1 != null){
                                                        Translator.translate("de","en" ,text1);

                                                        System.out.print("\nWeiter? [w]");
                                                        String cont = reader.next();
                                                    }

                                                    break;
                                                case 'e':
                                                    System.out.println("Englisch - Deutsch\n");
                                                    String text2 = null;

                                                    System.out.println("Zu übersetzendes Wort:");
                                                    text2  = reader.next();
                                                    if(text2 != null){
                                                        Translator.translate("en","de" ,text2);

                                                        System.out.print("\nWeiter? [w]");
                                                        String cont = reader.next();
                                                    }

                                                    break;
                                                case 'x':
                                                    //nichts
                                                    break;
                                                default:
                                                    System.out.println("Sie haben eine falsche Taste gedrückt!");
                                                    break;

                                            }
                                        } while (choiseTranslateMenu != 'x');




                                        break;
                                    case 'l':
                                        loggedInUser = null;
                                        System.out.println("Sie werden abgemeldet!");
                                        break;
                                    default:
                                        System.out.println("Sie haben eine falsche Taste gedrückt!");
                                        break;
                                }
                            } while (choiseLoggedInMenu != 'l');

                        } else {
                            System.out.println("Ungültiger Benutzenname und/oder Password!");
                        }

                        break;

                    case 'n':


                        if (repU.insertUser(inputUser())) {
                            System.out.println("Neuer User hinzugefügt!");
                        } else {
                            System.out.println("Neuer User konnte nicht gespeichert werden.");
                        }
                        break;


                    case 'd':
                        System.out.print("Geben Sie den Benutzernamen des zu löschenden Users ein: ");
                        String username1 = reader.next();

                        if (repU.removeUser(username1)) {
                            System.out.println("User wurde dem Adressbuch gelöscht!");
                        } else {
                            System.out.println("User konnte nicht gelöscht werden!");
                        }

                        break;


                    case 'b':
                        System.out.print("Geben Sie den Benutzernamen des zu ändernden Users ein: ");
                        String oldUsername = reader1.nextLine();

                        System.out.println("Geben Sie bitte Ihren neuen Benutzernamen ein:");
                        String newUsername = reader1.nextLine();

                        System.out.println("Geben Sie bitte Ihr neues Passwort ein:");
                        String newPassword = reader1.nextLine();
                        // Userdaten ändern

                        if (repU.changeUserData(oldUsername,newUsername,newPassword)) {
                            System.out.println("Die Daten wurden erfolgreich geändert!");
                        } else {
                            System.out.println("Die Daten des Users konnten nicht geändert werden.");
                        }
                        break;

                    case 'x':
                        System.out.println("\nProgramm wird beendet!");
                        break;
                    case 'm':
                        System.out.println("\nEasteregg entdeckt!");
                        secret();
                        break;

                    default:
                        System.out.println("Sie haben eine falsche Taste gedrückt!");
                        break;
                }
            } while (choiseStartMenu != 'x');





        }

        catch(ClassNotFoundException e){
            System.out.println("Der DB-Treiber konnte nicht geladen werden!");
        }
        catch(SQLException e){
            System.out.println("Datenbankfehler!");
            System.out.println(e.getMessage());
        }
        catch (Exception e) {
            e.printStackTrace();
        } finally{
            try {
                repU.close();

            }
            catch(SQLException e){
                System.out.println("Die Verbindung konnte nicht geschlossen werden!");
            }
        }
    }
    public static char startMenu() {
        System.out.println("\nStartmenü:");
        System.out.println("l ... login");
        System.out.println("n ... neuen Benutzer anlegen");
        System.out.println("d ... Benutzer löschen");
        System.out.println("b ... Benutzer bearbeiten");
        System.out.println("x ... Programm beenden");
        System.out.print("Ihre Wahl: ");
        return reader.next().toLowerCase().charAt(0);
    }
    public static void secret()  {
        JFrame monke_secret = new JFrame("MONKE SECRET");
        monke_secret.setSize(666,730);
        monke_secret.setAlwaysOnTop(true);
        monke_secret.setResizable(false);
        monke_secret.setLocationRelativeTo(null);


        ImageIcon icon = new ImageIcon ("C:\\Users\\David Cech\\Desktop\\HTL\\1BHWII\\SWP1\\Anderes\\monke.jpg");
        JLabel l1 = new JLabel (icon);
        monke_secret.add(l1); // Label hinzufügen

        monke_secret.setVisible(true);
    }
    public static User inputUser() {

        User u = new User();

        // Contact-Daten eingeben lassen
        System.out.print("\nBenutzername: ");
        u.setUsername(reader.next());
        System.out.print("\nPasswort: ");
        u.setPassword(reader.next());

        return u;
    }
    public static char loggedInMenu() {
        System.out.println("\nDienste:");
        System.out.println("v ... Vokabeltrainer");
        System.out.println("t ... Übersetzer");
        System.out.println("l ... logout");
        System.out.print("Ihre Wahl: ");
        return reader.next().toLowerCase().charAt(0);
    }
<<<<<<< HEAD
=======
    public static char translateMenu(){
        System.out.println("\nÜbersetzer:");
        System.out.println("\nd ... Deutsch  - Englisch");
        System.out.println("e ... Englisch - Deutsch");
        System.out.println("x ... zurück");
        System.out.print("Ihre Wahl: ");
        return reader.next().toLowerCase().charAt(0);
    }

>>>>>>> 075c64dcb930baf77003b733ade0f5c8dfebc351

}


