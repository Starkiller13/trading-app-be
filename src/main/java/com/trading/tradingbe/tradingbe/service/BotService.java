package com.trading.tradingbe.tradingbe.service;

import com.trading.tradingbe.tradingbe.bot.TradingBot;
import com.trading.tradingbe.tradingbe.exception.BotLimitExceededException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BotService{
    private static final Map<UUID, TradingBot> BOT_MAP = new HashMap<>();
    private static final Integer LIMIT = 5;

    public UUID addBot(){
        if(BOT_MAP.size()<5){
            TradingBot tradingBot = new TradingBot();
            BOT_MAP.put(tradingBot.getBotId(),tradingBot);
            return tradingBot.getBotId();
        }
        throw new BotLimitExceededException();
    }

    public TradingBot removeBot(UUID uuid){
        return BOT_MAP.remove(uuid);
    }

    public Collection<TradingBot> getBots(){
        return BOT_MAP.values();
    }
}
