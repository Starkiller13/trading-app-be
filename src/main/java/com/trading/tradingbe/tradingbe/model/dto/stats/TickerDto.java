package com.trading.tradingbe.tradingbe.model.dto.stats;

import lombok.Data;

@Data
public class TickerDto {
    private String ask;
    private String bid;
    private String last;
    private Object volume;
}