package com.trading.tradingbe.tradingbe.model.dto.stats;

import lombok.Data;

import java.util.List;

@Data
public class TickerV2Dto {
    private String symbol;
    private String open;
    private String high;
    private String low;
    private String close;
    private List<String> changes;
    private String bid;
    private String ask;
}
