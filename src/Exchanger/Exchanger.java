package Exchanger;

import Interfaces.IExchangeRate;
import Interfaces.IExchanger;

public class Exchanger implements IExchanger {
    private static Exchanger exchanger;

    public static Exchanger getInstance(){
        if (exchanger == null){
            exchanger = new Exchanger();
        }
        return exchanger;
    }
    @Override
    public double exchange(IExchangeRate exchangeRateFrom, IExchangeRate exchangeRateTo, double amountOfMoney) {
        return exchangeRateFrom.getRate() * amountOfMoney / exchangeRateTo.getRate();
    }
}
