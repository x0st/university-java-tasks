package com.dut;

import com.dut.entities.Character;
import com.dut.entities.Sentence;
import com.dut.entities.Text;
import com.dut.entities.Word;

import java.util.ArrayList;

public class Task8 {
    public static void main(String[] args) {
        Text text = new Text(TextProvider.loremIpsum());
        ArrayList<Sentence> sentences = text.getSentences();
        ArrayList<Word> wordsWithVowelLettersFirst = new ArrayList<>();

        for (Sentence sentence : sentences) {
            for (Word word : sentence.getWords()) {
                if (isFirstLetterVowel(word) && findFirstConsonantLetter(word) != null) {
                    wordsWithVowelLettersFirst.add(word);
                }
            }
        }

        wordsWithVowelLettersFirst.sort((o1, o2) -> {
            String f = findFirstConsonantLetter(o1);
            String s = findFirstConsonantLetter(o2);
            return (int)f.charAt(0) - (int)s.charAt(0);
        });

        for (Word word: wordsWithVowelLettersFirst) {
            System.out.println(word.toString());
        }
    }

    private static String findFirstConsonantLetter(Word word) {
        for (Character character : word.getCharacters()) {
            String l = character.toString().toUpperCase();

            if (    l.equals("B") || l.equals("C") || l.equals("D") || l.equals("F") || l.equals("G") ||
                    l.equals("H") || l.equals("J") || l.equals("K") || l.equals("L") || l.equals("M") ||
                    l.equals("N") || l.equals("P") || l.equals("Q") || l.equals("R") || l.equals("S") ||
                    l.equals("T") || l.equals("V") || l.equals("W") || l.equals("X") || l.equals("Z")) {
                return character.toString();
            }
        }

        return null;
    }

    private static Boolean isFirstLetterVowel(Word word) {
        String l = word.getCharacters().get(0).toString().toUpperCase();

        return l.equals("A") || l.equals("E") || l.equals("I") || l.equals("O") || l.equals("Y");
    }
}
