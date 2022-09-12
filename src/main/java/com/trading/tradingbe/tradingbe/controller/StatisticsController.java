package com.trading.tradingbe.tradingbe.controller;

import com.trading.tradingbe.tradingbe.connector.PublicTradingApiConnector;
import com.trading.tradingbe.tradingbe.model.dto.stats.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "statistics")
public class StatisticsController {
    private final PublicTradingApiConnector apiConnector;

    public StatisticsController(PublicTradingApiConnector apiConnector) {
        this.apiConnector = apiConnector;
    }

    @RequestMapping(value = "/market")
    public ResponseEntity<String> getMarketSymbols(){
        return ResponseEntity.ok(Objects.requireNonNull(apiConnector.getSymbols().block()).toString());
    }

    @RequestMapping(value = "/market/{symbol}")
    public ResponseEntity<SymbolDto> getMarketSymbols(@PathVariable String symbol){
        return ResponseEntity.ok(Objects.requireNonNull(apiConnector.getSymbolDetail(symbol).block()));
    }

    @RequestMapping(value = "/market/fee-promos")
    public ResponseEntity<SymbolListDto> getFeePromos(){
        return ResponseEntity.ok(Objects.requireNonNull(apiConnector.getFeePromos().block()));
    }

    @RequestMapping(value = "/market/ticker/{symbol}")
    public ResponseEntity<TickerDto> getSymbolsTicker(@PathVariable String symbol){
        return ResponseEntity.ok(Objects.requireNonNull(apiConnector.getSymbolTicker(symbol).block()));
    }

    @RequestMapping(value = "/market/trades/{symbol}")
    public ResponseEntity<List<TradeUnitDto>> getTradeHistory(@PathVariable String symbol){
        return ResponseEntity.ok(Objects.requireNonNull(apiConnector.getTradeHistory(symbol).buffer().blockFirst()));
    }

    @RequestMapping(value = "/market/price-feed")
    public ResponseEntity<List<PriceDto>> getPriceFeed(){
        return ResponseEntity.ok(Objects.requireNonNull(apiConnector.getPriceFeed().buffer().blockFirst()));
    }
}
