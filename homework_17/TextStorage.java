package com.proftelran.org.homework_17;

import java.util.Map;

public interface TextStorage<T> {
    void addElement(T element);
    Map<T, Integer> getElements();
    void writeToFile(String filename);
    String generateHashString();
    void writeHashToFile(String filename);
}