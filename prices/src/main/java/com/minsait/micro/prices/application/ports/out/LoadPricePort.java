package com.minsait.micro.prices.application.ports.out;

import com.minsait.micro.prices.domain.Price;

import java.time.LocalDateTime;
import java.util.Optional;

public interface LoadPricePort {
    Optional<Price> loadPrice(LocalDateTime applicationDate, Integer productId, Short brandId);
}
