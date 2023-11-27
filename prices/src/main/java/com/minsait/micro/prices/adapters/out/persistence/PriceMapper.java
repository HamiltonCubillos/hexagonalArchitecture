package com.minsait.micro.prices.adapters.out.persistence;

import com.minsait.micro.prices.domain.Price;

public class PriceMapper {
    public static Price entityToDomain(PriceEntity priceEntity) {
        final Price price = new Price();
        price.setPrice(priceEntity.getPrice());
        price.setCurrency(priceEntity.getCurrency());
        price.setPriority(priceEntity.getPriority());
        price.setBrandId(priceEntity.getBrandId());
        price.setEndDate(priceEntity.getEndDate());
        price.setProductId(priceEntity.getProductId());
        price.setStartDate(priceEntity.getStartDate());
        price.setTariffIndicator(priceEntity.getTariffIndicator());
        return price;
    }

    public static PriceEntity domainToEntity(Price price) {
        final PriceEntity priceEntity = new PriceEntity();
        priceEntity.setPrice(price.getPrice());
        priceEntity.setBrandId(price.getBrandId());
        priceEntity.setEndDate(price.getEndDate());
        priceEntity.setProductId(price.getProductId());
        priceEntity.setCurrency(price.getCurrency());
        priceEntity.setPriority(price.getPriority());
        priceEntity.setStartDate(price.getStartDate());
        priceEntity.setTariffIndicator(price.getTariffIndicator());
        return priceEntity;
    }
}
