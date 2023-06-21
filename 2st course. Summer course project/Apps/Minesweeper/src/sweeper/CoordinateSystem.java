package sweeper;

public class CoordinateSystem {
    /* Значение координаты по оси X */
    public int x;

    /* Значение координаты по оси Y */
    public int y;

    /* Конструктор класса CoordinateSystem */
    public CoordinateSystem(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /* Сравнение координат по оси X и Y между собой */
    @Override
    public boolean equals(Object obj) {
        /* Является ли передаваемый объект координатой */
        if (obj instanceof CoordinateSystem) {
            /* Приведение obj к типу объекта CoordinateSystem */
            CoordinateSystem coordinateSystem = (CoordinateSystem) obj;
            /* Сравнение координат по оси X и Y между собой */
            return coordinateSystem.x == x && coordinateSystem.y == y;
        } else {
            /* Использование базового метода equals */
            return super.equals(obj);
        }
    }
}
