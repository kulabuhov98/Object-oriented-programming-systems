import javax.swing.*;

public class Main extends JFrame {
    /*
    *
    *
    *
    */
    public static void main(String[] args) {
        /* Экземляр класса Main */
        new Main();
    }

    /* Конструктор класса Main */
    private Main() {
        /* Действие при завершении приложения */
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        /* Заголовок окна приложения */
        setTitle("Minesweeper");
        /* Возможность изменения размеров окна приложения */
        setResizable(false);
        /* Отображение окна приложения на экране */
        setVisible(true);
        /* Отображение окна приложения с учетом подобранных оптимальным образом размеров окна */
        pack();
        /* Отображение окна приложения по центру экрана */
        setLocationRelativeTo(null);
    }

    /* Инициализация приложения */
    private void initJFrame() {

    }
}