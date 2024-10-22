package View;
import Interfaces.IExchanger;
import Interfaces.IRateDataParser;
import Interfaces.IRateDataProvider;
import Exchanger.*;


public class LaunchApp {

    public static void launch(String launchType) {

        if (launchType.equals("console")) {
            ConsoleExchangeView.startLoop();
        }
        else if (launchType.equals("window")) {
            WindowExchangeView windowExchangeView = new WindowExchangeView();
            windowExchangeView.show();
        }
        else {
            System.err.println("Undefined launch type");
        }
    }
}

