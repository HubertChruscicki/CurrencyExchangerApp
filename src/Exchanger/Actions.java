package Exchanger;
import Interfaces.*;


public class Actions
{
    private IRateDataProvider dataProvider;
    private IRateDataParser dataParser;
    private IExchanger exchanger;
    private static Actions instance = null;

    private Actions() {
        dataProvider = new XMLRateDataProvider();
        dataParser = new XMLRateDataParser();
        exchanger = Exchanger.getInstance();
    }
    
    public static Actions getInstance() {
        if (instance == null) {
            instance = new Actions();
        }
        return instance;
    }

    public IRateCollection getData() {
        String data = dataProvider.getData();
        return dataParser.parseData(data);
    }
    public double exchange(double amount, IExchangeRate currencyFrom, IExchangeRate currencyTo) {
        return exchanger.exchange(currencyFrom, currencyTo, amount);
    }

    public IExchangeRate chooseCurrency(String code) {
        IRateCollection rateCollection= this.getData();
        try {
            IExchangeRate exchangeRate = rateCollection.getRateList().stream()
                    .filter(rate -> rate.getCode().equals(code))
                    .findFirst()
                    .orElse(null);

            return exchangeRate;
        }
        catch (Exception e) {
            throw new IllegalArgumentException("No such a currency, try again");
        }

    }

}
