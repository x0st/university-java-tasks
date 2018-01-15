package com.dut.entities;

public class ExclamationMark extends Character {
    public static final int ASCII = 33;

    public ExclamationMark(String character) {
        super(character);
    }

    public ExclamationMark() {
        super("!");
    }

    @Override
    public String toString() {
        return "!";
    }
}
