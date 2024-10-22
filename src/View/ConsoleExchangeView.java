package View;
import Exchanger.*;

public class ConsoleExchangeView {

    public static void startLoop() {
        Actions actions = Actions.getInstance();
        char option;
        while (true) {
            System.out.println("1. Exchange");
            System.out.println("2. Show all currencies");
            System.out.println("0. EXIT");
            System.out.print("Choice: ");
            ConsoleActions consoleActions = ConsoleActions.getInstance();
            option = consoleActions.askForOption();
            switch (option) {
                case '1':
                    consoleActions.performExchange();
                    break;
                case '2':
                    System.out.println(actions.getData().toString());
                    break;
                case '0':
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid operation. Try again");
            }
        }
    }


}
