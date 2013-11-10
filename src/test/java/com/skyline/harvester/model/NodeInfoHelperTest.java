package com.skyline.harvester.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NodeInfoHelperTest {

    @Test
    public void testSerDeser() throws Exception {
        NodeInfo nodeInfo = new NodeInfo.Builder()
                .cpuUsage(1.1)
                .freeRam(2.2)
                .freeSwap(3.3)
                .build();

        byte[] data = NodeInfoHelper.serializ(nodeInfo);
        NodeInfo actualResult = NodeInfoHelper.deserializ(data);

        assertEquals(nodeInfo, actualResult);
    }
}
