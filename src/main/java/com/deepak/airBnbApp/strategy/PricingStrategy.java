package com.deepak.airBnbApp.strategy;

import com.deepak.airBnbApp.entity.Inventory;

import java.math.BigDecimal;

public interface PricingStrategy {
    BigDecimal calculatePrice(Inventory inventory);
}
