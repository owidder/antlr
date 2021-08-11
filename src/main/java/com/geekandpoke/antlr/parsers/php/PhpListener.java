package com.geekandpoke.antlr.parsers.php;

import com.geekandpoke.antlr.common.Words;
import com.geekandpoke.antlr.grammars.php.PhpParser;
import com.geekandpoke.antlr.grammars.php.PhpParserBaseListener;
import com.geekandpoke.antlr.parsers.ListenerGuard;

import java.util.ArrayList;
import java.util.List;

public class PhpListener extends PhpParserBaseListener {

    private final Words words;
    ListenerGuard identifierGuard = new ListenerGuard();

    public PhpListener(Words words) {
        this.words = words;
    }

    @Override
    public void enterIdentifier(PhpParser.IdentifierContext ctx) {
        if(identifierGuard.isGateOpen()) {
            System.out.println(ctx.getText());
        }
    }

    @Override
    public void enterFunctionDeclaration(PhpParser.FunctionDeclarationContext ctx) {
        identifierGuard.openGate();
    }

    @Override
    public void exitFunctionDeclaration(PhpParser.FunctionDeclarationContext ctx) {
        identifierGuard.endOpenOrClose();
    }

    @Override
    public void enterAttributes(PhpParser.AttributesContext ctx) {
        identifierGuard.closeGate();
    }

    @Override
    public void exitAttributes(PhpParser.AttributesContext ctx) {
        identifierGuard.endOpenOrClose();
    }

    @Override
    public void enterTypeParameterListInBrackets(PhpParser.TypeParameterListInBracketsContext ctx) {
        identifierGuard.closeGate();
    }

    @Override
    public void exitTypeParameterListInBrackets(PhpParser.TypeParameterListInBracketsContext ctx) {
        identifierGuard.endOpenOrClose();
    }

    @Override
    public void enterFormalParameterList(PhpParser.FormalParameterListContext ctx) {
        identifierGuard.closeGate();
    }

    @Override
    public void exitFormalParameterList(PhpParser.FormalParameterListContext ctx) {
        identifierGuard.endOpenOrClose();
    }

    @Override
    public void enterTypeHint(PhpParser.TypeHintContext ctx) {
        identifierGuard.closeGate();
    }

    @Override
    public void exitTypeHint(PhpParser.TypeHintContext ctx) {
        identifierGuard.endOpenOrClose();
    }

    @Override
    public void enterBlockStatement(PhpParser.BlockStatementContext ctx) {
        identifierGuard.closeGate();
    }

    @Override
    public void exitBlockStatement(PhpParser.BlockStatementContext ctx) {
        identifierGuard.endOpenOrClose();
    }
}
