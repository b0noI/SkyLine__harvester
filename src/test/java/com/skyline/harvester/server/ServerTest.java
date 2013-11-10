package com.skyline.harvester.server;

import com.skyline.harvester.model.HarvesterInfo;
import com.skyline.harvester.model.HarvesterInfo;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.net.Socket;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

public class ServerTest {

    private Thread serverThread;

    @Before
    public void setUp() throws Exception {
        serverThread = new Thread() {
            @Override
            public void run() {
                try {
                    Server.main(null);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        serverThread.start();
    }

    @Test
    public void testServer() throws Exception {
        Socket socket = new Socket("localhost", 1755);
        ObjectInput in = new ObjectInputStream(socket.getInputStream());
        HarvesterInfo harvesterInfo = (HarvesterInfo)in.readObject();

        assertNotNull(harvesterInfo);
        assertTrue(harvesterInfo.getFreeRam() > 0);
        assertTrue(harvesterInfo.getFreeSwap() > 0);
    }

    @After
    public void tearDown() throws Exception {
        serverThread.stop();

    }
}
