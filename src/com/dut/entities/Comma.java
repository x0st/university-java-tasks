package com.dut.entities;

public class Comma extends Character {
    public static final int ASCII = 44;

    Comma(String character) {
        super(character);
    }

    Comma() {
        super(",");
    }

    @Override
    public String toString() {
        return ",";
    }
}
