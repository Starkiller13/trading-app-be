package com.trading.tradingbe.tradingbe.command;

import com.trading.tradingbe.tradingbe.service.BotService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Scope("prototype")
@Component
public class CreateBotCommand extends BaseCommand<UUID> {
    private final BotService botService;

    public CreateBotCommand(BotService botService) {
        this.botService = botService;
    }

    @Override
    protected UUID doExecute() {
        return botService.addBot();
    }
}
