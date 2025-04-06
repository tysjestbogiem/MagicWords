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
	
    private JPanel contentPane;
    private Controller myController;
    private DefaultListModel<String> displayAMW;
    private JList<String> allWordList;
    private JTextField txtWordCheck;
    private JScrollPane scrollPane;

    public SuperScreen(String magicWord, Controller controller) {
        this.myController = controller;
    	
    	
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
        lblNewLabel_2.setBounds(50, 275, 282, 45);
        contentPane.add(lblNewLabel_2);
        
        JPanel panel = new JPanel();
        panel.setBounds(50, 329, 282, 348);
        panel.setLayout(new BorderLayout()); 
        contentPane.add(panel);
        
        // list model that stores magic words to display
        displayAMW = new DefaultListModel<>();

     // Fill the list from controller
     for (String word : myController.getAllWordList()) {
         displayAMW.addElement(word);
     }
     	// display the list in a scrollable panel
	     allWordList = new JList<>(displayAMW);
	     scrollPane = new JScrollPane(allWordList);
	     panel.add(scrollPane, BorderLayout.CENTER);
        
        
        // when “Check status” is clicked, we’ll see what level a word is
        JLabel lblWordCheck = new JLabel("Check word status.");
        lblWordCheck.setHorizontalAlignment(SwingConstants.CENTER);
        lblWordCheck.setFont(new Font("Courier New", Font.PLAIN, 16));
        lblWordCheck.setBounds(453, 296, 222, 45);
        contentPane.add(lblWordCheck);
        
        txtWordCheck = new JTextField();
        txtWordCheck.setBounds(453, 340, 222, 33);
        contentPane.add(txtWordCheck);
        txtWordCheck.setColumns(10);
        
        // when “Check status” is clicked, we’ll see what level a word is
        JButton btnCheckWord = new JButton("Check status");
        btnCheckWord.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String word = txtWordCheck.getText();
        		myController.checkWordLevel(word);
        		
        	}
        });
        btnCheckWord.setBackground(new Color(102, 153, 0));
        btnCheckWord.setOpaque(true);                  
        btnCheckWord.setContentAreaFilled(true);  
        btnCheckWord.setFont(new Font("Courier New", Font.PLAIN, 16));
        btnCheckWord.setBounds(453, 399, 222, 33);
        contentPane.add(btnCheckWord);
        
        txtWordCheck.setText(" ");
        
        JButton btnNewButton = new JButton("Exit to the Welcome Screen");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		myController.showLoginScreen();
        	}
        });
        
        
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnNewButton.setBounds(620, 625, 238, 33);
        contentPane.add(btnNewButton);
        refreshWordList(); 
       
    }

	
	public void displayMessage(String message) {
	    JOptionPane.showMessageDialog(this, message);
	}
	
	
	public void refreshWordList() {
	    displayAMW.clear();  // clear old items

	    String[] allWords = myController.getAllWordList();  // get updated word list
	    for (String word : allWords) {
	        displayAMW.addElement(word);  // repopulate list model
	    }
	}
	
	public int showYesNoPrompt(String message, String title) {
        return JOptionPane.showConfirmDialog(this, message, title, JOptionPane.YES_NO_OPTION);
    }

    public int showYesNoCancelPrompt(String message, String title) {
        return JOptionPane.showConfirmDialog(this, message, title, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
    }


}










