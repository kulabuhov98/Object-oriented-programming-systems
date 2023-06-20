package views;

import controllers.HomeController;
import sweeper.ImagesForCell;

import javax.swing.*;
import java.awt.*;

public class HomeView extends JFrame {
    /* Объект класса контроллера HomeController */
    private final HomeController homeController;

    /* Стиль приложения */
    private final String uiManager = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";

    /* Количество столбцов на игровом поле по умолчанию */
    private final int COLS = 16;
    /* Количество строк на игровой поле по умолчанию */
    private final int ROWS = 16;
    /* Размер ячейки игрового поля */
    private final int CELL_SIZE = 16;

    /* Конструктор класса HomeView */
    public HomeView(HomeController homeController) {
        this.homeController = homeController;
    }

    /* Основной экран приложения */
    public void main() throws Exception {
        /* Изменение стиля приложения */
        UIManager.setLookAndFeel(uiManager);
        /* Вызов метода initJMenuBar класса Main */
        initJMenuBar();
        /* Вызов метода setImages класса контроллер HomeController */
        homeController.setImages();
        /* Вызов метода initJPanel класса Main */
        initJPanel();
        /* Вызов метода initJFrame класса Main */
        initJFrame();
    }

    /* Инициализация JMenuBar и JMenuItem */
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
        /* Добавление горизонтального разделите в основной элемент меню Game */
        gameJMenu.addSeparator();
        /* Добавление дополнительного элемента Beginner в основной элемент меню Game */
        gameJMenu.add(beginnerJMenuItem);
        /* Добавление дополнительного элемента Intermediate в основной элемент меню Game */
        gameJMenu.add(intermediateJMenuItem);
        /* Добавление дополнительного элемента Expert в основной элемент меню Game */
        gameJMenu.add(expertJMenuItem);
        /* Добавление горизонтального разделите в основной элемент меню Game */
        gameJMenu.addSeparator();
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
                /* Вызов конструктора базового класса */
                super.paintComponent(graphics);

                /* Прохождение по всем элементам перечисления */
                for (ImagesForCell imagesForCell : ImagesForCell.values())
                    /* Отображение элементов перечисления на игровом поле */
                    graphics.drawImage(imagesForCell.image, imagesForCell.ordinal() * CELL_SIZE, 0, this);
            }
        };
        /* Установка предпочтительного размера компонента JPanel */
        jPanel.setPreferredSize(new Dimension(COLS * CELL_SIZE, ROWS * CELL_SIZE));
        /* Добавление компонента JPanel в окно приложения */
        add(jPanel);
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
        /* Установки иконки приложения */
        setIconImage(homeController.getImage("icon"));
    }
}
