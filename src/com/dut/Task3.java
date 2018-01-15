package com.dut;

import com.dut.entities.Sentence;
import com.dut.entities.Text;
import com.dut.entities.Word;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Task3 {
    public static void main(String[] args) {
        Text text = new Text(TextProvider.loremIpsum());
        ArrayList<Sentence> sentences = text.getSentences();
        HashMap<String, Integer> map = new HashMap<>();
        Boolean foundWithinSentence;

        for (int i = 0; i < sentences.get(0).getWordCount(); i++) {
            String word = sentences.get(0).getWords().get(i).toString();

            for (int j = 1; j < sentences.size(); j++) {
                ArrayList<Word> words = sentences.get(j).getWords();
                foundWithinSentence = false;

                for (Word word1 : words) {
                    if (word1.toString().equals(word)) {
                        foundWithinSentence = true;
                        break;
                    }
                }

                if (false == foundWithinSentence) {
                    if (false == map.containsKey(word)) {
                        map.put(word, 1);
                    } else {
                        map.put(word, map.get(word) + 1);
                    }
                }
            }
        }

        Set set = map.entrySet();

        for (Object aSet : set) {
            Map.Entry pair = (Map.Entry) aSet;

            if ((Integer) pair.getValue() == sentences.size() - 1) {
                System.out.println(pair.getKey() + ": " + pair.getValue());
            }
        }
    }
}
