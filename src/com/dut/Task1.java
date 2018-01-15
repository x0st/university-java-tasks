package com.dut;

import com.dut.entities.Sentence;
import com.dut.entities.Text;

import java.util.ArrayList;

public class Task1 {
    public static void main(String[] args) {
        Text text = new Text(TextProvider.loremIpsum());
        ArrayList<Sentence> sentences = text.getSentences();

        for (Sentence sentence : sentences) {
            if (Util.hasRepeatingWords(sentence)) {
                System.out.println(sentence);
            }
        }
    }
}
