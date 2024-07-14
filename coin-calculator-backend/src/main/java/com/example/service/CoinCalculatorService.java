package com.example.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class CoinCalculatorService {

    public List<Double> calculateMinimumCoins(double targetAmount, List<Double> coinDenominations) {
        Collections.sort(coinDenominations, Collections.reverseOrder());
        List<Double> result = new ArrayList<>();

        for (double coin : coinDenominations) {
            while (targetAmount >= coin) {
                result.add(coin);
                targetAmount -= coin;
            }
            targetAmount = Math.round(targetAmount * 100.0) / 100.0;
        }

        return result;
    }
}