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
        logger.info("LOG TEST {}", logger.getClass().getName());
        System.out.println( "Hello World!" );
    }
}
