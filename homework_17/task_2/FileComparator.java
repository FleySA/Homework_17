package com.proftelran.org.homework_17.task_2;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class FileComparator {
    public boolean areFilesIdentical(String file1Path, String file2Path) {
        try (BufferedReader reader1 = new BufferedReader(new FileReader(file1Path));
             BufferedReader reader2 = new BufferedReader(new FileReader(file2Path))) {

            String line1, line2;
            while ((line1 = reader1.readLine()) != null && (line2 = reader2.readLine()) != null) {
                // Убираем начальные и конечные пробелы перед сравнением строк
                if (!line1.trim().equals(line2.trim())) {
                    return false;
                }
            }

            // Проверяем, что оба файла имеют одинаковое количество строк
            return reader1.readLine() == null && reader2.readLine() == null;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}