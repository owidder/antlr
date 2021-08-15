package com.geekandpoke.antlr.parsers.python;

import com.geekandpoke.antlr.common.Words;
import com.geekandpoke.antlr.grammars.python.Python3Parser;
import com.geekandpoke.antlr.parsers.FileUtil;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class PythonListenerStarter {

    public static String start(String absPath) {
        try {
            var words = new Words();

            String code = FileUtil.readFile(new File(absPath), StandardCharsets.UTF_8);
            var lexer = new PrintTokensPython3Lexer(CharStreams.fromString(code), words);
            var tokens = new CommonTokenStream(lexer);
            var parser = new Python3Parser(tokens);
            var tree = parser.file_input();

            var python3Listener = new Python3Listener(words);
            var walker = new ParseTreeWalker();
            walker.walk(python3Listener, tree);

            return words.getText();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) throws IOException {
        String words = PythonListenerStarter.start("/Users/oliverwidder/Documents/dev/erp_doc/erpnext/code/healthcare/doctype/clinical_procedure/clinical_procedure.py");
        System.out.println(words);
    }
}
