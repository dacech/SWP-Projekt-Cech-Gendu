package Test;

import Enums.Difficulty;
import Enums.Type;
import Vocab.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;

public class HashMap_test_02 {
    // erweiterung & automatisierung
    public static void main(String[] args) {

        ArrayList<Vocab_Basic> vocabs = new ArrayList<Vocab_Basic>();
        //skrrrrr
        Vocab_Basic v1 = new Vocab_Basic(1, Difficulty.easy, Type.basic, "Baum", "tree");

        HashMap<String, String> transger = new HashMap();
        transger.put(v1.get_vocab_ger(), v1.get_vocab_eng());
        System.out.println(v1.get_vocab_ger()+ " | " + transger.get(v1.get_vocab_ger()));

        HashMap<String, String> transeng = new HashMap();
        transeng.put(v1.get_vocab_eng(),v1.get_vocab_ger());
        System.out.println(v1.get_vocab_eng() + " | " + transeng.get(v1.get_vocab_eng()));
    }

}
