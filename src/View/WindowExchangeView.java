package View;
import Exchanger.*;
import GUI.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Interfaces.*;

public class WindowExchangeView {

    private ExchangerFrame frame;
    private HeaderTextLabel headerTextLabel;
    private OutputTextLabel outputTextLabel;
    private JPanel mainPanel;
    private Actions actions = Actions.getInstance();
    private WindowActions windowActions = WindowActions.getInstance();

    public WindowExchangeView() {
        frame = new ExchangerFrame("Currency Exchanger", 800, 600);
        headerTextLabel = new HeaderTextLabel("Currency Exchanger");
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        JPanel panel1 = new JPanel();
        panel1.setBackground(new Color(6, 55, 58));
        panel1.setPreferredSize(new Dimension(frame.getWidth(), 140));
        panel1.add(headerTextLabel);
        mainPanel.add(panel1);

        JPanel panel2 = new JPanel();
        panel2.setBackground(new Color(6, 55, 58));
        panel2.setPreferredSize(new Dimension(frame.getWidth(), 120));
        panel2.add(windowActions.getCurrencyFromMenu());
        panel2.add(windowActions.getInputLabel());
        panel2.add(windowActions.getCurrencyToMenu());
        mainPanel.add(panel2);

        JPanel panel3 = new JPanel();
        panel3.setBackground(new Color(6, 55, 58));
        panel3.setPreferredSize(new Dimension(frame.getWidth(), 140));
        panel3.add(windowActions.getOutputTextLabel());
        mainPanel.add(panel3);

        JPanel panel4 = new JPanel();
        panel4.setBackground(new Color(6, 55, 58));
        panel4.setPreferredSize(new Dimension(frame.getWidth(), 100));
        MyButton exchangeButton = new ExchangeButton();
        MyButton clearButton = new ClearButton();
        panel4.add(exchangeButton);
        panel4.add(clearButton);
        mainPanel.add(panel4);


        frame.add(mainPanel);

        try{
            IRateCollection rateCollection = actions.getData();

            IExchanger exchanger = Exchanger.getInstance();
            String[] currencyCodes = rateCollection.getRateList().stream()
                    .map(IExchangeRate::getCode)
                    .toArray(String[]::new);

            windowActions.getCurrencyFromMenu().setOptions(currencyCodes);
            windowActions.getCurrencyToMenu().setOptions(currencyCodes);
        }
        catch (Exception e) {
            windowActions.getInputLabel().setText("Error: " + e.getMessage());
        }

    }

    public void show() {
        frame.setVisible(true);
    }
}

