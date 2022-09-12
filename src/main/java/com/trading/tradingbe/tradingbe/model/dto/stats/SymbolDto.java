package com.trading.tradingbe.tradingbe.model.dto.stats;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SymbolDto {
    @JsonProperty("symbol")
    private String symbol;
    @JsonProperty("base_currency")
    private String baseCurrency;
    @JsonProperty("quote_currency")
    private String quoteCurrency;
    @JsonProperty("tick_size")
    private Double tickSize;
    @JsonProperty("quote_increment")
    private Double quoteIncrement;
    @JsonProperty("min_order_size")
    private String minOrderSize;
    @JsonProperty("status")
    private String status;
    @JsonProperty("wrap_enabled")
    private Boolean wrapEnabled;
}