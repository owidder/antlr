package com.geekandpoke.antlr.parsers.python;

import com.geekandpoke.antlr.grammars.python.Python3Parser;
import com.geekandpoke.antlr.grammars.python.Python3ParserBaseVisitor;

import java.util.HashSet;
import java.util.Set;

public class Python3Visitor extends Python3ParserBaseVisitor<Void> {

    public final Set<String> words = new HashSet<>();

    @Override
    public Void visitFuncdef(Python3Parser.FuncdefContext ctx) {
        words.add(ctx.NAME().toString());
        return null;
    }

    @Override
    public Void visitClassdef(Python3Parser.ClassdefContext ctx) {
        words.add(ctx.NAME().toString());
        return null;
    }
}
