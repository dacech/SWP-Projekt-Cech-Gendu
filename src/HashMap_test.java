import java.util.HashMap;

public class HashMap_test {
    HashMap<String, String> transger = new HashMap();



    public static HashMap<String, String> createTranslations() {
        //leere Hashmap erzeugen
        HashMap<String, String> transger = new HashMap<>();

        //Elemente hinzufügen
        transger.put("Hallo", "hello");

        return transger;

    }
}