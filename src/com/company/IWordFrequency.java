package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;

public interface IWordFrequency {
    Map<Integer, Double> findWordLengthFrequency(File file) throws FileNotFoundException;
}
