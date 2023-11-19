package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500/")

public class TaxCalculatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaxCalculatorApplication.class, args);
    }

    @PostMapping("/calculate_tax")

    public TaxCalculationResult calculateTax(@RequestParam double salary) {
        double taxRate;
        double taxAmount;

        salary = salary - 5000;
        if (salary  <= 0) {
            taxRate = 0;
        } else if (salary <= 3000) {
            taxRate = 3;
        } else if (salary <= 12000) {
            taxRate = 10;
        } else if (salary <= 25000) {
            taxRate = 20;
        } else if (salary <= 35000) {
            taxRate = 25;
        } else {
            taxRate = 0;
        }

        taxAmount = salary * (taxRate / 100);
        salary = salary + 5000;
        double netIncome = salary - taxAmount;

        return new TaxCalculationResult(taxRate, taxAmount, netIncome);
    }
}