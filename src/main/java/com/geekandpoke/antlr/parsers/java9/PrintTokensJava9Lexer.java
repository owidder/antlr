package com.geekandpoke.antlr.parsers.java9;

import com.geekandpoke.antlr.grammars.java9.Java9Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;

public class PrintTokensJava9Lexer extends Java9Lexer {
    public PrintTokensJava9Lexer(CharStream input) {
        super(input);
    }

    @Override
    public void emit(Token t) {
        super.emit(t);
        if(t.getType() == Java9Lexer.StringLiteral) {
            System.out.println(t.getText());
        }
    }
}
