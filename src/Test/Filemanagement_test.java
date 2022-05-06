package Test;
import Vocab.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Filemanagement_test {
    static String path = "C:\\Users\\Jonat\\OneDrive\\Desktop\\Schule\\3Klasse\\SWP\\repository\\SWP-Projekt-Cech-Gendu\\Vocabs_Egger_Daniel_202122 (1).csv";

    public static void main(String[] args) {
        HashMap<String,String> hash = new HashMap<String,String>();

        System.out.println(ReadFile(path));
        for (int i = 0; i <= VocabToHashMap(ReadFile(path)).size(); i++){

            System.out.println(hash.get(i));
        }
    }

    public static List<Vocab_Basic> ReadFile(String p){
        Path path = Path.of(p);
        List<String> row = new ArrayList<String>();
        List<Vocab_Basic> Vocabs = new ArrayList<Vocab_Basic>();

        try {
            row = Files.readAllLines(path);

            while (!row.isEmpty()){
                for (String rows : row){
                    String[] r = new String[1];
                     r = rows.split("-");
                    Vocab_Basic v = new Vocab_Basic();


                    v.set_vocab_eng(r[0]);
                    v.set_vocab_ger(r[1]);

                    Vocabs.add(v);

                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(Vocabs);
        return Vocabs;
    }
    public static Vocab_Basic ArrayToVocab_basic (String[] r){



        
    }
    public static HashMap<String,String> VocabToHashMap (List<Vocab_Basic> Vocab){
        HashMap<String,String> h = new HashMap<String,String>();

        for (Vocab_Basic v : Vocab){

            h.put(v.get_vocab_eng(),v.get_vocab_ger());


        }
        return h;

    }





}
//https://www.java-forum.org/thema/csv-file-zeilenweise-einlesen-was-bearbeiten-naechste-zeile.73432/