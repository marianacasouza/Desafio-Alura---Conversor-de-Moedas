package com.empresa.currencyconverter;

/**
 * Representa a lista de moedas utilizadas no menu
 */
public enum CurrencyEnum {
    USD_TO_BRL(1, "USD ---> BRL", "USD", "BRL"),
    EUR_TO_BRL(2, "EUR ---> BRL", "EUR", "BRL"),
    BRL_TO_ARS(3, "BRL ---> ARS", "BRL", "ARS"),
    BOB_TO_BRL(4, "BOB ---> BRL", "BOB", "BRL"),
    USD_TO_ARS(5, "USD ---> ARS", "USD", "ARS"),
    ARS_TO_CLP(6, "ARS ---> CLP", "ARS", "CLP"),
    EXIT(7, "SAIR", "", "");

    private final int optionNumber;
    private final String description;
    private final String fromCurrency;
    private final String toCurrency;

    CurrencyEnum(int optionNumber, String description, String fromCurrency, String toCurrency) {
        this.optionNumber = optionNumber;
        this.description = description;
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
    }

    public int getOptionNumber() {
        return optionNumber;
    }

    public String getDescription() {
        return description;
    }

    public String getFromCurrency() {
        return fromCurrency;
    }

    public String getToCurrency() {
        return toCurrency;
    }

    public static CurrencyEnum getByOptionNumber(int optionNumber) {
        for (CurrencyEnum option : values()) {
            if (option.getOptionNumber() == optionNumber) {
                return option;
            }
        }
        return null;
    }
}

