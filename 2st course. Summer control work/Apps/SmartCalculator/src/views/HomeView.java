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
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
