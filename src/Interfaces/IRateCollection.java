package Interfaces;

import java.util.List;

public interface IRateCollection {
    public List<IExchangeRate> getRateList();
    public IExchangeRate getRateByCode(IExchangeRate rate);
    public String toString();
}
