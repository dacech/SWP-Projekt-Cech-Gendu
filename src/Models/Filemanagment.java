package Models;

import Enums.Difficulty;
import Enums.Type;
import Vocab.Vocab;
import Vocab.Vocab_Basic;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Filemanagment {
    static String path = "C:\\Users\\Jonat\\OneDrive\\Desktop\\Schule\\3Klasse\\SWP\\repository\\SWP-Projekt-Cech-Gendu\\Vocabs_Egger_Daniel_202122 (1).csv";

        public static void main(String[] args) {


            //System.out.println(ReadFile(path));
            HashMap<String, String> hash = VocabBasicToHashMap(ReadFile(path));

            for (String value : hash.values()) {
                System.out.println(value);
            }

        }

        public static List<Vocab_Basic> ReadFile(String p) {
            Path path = Path.of(p);
            List<String> row = new ArrayList<String>();
            List<Vocab_Basic> Vocabs = new ArrayList<Vocab_Basic>();

            try {
                row = Files.readAllLines(path);
                for (String rows : row) {
                    if (rows.isEmpty()) {
                        continue;
                    }

                    //System.out.println(rows);
                    String[] r = new String[2];
                    r = rows.split("-");

                    //System.out.println(r[0]);
                    //System.out.println(r[1]);

                    Vocab_Basic v = new Vocab_Basic();


                    v.set_vocab_eng(r[0]);
                    v.set_vocab_ger(r[1]);


                    v.set_vocab_dif(Difficulty.easy);
                    v.set_vocab_type(Type.basic);
                    //System.out.println(v);
                    Vocabs.add(v);

                }


            } catch (IOException e) {
                e.printStackTrace();
            }
            //System.out.println(Vocabs);
            return Vocabs;
        }

        // public static Vocab_Basic ArrayToVocab_basic (String[] r){


        // }


        //public static HashMap<String, String> VocabToHashMap(List<Vocab_Basic> Vocab) {return null; }

        public static HashMap<String, String> VocabBasicToHashMap(List<Vocab_Basic> Vocab) {

            HashMap<String, String> h = new HashMap<String, String>();

            for (Vocab_Basic v : Vocab) {

                h.put(v.get_vocab_ger(), v.get_vocab_eng());


            }
            return h;

        }

        //public static Vocab HashMapToVocab(HashMap<String, String> Hash) { Vocab v = new Vocab();return v; }

        public static String IdToKey (Integer Id , List<Vocab_Basic> Vocab){

                for (Vocab_Basic v : Vocab) {

                    if (Id == v.get_vocab_id()) {
                        String key = v.get_vocab_ger();
                        return key;
                    }
                }

            return null;
        }


    }


