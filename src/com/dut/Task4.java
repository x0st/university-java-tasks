package com.dut;

import com.dut.entities.QuestionMark;
import com.dut.entities.Sentence;
import com.dut.entities.Text;

import java.util.ArrayList;
import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        Text text = new Text(TextProvider.loremIpsum());
        ArrayList<Sentence> sentences = text.getSentences();

        System.out.print("Enter a length: ");
        int length = reader.nextInt();
        reader.close();

        for (Sentence sentence : sentences) {
            if (sentence.getEndMark() instanceof QuestionMark) {
                for (int j = 0; j < sentence.getWords().size(); j++) {
                    if (sentence.getWords().get(j).toString().length() == length) {
                        System.out.println(sentence.getWords().get(j).toString());
                    }
                }
            }
        }
    }
}
