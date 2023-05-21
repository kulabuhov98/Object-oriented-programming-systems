package Calculator;

import java.util.EmptyStackException;
import java.util.InputMismatchException;
import java.util.Scanner;
public class View {
    public static void main(String[] args) {
        /* Экземляр класса Controller */
        Controller controller = new Controller();
        /* Экземляр класса Scanner */
        Scanner scanner = new Scanner(System.in);
        /* Выбранное действие в навигации */
        int selectedAction = 0;

        /* Сообщение пользователю */
        System.out.println("Select an action: 1. Calculator 2. History of equations 3. History of results 4. Exit");
        try {
            /* Получение выбранного действия в навигации от пользователя */
            selectedAction = scanner.nextInt();
        } catch (InputMismatchException e) {
            /* Сообщение пользователю */
            System.out.println(e.getMessage());
        }

        /* Обработка выбранного действия в навигации */
        switch (selectedAction) {
            case 1:
                /* Сообщение пользователю */
                System.out.print("Enter the equation: ");
                try {
                    /* Получение уравнения от пользователя */
                    String equation = scanner.next();
                    /* Передеча управления методу Calculator класса Controller */
                    System.out.print(controller.calculator(equation));
                } catch (EmptyStackException | NumberFormatException e) {
                    /* Сообщение пользователю */
                    System.out.println(e.getMessage());
                }
                break;
            case 2:
                break;
            case 3:
                break;
            default:
                /* Сообщение пользователю */
                System.out.print("Exit...");
                /* Выход из программы и завершение работы */
                System.exit(1);
                /* Закрытие экземпляра класса Scanner */
                scanner.close();
        }
    }
}