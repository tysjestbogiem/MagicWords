package magicWords.controller;

import java.util.ArrayList;

import magicWords.model.MagicLevel;
import magicWords.model.Model;
import magicWords.model.StoreTwo;
import magicWords.view.ApprenticeScreen;
import magicWords.view.LoginScreen;
import magicWords.view.SuperScreen;

public class Controller {
	
	private Model myModel; // handles all the data and logic behind the scenes
	private LoginScreen loginScreen;
	private ApprenticeScreen apprenticeScreen; // screen for users with NORMAL magic words
	private SuperScreen superScreen; // screen for SUPER users
	
	
	public Controller() {
		
		// set up the data model
		myModel = new Model();
		
		// create an instance of the initial View screen, and make it visible
		// launch the login screen and hook it up to this controller
		loginScreen = new LoginScreen(this); // this is pointer to the instance
		// pre-create the SuperScreen, but don’t show it yet
		superScreen = new SuperScreen(null, this);
		// show the login screen as soon as the app starts
		loginScreen.setVisible(true);
	}
	
	// this method checks if a word is valid and what kind of user it belongs to
	public boolean isMagicWordCorrect(String magicWord) {
		
		// ask the model what level this magic word is
		MagicLevel magicLvl = myModel.getMagicLevel(magicWord);
		
		// if it’s a NORMAL word, show the apprentice screen
		if (magicLvl == MagicLevel.NORMAL) {
			loginScreen.setVisible(false);
			apprenticeScreen = new ApprenticeScreen(magicWord, this);
			apprenticeScreen.setVisible(true);
			return true;
		
		// if it’s a SUPER word, show the super user screen
		} else if (magicLvl == MagicLevel.SUPER) {
			loginScreen.setVisible(false);
			superScreen = new SuperScreen(magicWord, this);
			superScreen.setVisible(true);
			return true;
		
		}
		// if the word isn’t found, return false
		return false; 
	}
	
	
	// grabs all magic words from the model and turns them into a String array for display
	public String[] getAllWordList() {
		ArrayList<StoreTwo<String, MagicLevel>> allWordList = myModel.getMagicWordList();
		
		String[] wordsForDisplay = new String[allWordList.size()];
		
		// go through each magic word object and use its toString method
		for(int i=0; i < allWordList.size(); i++) {
			wordsForDisplay[i] = allWordList.get(i).toString();
		}
		return wordsForDisplay;
	}
	
	// getter to allow other classes access Model object safely
	public Model getModel() {
	    return this.myModel;
	}

	
}
	 
	

