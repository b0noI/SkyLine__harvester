package com.skyline.harvester.model;

import java.io.*;

public final class HarvesterInfoHelper {

    public static byte[] serializ(HarvesterInfo harvesterInfo) {
        try(ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutput out = new ObjectOutputStream(bos)) {
            out.writeObject(harvesterInfo);
            return bos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static HarvesterInfo deserializ(byte[] data) {
        try(ByteArrayInputStream bais = new ByteArrayInputStream(data);
            ObjectInput in = new ObjectInputStream(bais)) {
            return (HarvesterInfo)in.readObject();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
