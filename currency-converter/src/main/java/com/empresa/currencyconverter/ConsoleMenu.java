package com.empresa.currencyconverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ConsoleMenu {

    private final CurrencyConverterService converterService;

    @Autowired
    public ConsoleMenu(CurrencyConverterService converterService) {
        this.converterService = converterService;
    }

    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Selecione a opção que deseja para realizar a conversão:");
            for (CurrencyEnum option : CurrencyEnum.values()) {
                System.out.println(option.getOptionNumber() + "- " + option.getDescription());
            }
            int choice = scanner.nextInt();
            if (choice == CurrencyEnum.EXIT.getOptionNumber()) {
                System.out.println("Saindo...");
                break;
            }
            CurrencyEnum selectedOption = CurrencyEnum.getByOptionNumber(choice);
            if (selectedOption == null) {
                System.out.println("Escolha uma opção válida");
                continue;
            }
            System.out.println("Digite o valor que deseja converter:");
            double value = scanner.nextDouble();
            double convertedValue = converterService.convertCurrency(selectedOption, value);
            System.out.println("Valor de " + value + " (" + selectedOption.getFromCurrency() + ") corresponde ao valor final de =>>>> " + convertedValue + " (" + selectedOption.getToCurrency() + ")");
        }
        scanner.close();
    }
}
