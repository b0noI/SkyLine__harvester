package com.skyline.harvester.server;

import com.skyline.harvester.controller.NodeInfoCollector;
import com.skyline.harvester.model.HarvesterInfo;
import com.skyline.harvester.model.HarvesterInfo;

final class ServerCache {

    public static ServerCache getInstance() {
        return InstanceHendler.getInstance();
    }

    public HarvesterInfo getHarvesterInfo() {
        long time = System.currentTimeMillis();
        if (time - lastUpdate > CACHE_TIME)
            updateCache();
        return harvesterInfo;
    }

    // private section

    private static final long CACHE_TIME = 100;

    private static final NodeInfoCollector NODE_INFO_COLLECTOR = NodeInfoCollector.getInstance();

    private long lastUpdate = 0;

    private HarvesterInfo harvesterInfo;

    private ServerCache() {}

    private synchronized void updateCache() {
        long time = System.currentTimeMillis();
        if (time - lastUpdate > CACHE_TIME) {
            harvesterInfo = NODE_INFO_COLLECTOR.collect();
        }
    }

    private static final class InstanceHendler {

        private static final ServerCache INSTANCE = new ServerCache();

        public static ServerCache getInstance() {
            return INSTANCE;
        }

    }

}
