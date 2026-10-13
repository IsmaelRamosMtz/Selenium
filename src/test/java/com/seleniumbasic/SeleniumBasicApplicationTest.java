package com.seleniumbasic;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple SeleniumBasicApplication.
 */
public class SeleniumBasicApplicationTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public SeleniumBasicApplicationTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( SeleniumBasicApplicationTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testExampleAssertion()
    {
        assertTrue( true );
    }
}
