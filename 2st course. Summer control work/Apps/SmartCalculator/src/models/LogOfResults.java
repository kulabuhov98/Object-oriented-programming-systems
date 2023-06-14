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
    private final Path logOfResultsDefault = Paths.get(System.getProperty("user.dir") + "\\logOfResults.txt");

    /* Чтение массива данных из файла по умолчанию */
    public List<String> getResults() {
        try {
            /* Получение массива данных из файла по умолчанию */
            results = Files.readAllLines(logOfResultsDefault);
        } catch (Exception e) {
            /* Сообщение пользователю */
            System.out.println(e.getMessage());
        }
        /* Возвращение массива данных из файла по умолчанию */
        return results;
    }

    /* Запись массива данных в файл по умолчанию */
    public void setResults(Double result) {
        try {
            /* Существует ли файл по умолчанию */
            if (Files.notExists(logOfResultsDefault)) {
                Files.createFile(logOfResultsDefault);
            }
            /* Добавление нового значения в массив данных */
            results.add(Double.toString(result));
            /* Запись массива данных в файл по умолчанию */
            Files.write(logOfResultsDefault, results, StandardOpenOption.APPEND);
            /* Сообщение пользователю */
            System.out.println("The result was successfully saved in " + logOfResultsDefault.getParent() + logOfResultsDefault.getFileName() + ".");
        } catch (Exception e) {
            /* Сообщение пользователю */
            System.out.println(e.getMessage());
        }
    }

    /* Запись массива данных в пользовательский файл */
    public void setResultsCustom() {
        try {

        } catch (Exception e) {
            /* Сообщение пользователю */
            System.out.println(e.getMessage());
        }
    }
}
