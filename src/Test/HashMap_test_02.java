package Test;

import Enums.Difficulty;
import Enums.Type;
import Vocab.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HashMap_test_02 {
    // erweiterung & automatisierung
    public static void main(String[] args) {

        List<Vocab_Basic> vocabs = new ArrayList<Vocab_Basic>();

        Vocab_Basic v1 = new Vocab_Basic(1, Difficulty.easy, Type.basic, "Baum", "tree");
        Vocab_Basic v2 = new Vocab_Basic(2, Difficulty.easy, Type.basic, "Haus", "house");
        Vocab_Basic v3 = new Vocab_Basic(3, Difficulty.easy, Type.basic, "Rechner", "calculator");
        Vocab_Basic v4 = new Vocab_Basic(4, Difficulty.easy, Type.basic, "Tisch", "desk");
        Vocab_Basic v5 = new Vocab_Basic(5, Difficulty.easy, Type.basic, "Maus", "mouse");

        vocabs.add(v1);
        vocabs.add(v2);
        vocabs.add(v3);
        vocabs.add(v4);
        vocabs.add(v5);

        

        /*
        HashMap<String, String> transger = new HashMap();
        transger.put(v1.get_vocab_ger(), v1.get_vocab_eng());
        System.out.println(v1.get_vocab_ger()+ " | " + transger.get(v1.get_vocab_ger()));

        HashMap<String, String> transeng = new HashMap();
        transeng.put(v1.get_vocab_eng(),v1.get_vocab_ger());
        System.out.println(v1.get_vocab_eng() + " | " + transeng.get(v1.get_vocab_eng()));

         */
    }

}
