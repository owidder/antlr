package com.geekandpoke.antlr.parsers.python;

import com.geekandpoke.antlr.grammars.python.Python3Lexer;
import com.geekandpoke.antlr.grammars.python.Python3Parser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;

public class ParserFacade {

    public static String readFile(File file, Charset encoding) throws IOException {
        byte[] encoded = Files.readAllBytes(file.toPath());
        return new String(encoded, encoding);
    }

    public Python3Parser.File_inputContext parse(File file) throws IOException {
        String code = readFile(file, Charset.forName("UTF-8"));
        Python3Lexer lexer = new Python3Lexer(CharStreams.fromString(code));

        CommonTokenStream tokens = new CommonTokenStream(lexer);

        Python3Parser parser = new Python3Parser(tokens);

        return parser.file_input();
    }
}
