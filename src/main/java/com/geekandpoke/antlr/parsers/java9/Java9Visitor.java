package com.geekandpoke.antlr.parsers.java9;

import com.geekandpoke.antlr.grammars.java9.Java9Parser;
import com.geekandpoke.antlr.grammars.java9.Java9ParserBaseVisitor;

import java.util.HashSet;
import java.util.Set;

public class Java9Visitor extends Java9ParserBaseVisitor<Void> {

    public final Set<String> words = new HashSet<>();

    @Override
    public Void visitClassType(Java9Parser.ClassTypeContext ctx) {
        return super.visitClassType(ctx);
    }
}
