package com.skyline.harvester.model;

public final class NodeInfo {

    public double getCpuUsage() {
        return cpuUsage;
    }

    public double getFreeRam() {
        return freeRam;
    }

    public double getFreeSwap() {
        return freeSwap;
    }

    public static class Builder {

        private double cpuUsage;

        private double freeRam;

        private double freeSwap;

        public Builder freeRam(final double freeRam) {
            this.freeRam = freeRam;
            return this;
        }

        public Builder cpuUsage(final double cpuUsage) {
            this.cpuUsage = cpuUsage;
            return this;
        }

        public Builder freeSwap(final double freeSwap) {
            this.freeSwap = freeSwap;
            return this;
        }

        public double getFreeSwap() {
            return freeSwap;
        }

        public double getFreeRam() {
            return freeRam;
        }

        public double getCpuUsage() {
            return cpuUsage;
        }

        public NodeInfo build() {
            return new NodeInfo(this);
        }

    }

    // private section

    private final double cpuUsage;

    private final double freeRam;

    private final double freeSwap;

    private NodeInfo(final Builder builder) {
        this.cpuUsage = builder.getCpuUsage();
        this.freeSwap = builder.getFreeSwap();
        this.freeRam = builder.getFreeRam();
    }

}
