package controllers;

import models.Calculator;
import models.LogOfExpressions;
import models.LogOfResults;

import java.nio.file.Paths;
import java.util.List;

public class HomeController {
    /* Объект класса модели Calculator */
    private final Calculator calculator;
    /* Объект класса модели LogOfExpressions */
    private final LogOfExpressions logOfExpressions;
    /* Объект класса модели LogOfResults */
    private final LogOfResults logOfResults;

    /* Конструктор класса контроллера HomeController */
    public HomeController(Calculator calculator, LogOfExpressions logOfExpressions, LogOfResults logOfResults) {
        this.calculator = calculator;
        this.logOfExpressions = logOfExpressions;
        this.logOfResults = logOfResults;
    }

    /* Получение результата работы приложения */
    public double calculator(String expression) {
        return calculator.main(expression);
    }

    /* Запись выражения и результата работы приложения в файлы по умолчанию */
    public void setLogs(String expression) {
        logOfExpressions.setExpressions(expression);
        logOfResults.setResults(calculator.main(expression));
    }

    /* Запись выражения в пользовательский файл */
    public void setLogExpressionsCustom(String logOfExpressionCustom, String expression) {
        logOfExpressions.setExpressionsCustom(Paths.get(logOfExpressionCustom), expression);
    }

    /* Запись выражения в пользовательский файл */
    public void setLogResultsCustom(String logOfResultCustom) {
        logOfResults.setResultsCustom(Paths.get(logOfResultCustom));
    }

    /* Отображение выражения и результатов работы приложения */
    public void history() {
        List<String> expressions = logOfExpressions.getExpressions(), results = logOfResults.getResults();
        for (int i = 0; i < expressions.size(); i++) {
            System.out.println(expressions.get(i) + "\t= " + results.get(i));
        }
    }

    /* Выход и завершение работы приложения */
    public void exit() {
        /* Сообщение пользователю */
        System.out.print("Exit...");
        /* Выход и завершение работы приложения */
        System.exit(1);
    }
}
