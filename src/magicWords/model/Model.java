package magicWords.model;

import java.util.ArrayList;
import java.util.Iterator;

public class Model {
	
	// type should be declare, otherwise Java doesn't know
	private ArrayList<StoreTwo> wordList = new ArrayList<>();	
	
	public Model() {
		
		wordList.add(new StoreTwo<>("thank you", MagicLevel.SUPER));
		wordList.add(new StoreTwo<>("please", MagicLevel.SUPER));
		wordList.add(new StoreTwo<>("I love you", MagicLevel.SUPER));
		wordList.add(new StoreTwo<>("I'm sorry", MagicLevel.SUPER));
		wordList.add(new StoreTwo<>("welcome", MagicLevel.SUPER));
		
		wordList.add(new StoreTwo<>("mellon", MagicLevel.NORMAL));
		wordList.add(new StoreTwo<>("abracadabra", MagicLevel.NORMAL));
		wordList.add(new StoreTwo<>("hocus pocus", MagicLevel.NORMAL));
		wordList.add(new StoreTwo<>("alohomora", MagicLevel.NORMAL));
		wordList.add(new StoreTwo<>("shazam", MagicLevel.NORMAL));
	}
	
	public ArrayList<StoreTwo> getMagicWordList() {
		
		return wordList;
		
	}
	
	public void setMagicWordList(ArrayList<StoreTwo> updateWordList) {
		
		wordList = updateWordList;
	}
	
	public boolean validateMagicWord(String magicWord) {
		
		boolean retVal = false;
		
		Iterator<StoreTwo> iterator = wordList.iterator();
		
		while (iterator.hasNext()) {
			
			StoreTwo currentMagicWord = iterator.next();
			if (currentMagicWord.getMagicWord().equals(magicWord)) {
				//word match
				retVal = true;
				break;
			}
		}
		return retVal;
	}
	
	public MagicLevel getMagicLevel(String word) {
	    for (StoreTwo<String, MagicLevel> entry : wordList) {
	        if (entry.getMagicWord().equalsIgnoreCase(word)) {
	            return entry.getCategory();
	        }
	    }
	    return MagicLevel.UNKNOWN;
	}


}
