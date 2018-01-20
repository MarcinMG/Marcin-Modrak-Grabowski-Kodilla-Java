package com.kodilla.patterns.singleton;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class LoggerTestSuite {

    @BeforeClass
    public static void saveToLog() {
        Logger.getInstance().log("00:00 system start");
    }

    @Test
    public void testGetLastLog() {
        //Given
        //When
        String log = Logger.getInstance().getLastLog();
        //Then
        Assert.assertEquals("00:00 system start", log);
    }
}
