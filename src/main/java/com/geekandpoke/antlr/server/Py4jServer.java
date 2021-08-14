package com.geekandpoke.antlr.server;

import com.geekandpoke.antlr.parsers.java9.Java9ListenerStarter;
import com.geekandpoke.antlr.parsers.php.PhpListenerStarter;
import com.geekandpoke.antlr.parsers.python.PythonListenerStarter;
import com.geekandpoke.antlr.parsers.typescript.TypeScriptListenerStarter;
import py4j.GatewayServer;

public class Py4jServer {

    public String startListener(String absPath) {
        try {
            var parts = absPath.split("\\.");
            var ext = parts[parts.length-1];

            return switch (ext) {
                case "java" -> Java9ListenerStarter.start(absPath);
                case "php" -> PhpListenerStarter.start(absPath);
                case "py" -> PythonListenerStarter.start(absPath);
                case "js", "jsx", "ts", "tsx" -> TypeScriptListenerStarter.start(absPath);
                default -> "";
            };
        } catch (Exception e) {
            return "";
        }
    }

    public static void main(String[] args) {
        GatewayServer gatewayServer = new GatewayServer(new Py4jServer());
        gatewayServer.start();
    }
}
