package com.dut;

import com.dut.entities.Sentence;
import com.dut.entities.Text;
import com.dut.entities.Word;

import java.util.ArrayList;
import java.util.Comparator;

public class Task6 {
    public static void main(String[] args) {
        Text text = new Text(TextProvider.loremIpsum());
        ArrayList<Sentence> sentences = text.getSentences();
        ArrayList<Word> words = new ArrayList<>();

        for (Sentence sentence : sentences) {
            words.addAll(sentence.getWords());
        }

        words.sort(Comparator.comparingInt(o -> o.getCharacters().get(0).toString().toUpperCase().charAt(0)));

        String last = null;

        for (Word word: words) {
            if (last == null || !word.getCharacters().get(0).toString().toUpperCase().equals(last)) {
                System.out.println("\033[31;1m" + word.toString() + "\033[0m");
            } else {
                System.out.println(word.toString());
            }

            last = word.getCharacters().get(0).toString().toUpperCase();
        }
    }
}
