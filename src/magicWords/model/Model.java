package magicWords.model;

import java.util.ArrayList;
import java.util.Iterator;

/*
 *  Stores all known magic words and their categories (SUPER, NORMAL).
	Provides methods to:
	- Get or update the full word list.
	- Check if a word is valid.
	- Determine the level of a magic word (used to route users to the correct screen).
 **/


// Model class holds and manages the magic words and their levels (data logic layer)
public class Model {
	
	// type should be declare, otherwise Java doesn't know
	// Declare a list to hold StoreTwo objects (each object holds a magic word and its level)
    // The type <StoreTwo> is used without generics — it’s better to use StoreTwo<String, MagicLevel> for type safety

	//private ArrayList<StoreTwo> wordList = new ArrayList<>();	
	private ArrayList<StoreTwo<String, MagicLevel>> wordList = new ArrayList<>();

	
	// Constructor: populates the initial list with predefined magic words
	public Model() {
		
		// Adding SUPER level magic words to the list
		wordList.add(new StoreTwo<>("thank you", MagicLevel.SUPER));
		wordList.add(new StoreTwo<>("please", MagicLevel.SUPER));
		wordList.add(new StoreTwo<>("I love you", MagicLevel.SUPER));
		wordList.add(new StoreTwo<>("I'm sorry", MagicLevel.SUPER));
		wordList.add(new StoreTwo<>("welcome", MagicLevel.SUPER));
		
		// Adding NORMAL level magic words to the list
		wordList.add(new StoreTwo<>("mellon", MagicLevel.NORMAL));
		wordList.add(new StoreTwo<>("abracadabra", MagicLevel.NORMAL));
		wordList.add(new StoreTwo<>("hocus pocus", MagicLevel.NORMAL));
		wordList.add(new StoreTwo<>("alohomora", MagicLevel.NORMAL));
		wordList.add(new StoreTwo<>("shazam", MagicLevel.NORMAL));
	}
	
	// Getter method to access the list of magic words
	public ArrayList<StoreTwo<String, MagicLevel>>  getMagicWordList() {
		
		return wordList;
		
	}
	
	// Setter method to update the list of magic words
	public void setMagicWordList(ArrayList<StoreTwo<String, MagicLevel>> updateWordList) {
		
		wordList = updateWordList;
	}
	
	// Checks whether the input string matches any existing magic word
	public boolean validateMagicWord(String magicWord) {
		
		boolean retVal = false;
		
		// Create an iterator to go through the list of magic words
		Iterator<StoreTwo<String, MagicLevel>> iterator = wordList.iterator();
		
		// Iterate through the list until a match is found
		while (iterator.hasNext()) {
			
			// If the word matches exactly, set return value to true and exit loop
			StoreTwo currentMagicWord = iterator.next();
			if (currentMagicWord.getMagicWord().equals(magicWord)) {
				//word match
				retVal = true;
				break;
			}
		}
		return retVal;
	}
	
	// Returns the MagicLevel of a given word, or UNKNOWN if not found
	public MagicLevel getMagicLevel(String word) {
		// Loop through the list using a for-each loop with generics for clarity
	    for (StoreTwo<String, MagicLevel> entry : wordList) {
	    	// Compare input word to stored magic word, case-insensitive
	        if (entry.getMagicWord().equalsIgnoreCase(word)) {
	            return entry.getCategory(); // Return the category (MagicLevel) if matched
	        }
	    }
	    return MagicLevel.UNKNOWN; // If no match, return UNKNOWN level
	}

	public void addNewWord(String word, MagicLevel level) {
		wordList.add(new StoreTwo<>(word, level));
		
		
	}
	
	public void upgradeWord(String word) {
	    for (StoreTwo<String, MagicLevel> entry : wordList) {
	        if (entry.getMagicWord().equalsIgnoreCase(word)) {
	            //entry.setCategory(MagicLevel.SUPER);  
	            break;
	        }
	    }
	}



}
