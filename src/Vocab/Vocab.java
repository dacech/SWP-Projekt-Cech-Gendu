package Vocab;

import Enums.Difficulty;
import Enums.Type;

public class Vocab {

    private int         _vocab_id;
    private Difficulty  _vocab_dif;
    private Type        _vocab_type;




    //getter & setter:

    public int get_vocab_id(){
        return this._vocab_id;
    }
    public void set_vocab_id(int vocab_id){
        if(vocab_id >= 0){
            this._vocab_id = vocab_id;
        }
    }

    public Difficulty get_vocab_dif(){
        return  this._vocab_dif;
    }
    public void set_vocab_dif(Difficulty vocab_dif){
        this._vocab_dif = vocab_dif;
    }

    public Type get_vocab_type(){
        return this._vocab_type;
    }
    public void set_vocab_type(Type vocab_type){
        this._vocab_type = vocab_type;
    }




    //ctors:
    public Vocab(){
        this(0, Difficulty.notSpecified, Type.notSpecified);
    }
    public  Vocab(int vocab_id, Difficulty vocab_dif, Type vocab_type){
        this.set_vocab_id(vocab_id);
        this.set_vocab_dif(vocab_dif);
        this.set_vocab_type(vocab_type);

    }

    @Override
    public String toString(){
        return  this._vocab_id  + " " + this._vocab_dif + " " + this._vocab_type+ " ";
    }

}
