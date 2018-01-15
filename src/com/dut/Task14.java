package com.dut;

import com.dut.entities.Sentence;
import com.dut.entities.Text;
import com.dut.entities.Word;

import java.util.ArrayList;
import java.util.Comparator;

public class Task14 {
    public static void main(String[] args) {
        Text text = new Text(TextProvider.loremIpsum());
        ArrayList<Sentence> sentences = text.getSentences();
        ArrayList<Word> words = new ArrayList<>();
        Word longest = null;

        for (Sentence sentence : sentences) {
            words.addAll(sentence.getWords());
        }

        for (Word word : words) {
            if (Util.isStringPalindrome(word.toString())) {
                if (longest == null || word.toString().length() > longest.toString().length()) {
                    longest = word;
                }
            }
        }

        if (longest != null) {
            System.out.println("Palindrome: " + longest.toString());
        }
    }
}
