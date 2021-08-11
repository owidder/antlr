package com.geekandpoke.antlr.parsers.php;

import com.geekandpoke.antlr.common.Words;
import com.geekandpoke.antlr.grammars.php.PhpLexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;

public class PrintTokensPhpLexer extends PhpLexer {

    private final Words words;

    public PrintTokensPhpLexer(CharStream input, Words words) {
        super(input);
        this.words = words;
    }

    @Override
    public void emit(Token t) {
        super.emit(t);
        if(t.getType() == PhpLexer.StringType
                || t.getType() == PhpLexer.StringPart
                || t.getType() == PhpLexer.SingleQuoteString
                || t.getType() == PhpLexer.DoubleQuote
                || t.getType() == PhpLexer.PHPStartDoubleQuoteString) {
            words.add(t.getText());
        }
    }
}
