package AdapterPattern;

// Adapter pattern
public class CurrencyConverterAdapter implements CurrencyConverter {
    private final ExchangeRateService exchangeRateService;

    public CurrencyConverterAdapter(ExchangeRateService exchangeRateService) {
        this.exchangeRateService = exchangeRateService;
    }

    @Override
    public double convert(double amount) {
        double exchangeRate = exchangeRateService.getExchangeRate();
        return amount * exchangeRate;
    }
}
