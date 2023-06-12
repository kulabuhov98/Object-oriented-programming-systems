package views;

import controllers.HomeController;

import java.util.Scanner;

public class HomeView {
    /* Объект класса контроллера HomeController */
    private final HomeController homeController;
    /* Объект класса Scanner */
    private final Scanner scanner;

    /* Конструктор класса представления HomeView */
    public HomeView(HomeController homeController, Scanner scanner) {
        this.homeController = homeController;
        this.scanner = scanner;
    }

    /* Основной экран приложения */
    public void main() {
        try {
            /* Сообщение пользователю */
            System.out.println("Navigation: \n1. Calculator \n2. Show expressions and results \n3. Save results \n4. Exit");
            /* Обработка выбранного действия в навигации */
            switch (scanner.nextInt()) {
                case 1 -> {
                    /* Сообщение пользователю */
                    System.out.println("Enter the expression:");
                    /* Получение выражения от пользователя */
                    String expression = scanner.next();
                    /* Сообщение пользователю и вызов метода calculator класса контроллера HomeController */
                    System.out.println("The result of the expression: \n" + homeController.calculator(expression));
                    /* Вызов метода setLogs класса контроллера HomeController */
                    homeController.setLogs(expression);
                }
                case 2 -> homeController.history();
                case 3 -> {

                }
                /* Выход и завершение работы приложения */
                default -> homeController.exit();
            }
        } catch (Exception e) {
            /* Сообщение пользователю */
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
