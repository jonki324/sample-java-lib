package com.example;

import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 *
 */
public class App 
{
    private static Logger logger = LoggerFactory.getLogger(App.class);
    private static ResourceBundle rBundle = ResourceBundle.getBundle("app");
    public static void main( String[] args )
    {
        exec();
    }
    
    public static void exec() {
        System.out.println( "Hello World!" );
        printLogs();
        printProp();
    }
    
    public static void printLogs() {
        logger.error("LOG TEST {}", "error");
        logger.warn("LOG TEST {}", "warn");
        logger.info("LOG TEST {}", "info");
        logger.debug("LOG TEST {}", "debug");
        logger.trace("LOG TEST {}", "trace");
    }
    
    public static void printProp() {
        String val = rBundle.getString("key");
        logger.info(val);
    }
}
