import sweeper.Cells;
import sweeper.CoordinateSystem;
import sweeper.Images;
import sweeper.ImagesForCell;

import javax.swing.*;
import java.awt.*;

public class Minesweeper extends JFrame {
    /* Объект класса Images */
    private final Images images = new Images();

    /* Размер оси координат X */
    private final int SIZE_X = 16;

    /* Размер оси координат Y */
    private final int SIZE_Y = 16;

    /* Размер ячейки игрового поля */
    private final int SIZE_CELL = 16;

    /* Инициализация приложения */
    public static void main(String[] args) throws Exception {
        new Minesweeper();
    }

    /* Основной экран приложения */
    private Minesweeper() throws Exception {
        /* Стиль приложения */
        String uiManager = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
        /* Изменение стиля приложения */
        UIManager.setLookAndFeel(uiManager);
        /* Вызов статического метода setSize класса Cells */
        Cells.setSize(new CoordinateSystem(SIZE_X, SIZE_Y));
        /* Вызов метода setImages класса Images */
        images.setImages();
        /* Вызов метода initJMenuBar класса Main */
        initJMenuBar();
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
                    graphics.drawImage(imagesForCell.image, imagesForCell.ordinal() * SIZE_CELL, 0, this);
            }
        };
        /* Установка предпочтительного размера компонента JPanel */
        jPanel.setPreferredSize(new Dimension(Cells.getSize().x * SIZE_CELL,
                Cells.getSize().y * SIZE_CELL));
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
        setIconImage(images.getImage("icon"));
    }
}