package com.geekandpoke.antlr.parsers.java9;

import com.geekandpoke.antlr.grammars.java9.Java9Parser;
import com.geekandpoke.antlr.parsers.FileUtil;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Java9ListenerStarter {

    public static void start(String absPath) {
        try {
            var code = FileUtil.readFile(new File(absPath), StandardCharsets.UTF_8);
            var lexer = new PrintTokensJava9Lexer(CharStreams.fromString(code));
            var tokens = new CommonTokenStream(lexer);
            var parser = new Java9Parser(tokens);
            var tree = parser.compilationUnit();

            var java9Listener = new Java9Listener();
            var walker = new ParseTreeWalker();
            walker.walk(java9Listener, tree);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Java9ListenerStarter.start("/Users/oliverwidder/Documents/dev/erp_doc/axelor-open-suite/axelor-business-project/src/main/java/com/axelor/apps/businessproject/web/ProjectFolderController.java");
    }
}
