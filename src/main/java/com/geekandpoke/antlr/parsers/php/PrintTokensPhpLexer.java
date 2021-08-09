package com.geekandpoke.antlr.parsers.php;

import com.geekandpoke.antlr.grammars.php.PhpLexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;

public class PrintTokensPhpLexer extends PhpLexer {
    public PrintTokensPhpLexer(CharStream input) {
        super(input);
    }

    @Override
    public void emit(Token t) {
        super.emit(t);
//        System.out.println("--> " + t.getType() + "/" + PhpLexer.VOCABULARY.getDisplayName(t.getType()));
//        System.out.println(t.getText());
        if(t.getType() == PhpLexer.StringType
                || t.getType() == PhpLexer.StringPart
                || t.getType() == PhpLexer.SingleQuoteString
                || t.getType() == PhpLexer.DoubleQuote
                || t.getType() == PhpLexer.PHPStartDoubleQuoteString) {
            System.out.println(t.getText());
        }
    }
}
