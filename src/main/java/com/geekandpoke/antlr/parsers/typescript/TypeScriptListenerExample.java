package com.geekandpoke.antlr.parsers.typescript;

import com.geekandpoke.antlr.grammars.typescript.TypeScriptParser;
import com.geekandpoke.antlr.parsers.FileUtil;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class TypeScriptListenerExample {

    public static void main(String[] args) throws IOException {
        String code = FileUtil.readFile(new File("/Users/oliverwidder/Documents/dev/erp_doc/erpnext/code/agriculture/doctype/agriculture_analysis_criteria/agriculture_analysis_criteria.js"), StandardCharsets.UTF_8);
        var lexer = new PrintTokensTypeScriptLexer(CharStreams.fromString(code));
        var tokens = new CommonTokenStream(lexer);
        var parser = new TypeScriptParser(tokens);
        var tree = parser.program();

        var typeScriptListener = new TypeScriptListener();
        var walker = new ParseTreeWalker();
        walker.walk(typeScriptListener, tree);
    }
}
