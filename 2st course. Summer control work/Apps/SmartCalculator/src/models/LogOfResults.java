package models;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class LogOfResults {
    /* Массив данных */
    private List<String> results = new ArrayList<>();
    /* Файл по умолчанию, содержащий массив данных */
    private final Path logOfResults = Paths.get(System.getProperty("user.dir") + "\\logOfResults.txt");

    /* Чтение массива данных из файла */
    public List<String> getResults() {
        try {
            /* Получение массива данных из файла */
            results = Files.readAllLines(logOfResults);
        } catch (Exception e) {
            /* Сообщение пользователю */
            System.out.println(e.getMessage());
        }
        /* Возвращение массива данных из файла */
        return results;
    }

    /* Запись массива данных в файл */
    public void setResults(Double result) {
        try {
            /* Существует ли файл */
            if (Files.notExists(logOfResults)) {
                Files.createFile(logOfResults);
            }
            /* Добавление нового значения в массив данных */
            results.add(Double.toString(result));
            /* Запись массива данных в файл */
            Files.write(logOfResults, results, StandardOpenOption.APPEND);
            /* Сообщение пользователю */
            System.out.println("The result was successfully saved in " + logOfResults.getParent() + logOfResults.getFileName() + ".");
        } catch (Exception e) {
            /* Сообщение пользователю */
            System.out.println(e.getMessage());
        }
    }
}
