package com.skyline.harvester.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HarvesterInfoHelperTest {

    @Test
    public void testSerDeser() throws Exception {
        HarvesterInfo harvesterInfo = new HarvesterInfo.Builder()
                .cpuUsage(1.1)
                .freeRam(2.2)
                .freeSwap(3.3)
                .build();

        byte[] data = HarvesterInfoHelper.serializ(harvesterInfo);
        HarvesterInfo actualResult = HarvesterInfoHelper.deserializ(data);

        assertEquals(harvesterInfo, actualResult);
    }
}
