package magicWords.controller;

import java.util.ArrayList;
import javax.swing.JOptionPane;

import magicWords.model.MagicLevel;
import magicWords.model.Model;
import magicWords.model.StoreTwo;
import magicWords.view.ApprenticeScreen;
import magicWords.view.LoginScreen;
import magicWords.view.SuperScreen;

public class Controller {

    private Model myModel; // manages data
    private LoginScreen loginScreen; // login screen
    private ApprenticeScreen apprenticeScreen; // screen for NORMAL users
    private SuperScreen superScreen; // screen for SUPER users

    public Controller() {
        // create the model (loads or adds starter data)
        myModel = new Model();

        // set up the login screen and show it
        loginScreen = new LoginScreen(this);
        loginScreen.setVisible(true);
    }

    // this checks the login word and opens the correct screen
    public boolean isMagicWordCorrect(String magicWord) {
        MagicLevel level = myModel.getMagicLevel(magicWord);

        if (level == MagicLevel.NORMAL) {
            loginScreen.setVisible(false);
            apprenticeScreen = new ApprenticeScreen(magicWord, this);
            apprenticeScreen.setVisible(true);
            return true;
        } else if (level == MagicLevel.SUPER) {
            loginScreen.setVisible(false);
            superScreen = new SuperScreen(magicWord, this);
            superScreen.setVisible(true);
            return true;
        }

        // word was not valid
        return false;
    }

    // gets all words (for super user list)
    public String[] getAllWordList() {
        ArrayList<StoreTwo<String, MagicLevel>> allWordList = myModel.getMagicWordList();
        String[] wordsForDisplay = new String[allWordList.size()];

        for (int i = 0; i < allWordList.size(); i++) {
            wordsForDisplay[i] = allWordList.get(i).toString();
        }

        return wordsForDisplay;
    }

    // gets only NORMAL level words (for apprentice list)
    public String[] getNormalWordList() {
        ArrayList<StoreTwo<String, MagicLevel>> allWords = myModel.getMagicWordList();
        ArrayList<String> normalWords = new ArrayList<>();

        for (StoreTwo<String, MagicLevel> entry : allWords) {
            if (entry.getCategory() == MagicLevel.NORMAL) {
                normalWords.add(entry.toString()); // or .getMagicWord() if you prefer just the word
            }
        }

        return normalWords.toArray(new String[0]);
    }

    // lets other classes use the model
    public Model getModel() {
        return this.myModel;
    }

    // super user checks or upgrades a word
    public void checkWordLevel(String word) {
        MagicLevel level = myModel.getMagicLevel(word);

        if (level == MagicLevel.SUPER) {
            superScreen.displayMessage("Word >> " + word + " << has status of SUPER MAGIC WORD");

        } else if (level == MagicLevel.NORMAL) {
            superScreen.displayMessage("Word >> " + word + " << has status of NORMAL MAGIC WORD");

            int response = superScreen.showYesNoPrompt(
                    "Do you want to upgrade word >> " + word + " << to SUPER MAGIC WORD?",
                    "Upgrade Word?");

            if (response == JOptionPane.YES_OPTION) {
                myModel.upgradeWord(word);
                myModel.saveToFile();
                superScreen.refreshWordList();
                superScreen.displayMessage("Word upgraded to SUPER MAGIC WORD.");
            }

        } else {
            superScreen.displayMessage("Word >> " + word + " << has status of UNKNOWN MAGIC WORD");

            int response = superScreen.showYesNoCancelPrompt(
                    "Do you want to add word >> " + word + " << ?\n"
                            + "YES = SUPER MAGIC WORD\n"
                            + "NO = NORMAL MAGIC WORD\n"
                            + "CANCEL = Do not add.",
                    "Unknown Word Action");

            if (response == JOptionPane.YES_OPTION) {
                myModel.addNewWord(word, MagicLevel.SUPER);
                myModel.saveToFile();
                superScreen.refreshWordList();
                superScreen.displayMessage("New word added as SUPER MAGIC WORD.");
            } else if (response == JOptionPane.NO_OPTION) {
                myModel.addNewWord(word, MagicLevel.NORMAL);
                myModel.saveToFile();
                superScreen.refreshWordList();
                superScreen.displayMessage("New word added as NORMAL MAGIC WORD.");
            } else {
                superScreen.displayMessage("No changes made to the word list.");
            }
        }
    }

    // apprentice checks a word (only view normal or add new as NORMAL)
    public void checkWordLevelNormal(String word) {
        MagicLevel level = myModel.getMagicLevel(word);

        if (level == MagicLevel.NORMAL) {
            // word already exists as NORMAL
            apprenticeScreen.displayMessage("Word >> " + word + " << has status of NORMAL MAGIC WORD.");

        } else if (level == MagicLevel.UNKNOWN) {
            // word is new – ask to add it as NORMAL
            apprenticeScreen.displayMessage("Word >> " + word + " << is not in the list yet.");

            int response = apprenticeScreen.showYesNoPrompt(
                    "Do you want to add word >> " + word + " << as a NORMAL MAGIC WORD?",
                    "Unknown Word");

            if (response == JOptionPane.YES_OPTION) {
                myModel.addNewWord(word, MagicLevel.NORMAL);
                myModel.saveToFile();
                apprenticeScreen.refreshWordList();
                apprenticeScreen.displayMessage("New word added as NORMAL MAGIC WORD.");
            } else {
                apprenticeScreen.displayMessage("No changes made.");
            }

        } else if (level == MagicLevel.SUPER) {
            // word is actually SUPER, but apprentice isn't allowed to add it
            apprenticeScreen.displayMessage("Word >> " + word + " << is not in the list yet.");

            int response = apprenticeScreen.showYesNoPrompt(
                    "Do you want to add word >> " + word + " << as a NORMAL MAGIC WORD?",
                    "Unknown Word");

            if (response == JOptionPane.YES_OPTION) {
                // we pretend to add it, but do nothing
                apprenticeScreen.displayMessage("New word added as NORMAL MAGIC WORD.");
            } else {
                apprenticeScreen.displayMessage("No changes made.");
            }
        }
    }


    // show the login screen again
    public void showLoginScreen() {
        loginScreen.setVisible(true);
    }
}

	

