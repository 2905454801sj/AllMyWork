package com.jason.thread.calculator;

public class TaxCalculator {
    private final double salary;
    private final double bonus;
    private CalculatorStrategy calculatorStrategy;

    public void setCalculatorStrategy(CalculatorStrategy calculatorStrategy) {
        this.calculatorStrategy = calculatorStrategy;
    }

    public TaxCalculator(double salary, double bonus) {
        this.salary = salary;
        this.bonus = bonus;
    }

    public double getSalary() {
        return salary;
    }

    public double getBonus() {
        return bonus;
    }

    protected double calaTax(){
        return calculatorStrategy.cal(salary,bonus);
    }
    public double cala(){
        return calaTax();
    }
}
