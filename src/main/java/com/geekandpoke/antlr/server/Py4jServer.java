package com.geekandpoke.antlr.server;

import com.geekandpoke.antlr.parsers.java9.Java9ListenerStarter;
import py4j.GatewayServer;

public class Py4jServer {

    public String startListener(String absPath) {
        Java9ListenerStarter.start(absPath);
        return "OK";
    }

    public static void main(String[] args) {
        GatewayServer gatewayServer = new GatewayServer(new Py4jServer());
        gatewayServer.start();
    }
}
