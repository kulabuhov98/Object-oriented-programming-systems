import controllers.HomeController;
import models.Calculator;
import models.LogOfExpressions;
import models.LogOfResults;
import views.HomeView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /* Экземляр класса Scanner */
        Scanner scanner = new Scanner(System.in);
        /* Экземляр класса модели Calculator */
        Calculator calculator = new Calculator();
        /* Экзеплляр класса модели LogOfExpressions */
        LogOfExpressions logOfExpressions = new LogOfExpressions();
        /* Экземпляр класса модели LogOfResults */
        LogOfResults logOfResults = new LogOfResults();
        /* Экземпляр класса контроллера HomeController */
        HomeController homeController = new HomeController(calculator, logOfExpressions, logOfResults);
        /* Экземпляр класса представления HomeView */
        HomeView homeView = new HomeView(homeController, scanner);
        /* Инициализация приложения */
        homeView.main();
    }
}