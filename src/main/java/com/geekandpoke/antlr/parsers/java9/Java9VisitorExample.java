package com.geekandpoke.antlr.parsers.java9;

import com.geekandpoke.antlr.grammars.java9.Java9Lexer;
import com.geekandpoke.antlr.grammars.java9.Java9Parser;
import com.geekandpoke.antlr.parsers.FileUtil;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Java9VisitorExample {

    public static void main(String[] args) throws IOException {
        var java9Visitor = new Java9Visitor();
        var code = FileUtil.readFile(new File("/Users/oliverwidder/Documents/dev/erp_doc/axelor-open-suite/axelor-business-project/src/main/java/com/axelor/apps/businessproject/web/InvoicingProjectController.java"), StandardCharsets.UTF_8);
        var lexer = new Java9Lexer(CharStreams.fromString(code));
        var tokens = new CommonTokenStream(lexer);
        var parser = new Java9Parser(tokens);
        var tree = parser.compilationUnit();
        java9Visitor.visit(tree);

        System.out.println(String.join(" ", java9Visitor.words));
    }
}
