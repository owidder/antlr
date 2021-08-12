package com.geekandpoke.antlr.parsers.java9;

import com.geekandpoke.antlr.common.Words;
import com.geekandpoke.antlr.grammars.java9.Java9Parser;
import com.geekandpoke.antlr.parsers.FileUtil;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Java9ListenerStarter {

    public static String start(String absPath) {
        try {
            var words = new Words();

            var code = FileUtil.readFile(new File(absPath), StandardCharsets.UTF_8);
            var lexer = new PrintTokensJava9Lexer(CharStreams.fromString(code), words);
            var tokens = new CommonTokenStream(lexer);
            var parser = new Java9Parser(tokens);
            var tree = parser.compilationUnit();

            var java9Listener = new Java9Listener(words);
            var walker = new ParseTreeWalker();
            walker.walk(java9Listener, tree);

            return words.getText();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        var words = Java9ListenerStarter.start("/Users/oliverwidder/Documents/dev/erp_doc/axelor-open-suite/axelor-business-project/src/main/java/com/axelor/apps/businessproject/web/ProjectFolderController.java");
        System.out.println(words);
    }
}
