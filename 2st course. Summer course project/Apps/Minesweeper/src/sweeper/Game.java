package sweeper;

public class Game {
    /* Конструктор класса Sweeper */
    public Game(int cols, int rows) {
        Ranges.setSize(new CoordinateSystem(cols, rows));
    }

    /* Получение изображения из ячейки игрового поля */
    public ImagesEnum getImageFromCell(CoordinateSystem coordinateSystem) {
        return ImagesEnum.values()[(coordinateSystem.x + coordinateSystem.y) % ImagesEnum.values().length];
    }
}
