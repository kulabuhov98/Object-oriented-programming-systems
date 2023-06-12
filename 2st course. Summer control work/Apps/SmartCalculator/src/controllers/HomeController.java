package controllers;

import models.Calculator;
import models.LogOfExpressions;
import models.LogOfResults;

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
}
