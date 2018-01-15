package com.dut.entities;

import java.util.ArrayList;

public class Word implements PartOfSentence {
    private ArrayList<Character> characters;
    private String word;

    Word(String word) {
        this.characters = new ArrayList<>();
        this.word = word;

        for (int i = 0; i < word.length(); i++) {
            characters.add(new Character(String.valueOf(word.charAt(i))));
        }
    }

    public ArrayList<Character> getCharacters() {
        return characters;
    }

    @Override
    public String toString() {
        return this.word;
    }
}
