package sweeper;

public class Game {
    /* Карта для объектов нижнего слоя */
    private MapMatrix mapLayerBottom;
    /* Карта для объектов верхнего слоя */
    private MapMatrix mapLayerTop;

    /* Конструктор класса Game */
    public Game(int cols, int rows) {
        Ranges.setSize(new CoordinateSystem(cols, rows));
    }

    /* Получение изображения из ячейки игрового поля */
    public ImagesEnum getImageFromCell(CoordinateSystem coordinateSystem) {
        return mapLayerBottom.getImageEnum(coordinateSystem);
    }

    /* Инициализация новой игры */
    public void start() {
        mapLayerBottom = new MapMatrix(ImagesEnum.NUM7);
    }
}
