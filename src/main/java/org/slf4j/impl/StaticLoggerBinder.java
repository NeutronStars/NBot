package org.slf4j.impl;

import org.slf4j.spi.LoggerFactoryBinder;

import java.io.IOException;

/**
 * Origin Code by SLF4J-Simple [Link=https://github.com/qos-ch/slf4j/tree/master/slf4j-simple]
 * Modified by NeutronStars
 */

public class StaticLoggerBinder implements LoggerFactoryBinder
{
    private static final StaticLoggerBinder SINGLETON = new StaticLoggerBinder();

    public static final StaticLoggerBinder getSingleton() {
        return SINGLETON;
    }

    private final BotLoggerFactory loggerFactory;

    public StaticLoggerBinder()
    {
        BotLoggerFactory loggerFactory = null;
        try {
            loggerFactory = new BotLoggerFactory();
        }catch (IOException ignored){}

        this.loggerFactory = loggerFactory;
    }

    @Override
    public BotLoggerFactory getLoggerFactory()
    {
        return loggerFactory;
    }

    @Override
    public String getLoggerFactoryClassStr()
    {
        return loggerFactory.getClass().getName();
    }
}
