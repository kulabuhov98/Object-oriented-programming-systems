import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Main extends JFrame {
    /* Количество столбцов на игровом поле по умолчанию */
    private final int COLS = 15;
    /* Количество строк на игровой поле по умолчанию */
    private final int ROWS = 1;
    /* Размер изображения на игровом поле */
    private final int IMAGE_SIZE = 16;
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
        /* Элемент управления, представляющий собой прямоугольное пространство */
        JPanel jPanel = new JPanel();
        /* Установка предпочтительного размера компонента JPanel */
        jPanel.setPreferredSize(new Dimension(COLS * IMAGE_SIZE, ROWS * IMAGE_SIZE));
        /* Добавление компонента JPanel в окно приложения */
        add(jPanel);
    }

    /* Получение изображения для игрового поля */
    private Image getImage(String filename) {
        /* Формирование пути до изображения */
        String resource = "img/" + filename.toLowerCase() + ".png";
        /* Получение изображения из ресурсов проекта */
        ImageIcon imageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource(resource)));
        /* Возвращение изображения для игрового поля */
        return imageIcon.getImage();
    }
}