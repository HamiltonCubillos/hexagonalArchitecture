package com.minsait.micro.prices.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Entidad de negocio
 */
@Data
public class Price {
    private Short brandId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startDate;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endDate;
    private Short tariffIndicator;
    private Integer productId;
    private Byte priority;
    private BigDecimal price;
    private String currency;
}
