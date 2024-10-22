package GUI;

import View.WindowActions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExchangeButton extends MyButton {

    WindowActions windowActions = WindowActions.getInstance();

    public ExchangeButton() {
        super("Exchange");

        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                windowActions.performExchange();
            }
        });
    }

}