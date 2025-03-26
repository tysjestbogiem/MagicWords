package magicWords;

import javax.swing.UIManager;
import java.awt.EventQueue;

import magicWords.controller.Controller;

public class Main {

    public static void main(String[] args) {

        // set Nimbus Look and Feel
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // start controller >> which starts LoginScreen
        EventQueue.invokeLater(() -> {
            Controller myController = new Controller();
        });
    }
}
