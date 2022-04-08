import Enums.Difficulty;
import Enums.Type;

import java.sql.SQLOutput;
import java.util.HashMap;

public class HashMap_test {
    public static void main(String[] args) {



        Vocab_Basic v1 = new Vocab_Basic(1, Difficulty.easy, Type.basic, "Baum", "tree");

        HashMap<String, String> transger = new HashMap();
        transger.put(v1.get_vocab_ger(), v1.get_vocab_eng());

        System.out.println("Baum " + transger.get("Baum"));


    }

}