package com.proftelran.org.homework_17.task_2;

import java.util.List;
import java.util.Map;

public interface TextStorage<T> {
    void addElement(T element);
    Map<T, List<Integer>> getIndices();
    void writeToFile(String filename);
    void readFromFile(String filename);
    List<T> getElements();
}
