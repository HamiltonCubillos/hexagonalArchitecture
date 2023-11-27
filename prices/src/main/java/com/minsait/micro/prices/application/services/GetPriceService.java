package com.minsait.micro.prices.application.services;

import com.minsait.micro.prices.application.ports.in.GetPriceCommand;
import com.minsait.micro.prices.application.ports.in.GetPricePort;
import com.minsait.micro.prices.application.ports.out.LoadPricePort;
import com.minsait.micro.prices.common.UseCase;
import com.minsait.micro.prices.domain.Price;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@UseCase
@RequiredArgsConstructor
public class GetPriceService implements GetPricePort {
    private final LoadPricePort loadPricePort;
    @Override
    public Optional<Price> getPrice(final GetPriceCommand getPriceCommand){
        return loadPricePort.loadPrice(getPriceCommand.getApplicationDate(),getPriceCommand.getProductId(),
                getPriceCommand.getBrandId());
    }
}
