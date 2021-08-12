package com.geekandpoke.antlr.parsers.typescript;

import com.geekandpoke.antlr.common.Words;
import com.geekandpoke.antlr.grammars.typescript.TypeScriptParser;
import com.geekandpoke.antlr.grammars.typescript.TypeScriptParserBaseListener;
import com.geekandpoke.antlr.parsers.ListenerGuard;

public class TypeScriptListener extends TypeScriptParserBaseListener {

    private final Words words;

    public TypeScriptListener(Words words) {
        this.words = words;
    }

    @Override
    public void enterClassDeclaration(TypeScriptParser.ClassDeclarationContext ctx) {
        // "class xyz vs. abstract class xyz"
        int index = "abstract".equals(ctx.getChild(0).getText()) ? 2 : 1;
        words.add(ctx.getChild(index).getText());
    }

    @Override
    public void enterFunctionDeclaration(TypeScriptParser.FunctionDeclarationContext ctx) {
        words.add(ctx.getChild(1).getText());
    }
}
