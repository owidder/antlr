package com.geekandpoke.antlr.parsers;

import java.util.Stack;

public class ListenerGuard {

    private Stack<Boolean> stack = new Stack<>();

    public void openGate() {
        stack.push(true);
    }

    public void closeGate() {
        stack.push(false);
    }

    public void endOpenOrClose() {
        stack.pop();
    }

    public Boolean isGateOpen() {
        return  stack.size() > 0 && stack.peek();
    }
}
