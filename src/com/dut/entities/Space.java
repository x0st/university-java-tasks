package com.dut.entities;

public class Space extends Character {
    public static final int ASCII = 32;

    Space(String word) {
        super(word);
    }

    Space() {
        super(" ");
    }

    @Override
    public String toString() {
        return " ";
    }
}
