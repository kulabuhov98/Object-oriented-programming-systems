package models;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class LogOfExpressions {
    /* Массив данных */
    private List<String> expressions = new ArrayList<>();
    /* Файл по умолчанию, содержащий массив данных */
    private final Path logOfExpressions = Paths.get(System.getProperty("user.dir") + "\\logOfExpressions.txt");

    /* Чтение массива данных из файла */
    public List<String> getExpressions() {
        try {
            /* Получение массива данных из файла */
            expressions = Files.readAllLines(logOfExpressions);
        } catch (Exception e) {
            /* Сообщение пользователю */
            System.out.println(e.getMessage());
        }
        /* Возвращение массива данных из файла */
        return expressions;
    }

    /* Запись массива данных в файл */
    public void setExpressions(String expression) {
        try {
            /* Существует ли файл */
            if (Files.notExists(logOfExpressions)) {
                Files.createFile(logOfExpressions);
            }
            /* Добавление нового значения в массив данных */
            expressions.add(expression);
            /* Запись массива данных в файл */
            Files.write(logOfExpressions, expressions, StandardOpenOption.APPEND);
            /* Сообщение пользователю */
            System.out.println("The expression was successfully saved in " + logOfExpressions.getParent() + logOfExpressions.getFileName() + ".");
        } catch (Exception e) {
            /* Сообщение пользователю */
            System.out.println(e.getMessage());
        }
    }
}
