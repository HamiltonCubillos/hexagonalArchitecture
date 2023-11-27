package com.minsait.micro.prices.application.ports.in;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
@Getter
@RequiredArgsConstructor
public class GetPriceCommand {
    private final LocalDateTime applicationDate;
    private final Integer productId;
    private final Short brandId;
}
