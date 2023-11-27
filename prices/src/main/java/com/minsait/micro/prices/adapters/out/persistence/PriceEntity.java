package com.minsait.micro.prices.adapters.out.persistence;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Entity
@Table(name = "prices")
@NoArgsConstructor
public class PriceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Short brandId;
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime startDate;
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime endDate;
    private Short tariffIndicator;
    private Integer productId;
    private Byte priority;
    @Column(precision = 6, scale = 2)
    private BigDecimal price;
    private String currency;
}
