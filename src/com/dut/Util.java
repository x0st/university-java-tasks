package com.dut;

import com.dut.entities.Sentence;
import com.dut.entities.Word;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Util {
    public static boolean isStringPalindrome(String str) {
        return str.equals(new StringBuilder(str).reverse().toString());
    }

    public static void printSentences(ArrayList<Sentence> sentences) {
        for (Sentence sentence : sentences) {
            System.out.println(sentence.toString());
        }
    }

    public static boolean hasRepeatingWords(Sentence sentence) {
        HashMap<String, Integer> map = new HashMap<>();

        for (Word word: sentence.getWords()) {
            if (false == map.containsKey(word.toString())) {
                map.put(word.toString(), 1);
            } else {
                return false;
            }
        }

        return true;
    }

    public static Map<Integer, Integer> sortMapByValue(Map<Integer, Integer> sourceMap) {
        List<Map.Entry<Integer, Integer>> list = new LinkedList<>(sourceMap.entrySet());

        list.sort(Comparator.comparing(o -> (o.getValue())));

        Map<Integer, Integer> sortedMap = new LinkedHashMap<>();

        for (Map.Entry<Integer, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }
}
