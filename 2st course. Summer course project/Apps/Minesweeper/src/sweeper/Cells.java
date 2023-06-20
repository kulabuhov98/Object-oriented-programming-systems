package sweeper;

public class Cells {
    /* Значения размеров оси координат X и Y */
    private static CoordinateSystem size;

    /* Установка размера оси координат X и Y */
    public static void setSize(CoordinateSystem xy) {
        size = xy;
    }

    /* Получение размера оси координат X и Y */
    public static CoordinateSystem getSize() {
        return size;
    }
}
