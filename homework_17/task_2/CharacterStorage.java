package com.proftelran.org.homework_17.task_2;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CharacterStorage implements TextStorage<Character> {
    private final Map<Character, List<Integer>> indices = new HashMap<>();

    @Override
    public void addElement(Character element) {
        indices.computeIfAbsent(element, k -> new ArrayList<>()).add(indices.size());
    }

    @Override
    public Map<Character, List<Integer>> getIndices() {
        return new HashMap<>(indices);
    }

    @Override
    public void writeToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Map.Entry<Character, List<Integer>> entry : indices.entrySet()) {
                writer.write(entry.getKey() + "[" + indicesToString(entry.getValue()) + "]" + System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String indicesToString(List<Integer> indices) {
        StringBuilder result = new StringBuilder();
        for (Integer index : indices) {
            result.append(index).append(",");
        }
        result.deleteCharAt(result.length() - 1); // Remove the last comma
        return result.toString();
    }

    @Override
    public void readFromFile(String filename) {
        // Implement the logic to read from the file and populate the indices map
    }

    @Override
    public List<Character> getElements() {
        List<Character> elements = new ArrayList<>();
        for (Map.Entry<Character, List<Integer>> entry : indices.entrySet()) {
            elements.add(entry.getKey());
        }
        return elements;
    }
}
