package com.dut;

import com.dut.entities.PartOfSentence;
import com.dut.entities.Sentence;
import com.dut.entities.Text;
import com.dut.entities.Word;

import java.util.ArrayList;

public class Task5 {
    public static void main(String[] args) {
        Text text = new Text(TextProvider.loremIpsum());
        ArrayList<Sentence> sentences = text.getSentences();

        Integer firstWordIndex = null;
        Integer lastWordIndex = null;

        for (Sentence sentence : sentences) {
            for (int j = 0; j < sentence.getParts().size(); j++) {
                if (sentence.getParts().get(j) instanceof Word) {
                    firstWordIndex = j;
                    break;
                }
            }

            for (int j = sentence.getParts().size() - 1; j >= 0; j--) {
                if (sentence.getParts().get(j) instanceof Word) {
                    lastWordIndex = j;
                    break;
                }
            }

            if (firstWordIndex == null || lastWordIndex == null) {
                continue;
            }

            PartOfSentence first = sentence.getParts().get(firstWordIndex);
            PartOfSentence last = sentence.getParts().get(lastWordIndex);

            sentence.getParts().set(firstWordIndex, last);
            sentence.getParts().set(lastWordIndex, first);

            firstWordIndex = null;
            lastWordIndex = null;
        }

        Util.printSentences(sentences);
    }
}
