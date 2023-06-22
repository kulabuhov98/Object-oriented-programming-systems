package sweeper;

public class Game {
    /* Карта для объектов верхнего слоя */
    private MapLayerTop mapLayerTop;

    /* Карта для объектов нижнего слоя */
    private MapLayerBottom mapLayerBottom;

    /* Перечисление с состояниями игры */
    private GameStateEnum gameState;

    /* Конструктор класса Game */
    public Game(int cols, int rows, int bombs) {
        Ranges.setSize(new CoordinateSystem(cols, rows));
        mapLayerTop = new MapLayerTop();
        mapLayerBottom = new MapLayerBottom(bombs);
    }

    /* Инициализация новой игры */
    public void initNewGame() {
        /* Инициализация карты для объектов верхнего слоя */
        mapLayerTop.initMapLayerTop();
        /* Инициализация карты для объектов нижнего слоя */
        mapLayerBottom.initMapLayerBottom();
        /* Установка состояние игры - в процессе игры */
        gameState = GameStateEnum.PLAYED;
    }

    /* Получение текущего состояния игры */
    public GameStateEnum getGameState() {
        return gameState;
    }

    /* Получение изображения из ячейки игрового поля */
    public ImagesEnum getImageFromCell(CoordinateSystem coordinateSystem) {
        /* Ячейка на игровом поле открыта */
        if (mapLayerTop.getImageEnum(coordinateSystem) == ImagesEnum.OPENED)
            /* Взаимодействие с картой для объектов нижнего слоя */
            return mapLayerBottom.getImageEnum(coordinateSystem);
        else
            /* Взаимодействие с картой для объектов верхнего слоя */
            return mapLayerTop.getImageEnum(coordinateSystem);
    }

    /* Обработка нажатия левой кнопки мыши */
    public void pressLeftMouseButton(CoordinateSystem coordinateSystem) {
        /* Вызов метода cellBehavior класса Game */
        cellBehavior(coordinateSystem);
        /* Вызов метода checkGameWinner класса Game */
        checkGameWinner();
    }

    /* Обработка поведения ячейки верхнего слоя игрового поля */
    private void cellBehavior(CoordinateSystem coordinateSystem) {
        /* Получение текущего элемента перечисления в указанной координате на верхнем слое игрового поля */
        switch (mapLayerTop.getImageEnum(coordinateSystem)) {
            /* Является ли указанная ячейка открытой */
            case OPENED: return;
            /* Находится ли в указанной координате флаг */
            case FLAGED: return;
            /* Является ли указанная ячейка закрытой */
            case CLOSED:
                /* Получение текущего элемента перечисления в указанной координате на нижнем слое игрового поля */
                switch (mapLayerBottom.getImageEnum(coordinateSystem)) {
                    /* Является ли указанная ячейка пустой */
                    case ZERO: setOpenedCellAround(coordinateSystem); return;
                    /* Находится ли в указанной координате бомба */
                    case BOMB: setBombedCell(); return;
                    /* Находятся ли в указанной координате цифры 1 - 8 */
                    default: mapLayerTop.setOpenedCell(coordinateSystem); return;
                }
        }
    }

    /* Установка элемента перечисления OPENED вокруг указанной координаты */
    private void setOpenedCellAround(CoordinateSystem coordinateSystem) {
        /* Вызов метода setOpenedCell класса MapLayerTop */
        mapLayerTop.setOpenedCell(coordinateSystem);
        /* Прохождение по списку всех координат оси X и Y вокруг указанной координаты */
        for (CoordinateSystem around : Ranges.getCoordinatesAround(coordinateSystem))
            /* Вызов метода cellBehavior класса Game */
            cellBehavior(around);
    }

    /* Определение победы в игре */
    private void checkGameWinner() {
        /* Текущее состояние игры - в процессе игры */
        if (gameState == GameStateEnum.PLAYED)
            /* Количество закрытых ячеек совпадает с количеством бомб на игровом поле */
            if (mapLayerTop.getNumberOfClosedCells() == mapLayerBottom.getNumberOfBombs())
                /* Установка состояние игры - победа в игре */
                gameState = GameStateEnum.WINNER;
    }

    /* Обработка нажатия правой кнопки мыши */
    public void pressRightMouseButton(CoordinateSystem coordinateSystem) {
        mapLayerTop.toggleFlagedCell(coordinateSystem);
    }

}
