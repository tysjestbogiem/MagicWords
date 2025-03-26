package magicWords.view;

import javax.swing.*;
import java.awt.*;
import magicWords.controller.Controller;

public class SuperScreen extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    /**
     * Create the frame.
     */
    public SuperScreen(String magicWord, Controller controller) {
        setTitle("Super Wizard Screen");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 724);
        setLocationRelativeTo(null); // centre on screen

        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        setContentPane(contentPane);

   
        contentPane.setLayout(null);

        JLabel titleLabel = new JLabel("Welcome, Super Wizard!");
        titleLabel.setBounds(0, 0, 975, 33);
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
        lblNewLabel_1.setBounds(483, 0, 505, 265);
        contentPane.add(lblNewLabel_1);
        
        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\44745\\eclipse-workspace-extra\\MagicWords\\src\\resources\\glitter-stars.gif"));
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2.setBounds(0, 248, 505, 265);
        contentPane.add(lblNewLabel_2);
        
        JLabel lblNewLabel_3 = new JLabel("");
        lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\44745\\eclipse-workspace-extra\\MagicWords\\src\\resources\\glitter-stars.gif"));
        lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_3.setBounds(470, 248, 505, 265);
        contentPane.add(lblNewLabel_3);
        
        JLabel lblNewLabel_4 = new JLabel("");
        lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\44745\\eclipse-workspace-extra\\MagicWords\\src\\resources\\glitter-stars.gif"));
        lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_4.setBounds(0, 445, 505, 265);
        contentPane.add(lblNewLabel_4);
        
        JLabel lblNewLabel_5 = new JLabel("");
        lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\44745\\eclipse-workspace-extra\\MagicWords\\src\\resources\\glitter-stars.gif"));
        lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_5.setBounds(470, 471, 505, 265);
        contentPane.add(lblNewLabel_5);
    }
}
