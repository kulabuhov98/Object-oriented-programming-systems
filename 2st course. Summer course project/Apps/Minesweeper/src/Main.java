import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Main extends JFrame {
    /* Количество столбцов на игровом поле по умолчанию */
    private final int COLS = 15;
    /* Количество строк на игровой поле по умолчанию */
    private final int ROWS = 15;
    /* Размер изображения на игровом поле */
    private final int IMAGE_SIZE = 16;
    public static void main(String[] args) {
        /* Экземляр класса Main */
        new Main();
    }

    /* Конструктор класса Main */
    private Main() {
        /* Вызов метода initJMenuBar класса Main */
        initJMenuBar();
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

    private void initJMenuBar() {
        /* Экземляр класса JMenuBar */
        JMenuBar jMenuBar = new JMenuBar();

        /* Основной элемент меню Game */
        JMenu gameJMenu = new JMenu("Game");
        /* Основной элемент меню Help */
        JMenu helpJMenu = new JMenu("Help");

        /* Добавление основного элемента Game в меню */
        jMenuBar.add(gameJMenu);
        /* Добавление основного элемента Help в меню */
        jMenuBar.add(helpJMenu);

        /* Дополнительный элемент New основного элемента меню Game */
        JMenuItem newJMenuItem = new JMenuItem("New");
        /* Дополнительный элемент Beginner основного элемента меню Game */
        JMenuItem beginnerJMenuItem = new JMenuItem("Beginner");
        /* Дополнительный элемент Intermediate основного элемента меню Game */
        JMenuItem intermediateJMenuItem = new JMenuItem("Intermediate");
        /* Дополнительный элемент Expert основного элемента меню Game */
        JMenuItem expertJMenuItem = new JMenuItem("Expert");
        /* Дополнительный элемент Exit основного элемента меню Game */
        JMenuItem exitJMenuItem = new JMenuItem("Exit");

        /* Добавление дополнительного элемента New в основной элемент меню Game */
        gameJMenu.add(newJMenuItem);
        /* Добавление дополнительного элемента Beginner в основной элемент меню Game */
        gameJMenu.add(beginnerJMenuItem);
        /* Добавление дополнительного элемента Intermediate в основной элемент меню Game */
        gameJMenu.add(intermediateJMenuItem);
        /* Добавление дополнительного элемента Expert в основной элемент меню Game */
        gameJMenu.add(expertJMenuItem);
        /* Добавление дополнительного элемента Exit в основной элемент меню Game */
        gameJMenu.add(exitJMenuItem);

        /* Добавление компонента jMenuBar в окно приложения */
        add(jMenuBar, BorderLayout.NORTH);
    }

    /* Инициализация JPanel */
    private void initJPanel() {
        /* Элемент управления, представляющий собой прямоугольное пространство */
        JPanel jPanel = new JPanel() {
            /* Переопределение элемента родительского класса или суперкласса */
            @Override
            protected void paintComponent(Graphics graphics) {
                graphics.drawImage(getImage("closed"), 0, 0, this);
            }
        };
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