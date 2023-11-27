package com.minsait.micro.prices.adapters.in.web;

import com.minsait.micro.prices.application.ports.in.GetPriceCommand;
import com.minsait.micro.prices.application.ports.in.GetPricePort;
import com.minsait.micro.prices.common.WebAdapter;
import com.minsait.micro.prices.domain.Price;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Optional;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class PriceController {
    private final GetPricePort getPricePort;
    @GetMapping(path = "/prices/getPrice",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Price> getPrice(@RequestParam("applicationDate") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")  LocalDateTime applicationDate,
                                          @RequestParam("productId") Integer productId,
                                          @RequestParam("brandId") Short brandId){
        ResponseEntity responseEntity = ResponseEntity.notFound().build();
        final GetPriceCommand getPriceCommand = new GetPriceCommand(applicationDate,productId,brandId);
        final Optional<Price> price = getPricePort.getPrice(getPriceCommand);
        if (price.isPresent()){
            responseEntity = responseEntity.ok(price.get());
        }
        return responseEntity;
    }
}
