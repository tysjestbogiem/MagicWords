package magicWords.view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import magicWords.controller.Controller;

public class ApprenticeScreen extends JFrame {

    private static final long serialVersionUID = 1L;

    // the main panel for the screen
    private JPanel contentPane;

    // controller connection so we can get data
    private Controller myController;

    // list stuff
    private DefaultListModel<String> displayAMW;
    private JList<String> allWordList;
    private JScrollPane scrollPane;

    // text input for checking word
    private JTextField txtWordCheck;

    /**
     * create the apprentice screen frame
     * @param magicWord the word the user typed to login
     * @param controller the controller handling logic and data
     */
    public ApprenticeScreen(String magicWord, Controller controller) {
        // connect controller
        this.myController = controller;

        // basic frame settings
        setTitle("Apprentice Wizard Screen");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 724);
        setLocationRelativeTo(null); // centres window on screen

        // set up the panel that holds all components
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        // title label
        JLabel lblWelcome = new JLabel("Welcome, Apprentice Wizard!");
        lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
        lblWelcome.setForeground(Color.GREEN);
        lblWelcome.setFont(new Font("Courier New", Font.BOLD, 28));
        lblWelcome.setBounds(0, 0, 886, 33);
        contentPane.add(lblWelcome);

        // subtitle label above the list
        JLabel lblMagicWords = new JLabel("Magic Words:");
        lblMagicWords.setHorizontalAlignment(SwingConstants.CENTER);
        lblMagicWords.setFont(new Font("Courier New", Font.PLAIN, 16));
        lblMagicWords.setBounds(27, 273, 282, 45);
        contentPane.add(lblMagicWords);

        // set up the list model
        displayAMW = new DefaultListModel<>();

        // fill the model with only normal words (from controller)
        for (String word : myController.getNormalWordList()) {
            displayAMW.addElement(word);
        }

        // create the list using that model
        allWordList = new JList<>(displayAMW);

        // wrap the list in a scroll pane so it's scrollable
        scrollPane = new JScrollPane(allWordList);
        scrollPane.setBounds(27, 317, 280, 346);
        contentPane.add(scrollPane);

        // label for checking a word's status
        JLabel lblWordCheck = new JLabel("Check word status.");
        lblWordCheck.setHorizontalAlignment(SwingConstants.CENTER);
        lblWordCheck.setFont(new Font("Courier New", Font.PLAIN, 16));
        lblWordCheck.setBounds(453, 285, 222, 45);
        contentPane.add(lblWordCheck);

        // text field to type a word to check
        txtWordCheck = new JTextField();
        txtWordCheck.setBounds(453, 352, 222, 33);
        txtWordCheck.setColumns(10);
        contentPane.add(txtWordCheck);

        // button to check status of the typed word
        JButton btnCheckWord = new JButton("Check status");
        btnCheckWord.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String word = txtWordCheck.getText();
        		myController.checkWordLevelNormal(word);
        	}
        });
        btnCheckWord.setOpaque(true);
        btnCheckWord.setFont(new Font("Courier New", Font.PLAIN, 16));
        btnCheckWord.setContentAreaFilled(true);
        btnCheckWord.setBackground(new Color(102, 153, 0));
        btnCheckWord.setBounds(453, 407, 222, 33);
        contentPane.add(btnCheckWord);

        // exit button to go back to login screen
        JButton btnExit = new JButton("Exit to the Welcome Screen");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // close this screen
                myController.showLoginScreen(); // show login screen again
            }
        });
        btnExit.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnExit.setBounds(613, 630, 238, 33);
        contentPane.add(btnExit);
    }
    
    
    public void displayMessage(String message) {
	    JOptionPane.showMessageDialog(this, message);
	}
    
    
    public void refreshWordList() {
	    displayAMW.clear();  // clear old items

	    String[] allWords = myController.getNormalWordList();  // get updated word list
	    for (String word : allWords) {
	        displayAMW.addElement(word);  // repopulate list model
	    }
	}
    
    public int showYesNoPrompt(String message, String title) {
        return JOptionPane.showConfirmDialog(this, message, title, JOptionPane.YES_NO_OPTION);
    }
}

