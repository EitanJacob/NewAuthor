package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EitanFrequency implements IWordFrequency {

    @Override
    public Map<Integer, Double> findWordLengthFrequency(File file) throws FileNotFoundException {
        Scanner sc = new Scanner(file);
        double totalWords = 0;
        Map<Integer, Double> myMap = new HashMap<>();
        while (sc.hasNext()) {
            // Keeping track of total words to find percentage of each word length in lines 28-31
            totalWords = totalWords + 1;
            // Creating map of word lengths with corresponding frequency
            String s = sc.next();
            int wordLength = s.length();
            if (!myMap.containsKey(wordLength)) {
                myMap.put(wordLength, 1.0);
            } else {
                double currAmount = myMap.get(wordLength);
                myMap.put(wordLength, currAmount + 1);
            }
        }
        //Replacing the frequency with frequency percentage using variable "totalWords "
        for (Integer i : myMap.keySet()) {
            double totalOfThisLength = myMap.get(i);
            myMap.put(i, totalOfThisLength / totalWords * 100);
        }
        return myMap;
    }
}
