package com.geekandpoke.antlr.parsers.python;

import com.geekandpoke.antlr.grammars.python.Python3Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;

public class PrintTokensPython3Lexer extends Python3Lexer {
    public PrintTokensPython3Lexer(CharStream input) {
        super(input);
    }

    @Override
    public void emit(Token t) {
        super.emit(t);
        if(t.getType() == Python3Lexer.STRING) {
            System.out.println(t.getText());
        }
    }
}
