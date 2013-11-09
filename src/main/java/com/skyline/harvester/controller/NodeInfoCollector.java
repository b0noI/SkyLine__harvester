package com.skyline.harvester.controller;

import com.skyline.harvester.model.NodeInfo;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public final class NodeInfoCollector {

    public static NodeInfoCollector getInstance() {
        return InstanceHandler.getInstance();
    }

    public NodeInfo collect() {
        return new NodeInfo.Builder()
                .cpuUsage(collectCpuUsage())
                .freeRam(collectFreeRam())
                .freeSwap(collectFreeSwap())
                .build();
    }

    // private section

    private static final String GET_SYSTEM_CPU_LOAD_METHOD_NAME = "getSystemCpuLoad";

    private static final String GET_TOTAL_PHYSICAL_MEMORY_SIZE_METHOD_NAME = "getTotalPhysicalMemorySize";

    private static final String GET_FREE_PHYSICAL_MEMORY_SIZE_METHOD_NAME = "getFreePhysicalMemorySize";

    private static final String GET_TOTAL_SWAP_SPACE_SIZE_MTHOD_NAME = "getTotalSwapSpaceSize";

    private static final String GET_FREE_SWAP_SPACE_SIZE_METHOD_NAME = "getFreeSwapSpaceSize";

    private static final OperatingSystemMXBean OPERATING_SYSTEM_MX_BEAN = ManagementFactory.getOperatingSystemMXBean();

    private NodeInfoCollector(){}

    private double collectCpuUsage() {
        try {
            return collectValue(GET_SYSTEM_CPU_LOAD_METHOD_NAME);
        } catch (ClassCastException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
            return 0.0;
        }
    }

    private double collectFreeSwap() {
        try {
            long totalSwap = collectValue(GET_TOTAL_SWAP_SPACE_SIZE_MTHOD_NAME);
            long freeSwap = collectValue(GET_FREE_SWAP_SPACE_SIZE_METHOD_NAME);
            return freeSwap / totalSwap;
        } catch (ClassCastException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
            return 0.0;
        }
    }

    private double collectFreeRam() {
        try {
            long totalMemory = collectValue(GET_TOTAL_PHYSICAL_MEMORY_SIZE_METHOD_NAME);
            long freeMemory = collectValue(GET_FREE_PHYSICAL_MEMORY_SIZE_METHOD_NAME);
            return freeMemory / totalMemory;
        } catch (ClassCastException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
            return 0.0;
        }
    }

    private <T>T collectValue(final String methodName) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        final Method method = OPERATING_SYSTEM_MX_BEAN.getClass().getDeclaredMethod(GET_TOTAL_PHYSICAL_MEMORY_SIZE_METHOD_NAME);
        method.setAccessible(true);
        return (T)method.invoke(methodName);
    }

    private static class InstanceHandler {

        private static final NodeInfoCollector INSTANCE = new NodeInfoCollector();

        public static NodeInfoCollector getInstance() {
            return InstanceHandler.INSTANCE;
        }

    }

}
