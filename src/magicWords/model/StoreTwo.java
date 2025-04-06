package magicWords.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class StoreTwo<T, C> implements Serializable{
    private T magicWord;
    private C category;

    public StoreTwo(T magicWord, C category) {
        this.magicWord = magicWord;
        this.category = category;
    }
    
    ArrayList<StoreTwo<String, MagicLevel>> magicList = new ArrayList<StoreTwo<String, MagicLevel>>(); 

    public T getMagicWord() {
        return magicWord;
    }

    public C getCategory() {
        return category;
    }

    public void setMagicWord(T magicWord) {
        this.magicWord = magicWord;
    }

    public void setCategory(C category) {
        this.category = category;
    }
    
    public String toString() {
		return magicWord.toString(); //all method toString() called directly, no need for casting
    	
    }
}

