package com.minsait.micro.prices.adapters.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Optional;
public interface SpringPriceRepository extends JpaRepository<PriceEntity, Long> {
    Optional<PriceEntity> findFirstByStartDateBeforeAndEndDateAfterAndProductIdAndBrandIdOrderByPriorityDesc
            (final LocalDateTime dateToCompareAfter,
             final LocalDateTime dateToCompareBefore,
             final Integer productId, Short brandId);
}
