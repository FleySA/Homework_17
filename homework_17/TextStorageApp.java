package com.proftelran.org.homework_17;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TextStorageApp {
    public static void main(String[] args) {
        TextStorage<Character> charStorage = new CharacterStorage();
        TextStorage<Integer> intStorage = new IntegerStorage();

        try (BufferedReader reader = new BufferedReader(new FileReader("D:\\JavaBE\\Terlranprof\\src\\main\\java\\com\\proftelran\\org\\homework_17\\input.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                for (char c : line.toCharArray()) {
                    if (Character.isDigit(c)) {
                        intStorage.addElement(Integer.parseInt(String.valueOf(c)));
                    } else {
                        charStorage.addElement(c);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Character Map: " + charStorage.getElements());
        System.out.println("Integer Map: " + intStorage.getElements());

        charStorage.writeToFile("D:\\JavaBE\\Terlranprof\\src\\main\\java\\com\\proftelran\\org\\homework_17\\customHash.txt");
        intStorage.writeToFile("D:\\JavaBE\\Terlranprof\\src\\main\\java\\com\\proftelran\\org\\homework_17\\customNumbers.txt");
        charStorage.writeHashToFile("D:\\JavaBE\\Terlranprof\\src\\main\\java\\com\\proftelran\\org\\homework_17\\encoded.txt");
        intStorage.writeHashToFile("D:\\JavaBE\\Terlranprof\\src\\main\\java\\com\\proftelran\\org\\homework_17\\encodedNumbers.txt");
    }
}