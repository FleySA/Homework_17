package com.proftelran.org.homework_17.task_2;

import java.io.*;
import java.util.List;
import java.util.Map;


public class TextEncoderDecoder {
    private static final String INPUT_FILE_PATH = "D:\\JavaBE\\Terlranprof\\src\\main\\java\\com\\proftelran\\org\\homework_17\\task_2\\input.txt";
    private static final String ENCODED_FILE_PATH = "D:\\JavaBE\\Terlranprof\\src\\main\\java\\com\\proftelran\\org\\homework_17\\task_2\\encoded.txt";
    private static final String DECODED_FILE_PATH = "D:\\JavaBE\\Terlranprof\\src\\main\\java\\com\\proftelran\\org\\homework_17\\task_2\\decoded.txt";

    public static void main(String[] args) {
        TextStorage<Character> charStorage = new CharacterStorage();
        encode(charStorage, INPUT_FILE_PATH, ENCODED_FILE_PATH);
        decode(charStorage, ENCODED_FILE_PATH, DECODED_FILE_PATH);
        compareFiles(INPUT_FILE_PATH, DECODED_FILE_PATH);
    }

    public static void encode(TextStorage<Character> charStorage, String inputFilePath, String encodedFilePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                for (char c : line.toCharArray()) {
                    charStorage.addElement(c);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        charStorage.writeToFile(encodedFilePath);
    }

    public static void decode(TextStorage<Character> charStorage, String encodedFilePath, String decodedFilePath) {
        charStorage.readFromFile(encodedFilePath);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(decodedFilePath))) {
            Map<Character, List<Integer>> indices = charStorage.getIndices();

            for (Map.Entry<Character, List<Integer>> entry : indices.entrySet()) {
                char character = entry.getKey();
                List<Integer> characterIndices = entry.getValue();

                for (Integer index : characterIndices) {
                    writer.write(character);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void compareFiles(String file1, String file2) {
        FileComparator comparator = new FileComparator();
        if (comparator.areFilesIdentical(file1, file2)) {
            System.out.println("Files are identical.");
        } else {
            System.out.println("Files are different. Contents:");
            printFileContents(file1);
            System.out.println("------");
            printFileContents(file2);
        }
    }
    private static void printFileContents(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
}
}
