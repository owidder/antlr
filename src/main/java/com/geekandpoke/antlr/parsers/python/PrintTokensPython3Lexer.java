package com.geekandpoke.antlr.parsers.python;

import com.geekandpoke.antlr.common.Words;
import com.geekandpoke.antlr.grammars.python.Python3Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;

public class PrintTokensPython3Lexer extends Python3Lexer {

    private final Words words;

    public PrintTokensPython3Lexer(CharStream input, Words words) {
        super(input);
        this.words = words;
    }

    @Override
    public void emit(Token t) {
        super.emit(t);
        if(t.getType() == Python3Lexer.STRING) {
            words.add(t.getText());
        }
    }
}
