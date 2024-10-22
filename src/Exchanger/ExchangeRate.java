package Exchanger;

import Interfaces.IExchangeRate;

public class ExchangeRate implements IExchangeRate {
    private String name;
    private String code;
    private double rate;

    public ExchangeRate(String name, String code, double rate) {
        this.name = name;
        this.code = code;
        this.rate = rate;
    }
    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public void setRate(double rate) {
        this.rate = rate;
    }

    @Override
    public double getRate() {
        return rate;
    }


    @Override
    public String toString() {
        return "cos.ExchangeRate [name=" + name + ", code=" + code + ", rate=" + rate + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ExchangeRate other = (ExchangeRate) obj;

        if ((name == null && other.name != null) || (name != null && !name.equals(other.name))) {
            return false;
        }
        if ((code == null && other.code != null) || (code != null && !code.equals(other.code))) {
            return false;
        }

        return Double.compare(rate, other.rate) == 0;
    }

}
