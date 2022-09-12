package com.trading.tradingbe.tradingbe.command;

import com.trading.tradingbe.tradingbe.bot.TradingBot;
import com.trading.tradingbe.tradingbe.service.BotService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Scope("prototype")
@Component
public class DeleteBotCommand extends BaseCommand<TradingBot> {
    private final BotService botService;
    private final UUID uuid;

    public DeleteBotCommand(BotService botService, UUID uuid) {
        this.botService = botService;
        this.uuid = uuid;
    }

    @Override
    protected TradingBot doExecute() {
        return botService.removeBot(uuid);
    }
}
