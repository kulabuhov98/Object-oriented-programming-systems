package sweeper;

public class Game {
    /* Карта для объектов верхнего слоя */
    private MapLayerTop mapLayerTop;

    /* Карта для объектов нижнего слоя */
    private MapLayerBottom mapLayerBottom;

    /* Конструктор класса Game */
    public Game(int cols, int rows, int bombs) {
        Ranges.setSize(new CoordinateSystem(cols, rows));
        mapLayerTop = new MapLayerTop();
        mapLayerBottom = new MapLayerBottom(bombs);
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
        mapLayerTop.initMapLayerTop();
        mapLayerBottom.initMapLayerBottom();
    }

    /* Обработка нажатия левой кнопки мыши */
    public void pressLeftMouseButton(CoordinateSystem coordinateSystem) {
        mapLayerTop.setOpenedCell(coordinateSystem);
    }

}
