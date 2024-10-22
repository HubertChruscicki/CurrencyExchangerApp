package Interfaces;

public interface IExchangeRate {

    public void setName(String name);

    public String getName();

    public void setCode(String code);

    public String getCode();

    public void setRate(double rate);

    public double getRate();

    public String toString();

    public boolean equals(Object obj);
}
