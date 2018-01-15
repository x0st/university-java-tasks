package com.dut.entities;

public class Dot extends Character {
    public static final int ASCII = 46;

    Dot(String word) {
        super(word);
    }

    Dot() {
        super(".");
    }

    @Override
    public String toString() {
        return ".";
    }
}
