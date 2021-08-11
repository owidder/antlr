package com.geekandpoke.antlr.server;

import com.geekandpoke.antlr.parsers.java9.Java9ListenerStarter;
import py4j.GatewayServer;

public class Py4jServer {

    public String startListener(String absPath) {
        var parts = absPath.split("\\.");
        var ext = parts[parts.length-1];
        return Java9ListenerStarter.start(absPath);
    }

    public static void main(String[] args) {
        GatewayServer gatewayServer = new GatewayServer(new Py4jServer());
        gatewayServer.start();
    }
}
