package com.dut.entities;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.ArrayList;

public class Sentence implements PartOfSentence {
    private String originalSentence;
    private ArrayList<PartOfSentence> parts;
    private ArrayList<Word> words;
    private Integer wordCount = 0;
    private Character endMark;

    public Sentence(String sentence, Character endMark) {
        this.endMark = endMark;
        this.originalSentence = sentence;
        this.parts = new ArrayList<>();
        this.words = new ArrayList<>();

        String word = "";
        Boolean letterNow;
        Character charToAdd = null;

        for (int i = 0; i < sentence.length(); i++) {
            int ascii = (int)sentence.charAt(i);

            if ((ascii >= 65 && ascii <= 90) || (ascii >= 97 && ascii <= 122)) {
                letterNow = true;
                word += String.valueOf(sentence.charAt(i));
                charToAdd = null;
            } else if (ascii == Space.ASCII) {
                charToAdd = new Space();
                letterNow = false;
            } else if (ascii == Comma.ASCII) {
                charToAdd = new Comma();
                letterNow = false;
            } else {
                charToAdd = new Character(String.valueOf(sentence.charAt(i)));
                letterNow = false;
            }

            if (word.length() > 0 && false == letterNow) {
                this.parts.add(new Word(word));
                this.words.add(new Word(word));
                this.wordCount++;
                word = "";
            }

            if (charToAdd != null) {
                this.parts.add(charToAdd);
            }
        }

        this.parts.remove(this.parts.size()-1);
    }

    public ArrayList<PartOfSentence> getParts() {
        return parts;
    }

    public Integer getWordCount() {
        return wordCount;
    }

    public ArrayList<Word> getWords() {
        return words;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        for (PartOfSentence part : parts) {
            result.append(part.toString());
        }

        return result + endMark.toString();
    }

    public Character getEndMark() {
        return endMark;
    }
}
