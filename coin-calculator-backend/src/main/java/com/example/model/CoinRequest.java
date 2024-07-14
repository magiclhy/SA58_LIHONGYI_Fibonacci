package com.example.model;

import java.util.List;

public class CoinRequest {
    private double targetAmount;
    private List<Double> coinDenominations;

    // Getters and Setters
    public double getTargetAmount() {
        return targetAmount;
    }

    public void setTargetAmount(double targetAmount) {
        this.targetAmount = targetAmount;
    }

    public List<Double> getCoinDenominations() {
        return coinDenominations;
    }

    public void setCoinDenominations(List<Double> coinDenominations) {
        this.coinDenominations = coinDenominations;
    }
}