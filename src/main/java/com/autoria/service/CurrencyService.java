package com.autoria.service;

import lombok.RequiredArgsConstructor;
import octen.java.com.autoria.model.CurrencyRate;
import octen.java.com.autoria.repository.CurrencyRateRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CurrencyService {

    private final CurrencyRateRepository currencyRateRepository;

    // Повертає курс конкретної валюти
    public double getRate(String currency) {
        Optional<CurrencyRate> rate = currencyRateRepository.findByCurrency(currency.toUpperCase());
        return rate.map(CurrencyRate::getRate).
