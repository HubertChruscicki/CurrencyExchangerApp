package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DropdownMenu extends JPanel implements ActionListener {
    private JComboBox<String> comboBox;

    public DropdownMenu() {
        this.setLayout(new FlowLayout());
        this.setBackground(new Color(31, 95, 91)); // Ustawiamy kolor tła panelu

        String[] options = {};

        comboBox = new JComboBox<>(options);
        comboBox.setPreferredSize(new Dimension(150, 40)); // Ustawiamy preferowany rozmiar
        comboBox.setBackground(new Color(31, 95, 91)); // Ustawiamy kolor tła
        comboBox.setForeground(new Color(6, 26, 35)); // Ustawiamy kolor tekstu
        comboBox.setFont(new Font("Arial", Font.BOLD, 16)); // Ustawiamy czcionkę
        comboBox.addActionListener(this);

        this.add(comboBox);
    }

    public void setOptions(String[] options) {
        for (String option : options) {
            comboBox.addItem(option);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == comboBox) {
        }
    }

    public String getSelectedItem() {
        return (String) comboBox.getSelectedItem();
    }
}
