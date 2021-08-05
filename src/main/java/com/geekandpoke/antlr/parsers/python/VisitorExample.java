package com.geekandpoke.antlr.parsers.python;

import com.geekandpoke.antlr.grammars.python.Python3Lexer;
import com.geekandpoke.antlr.grammars.python.Python3Parser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

public class VisitorExample {

    public static void main(String[] args) throws IOException {
        var python3Visitor = new Python3Visitor();
        String code = ParserFacade.readFile(new File("examples/render.py"), Charset.forName("UTF-8"));
        var lexer = new Python3Lexer(CharStreams.fromString(code));
        var tokens = new CommonTokenStream(lexer);
        var parser = new Python3Parser(tokens);
        var tree = parser.file_input();
        python3Visitor.visit(tree);

        System.out.println(String.join(" ", python3Visitor.words));
    }
}
