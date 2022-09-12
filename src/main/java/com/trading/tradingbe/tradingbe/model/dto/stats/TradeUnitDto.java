package com.trading.tradingbe.tradingbe.model.dto.stats;

import lombok.Data;

@Data
public class TradeUnitDto {
    private Long timestamp;
    private Long timestampms;
    private Integer tid;
    private String price;
    private String amount;
    private String exchange;
    private String type;
}
