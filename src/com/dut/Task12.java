package com.dut;

import com.dut.entities.PartOfSentence;
import com.dut.entities.Sentence;
import com.dut.entities.Text;
import com.dut.entities.Word;

import java.util.ArrayList;
import java.util.Scanner;

public class Task12 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        Text text = new Text(TextProvider.loremIpsum());
        ArrayList<Sentence> sentences = text.getSentences();

        System.out.print("Enter a length: ");
        int length = reader.nextInt();
        reader.close();

        for (Sentence sentence : sentences) {
            for (int i = 0; i < sentence.getParts().size(); i++) {
                if (sentence.getParts().get(i) instanceof Word &&
                        isFirstLetterVowel(sentence.getParts().get(i)) &&
                        sentence.getParts().get(i).toString().length() == length) {
                    sentence.getParts().remove(i);
                }
            }
        }

        Util.printSentences(sentences);
    }

    private static Boolean isFirstLetterVowel(PartOfSentence word) {
        String l = String.valueOf(word.toString().toUpperCase().charAt(0));

        return l.equals("A") || l.equals("E") || l.equals("I") || l.equals("O") || l.equals("Y");
    }
}
