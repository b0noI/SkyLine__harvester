package com.skyline.harvester.server;

import com.skyline.harvester.controller.NodeInfoCollector;
import com.skyline.harvester.model.NodeInfo;
import com.skyline.harvester.model.NodeInfoHelper;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.Socket;

final class SocketThread extends Thread{

    public SocketThread(final Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream())){
            byte[] data = NodeInfoHelper.serializ(SERVER_CACHE.getNodeInfo());
            bufferedOutputStream.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // private section

    private static final ServerCache SERVER_CACHE = ServerCache.getInstance();

    private final Socket socket;

}
