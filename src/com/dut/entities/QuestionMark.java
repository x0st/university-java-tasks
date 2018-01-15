package com.dut.entities;

public class QuestionMark extends Character {
    public static final int ASCII = 63;

    public QuestionMark(String character) {
        super(character);
    }

    public QuestionMark() {
        super("?");
    }

    @Override
    public String toString() {
        return "?";
    }
}
