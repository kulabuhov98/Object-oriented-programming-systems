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
        /* Если в указанной координате установлен элемент перечисления OPENED */
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
            /* Если в указанной координате установлен элемент перечисления OPENED */
            case OPENED: return;
            /* Если в указанной координате установлен элемент перечисления FLAGED */
            case FLAGED: return;
            /* Если в указанной координате установлен элемент перечисления CLOSED */
            case CLOSED:
                /* Получение текущего элемента перечисления в указанной координате на нижнем слое игрового поля */
                switch (mapLayerBottom.getImageEnum(coordinateSystem)) {
                    /* Если в указанной координате установлен элемент перечисления ZERO */
                    case ZERO: setOpenedCellAround(coordinateSystem); return;
                    /* Если в указанной координате установлен элемент перечисления BOMB */
                    case BOMB: openBombCell(coordinateSystem); return;
                    /* Если в указанной координате установлен элемент перечисления NUM1 - NUM8 */
                    default: mapLayerTop.setOpenedCell(coordinateSystem); return;
                }
        }
    }

    /* Открытие ячеек на игровом поле содержащих бомбу */
    private void openBombCell(CoordinateSystem coordinateSystem) {
        /* Установка состояние игры - проигрыш в игре */
        gameState = GameStateEnum.BOMBED;
        /* Вызов метода setBombedCell класса MapLayerTop */
        mapLayerTop.setBombedCell(coordinateSystem);
        /* Прохождение по списку всех координат оси X и Y */
        for (CoordinateSystem coordinates : Ranges.getAllCoordinates())
            /* Если в указанной координате установлен элемент перечисления BOMB */
            if (mapLayerBottom.getImageEnum(coordinates) == ImagesEnum.BOMB)
                /* Вызов метода setOpenedCellToBomb класса MapLayerTop */
                mapLayerTop.setOpenedCellToBomb(coordinates);
            else
                /* Вызов метода setFlagedCellToNobomb класса MapLayerTop */
                mapLayerTop.setFlagedCellToNobomb(coordinates);
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
