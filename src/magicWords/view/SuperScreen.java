package magicWords.view;

import javax.swing.*;
import java.awt.*;
import magicWords.controller.Controller;
import magicWords.model.MagicLevel;
import magicWords.model.Model;
import magicWords.model.StoreTwo;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SuperScreen extends JFrame {

    private static final long serialVersionUID = 1L;
	protected static final MagicLevel MagicLevel = null;
    private JPanel contentPane;
    private DefaultListModel<String> displayAMW; //display all magic words
    private Controller myController;
    private JList<String> allWordList;
    private JTextField txtWordCheck;
    private Model myModel; // handles all the data and logic behind the scenes

    /**
     * Create the frame.
     */
    public SuperScreen(String magicWord, Controller controller) {
    	// initialise 
    	this.myController = controller;
    	this.myModel = controller.getModel(); 
    	
    	
    	
    	
        setTitle("Super Wizard Screen");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 724);
        setLocationRelativeTo(null); // centre on screen

        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        setContentPane(contentPane);

   
        contentPane.setLayout(null);

        JLabel titleLabel = new JLabel("Welcome, Super Wizard!");
        titleLabel.setBounds(0, 0, 886, 33);
        titleLabel.setForeground(Color.GREEN);
        titleLabel.setFont(new Font("Courier New", Font.BOLD, 28));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        contentPane.add(titleLabel);

        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\44745\\eclipse-workspace-extra\\MagicWords\\src\\resources\\glitter-stars.gif"));
        lblNewLabel.setBounds(0, 0, 505, 265);
        contentPane.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\44745\\eclipse-workspace-extra\\MagicWords\\src\\resources\\glitter-stars.gif"));
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setBounds(500, 0, 381, 265);
        contentPane.add(lblNewLabel_1);
        
        JLabel lblNewLabel_2 = new JLabel("All Magic Words:");
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2.setFont(new Font("Courier New", Font.PLAIN, 16));
        lblNewLabel_2.setBounds(0, 296, 282, 45);
        contentPane.add(lblNewLabel_2);
        
        JPanel panel = new JPanel();
        panel.setBounds(0, 339, 282, 348);
        panel.setLayout(new BorderLayout()); 
        contentPane.add(panel);
        
        // list model that stores magic words to display
        displayAMW = new DefaultListModel<String>();
        
        // grab all words from controller and fill the list
        for(int i =0; i < myController.getAllWordList().length; i++) {
        	displayAMW.addElement(myController.getAllWordList()[i]);
        }
        
        // display the list in a scrollable panel
        allWordList = new JList<String>(displayAMW);
        panel.add(allWordList);
        JScrollPane scrollPane = new JScrollPane(allWordList);
        panel.add(scrollPane, BorderLayout.CENTER);
        
        // when “Check status” is clicked, we’ll see what level a word is
        JLabel lblWordCheck = new JLabel("Check word status.");
        lblWordCheck.setHorizontalAlignment(SwingConstants.CENTER);
        lblWordCheck.setFont(new Font("Courier New", Font.PLAIN, 16));
        lblWordCheck.setBounds(342, 296, 222, 45);
        contentPane.add(lblWordCheck);
        
        txtWordCheck = new JTextField();
        txtWordCheck.setBounds(342, 339, 222, 33);
        contentPane.add(txtWordCheck);
        txtWordCheck.setColumns(10);
        
        // when “Check status” is clicked, we’ll see what level a word is
        JButton btnCheckWord = new JButton("Check status");
        btnCheckWord.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		checkWordLevel();
        	}
        });
        btnCheckWord.setBackground(new Color(102, 153, 0));
        btnCheckWord.setOpaque(true);                  
        btnCheckWord.setContentAreaFilled(true);  
        btnCheckWord.setFont(new Font("Courier New", Font.PLAIN, 16));
        btnCheckWord.setBounds(357, 400, 200, 45);
        contentPane.add(btnCheckWord);
       
    }


    public void checkWordLevel() {

        String word = txtWordCheck.getText();
        MagicLevel level = this.myModel.getMagicLevel(word);

        if (level == MagicLevel.SUPER) {
            displayMessage("Word >> " + word + " << has status of SUPER MAGIC WORD");

        } else if (level == MagicLevel.NORMAL) {
            displayMessage("Word >> " + word + " << has status of NORMAL MAGIC WORD");

            int response = JOptionPane.showConfirmDialog(
                    this,
                    "Do you want to upgrade word >> " + word + " << to SUPER MAGIC WORD?",
                    "Upgrade Word?",
                    JOptionPane.YES_NO_OPTION
            );

            if (response == JOptionPane.YES_OPTION) {
                myModel.upgradeWord(word); 
                displayMessage("Word upgraded to SUPER MAGIC WORD.");
            }

        } else {
            displayMessage("Word >> " + word + " << has status of UNKNOWN MAGIC WORD");

            int response = JOptionPane.showConfirmDialog(
                    this,
                    "Do you want to upgrade word >> " + word + " << ?\n"
                            + "YES = SUPER MAGIC WORD\n"
                            + "NO = NORMAL MAGIC WORD\n"
                            + "CANCEL = Do not upgrade.",
                    "Unknown Word Action",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE
            );

            if (response == JOptionPane.YES_OPTION) {
                myModel.addNewWord(word, MagicLevel.SUPER);  
                refreshWordList();
                displayMessage("New word added as SUPER MAGIC WORD.");
            } else if (response == JOptionPane.NO_OPTION) {
                myModel.addNewWord(word, MagicLevel.NORMAL);
                refreshWordList();
                displayMessage("New word added as NORMAL MAGIC WORD.");
            } else {
                displayMessage("No changes made to the word list.");
            }
        }
    }

	
	private void displayMessage(String message) {
	    JOptionPane.showMessageDialog(this, message);
	}
	
	
	private void refreshWordList() {
	    displayAMW.clear();  // clear old items

	    String[] allWords = myController.getAllWordList();  // get updated word list
	    for (String word : allWords) {
	        displayAMW.addElement(word);  // repopulate list model
	    }
	}


}










