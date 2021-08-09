package com.geekandpoke.antlr.parsers.python;

import com.geekandpoke.antlr.grammars.python.Python3Lexer;
import com.geekandpoke.antlr.grammars.python.Python3Parser;
import com.geekandpoke.antlr.parsers.FileUtil;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class ParserFacade {

    public Python3Parser.File_inputContext parse(File file) throws IOException {
        String code = FileUtil.readFile(file, StandardCharsets.UTF_8);
        Python3Lexer lexer = new Python3Lexer(CharStreams.fromString(code));

        CommonTokenStream tokens = new CommonTokenStream(lexer);

        Python3Parser parser = new Python3Parser(tokens);

        return parser.file_input();
    }
}
