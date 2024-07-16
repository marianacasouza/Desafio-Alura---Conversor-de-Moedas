package com.empresa.currencyconverter;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CurrencyConverterService {

    private static final String API_URL = "https://v6.exchangerate-api.com/v6/bc969eba866c1357a681c017/latest/";

    private final RestTemplate restTemplate;

    @Autowired
    public CurrencyConverterService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public double convertCurrency(CurrencyEnum currencyEnum, double value) {
        String url = API_URL + currencyEnum.getFromCurrency();
        String response = restTemplate.getForObject(url, String.class);
        ExchangeRateResponse exchangeRateResponse = new Gson().fromJson(response, ExchangeRateResponse.class);

        if (exchangeRateResponse != null && exchangeRateResponse.getConversion_rates() != null) {
            Double rate = exchangeRateResponse.getConversion_rates().get(currencyEnum.getToCurrency());
            if (rate != null) {
                return value * rate;
            } else {
                System.out.println("Taxa de conversão não encontrada para " + currencyEnum.getToCurrency());
                return 0;
            }
        } else {
            System.out.println("Resposta inválida da API ou taxa de conversão não encontrada.");
            return 0;
        }
    }
}
