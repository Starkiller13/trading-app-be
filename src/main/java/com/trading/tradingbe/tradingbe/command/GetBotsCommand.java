package com.trading.tradingbe.tradingbe.command;

import com.trading.tradingbe.tradingbe.bot.TradingBot;
import com.trading.tradingbe.tradingbe.service.BotService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
@Scope("prototype")
public class GetBotsCommand extends BaseCommand<Collection<TradingBot>> {
    private final BotService botService;

    public GetBotsCommand(BotService botService) {
        this.botService = botService;
    }
    @Override
    protected Collection<TradingBot> doExecute() {
        return botService.getBots();
    }
}
