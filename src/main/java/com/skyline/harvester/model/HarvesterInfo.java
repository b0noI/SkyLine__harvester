package com.skyline.harvester.model;

import java.io.Serializable;

public final class HarvesterInfo implements Serializable{

    public double getCpuUsage() {
        return cpuUsage;
    }

    public double getFreeRam() {
        return freeRam;
    }

    public double getFreeSwap() {
        return freeSwap;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HarvesterInfo harvesterInfo = (HarvesterInfo) o;

        if (Double.compare(harvesterInfo.cpuUsage, cpuUsage) != 0) return false;
        if (Double.compare(harvesterInfo.freeRam, freeRam) != 0) return false;
        if (Double.compare(harvesterInfo.freeSwap, freeSwap) != 0) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(cpuUsage);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(freeRam);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(freeSwap);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
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

        public HarvesterInfo build() {
            return new HarvesterInfo(this);
        }

    }

    // private section

    private final double cpuUsage;

    private final double freeRam;

    private final double freeSwap;

    private HarvesterInfo(final Builder builder) {
        this.cpuUsage = builder.getCpuUsage();
        this.freeSwap = builder.getFreeSwap();
        this.freeRam = builder.getFreeRam();
    }

}
