package com.minsait.micro.prices;

import com.minsait.micro.prices.adapters.out.persistence.PriceEntity;
import com.minsait.micro.prices.adapters.out.persistence.PriceMapper;
import com.minsait.micro.prices.adapters.out.persistence.SpringPriceRepository;
import com.minsait.micro.prices.domain.Price;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PricesApplicationTests {
    private final static DateTimeFormatter LOCAL_DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private final static int PRODUCT_ID = 35455;
    private final static short BRAND_ID = 1;
    @MockBean
    private SpringPriceRepository springPriceRepository;
    @Autowired
    private MockMvc mockMvc;
    @Test
    public void testCase01() throws Exception {
        //GIVEN
        final LocalDateTime applicationDate = LocalDateTime.parse("2020-06-14 10:00:00", LOCAL_DATE_TIME_FORMATTER);
        final Optional<PriceEntity> priceExpectedOptional = Optional.of(new PriceEntity(1L, (short) 1,
                LocalDateTime.parse("2020-06-14 00:00:00",LOCAL_DATE_TIME_FORMATTER),
                LocalDateTime.parse("2020-12-31 23:59:59",LOCAL_DATE_TIME_FORMATTER), (short) 1,35455,
                (byte) 0, new BigDecimal("35.50"),"EUR"));
        final PriceEntity priceEntity = priceExpectedOptional.get();
        final Price price = PriceMapper.entityToDomain(priceEntity);
        //WHEN
        when(springPriceRepository.findFirstByStartDateBeforeAndEndDateAfterAndProductIdAndBrandIdOrderByPriorityDesc(
                applicationDate, applicationDate,PRODUCT_ID,BRAND_ID)).thenReturn(priceExpectedOptional);
        //THEN
        mockMvc.perform(MockMvcRequestBuilders.get("/prices/getPrice")
                        .queryParam("applicationDate", String.valueOf(applicationDate))
                        .queryParam("productId", String.valueOf(PRODUCT_ID))
                        .queryParam("brandId", String.valueOf(BRAND_ID))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price").value(price.getPrice().floatValue()))
                .andDo(print());
    }
    @Test
    public void testCase02() throws Exception {
        //GIVEN
        final LocalDateTime applicationDate = LocalDateTime.parse("2020-06-14 16:00:00", LOCAL_DATE_TIME_FORMATTER);
        final Optional<PriceEntity> priceExpectedOptional = Optional.of(new PriceEntity(2L, (short) 1,
                LocalDateTime.parse("2020-06-14 15:00:00",LOCAL_DATE_TIME_FORMATTER),
                LocalDateTime.parse("2020-06-14 18:30:00",LOCAL_DATE_TIME_FORMATTER), (short) 2,35455,
                (byte) 1, new BigDecimal("25.45"),"EUR"));
        final PriceEntity priceEntity = priceExpectedOptional.get();
        final Price price = PriceMapper.entityToDomain(priceEntity);
        //WHEN
        when(springPriceRepository.findFirstByStartDateBeforeAndEndDateAfterAndProductIdAndBrandIdOrderByPriorityDesc(
                applicationDate, applicationDate,PRODUCT_ID,BRAND_ID)).thenReturn(priceExpectedOptional);
        //THEN
        mockMvc.perform(MockMvcRequestBuilders.get("/prices/getPrice")
                        .queryParam("applicationDate", String.valueOf(applicationDate))
                        .queryParam("productId", String.valueOf(PRODUCT_ID))
                        .queryParam("brandId", String.valueOf(BRAND_ID))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price").value(price.getPrice().floatValue()))
                .andDo(print());
    }
    @Test
    public void testCase03() throws Exception {
        //GIVEN
        final LocalDateTime applicationDate = LocalDateTime.parse("2020-06-14 21:00:00", LOCAL_DATE_TIME_FORMATTER);
        final Optional<PriceEntity> priceExpectedOptional = Optional.of(new PriceEntity(1L, (short) 1,
                LocalDateTime.parse("2020-06-14 00:00:00",LOCAL_DATE_TIME_FORMATTER),
                LocalDateTime.parse("2020-12-31 23:59:59",LOCAL_DATE_TIME_FORMATTER), (short) 1,35455,
                (byte) 0, new BigDecimal("35.50"),"EUR"));
        final PriceEntity priceEntity = priceExpectedOptional.get();
        final Price price = PriceMapper.entityToDomain(priceEntity);
        //WHEN
        when(springPriceRepository.findFirstByStartDateBeforeAndEndDateAfterAndProductIdAndBrandIdOrderByPriorityDesc(
                applicationDate, applicationDate,PRODUCT_ID,BRAND_ID)).thenReturn(priceExpectedOptional);
        //THEN
        mockMvc.perform(MockMvcRequestBuilders.get("/prices/getPrice")
                        .queryParam("applicationDate", String.valueOf(applicationDate))
                        .queryParam("productId", String.valueOf(PRODUCT_ID))
                        .queryParam("brandId", String.valueOf(BRAND_ID))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price").value(price.getPrice().floatValue()))
                .andDo(print());
    }
    @Test
    public void testCase04() throws Exception {
        //GIVEN
        final LocalDateTime applicationDate = LocalDateTime.parse("2020-06-15 10:00:00", LOCAL_DATE_TIME_FORMATTER);
        final Optional<PriceEntity> priceExpectedOptional = Optional.of(new PriceEntity(3L, (short) 1,
                LocalDateTime.parse("2020-06-14 00:00:00",LOCAL_DATE_TIME_FORMATTER),
                LocalDateTime.parse("2020-06-15 11:00:00",LOCAL_DATE_TIME_FORMATTER), (short) 3,35455,
                (byte) 1, new BigDecimal("30.50"),"EUR"));
        final PriceEntity priceEntity = priceExpectedOptional.get();
        final Price price = PriceMapper.entityToDomain(priceEntity);
        //WHEN
        when(springPriceRepository.findFirstByStartDateBeforeAndEndDateAfterAndProductIdAndBrandIdOrderByPriorityDesc(
                applicationDate, applicationDate,PRODUCT_ID,BRAND_ID)).thenReturn(priceExpectedOptional);
        //THEN
        mockMvc.perform(MockMvcRequestBuilders.get("/prices/getPrice")
                        .queryParam("applicationDate", String.valueOf(applicationDate))
                        .queryParam("productId", String.valueOf(PRODUCT_ID))
                        .queryParam("brandId", String.valueOf(BRAND_ID))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price").value(price.getPrice().floatValue()))
                .andDo(print());
    }
    @Test
    public void testCase05() throws Exception {
        //GIVEN
        final LocalDateTime applicationDate = LocalDateTime.parse("2020-06-16 21:00:00", LOCAL_DATE_TIME_FORMATTER);
        final Optional<PriceEntity> priceExpectedOptional = Optional.of(new PriceEntity(4L, (short) 1,
                LocalDateTime.parse("2020-06-15 16:00:00",LOCAL_DATE_TIME_FORMATTER),
                LocalDateTime.parse("2020-12-31 23:59:59",LOCAL_DATE_TIME_FORMATTER), (short) 4,35455,
                (byte) 1, new BigDecimal("38.95"),"EUR"));
        final PriceEntity priceEntity = priceExpectedOptional.get();
        final Price price = PriceMapper.entityToDomain(priceEntity);
        //WHEN
        when(springPriceRepository.findFirstByStartDateBeforeAndEndDateAfterAndProductIdAndBrandIdOrderByPriorityDesc(
                applicationDate, applicationDate,PRODUCT_ID,BRAND_ID)).thenReturn(priceExpectedOptional);
        //THEN
        mockMvc.perform(MockMvcRequestBuilders.get("/prices/getPrice")
                        .queryParam("applicationDate", String.valueOf(applicationDate))
                        .queryParam("productId", String.valueOf(PRODUCT_ID))
                        .queryParam("brandId", String.valueOf(BRAND_ID))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price").value(price.getPrice().floatValue()))
                .andDo(print());
    }
}
