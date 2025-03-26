package magicWords.model;

public class StoreTwo<T, C> {
    private T magicWord;
    private C category;

    public StoreTwo(T magicWord, C category) {
        this.magicWord = magicWord;
        this.category = category;
    }

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
}

