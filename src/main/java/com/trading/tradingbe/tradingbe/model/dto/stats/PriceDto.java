package com.trading.tradingbe.tradingbe.model.dto.stats;

import lombok.Data;

@Data
public class PriceDto {
    private String pair;
    private String price;
    private String percentChange24h;
}
