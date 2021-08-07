package com.geekandpoke.antlr.parsers.java9;

import com.geekandpoke.antlr.grammars.java9.Java9Parser;
import com.geekandpoke.antlr.grammars.java9.Java9ParserBaseListener;

import java.util.Stack;

public class Java9Listener extends Java9ParserBaseListener {

    Stack<Boolean> listenStack = new Stack<>();

    @Override
    public void enterClassDeclaration(Java9Parser.ClassDeclarationContext ctx) {
        listenStack.push(true);
    }

    @Override
    public void exitClassDeclaration(Java9Parser.ClassDeclarationContext ctx) {
        listenStack.pop();
    }

    @Override
    public void enterAnnotation(Java9Parser.AnnotationContext ctx) {
        listenStack.push(false);
    }

    @Override
    public void exitAnnotation(Java9Parser.AnnotationContext ctx) {
        listenStack.pop();
    }

    @Override
    public void enterIdentifier(Java9Parser.IdentifierContext ctx) {
        if(listenStack.size() > 0 && listenStack.peek()) {
            System.out.println(ctx.getText());
        }
    }

    @Override
    public void enterClassBody(Java9Parser.ClassBodyContext ctx) {
        listenStack.push(false);
    }

    @Override
    public void exitClassBody(Java9Parser.ClassBodyContext ctx) {
        listenStack.pop();
    }

    @Override
    public void enterMethodDeclaration(Java9Parser.MethodDeclarationContext ctx) {
        listenStack.push(true);
    }

    @Override
    public void exitMethodDeclaration(Java9Parser.MethodDeclarationContext ctx) {
        listenStack.pop();
    }

    @Override
    public void enterTypeParameters(Java9Parser.TypeParametersContext ctx) {
        listenStack.push(false);
    }

    @Override
    public void exitTypeParameters(Java9Parser.TypeParametersContext ctx) {
        listenStack.pop();
    }

    @Override
    public void enterFormalParameterList(Java9Parser.FormalParameterListContext ctx) {
        listenStack.push(false);
    }

    @Override
    public void exitFormalParameterList(Java9Parser.FormalParameterListContext ctx) {
        listenStack.pop();
    }

    @Override
    public void enterMethodBody(Java9Parser.MethodBodyContext ctx) {
        listenStack.push(false);
    }

    @Override
    public void exitMethodBody(Java9Parser.MethodBodyContext ctx) {
        listenStack.pop();
    }

    @Override
    public void enterThrows_(Java9Parser.Throws_Context ctx) {
        listenStack.push(false);
    }

    @Override
    public void exitThrows_(Java9Parser.Throws_Context ctx) {
        listenStack.pop();
    }
}
