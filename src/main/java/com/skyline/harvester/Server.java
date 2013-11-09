package com.skyline.harvester;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Server {

    // private section

    private static final String FILE_NAME = "server.properties";

    private static final Properties PROPERTIES = new Properties();

    private static final int SERVER_PORT = getServerPort();

    private static final String PORT_KEY_NAME = "port";

    private static int getServerPort() {
        try {
            PROPERTIES.load(new FileInputStream(FILE_NAME));
            return Integer.valueOf(PROPERTIES.getProperty(PORT_KEY_NAME));
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

}
