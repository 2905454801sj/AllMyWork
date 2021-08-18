package com.jason.thread.calculator;

public class CalculatorStrategyImpl implements CalculatorStrategy{
    @Override
    public double cal(double s, double b) {
        return s*0.1+b*0.15;
    }
}
