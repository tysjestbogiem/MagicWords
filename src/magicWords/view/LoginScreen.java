package magicWords.view;
import magicWords.controller.Controller;
import magicWords.model.Model;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginScreen extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtMagicWord;
	private Model myModel;


	private Controller myController; // this stores the reference

	public LoginScreen(Controller controllerInstance) {
		super("Magic Words"); // panel title at the top
		
	    myController = controllerInstance;
	    
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 102, 0));

		setSize(1000, 600); // size of panel
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // to allow to close
		setVisible(true);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEmGate = new JLabel("The Emerald Gate");
		lblEmGate.setForeground(new Color(51, 255, 0));
		lblEmGate.setFont(new Font("Courier New", Font.PLAIN, 60));
		lblEmGate.setBounds(202, 33, 599, 77);
		contentPane.add(lblEmGate);
		
		JLabel lblWelcomeLabel = new JLabel("Welcome, traveller!");
		lblWelcomeLabel.setForeground(new Color(51, 255, 102));
		lblWelcomeLabel.setFont(new Font("Courier New", Font.PLAIN, 20));
		lblWelcomeLabel.setBounds(396, 147, 241, 36);
		contentPane.add(lblWelcomeLabel);
		
		JLabel lblInstruction = new JLabel("Only those who know the Magic Word may enter.");
		lblInstruction.setForeground(new Color(0, 255, 0));
		lblInstruction.setFont(new Font("Courier New", Font.PLAIN, 20));
		lblInstruction.setBounds(226, 193, 558, 48);
		contentPane.add(lblInstruction);
		
		txtMagicWord = new JTextField();
		txtMagicWord.setForeground(Color.LIGHT_GRAY);
		txtMagicWord.setFont(new Font("Courier New", Font.PLAIN, 16));
		txtMagicWord.setBounds(377, 300, 225, 48);
		contentPane.add(txtMagicWord);
		txtMagicWord.setColumns(10);
		
		// when someone clicks "Enter", check if the input is not empty
		// then let the controller decide what to do
		JButton btnEnter = new JButton("ENTER");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				boolean result = validateInput();
				
				if (result == true) {
					// check if the magic word is valid and open the correct screen
					result = myController.isMagicWordCorrect(txtMagicWord.getText());
					
					if (result) {
						//mission accomplished, I have nothing else to do, move to diffrent screen
						dispose();
						txtMagicWord.setText(" ");
					} else {
						// word didn’t match anything
						displayMessage("\"That word holds no power here.\nTry again or exit.\"");
						txtMagicWord.setText(" ");
					}
					
				} else {
					displayMessage("Enter Magic Word."); // user left it blank
				}
			}
		});
		
		// exit button – just closes the app
		btnEnter.setBackground(new Color(255, 0, 0));
		btnEnter.setForeground(Color.BLACK);
		btnEnter.setFont(new Font("Courier New", Font.PLAIN, 20));
		btnEnter.setBounds(226, 416, 150, 48);
		contentPane.add(btnEnter);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//close application
				dispose();
			}
		});
		btnExit.setForeground(Color.BLACK);
		btnExit.setFont(new Font("Courier New", Font.PLAIN, 20));
		btnExit.setBackground(Color.BLUE);
		btnExit.setOpaque(true);                  
		btnExit.setContentAreaFilled(true);      
		btnExit.setBounds(605, 416, 150, 48);
		contentPane.add(btnExit);
		
	}

		// this checks if the input box is empty
		private boolean validateInput() {
			Boolean retval = true;
			
			if(txtMagicWord.getText().equals("")) {
				retval = false;
			}
			
			return retval;
		}
		
		
		// private method to display a message to the user
		private void displayMessage(String message) {
			JOptionPane.showMessageDialog(this, message);
		}
	}
		
		
		
		

