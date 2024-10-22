package View;

import java.util.Scanner;
import Exchanger.*;
import Interfaces.*;


public class ConsoleActions {

    private Scanner scanner = new Scanner(System.in);
    private static ConsoleActions consoleInputProvider;
    private Actions actions = Actions.getInstance();

    public static ConsoleActions getInstance() {
        if (consoleInputProvider == null) {
            consoleInputProvider = new ConsoleActions();
        }
        return consoleInputProvider;
    }
    public char askForOption() {
        try {
            return scanner.next().charAt(0);
        } catch (Exception e) {
            System.out.println("Invalid input. Please try again.");
            return askForOption();
        }
    }

    public void performExchange() {
        System.out.print("Enter the amount to exchange: ");
        String amountStr = InputHandler.inputAmount(scanner.next());

        if (amountStr.equals("Invalid input.")) {
            System.out.println("Invalid input. Please try again.");
            return;
        }
        if (amountStr.equals("EMPTY INPUT") || amountStr.equals("NOT A NUMBER") || amountStr.equals("AMOUNT CANNOT BE NEGATIVE")) {
            System.out.println(amountStr);
            return;
        }
        amountStr = amountStr.replace(",", ".");
        try {
            double amount = Double.parseDouble(amountStr);
            System.out.print("Enter the currency code to exchange from: ");
            String fromCurrencyCode = scanner.next().toUpperCase();
            IExchangeRate fromCurrency = actions.chooseCurrency(fromCurrencyCode);
            if (fromCurrency == null ) {
                System.out.println("Invalid currency code. Please try again.");
                return;
            }

            System.out.print("Enter the currency code to exchange to: ");
            String toCurrencyCode = scanner.next().toUpperCase();
            IExchangeRate toCurrency = actions.chooseCurrency(toCurrencyCode);
            if (toCurrency == null) {
                System.out.println("Invalid currency code. Please try again.");
                return;
            }

            double result = actions.exchange(amount, fromCurrency, toCurrency);
            System.out.println(String.format("%.2f %s = %.2f %s", amount, fromCurrency.getCode(), result, toCurrency.getCode()));
        } catch (NumberFormatException e) {
            System.out.println("Invalid amount format: " + e.getMessage());
        }

    }

}