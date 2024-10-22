package View;
import Exchanger.Actions;
import GUI.*;
import Interfaces.*;
import Exchanger.*;
import javax.swing.*;

public class WindowActions {

    private static WindowActions windowActions;
    private Actions actions = Actions.getInstance();
    private InputLabel inputLabel = new InputLabel();
    private OutputTextLabel outputTextLabel = new OutputTextLabel("");
    private DropdownMenu currencyFromMenu = new DropdownMenu();
    private DropdownMenu currencyToMenu = new DropdownMenu();

    public static WindowActions getInstance() {
        if (windowActions == null) {
            windowActions = new WindowActions();
        }
        return windowActions;
    }

    public InputLabel getInputLabel() {
        return windowActions.inputLabel;
    }


    public OutputTextLabel getOutputTextLabel() {
        return outputTextLabel;
    }

    public DropdownMenu getCurrencyFromMenu() {
        return currencyFromMenu;
    }

    public DropdownMenu getCurrencyToMenu() {
        return currencyToMenu;
    }

    public void clearFields() {
        inputLabel.setText("");
        outputTextLabel.setText("");
    }


    public void performExchange() {
        String amountStr = InputHandler.inputAmount(inputLabel.getText()); //dziala pan
        if (amountStr.equals("INVALID INPUT")) {
            outputTextLabel.setText("INVALID INPUT");
            return;
        }
        if (amountStr.equals("EMPTY INPUT") || amountStr.equals("NOT A NUMBER") || amountStr.equals("NEGATIVE AMOUNT")) {
            outputTextLabel.setText(amountStr);
            return;
        }
        amountStr = amountStr.replace(",", ".");
        try {
            double amount = Double.parseDouble(amountStr);
            outputTextLabel.setText("Enter the currency code to exchange from: ");
            String fromCurrencyCode = currencyFromMenu.getSelectedItem().toString();
            IExchangeRate fromCurrency = actions.chooseCurrency(fromCurrencyCode);
            if (fromCurrency == null) {
                outputTextLabel.setText("Invalid currency code. Please try again.");
                return;
            }
            outputTextLabel.setText("Enter the currency code to exchange to: ");
            String toCurrencyCode = currencyToMenu.getSelectedItem().toString();
            IExchangeRate toCurrency = actions.chooseCurrency(toCurrencyCode);
            if (fromCurrency == null) {
                outputTextLabel.setText("Invalid currency code. Please try again.");
                return;
            }
            double result = actions.exchange(amount, fromCurrency, toCurrency);
            outputTextLabel.setText(String.format("%.2f %s", result, toCurrency.getCode()));
        } catch (NumberFormatException e) {
            outputTextLabel.setText("Invalid amount format: " + e.getMessage());
        }
    }
}












//        String amounts = inputLabel();
//
//        if (amountStr.equals("Invalid input.")) {
//            System.out.println("Invalid input. Please try again.");
//            return;
//        }
//        if (amountStr.equals("EMPTY INPUT") || amountStr.equals("NOT A NUMBER") || amountStr.equals("AMOUNT CANNOT BE NEGATIVE")) {
//            System.out.println(amountStr);
//            return;
//        }
//        amountStr = amountStr.replace(",", ".");
//        try {
//            double amount = Double.parseDouble(amountStr);
//            System.out.print("Enter the currency code to exchange from: ");
//            String fromCurrencyCode = scanner.next().toUpperCase();
//            IExchangeRate fromCurrency = actions.chooseCurrency(fromCurrencyCode);
//            if (fromCurrency == null ) {
//                System.out.println("Invalid currency code. Please try again.");
//                return;
//            }
//
//            System.out.print("Enter the currency code to exchange to: ");
//            String toCurrencyCode = scanner.next().toUpperCase();
//            IExchangeRate toCurrency = actions.chooseCurrency(toCurrencyCode);
//            if (toCurrency == null) {
//                System.out.println("Invalid currency code. Please try again.");
//                return;
//            }
//
//            double result = actions.exchange(amount, fromCurrency, toCurrency);
//            System.out.println(String.format("%.2f %s = %.2f %s", amount, fromCurrency.getCode(), result, toCurrency.getCode()));
//        } catch (NumberFormatException e) {
//            System.out.println("Invalid amount format: " + e.getMessage());
//        }


