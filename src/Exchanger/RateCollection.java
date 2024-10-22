package Exchanger;

import Interfaces.IExchangeRate;
import Interfaces.IRateCollection;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class RateCollection implements IRateCollection {
    private LocalDateTime timeStamp;
    private String id;
    private List<IExchangeRate> list;
    public RateCollection() {
        list = new ArrayList<>();
    }

    @Override
    public List<IExchangeRate> getRateList() {
        return this.list;
    }

    @Override
    public IExchangeRate getRateByCode(IExchangeRate rate) {
        for (IExchangeRate rateTmp : list) {
            if (rate.equals(rateTmp)) {
                return rateTmp;
            }
        }
        return null;
    }

    @Override
    public String toString(){
        String temp = "";
        for (IExchangeRate rateTmp : list) {
            temp += "[" + rateTmp.getCode()  + "]\t" +rateTmp.getName()+ "\n";
        }
        return temp;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


}
