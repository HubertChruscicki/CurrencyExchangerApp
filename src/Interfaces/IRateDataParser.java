package Interfaces;

import Exchanger.RateCollection;

public interface IRateDataParser {
    public RateCollection parseData(String data);
}
