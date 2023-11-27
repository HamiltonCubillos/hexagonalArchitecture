package com.minsait.micro.prices.adapters.out.persistence;

import com.minsait.micro.prices.application.ports.out.LoadPricePort;
import com.minsait.micro.prices.common.PersistenceAdapter;
import com.minsait.micro.prices.domain.Price;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.Optional;

@PersistenceAdapter
@RequiredArgsConstructor
public class PricePersistenceAdapter implements LoadPricePort {
    private final SpringPriceRepository springPriceRepository;
    @Override
    public Optional<Price> loadPrice(final LocalDateTime applicationDate,final Integer productId,final Short brandId) {
        return springPriceRepository
                .findFirstByStartDateBeforeAndEndDateAfterAndProductIdAndBrandIdOrderByPriorityDesc(applicationDate,applicationDate,productId,brandId)
                .map(PriceMapper::entityToDomain);
    }
}
