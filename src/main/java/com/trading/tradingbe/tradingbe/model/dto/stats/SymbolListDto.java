package com.trading.tradingbe.tradingbe.model.dto.stats;

import lombok.Data;

import java.util.List;

@Data
public class SymbolListDto {
    private List<String> symbols;
}
