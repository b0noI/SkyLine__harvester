package com.skyline.harvester.model;

import java.io.*;

public final class NodeInfoHelper {

    public static byte[] serializ(NodeInfo nodeInfo) {
        try(ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutput out = new ObjectOutputStream(bos)) {
            out.writeObject(nodeInfo);
            return bos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
