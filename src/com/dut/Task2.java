package com.dut;

import com.dut.entities.Sentence;
import com.dut.entities.Text;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.HashMap;

public class Task2 {
    public static void main(String[] args) {
        Text text = new Text(TextProvider.loremIpsum());
        ArrayList<Sentence> sentences = text.getSentences();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < sentences.size(); i++) {
            map.put(i, sentences.get(i).getWordCount());
        }

        Map<Integer, Integer> sortedMap = Util.sortMapByValue(map);

        Set set = sortedMap.entrySet();

        for (Object aSet : set) {
            Map.Entry pair = (Map.Entry) aSet;
            System.out.println(sentences.get((Integer) pair.getKey()).toString());
        }
    }
}
