package GUI;

import javax.swing.*;
import java.awt.*;

public class OutputTextLabel extends JLabel {
    public OutputTextLabel(String text) {
        super(text);
        setFont(new Font("Arial", Font.BOLD, 72));
        setForeground(new Color(21, 153, 72));
        setForeground(Color.WHITE);
        setHorizontalAlignment(JLabel.CENTER);
        setVerticalAlignment(JLabel.CENTER);
    }
}
