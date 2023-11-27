package com.minsait.micro.prices.application.ports.in;

import com.minsait.micro.prices.domain.Price;

import java.util.Optional;

public interface GetPricePort {
    Optional<Price> getPrice(GetPriceCommand getPriceCommand);
}
