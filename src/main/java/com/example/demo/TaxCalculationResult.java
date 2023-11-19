package com.example.demo;

public class TaxCalculationResult {
    private double taxRate;
    private double taxAmount;
    private double netIncome;

    public TaxCalculationResult(double taxRate, double taxAmount, double netIncome) {
        this.taxRate = taxRate;
        this.taxAmount = taxAmount;
        this.netIncome = netIncome;
    }

    public double getTaxRate() {
        return taxRate;
    }

    public double getTaxAmount() {
        return taxAmount;
    }

    public double getNetIncome() {
        return netIncome;
    }
}