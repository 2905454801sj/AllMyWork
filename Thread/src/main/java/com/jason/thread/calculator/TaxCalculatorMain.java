package com.jason.thread.calculator;

public class TaxCalculatorMain {
    public static void main(String[] args) {
        /*TaxCalculator taxCalculator=new TaxCalculator(10000d,2000d){
            @Override
            public double calaTax() {
                return getSalary()*0.1+getBonus()*0.15;
            }
        };
        double tax=taxCalculator.cala();
        System.out.println(tax);*/
        TaxCalculator taxCalculator=new TaxCalculator(10000d,20000d);
        CalculatorStrategy calculatorStrategy=new CalculatorStrategyImpl();
        taxCalculator.setCalculatorStrategy(calculatorStrategy);
        System.out.println(taxCalculator.cala());
    }
}
