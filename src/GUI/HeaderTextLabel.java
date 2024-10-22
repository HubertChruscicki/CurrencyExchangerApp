package GUI;

import javax.swing.*;
import java.awt.*;

public class HeaderTextLabel extends JLabel {
    public HeaderTextLabel(String text) {
        super(text);
        setFont(new Font("Arial", Font.BOLD, 52));
        setForeground(new Color(21, 153, 72));
        setHorizontalAlignment(JLabel.CENTER);
        setVerticalAlignment(JLabel.CENTER);
        setBorder(BorderFactory.createEmptyBorder(60, 0, 20, 0));
    }
}
