package com.trading.tradingbe.tradingbe.connector;

import com.trading.tradingbe.tradingbe.model.dto.stats.*;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PublicTradingApiConnector extends RestApiConnector{
    private final WebClient webClient;
    private static final HttpHeaders headers = new HttpHeaders();
    static {
        headers.add("","");
    }



    public PublicTradingApiConnector(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://api.sandbox.gemini.com/v1")
                //.defaultHeaders(httpHeaders -> httpHeaders.addAll(headers))

                .build();
    }

    public Mono<?> getSymbols() {
        return this.webClient.get().uri("/symbols")
                .retrieve()
                .bodyToMono(String.class);
    }

    public Mono<SymbolDto> getSymbolDetail(String symbol) {
        return this.webClient.get().uri("/symbols/details/{symbol}",symbol)
                .retrieve().bodyToMono(SymbolDto.class);
    }

    public Mono<TickerDto> getSymbolTicker(String symbol) {
        return this.webClient.get().uri("/pubticker/{symbol}",symbol)
                .retrieve().bodyToMono(TickerDto.class);
    }

    public Mono<SymbolListDto> getFeePromos() {
        return this.webClient.get().uri("/feepromos")
                .retrieve().bodyToMono(SymbolListDto.class);
    }

    public Flux<TradeUnitDto> getTradeHistory(String symbol) {
        return this.webClient.get().uri("/trades/{symbol}",symbol)
                .retrieve().bodyToFlux(TradeUnitDto.class);
    }

    public Flux<PriceDto> getPriceFeed() {
        return this.webClient.get().uri("/pricefeed")
                .retrieve().bodyToFlux(PriceDto.class);
    }

}
