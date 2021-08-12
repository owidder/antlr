package com.geekandpoke.antlr.parsers.php;

import com.geekandpoke.antlr.common.Words;
import com.geekandpoke.antlr.grammars.php.PhpParser;
import com.geekandpoke.antlr.parsers.FileUtil;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class PhpListenerStarter {

    public static String start(String absPath) {
        try {
            var words = new Words();

            var code = FileUtil.readFile(new File(absPath), StandardCharsets.UTF_8);
            var lexer = new PrintTokensPhpLexer(CharStreams.fromString(code), words);
            var tokens = new CommonTokenStream(lexer);
            var parser = new PhpParser( tokens);
            var phpListener = new PhpListener(words);
            var walker = new ParseTreeWalker();

            var htmlTree = parser.htmlDocument();
            walker.walk(phpListener, htmlTree);

            var scriptTree = parser.scriptText();
            walker.walk(phpListener, scriptTree);

            var phpTree = parser.phpBlock();
            walker.walk(phpListener, phpTree);

            return words.getText();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws IOException {
        var words = PhpListenerStarter.start("/Users/oliverwidder/Documents/dev/erp_doc/dolibarr/scripts/contracts/email_expire_services_to_customers.php");
        System.out.println(words);
    }
}
