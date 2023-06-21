package sweeper;

public class Game {
    /* Карта для объектов нижнего слоя */
    private MapLayerBottom mapLayerBottom;
    /* Карта для объектов верхнего слоя */
    private MapLayerTop mapLayerTop;

    /* Конструктор класса Game */
    public Game(int cols, int rows, int bombs) {
        Ranges.setSize(new CoordinateSystem(cols, rows));
        mapLayerBottom = new MapLayerBottom(bombs);
    }

    /* Получение изображения из ячейки игрового поля */
    public ImagesEnum getImageFromCell(CoordinateSystem coordinateSystem) {
        return mapLayerBottom.getImageEnum(coordinateSystem);
    }

    /* Инициализация новой игры */
    public void initNewGame() {
        mapLayerBottom.initMapLayerBottom();
    }
}
