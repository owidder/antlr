package com.geekandpoke.antlr.parsers.typescript;

import com.geekandpoke.antlr.common.Words;
import com.geekandpoke.antlr.grammars.typescript.TypeScriptLexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;

public class PrintTokensTypeScriptLexer extends TypeScriptLexer {

    private final Words words;

    public PrintTokensTypeScriptLexer(CharStream input, Words words) {
        super(input);
        this.words = words;
    }

    @Override
    public void emit(Token t) {
        super.emit(t);
        if(t.getType() == TypeScriptLexer.StringLiteral) {
            System.out.println(t.getText());
        }
    }
}
