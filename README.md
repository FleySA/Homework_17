# Homework_17
Запустить одновременно считывание двух файлов и убедиться что символы по одинаковому индексу в каждом файле равны. - c этим заданием возникли сложности. Как ни пытался не смог сделать чтобы содержание 
decoded.txt соответствовало input.txt 

1 уровень сложности: Задача уровня 1:
1) Взять текстовый файл, в нем должен быть текст из букв и чисел.(размер не ограничен, но хотя бы строк 10(буквы любые, числа от 0 до 9))) )
   Организовать чтение данного файла. При чтении нужно сохранить количество вхождений каждого символа из файла,
   причем, буквы, и спец знаки и их количество вхождений хранить в одной структуре, а цифры и их вхождения в другой структуре.

Но есть одно уточнение:

За хранения букв или цифр и их количества вхождений отвечает класс Storage, который внутри себя хранит как раз Мап,
   которая может работать и с символом в качестве ключа и с числом в качестве ключа.
   Те нужно создать два экземпляра класса Storage для разных типов данных.
   Класс Storage также должен иметь метод - addElement, который может принимать или символ или число.
   Класс Storage также должен иметь метод - getElements, который должен возвращать Мап с ключом или символа или числа.
   Используйте generics.

2) После того как организовано считывание и хранение, организовать запись в файл по имени customHash.txt
   Данный файл должен содержать строку - аналог простой hash функции , а именно : строку состоящую из символов которые вошли
   в оригинальный текст и их количества вхождений.(Пример : оригинальный текст : Hello World -> строка в файле : d1e1H1l3o2r1W1)
   Те сохранить информацию из структуры в которой хранятся символы и их вхождения в строку.
   Структуру с числами сохранить в отдельный файл customNumbers.txt (вида : число_Количествовхождений)

Задача уровня 2: 
   Все вышесказанное можно использовать для написания простого текстового кодировщика-декодировщика.
   Для этого нужно прочитать текстовый файл и для каждого символа, хранить не количество вхождений, а список индексов, где этот символ стоит.
   1) Задача : считать текстовый файл, сохранить в структуру вида символ -> список индексов.
      Сохранить данную структуру в файл -> encoded.txt;
   2) Прочитать файл  encoded.txt; На основе этого файла сформировать текст , вставляя нужные символы на нужные места.
      Записать получившийся текст в файл.
   3) Запустить одновременно считывание двух файлов и убедиться что символы по одинаковому индексу в каждом файле равны.



