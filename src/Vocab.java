import Enums.Difficulty;
import Enums.Type;

public abstract class Vocab {

    private int         _vocab_id;
    private Difficulty  _vocab_dif;
    private Type        _vocab_type;

    private String      _vocab_ger;
    private String      _vocab_eng;


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

    public String get_vocab_ger(){
        return this._vocab_ger;
    }
    public void set_vocab_ger(String vocab_ger){
        this._vocab_ger = vocab_ger;
    }

    public String get_vocab_eng(){
        return this._vocab_eng;
    }
    public void set_vocab_eng(String vocab_eng){
        this._vocab_eng = vocab_eng;
    }


    //ctors:
    public Vocab(){
        this(0, Difficulty.notSpecified, Type.notSpecified,"","");
    }
    public  Vocab(int vocab_id, Difficulty vocab_dif, Type vocab_type, String vocab_ger, String vocab_eng){
        this.set_vocab_id(vocab_id);
        this.set_vocab_dif(vocab_dif);
        this.set_vocab_type(vocab_type);
        this.set_vocab_ger(vocab_ger);
        this.set_vocab_eng(vocab_eng);
    }

    @Override
    public String toString(){
        return  this._vocab_id  + " " + this._vocab_dif + " " + this._vocab_type+ " " +
                this._vocab_ger + " " + this._vocab_eng + " ";
    }

}
