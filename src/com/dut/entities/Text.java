package com.dut.entities;

import java.util.ArrayList;

public class Text {
    private ArrayList<Sentence> sentences;
    private String text;

    public Text(String text) {
        this.text = text;
        this.sentences = new ArrayList<>();

        String sentence = "";

        for (int i = 0; i < text.length(); i++) {
            int ascii = (int) text.charAt(i);

            if (sentence.length() > 0 && (ascii == Dot.ASCII || ascii == QuestionMark.ASCII || ascii == ExclamationMark.ASCII)) {
                this.sentences.add(new Sentence(sentence, createCharacterFromASCII(ascii)));
                sentence = "";
            } else {
                sentence += String.valueOf(text.charAt(i));
            }
        }
    }

    private Character createCharacterFromASCII(int ascii) {
        if (ascii == Dot.ASCII) {
            return new Dot();
        } else if (ascii == QuestionMark.ASCII) {
            return new QuestionMark();
        } else if (ascii == ExclamationMark.ASCII) {
            return new ExclamationMark();
        } else {
            return new Character(java.lang.Character.toString((char) ascii));
        }
    }

    public String getOriginalText() {
        return text;
    }

    public ArrayList<Sentence> getSentences() {
        return sentences;
    }
}
