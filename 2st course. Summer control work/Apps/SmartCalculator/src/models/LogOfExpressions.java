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
    private final Path logOfExpressionsDefault = Paths.get(System.getProperty("user.dir") + "\\logOfExpressions.txt");

    /* Чтение массива данных из файла по умолчанию */
    public List<String> getExpressions() {
        try {
            /* Получение массива данных из файла по умолчанию */
            expressions = Files.readAllLines(logOfExpressionsDefault);
        } catch (Exception e) {
            /* Сообщение пользователю */
            System.out.println(e.getMessage());
        }
        /* Возвращение массива данных из файла по умолчанию */
        return expressions;
    }

    /* Запись массива данных в файл по умолчанию */
    public void setExpressions(String expression) {
        try {
            /* Существует ли файл по умолчанию */
            if (Files.notExists(logOfExpressionsDefault)) {
                Files.createFile(logOfExpressionsDefault);
            }
            /* Добавление нового значения в массив данных */
            expressions.add(expression);
            /* Запись массива данных в файл по умолчанию */
            Files.write(logOfExpressionsDefault, expressions, StandardOpenOption.APPEND);
            /* Сообщение пользователю */
            System.out.println("The expression was successfully saved in " + logOfExpressionsDefault.getParent() + "\\" + logOfExpressionsDefault.getFileName() + ".");
        } catch (Exception e) {
            /* Сообщение пользователю */
            System.out.println(e.getMessage());
        }
    }

    /* Запись массива данных в пользовательский файл */
    public void setExpressionsCustom(Path logOfExpressionCustom, String expression) {
        try {
            /* Существует ли пользовательский файл */
            if (Files.notExists(logOfExpressionCustom)) {
                Files.createFile(logOfExpressionCustom);
            }
            /* Запись массива данных в пользовательский файл */
            Files.write(logOfExpressionCustom, (expression).getBytes(), StandardOpenOption.APPEND);
            /* Сообщение пользователю */
            System.out.println("The expression was successfully saved in " + logOfExpressionCustom.getParent() + "\\" + logOfExpressionCustom.getFileName() + ".");
        } catch (Exception e) {
            /* Сообщение пользователю */
            System.out.println(e.getMessage());
        }
    }
}
