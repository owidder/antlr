package com.geekandpoke.antlr.parsers.java9;

import com.geekandpoke.antlr.common.Words;
import com.geekandpoke.antlr.grammars.java9.Java9Parser;
import com.geekandpoke.antlr.grammars.java9.Java9ParserBaseListener;
import com.geekandpoke.antlr.parsers.ListenerGuard;

import java.util.ArrayList;
import java.util.List;

public class Java9Listener extends Java9ParserBaseListener {

    private final Words words;

    public Java9Listener(Words words) {
        this.words = words;
    }

    ListenerGuard identifierGuard = new ListenerGuard();

    @Override
    public void enterClassDeclaration(Java9Parser.ClassDeclarationContext ctx) {
        identifierGuard.openGate();
    }

    @Override
    public void exitClassDeclaration(Java9Parser.ClassDeclarationContext ctx) {
        identifierGuard.endOpenOrClose();
    }

    @Override
    public void enterAnnotation(Java9Parser.AnnotationContext ctx) {
        identifierGuard.closeGate();
    }

    @Override
    public void exitAnnotation(Java9Parser.AnnotationContext ctx) {
        identifierGuard.endOpenOrClose();
    }

    @Override
    public void enterIdentifier(Java9Parser.IdentifierContext ctx) {
        if(identifierGuard.isGateOpen()) {
            words.add(ctx.getText());
        }
    }

    @Override
    public void enterClassBody(Java9Parser.ClassBodyContext ctx) {
        identifierGuard.closeGate();
    }

    @Override
    public void exitClassBody(Java9Parser.ClassBodyContext ctx) {
        identifierGuard.endOpenOrClose();
    }

    @Override
    public void enterMethodDeclaration(Java9Parser.MethodDeclarationContext ctx) {
        identifierGuard.openGate();
    }

    @Override
    public void exitMethodDeclaration(Java9Parser.MethodDeclarationContext ctx) {
        identifierGuard.endOpenOrClose();
    }

    @Override
    public void enterTypeParameters(Java9Parser.TypeParametersContext ctx) {
        identifierGuard.closeGate();
    }

    @Override
    public void exitTypeParameters(Java9Parser.TypeParametersContext ctx) {
        identifierGuard.endOpenOrClose();
    }

    @Override
    public void enterFormalParameterList(Java9Parser.FormalParameterListContext ctx) {
        identifierGuard.closeGate();
    }

    @Override
    public void exitFormalParameterList(Java9Parser.FormalParameterListContext ctx) {
        identifierGuard.endOpenOrClose();
    }

    @Override
    public void enterMethodBody(Java9Parser.MethodBodyContext ctx) {
        identifierGuard.closeGate();
    }

    @Override
    public void exitMethodBody(Java9Parser.MethodBodyContext ctx) {
        identifierGuard.endOpenOrClose();
    }

    @Override
    public void enterThrows_(Java9Parser.Throws_Context ctx) {
        identifierGuard.closeGate();
    }

    @Override
    public void exitThrows_(Java9Parser.Throws_Context ctx) {
        identifierGuard.endOpenOrClose();
    }
}
