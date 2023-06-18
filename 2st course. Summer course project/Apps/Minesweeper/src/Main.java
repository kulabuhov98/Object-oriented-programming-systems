import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    /* Элемент управления, представляющий собой прямоугольное пространство */
    private JPanel jPanel;
    /* Количество столбцов на игровом поле по умолчанию */
    private final int COLS = 16;
    /* Количество строк на игровой поле по умолчанию */
    private final int ROWS = 16;
    /* Размер изображения на игровом поле */
    private final int IMAGE_SIZE = 50;
    public static void main(String[] args) {
        /* Экземляр класса Main */
        new Main();
    }

    /* Конструктор класса Main */
    private Main() {
        /* Вызов метода initJPanel класса Main */
        initJPanel();
        /* Вызов метода initJFrame класса Main */
        initJFrame();
    }

    /* Инициализация JFrame */
    private void initJFrame() {
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

    /* Инициализация JPanel */
    private void initJPanel() {
        /* Экземляр класса JPanel */
        jPanel = new JPanel();
        /* Установка предпочтительного размера компонента JPanel */
        jPanel.setPreferredSize(new Dimension(500, 500));
        /* Добавление компонента JPanel в окно приложения */
        add(jPanel);
    }
}