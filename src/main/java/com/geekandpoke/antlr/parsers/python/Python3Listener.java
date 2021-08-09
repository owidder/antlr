package com.geekandpoke.antlr.parsers.python;

import com.geekandpoke.antlr.grammars.python.Python3Parser;
import com.geekandpoke.antlr.grammars.python.Python3ParserBaseListener;

public class Python3Listener extends Python3ParserBaseListener {

    @Override
    public void enterFuncdef(Python3Parser.FuncdefContext ctx) {
        System.out.println(ctx.getChild(1).getText());
    }

    @Override
    public void enterClassdef(Python3Parser.ClassdefContext ctx) {
        System.out.println(ctx.getChild(1).getText());
    }


}
