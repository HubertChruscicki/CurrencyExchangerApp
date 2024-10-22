package GUI;

import javax.swing.*;
import java.awt.*;

public class MyButton extends JButton{
    public MyButton(String text) {
        super(text);
        setFont(new Font("Arial", Font.BOLD, 16));
        setForeground(Color.WHITE);
        setForeground(new Color(6, 26, 35));
        setBackground(new Color(31, 95, 91));
        setFocusPainted(false);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setPreferredSize(new Dimension(150, 40));
    }
}

