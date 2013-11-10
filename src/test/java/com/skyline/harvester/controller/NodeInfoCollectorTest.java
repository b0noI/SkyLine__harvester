package com.skyline.harvester.controller;

import com.skyline.harvester.model.HarvesterInfo;
import com.skyline.harvester.model.HarvesterInfo;
import org.junit.Test;

import static junit.framework.Assert.assertTrue;

public class NodeInfoCollectorTest {

    @Test
    public void testCollect() throws Exception {
        NodeInfoCollector testClass = NodeInfoCollector.getInstance();

        HarvesterInfo harvesterInfo = testClass.collect();

        assertTrue(harvesterInfo.getFreeRam() > 0);
        assertTrue(harvesterInfo.getFreeSwap() > 0);
    }

}
