package com.geekandpoke.antlr.server;

import com.geekandpoke.antlr.parsers.java9.Java9ListenerStarter;
import com.geekandpoke.antlr.parsers.php.PhpListenerStarter;
import com.geekandpoke.antlr.parsers.python.PythonListenerStarter;
import com.geekandpoke.antlr.parsers.typescript.TypeScriptListenerStarter;
import py4j.GatewayServer;

public class Py4jServer {

    private static String _startListener(String absPath) {
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

    public String startListener(String absPath) {
        return Py4jServer._startListener(absPath);
    }

    public static void main(String[] args) {
        if(args.length > 0) {
            System.out.println(_startListener(args[0]));
        } else {
            GatewayServer gatewayServer = new GatewayServer(new Py4jServer());
            gatewayServer.start();
        }
    }
}
