import sweeper.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Minesweeper extends JFrame {
    /* Объект класса Game */
    private Game game;

    /* Объект класса Images */
    private Images images = new Images();

    /* Объект класса JPanel */
    private JPanel jPanel = new JPanel();

    /* Количество столбцов игрового поля по умолчанию */
    private final int COLS = 16;
    /* Количество строк игрового поля по умолчанию */
    private final int ROWS = 16;
    /* Количество бомб на игровом поле по умолчанию */
    private final int BOMBS = 10;

    /* Размер ячейки игрового поля */
    private final int SIZE_CELL = 16;

    /* Инициализация приложения */
    public static void main(String[] args) throws Exception {
        new Minesweeper();
    }

    /* Конструктор класса Minesweeper */
    private Minesweeper() throws Exception {
        /* Стиль приложения */
        String uiManager = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
        /* Изменение стиля приложения */
        UIManager.setLookAndFeel(uiManager);
        /* Вызов метода initMinesweeper класса Minesweeper */
        initMinesweeper(COLS, ROWS, BOMBS);
    }

    /* Инициализация основного окна приложения */
    private void initMinesweeper(int cols, int rows, int bombs) {
        /* Вызов конструктора класса Game */
        game = new Game(cols, rows, bombs);
        /* Вызов метода initNewGame класса Game */
        game.initNewGame();
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
        JMenu gameJMenu = new JMenu("Игра");

        /* Добавление основного элемента Game в меню */
        jMenuBar.add(gameJMenu);

        /* Дополнительный элемент New основного элемента меню Game */
        JMenuItem newJMenuItem = new JMenuItem("Новая игра");
        /* Дополнительный элемент Beginner основного элемента меню Game */
        JMenuItem beginnerJMenuItem = new JMenuItem("Beginner");
        /* Дополнительный элемент Intermediate основного элемента меню Game */
        JMenuItem intermediateJMenuItem = new JMenuItem("Intermediate");
        /* Дополнительный элемент Expert основного элемента меню Game */
        JMenuItem expertJMenuItem = new JMenuItem("Expert");
        /* Дополнительный элемент Exit основного элемента меню Game */
        JMenuItem exitJMenuItem = new JMenuItem("Выход");

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

        /* Регистрация слушателя события дополнительного элемента New */
        newJMenuItem.addActionListener(e -> {
            /* Вызов метода initNewGame класса Game */
            game.initNewGame();
            /* Обновление JPanel */
            jPanel.repaint();
        });

        /* Регистрация слушателя события дополнительного элемента Beginner */
        beginnerJMenuItem.addActionListener(e -> {
            /* Вызов метода initMinesweeper класса Minesweeper */
            initMinesweeper(COLS, ROWS, BOMBS);
        });

        /* Регистрация слушателя события дополнительного элемента Intermediate */
        intermediateJMenuItem.addActionListener(e -> {
            /* Вызов метода initMinesweeper класса Minesweeper */
            initMinesweeper(32, 32, 32);
        });

        /* Регистрация слушателя события дополнительного элемента Expert */
        expertJMenuItem.addActionListener(e -> {
            /* Вызов метода initMinesweeper класса Minesweeper */
            initMinesweeper(48, 48, 48);
        });

        /* Регистрация слушателя события дополнительного элемента Exit */
        exitJMenuItem.addActionListener(e -> {
            /* Выход и завершение работы приложения */
            System.exit(1);
        });
    }

    /* Определение победы в игре */
    private void checkGameWin() {
        /* Если текущее состояние игры - победа в игре */
        if (game.getGameState() == GameStateEnum.WINNER)
            /* Сообщение пользователю */
            JOptionPane.showMessageDialog(jPanel, "Игровое поле разминировано полностью.");
    }

    /* Инициализация JPanel */
    private void initJPanel() {
        /* Элемент управления, представляющий собой прямоугольное пространство */
        jPanel = new JPanel() {
            /* Переопределение элемента родительского класса или суперкласса */
            @Override
            protected void paintComponent(Graphics graphics) {
                /* Вызов конструктора базового класса */
                super.paintComponent(graphics);

                /* Прохождение по списку всех координат оси X и Y */
                for (CoordinateSystem coordinateSystem : Ranges.getAllCoordinates())
                    /* Установка элемента перечисления с учетом координат оси X и Y */
                    graphics.drawImage(game.getImageFromCell(coordinateSystem).image,
                            coordinateSystem.x * SIZE_CELL,
                            coordinateSystem.y * SIZE_CELL,
                            this);
            }
        };
        /* Регистрация слушателя события мыши */
        jPanel.addMouseListener(new MouseAdapter() {
            /* Переопределение элемента родительского класса или суперкласса */
            @Override
            public void mousePressed(MouseEvent e) {
                /* Координата нажатия кнопкой мыши по оси координат X */
                int x = e.getX() / SIZE_CELL;
                /* Координата нажатия кнопкой мыши по оси координат Y */
                int y = e.getY() / SIZE_CELL;
                /* Координата с данными о нажатии кнопки мыши */
                CoordinateSystem coordinateSystem = new CoordinateSystem(x, y);
                /* Нажатие левой кнопки мыши */
                if (e.getButton() == MouseEvent.BUTTON1)
                    /* Вызов метода pressLeftMouseButton класса Game */
                    game.pressLeftMouseButton(coordinateSystem);
                /* Нажатие правой кнопки мыши */
                if (e.getButton() == MouseEvent.BUTTON3)
                    /* Вызов метода pressRightMouseButton класса Game */
                    game.pressRightMouseButton(coordinateSystem);

                /* Вызов метода checkGameWin класса Minesweeper */
                checkGameWin();
                /* Обновление JPanel */
                jPanel.repaint();
            }
        });
        /* Установка предпочтительного размера компонента JPanel */
        jPanel.setPreferredSize(new Dimension(Ranges.getSize().x * SIZE_CELL,
                Ranges.getSize().y * SIZE_CELL));
        /* Добавление компонента JPanel в окно приложения */
        add(jPanel);
    }

    /* Инициализация JFrame */
    private void initJFrame() {
        /* Действие при завершении приложения */
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        /* Заголовок окна приложения */
        setTitle("Minesweeper XXX");
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