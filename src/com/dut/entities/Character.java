package com.dut.entities;

public class Character implements PartOfSentence {
    private String character;

    public Character(String character) {
        this.character = character;
    }

    @Override
    public String toString() {
        return this.character;
    }
}
