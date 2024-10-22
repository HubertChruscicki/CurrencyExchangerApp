package GUI;

import View.WindowActions;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClearButton extends MyButton {

    WindowActions windowActions = WindowActions.getInstance();

    public ClearButton() {
        super("Clear");

        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                windowActions.clearFields();
            }
        });
    }

}
