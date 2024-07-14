package com.example.controller;

import com.example.model.CoinRequest;
import com.example.service.CoinCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/coin-calculator")
public class CoinCalculatorController {

    @Autowired
    private CoinCalculatorService coinCalculatorService;

    @PostMapping("/calculate")
    public List<Double> calculateMinimumCoins(@RequestBody CoinRequest request) {
        return coinCalculatorService.calculateMinimumCoins(request.getTargetAmount(), request.getCoinDenominations());
    }
}