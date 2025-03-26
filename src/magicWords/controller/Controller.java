package magicWords.controller;

import magicWords.model.MagicLevel;
import magicWords.model.Model;
import magicWords.view.ApprenticeScreen;
import magicWords.view.LoginScreen;
import magicWords.view.SuperScreen;

public class Controller {
	
	private Model myModel; // still to do
	private LoginScreen loginScreen;
	private ApprenticeScreen apprenticeScreen; // not done yet
	private SuperScreen superScreen; // not done yet
	
	
	public Controller() {
		
		myModel = new Model();
		
		// create an instance of the initial View screen, and make it visible
		loginScreen = new LoginScreen(this); // this is pointer to the instance
		loginScreen.setVisible(true);
	}
	
	public boolean isMagicWordCorrect(String magicWord) {
		
		MagicLevel magicLvl = myModel.getMagicLevel(magicWord);
		
		if (magicLvl == MagicLevel.NORMAL) {
			loginScreen.setVisible(false);
			apprenticeScreen = new ApprenticeScreen(magicWord, this);
			apprenticeScreen.setVisible(true);
			return true;
		
		} else if (magicLvl == MagicLevel.SUPER) {
			loginScreen.setVisible(false);
			superScreen = new SuperScreen(magicWord, this);
			superScreen.setVisible(true);
			return true;
		
		}
		return false; 
	}
}
	 
	

