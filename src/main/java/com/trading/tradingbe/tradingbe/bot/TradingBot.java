package com.trading.tradingbe.tradingbe.bot;

import com.trading.tradingbe.tradingbe.model.enums.BotStateEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.context.annotation.Scope;

import java.util.UUID;

@Scope("prototype")
@Data
@EqualsAndHashCode(callSuper = true)
public class TradingBot extends Thread {
    private final UUID botId;
    private BotStateEnum botState;

    public TradingBot() {
        this.botId = UUID.randomUUID();
        this.botState = BotStateEnum.CREATED;
    }

    private void changeState(BotStateEnum nextState){
        if(botState !=nextState){
            switch (nextState){
                case RUNNING -> this.start();
                case STOPPED -> this.interrupt();
            }
        }
    }

    @Override
    public void run() {

    }
}
