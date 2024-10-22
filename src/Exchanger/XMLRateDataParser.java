package Exchanger;

import Interfaces.IRateDataParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


public class XMLRateDataParser implements IRateDataParser {

    @Override
    public RateCollection parseData(String data) {
        ObjectMapper objectMapper = new ObjectMapper();
        RateCollection rateCollection = new RateCollection();

        try {
            JsonNode rootNode = objectMapper.readTree(data);
            JsonNode ratesNode = rootNode.get(0).get("rates");
            String effectiveDate = rootNode.get(0).get("effectiveDate").asText();

            ExchangeRate pln = new ExchangeRate("złoty polski", "PLN", 1.0);
            rateCollection.getRateList().add(pln);

            for (JsonNode rateNode : ratesNode) {
                String currency = rateNode.get("currency").asText();
                String code = rateNode.get("code").asText();
                double mid = rateNode.get("mid").asDouble();

                ExchangeRate exchangeRate = new ExchangeRate(currency, code, mid);
                rateCollection.getRateList().add(exchangeRate);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        return rateCollection;
    }
}
