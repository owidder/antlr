package com.geekandpoke.antlr.parsers.python;

import com.geekandpoke.antlr.grammars.python.Python3Parser;
import com.geekandpoke.antlr.parsers.FileUtil;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class PythonListenerExample {

    public static void main(String[] args) throws IOException {
        String code = FileUtil.readFile(new File("/Users/oliverwidder/Documents/dev/erp_doc/erpnext/code/healthcare/doctype/clinical_procedure/clinical_procedure.py"), StandardCharsets.UTF_8);
        var lexer = new PrintTokensPython3Lexer(CharStreams.fromString(code));
        var tokens = new CommonTokenStream(lexer);
        var parser = new Python3Parser(tokens);
        var tree = parser.file_input();

        var python3Listener = new Python3Listener();
        var walker = new ParseTreeWalker();
        walker.walk(python3Listener, tree);
    }
}
