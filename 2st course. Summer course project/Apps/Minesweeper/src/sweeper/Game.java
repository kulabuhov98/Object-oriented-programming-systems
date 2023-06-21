package sweeper;

public class Game {
    /* Карта для объектов верхнего слоя */
    private MapLayerTop mapLayerTop;

    /* Карта для объектов нижнего слоя */
    private MapLayerBottom mapLayerBottom;

    /* Текущее состояние игры */
    private GameStateEnum gameState;

    /* Конструктор класса Game */
    public Game(int cols, int rows, int bombs) {
        Ranges.setSize(new CoordinateSystem(cols, rows));
        mapLayerTop = new MapLayerTop();
        mapLayerBottom = new MapLayerBottom(bombs);
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

    /* Инициализация новой игры */
    public void initNewGame() {
        /* Инициализация карты для объектов верхнего слоя */
        mapLayerTop.initMapLayerTop();
        /* Инициализация карты для объектов нижнего слоя */
        mapLayerBottom.initMapLayerBottom();
        /* Установка состояние игры - в процессе игры */
        gameState = GameStateEnum.PLAYED;
    }

    /* Обработка нажатия левой кнопки мыши */
    public void pressLeftMouseButton(CoordinateSystem coordinateSystem) {
        mapLayerTop.setOpenedCell(coordinateSystem);
    }

    /* Обработка нажатия правой кнопки мыши */
    public void pressRightMouseButton(CoordinateSystem coordinateSystem) {
        mapLayerTop.toggleFlagedCell(coordinateSystem);
    }

}
