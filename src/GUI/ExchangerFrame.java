package GUI;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.awt.*;

public class ExchangerFrame extends JFrame{
    public ExchangerFrame(String widnowTitle, int windowWidth, int windowHeight) {
        this.setTitle(widnowTitle);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(windowWidth, windowHeight);
        ImageIcon icon = new ImageIcon(getClass().getResource("/GUI/logoApp.jpg"));
        this.setIconImage(icon.getImage());
        this.getContentPane().setBackground(new Color(17, 143, 80));
        setLayout(new BorderLayout());
    }

}