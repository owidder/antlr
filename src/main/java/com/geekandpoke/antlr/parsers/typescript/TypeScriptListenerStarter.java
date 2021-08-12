package com.geekandpoke.antlr.parsers.typescript;

import com.geekandpoke.antlr.common.Words;
import com.geekandpoke.antlr.grammars.typescript.TypeScriptParser;
import com.geekandpoke.antlr.parsers.FileUtil;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class TypeScriptListenerStarter {

    public static String start(String absPath) {
        try {
            var words = new Words();

            String code = FileUtil.readFile(new File(absPath), StandardCharsets.UTF_8);
            var lexer = new PrintTokensTypeScriptLexer(CharStreams.fromString(code), words);
            var tokens = new CommonTokenStream(lexer);
            var parser = new TypeScriptParser(tokens);
            var tree = parser.program();

            var typeScriptListener = new TypeScriptListener(words);
            var walker = new ParseTreeWalker();
            walker.walk(typeScriptListener, tree);

            return words.getText();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws IOException {
        var words = TypeScriptListenerStarter.start("/Users/oliverwidder/Documents/dev/erp_doc/erpnext/code/agriculture/doctype/agriculture_analysis_criteria/agriculture_analysis_criteria.js");
        System.out.println(words);
    }
}
