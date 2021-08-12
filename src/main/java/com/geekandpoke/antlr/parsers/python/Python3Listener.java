package com.geekandpoke.antlr.parsers.python;

import com.geekandpoke.antlr.common.Words;
import com.geekandpoke.antlr.grammars.python.Python3Parser;
import com.geekandpoke.antlr.grammars.python.Python3ParserBaseListener;

public class Python3Listener extends Python3ParserBaseListener {

    private final Words words;

    public Python3Listener(Words words) {
        this.words = words;
    }

    @Override
    public void enterFuncdef(Python3Parser.FuncdefContext ctx) {
        words.add(ctx.getChild(1).getText());
    }

    @Override
    public void enterClassdef(Python3Parser.ClassdefContext ctx) {
        words.add(ctx.getChild(1).getText());
    }


}
