package com.trading.tradingbe.tradingbe.controller;

import com.trading.tradingbe.tradingbe.bot.TradingBot;
import com.trading.tradingbe.tradingbe.command.CreateBotCommand;
import com.trading.tradingbe.tradingbe.command.DeleteBotCommand;
import com.trading.tradingbe.tradingbe.command.GetBotsCommand;
import com.trading.tradingbe.tradingbe.service.BotService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.UUID;

@RestController
@RequestMapping("bots")
public class BotController {
    private final BeanFactory beanFactory;
    private final BotService botService;

    public BotController(BeanFactory beanFactory, BotService botService) {
        this.beanFactory = beanFactory;
        this.botService = botService;
    }

    @PutMapping("/create")
    public ResponseEntity<UUID> createBot(){
        CreateBotCommand command = beanFactory.getBean(CreateBotCommand.class,botService);
        return ResponseEntity.ok(command.execute());
    }

    @GetMapping("/list")
    public ResponseEntity<Collection<TradingBot>> getBots(){
        GetBotsCommand command = beanFactory.getBean(GetBotsCommand.class,botService);
        return ResponseEntity.ok(command.execute());
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<TradingBot> deleteBot(@PathVariable UUID uuid){
        DeleteBotCommand command = beanFactory.getBean(DeleteBotCommand.class,botService,uuid);
        return ResponseEntity.ok(command.execute());
    }


}
