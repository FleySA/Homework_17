package com.proftelran.org.homework_17;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CharacterStorage implements TextStorage<Character> {
    private final Map<Character, Integer> elementsCount = new HashMap<>();

    @Override
    public void addElement(Character element) {
        elementsCount.put(element, elementsCount.getOrDefault(element, 0) + 1);
    }

    @Override
    public Map<Character, Integer> getElements() {
        return new HashMap<>(elementsCount);
    }

    @Override
    public void writeToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Map.Entry<Character, Integer> entry : elementsCount.entrySet()) {
                writer.write(entry.getKey().toString() + entry.getValue() + System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String generateHashString() {
        StringBuilder hashString = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : elementsCount.entrySet()) {
            hashString.append(entry.getKey()).append(entry.getValue());
        }
        return hashString.toString();
    }

    @Override
    public void writeHashToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(generateHashString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}