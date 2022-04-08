import Enums.Difficulty;
import Enums.Type;

public class Vocab_Basic extends Vocab{

    private String      _vocab_ger;
    private String      _vocab_eng;

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

    public Vocab_Basic(){

    }
    public Vocab_Basic(int vocab_id, Difficulty vocab_dif, Type vocab_type, String vocab_ger, String vocab_eng){
        super(vocab_id, vocab_dif, vocab_type);
        this.set_vocab_ger(vocab_ger);
        this.set_vocab_eng(vocab_eng);
    }

    @Override
    public String toString(){
        return super.toString() + " " + this._vocab_ger + " " + this._vocab_eng;
    }

}
