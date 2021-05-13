package character_creation;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Container;
/**
 *
 * @author Eisma
 */
public class GUI {
    
    JFrame window;
    Container con;
    
    public GUI() {
        window = new JFrame();
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        window.setVisible(true);
        con = window.getContentPane();
        
    }
}
