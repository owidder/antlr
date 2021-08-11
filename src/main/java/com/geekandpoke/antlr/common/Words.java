package com.geekandpoke.antlr.common;

import java.util.ArrayList;
import java.util.List;

public class Words {
    private final List<String> words = new ArrayList<>();

    public void add(String word) {
        words.add(word);
    }

    public String getText() {
        return String.join("\n", words);
    }
}
