package com.skyline.harvester.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HarvesterInfoTest {

    @Test
    public void testBuilder() throws Exception {
        HarvesterInfo testClass = new HarvesterInfo.Builder()
                .cpuUsage(1.1)
                .freeRam(2.2)
                .freeSwap(3.3)
                .build();

        assertEquals(testClass.getCpuUsage(), 1.1, 0.1);
        assertEquals(testClass.getFreeRam(), 2.2, 0.1);
        assertEquals(testClass.getFreeSwap(), 3.3, 0.1);
    }
}
