package com.samsung.retrofittest;

import java.util.List;

public class Predict {

    Boolean endOfWord;
    Integer pos;
    List<String> text;

    public Boolean getEndOfWord() {
        return endOfWord;
    }

    public void setEndOfWord(Boolean endOfWord) {
        this.endOfWord = endOfWord;
    }

    public Integer getPos() {
        return pos;
    }

    public void setPos(Integer pos) {
        this.pos = pos;
    }

    public List<String> getText() {
        return text;
    }

    public void setText(List<String> text) {
        this.text = text;
    }
}

