package com.skyline.harvester.server;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Properties;

public class Server {

    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(SERVER_PORT)) {
            while (true) {
                Socket clientSocket = serverSocket.accept();
                new SocketThread(clientSocket).run();
            }
        }
    }

    // private section

    private static final Properties PROPERTIES = new Properties();

    private static final String FILE_NAME = "server.properties";

    static {
        try {
            PROPERTIES.load(Server.class.getResourceAsStream(FILE_NAME));
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    private static final int SERVER_PORT = getServerPort();

    private static final String PORT_KEY_NAME = "port";

    private static int getServerPort() {
        return Integer.valueOf(PROPERTIES.getProperty(PORT_KEY_NAME));
    }

}
