package com.geekandpoke.antlr.parsers.java9;

import com.geekandpoke.antlr.common.Words;
import com.geekandpoke.antlr.grammars.java9.Java9Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;

import java.util.List;

public class PrintTokensJava9Lexer extends Java9Lexer {

    final Words words;

    public PrintTokensJava9Lexer(CharStream input, Words words) {
        super(input);
        this.words = words;
    }

    @Override
    public void emit(Token t) {
        super.emit(t);
        if(t.getType() == Java9Lexer.StringLiteral) {
            words.add(t.getText());
        }
    }
}
