package com.trading.tradingbe.tradingbe.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BaseCommand<OUTPUT> {
    protected final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    protected  Boolean canExecute(){
        return true;
    }

    protected abstract OUTPUT doExecute();

    public OUTPUT execute(){
        return canExecute()?doExecute():null;
    }

}