package com.example;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import lombok.extern.slf4j.Slf4j;

/**
 * Unit test for simple App.
 */
@Slf4j
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        App.exec();
        assertTrue( true );
        User user = new User();
        user.setId(Integer.valueOf(1));
        user.setName("Bob");
        assertThat(user.getId(), is(1));
        assertThat(user.getName(), is("Bob"));
        log.debug("Slf4j Lombok");
    }
}
