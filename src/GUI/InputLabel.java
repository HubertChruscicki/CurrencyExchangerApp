package GUI;

import javax.swing.*;
import java.awt.*;

public class InputLabel extends JPanel {
    private JTextField textField;

    public InputLabel() {
        textField = new JTextField();
        textField.setPreferredSize(new Dimension(250, 40));
        textField.setFont(new Font("Arial", Font.BOLD, 44));
        textField.setBackground(new Color(31, 95, 91));
        textField.setBackground(new Color(31, 95, 91));
        textField.setForeground(new Color(6, 26, 35));
        textField.setBorder(null);

        setLayout(new FlowLayout(FlowLayout.LEFT));

        setBackground(new Color(31, 95, 91));

        add(textField);
    }

    public String getText() {
        return textField.getText();
    }

    public void setText(String s) {
        textField.setText(s);
    }

    public void clearText() {
        textField.setText("");
    }
}
