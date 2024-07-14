package com.example;

import com.example.service.CoinCalculatorService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CoinCalculatorServiceTest {

    private final CoinCalculatorService coinCalculatorService = new CoinCalculatorService();

    @Test
    public void testCalculateMinimumCoinsExample1() {
        double targetAmount = 7.03;
        List<Double> coinDenominations = Arrays.asList(0.1, 0.5, 1.0, 5.0, 10.0);
        List<Double> expected = Arrays.asList(5.0, 1.0, 1.0, 0.1, 0.1, 0.1);
        List<Double> result = coinCalculatorService.calculateMinimumCoins(targetAmount, coinDenominations);
        assertEquals(expected, result);
    }

    @Test
    public void testCalculateMinimumCoinsExample2() {
        double targetAmount = 103.0;
        List<Double> coinDenominations = Arrays.asList(1.0, 2.0, 50.0);
        List<Double> expected = Arrays.asList(50.0, 50.0, 2.0, 1.0);
        List<Double> result = coinCalculatorService.calculateMinimumCoins(targetAmount, coinDenominations);
        assertEquals(expected, result);
    }
}