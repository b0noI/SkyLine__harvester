package com.skyline.harvester.controller;

import com.skyline.harvester.model.NodeInfo;
import org.junit.Test;

import static junit.framework.Assert.assertTrue;

public class NodeInfoCollectorTest {

    @Test
    public void testCollect() throws Exception {
        NodeInfoCollector testClass = NodeInfoCollector.getInstance();

        NodeInfo nodeInfo = testClass.collect();

        assertTrue(nodeInfo.getFreeRam() > 0);
        assertTrue(nodeInfo.getFreeSwap() > 0);
    }

}
