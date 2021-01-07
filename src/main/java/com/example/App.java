package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 *
 */
public class App 
{
    private static Logger logger = LoggerFactory.getLogger(App.class);
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        printLogs();
    }
    
    public static void printLogs() {
        logger.error("LOG TEST {}", "error");
        logger.warn("LOG TEST {}", "warn");
        logger.info("LOG TEST {}", "info");
        logger.debug("LOG TEST {}", "debug");
        logger.trace("LOG TEST {}", "trace");
    }
}
