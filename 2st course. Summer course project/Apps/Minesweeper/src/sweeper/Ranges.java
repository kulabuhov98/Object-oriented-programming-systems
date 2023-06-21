package sweeper;

import java.util.ArrayList;

public class Ranges {
    /* Значения размеров оси координат X и Y */
    private static CoordinateSystem size;

    /* Список всех координат X и Y */
    private static ArrayList<CoordinateSystem> allCoordinates;

    /* Установка размера оси и заполнение списка всех координат X и Y */
    protected static void setSize(CoordinateSystem xy) {
        /* Значения размеров оси координат X и Y */
        size = xy;

        /* Список всех координат оси X и Y*/
        allCoordinates = new ArrayList<>();
        /* Прохождение по координатам оси Y */
        for (int y = 0; y < size.y; y++)
            /* Прохождение по координатам оси X */
            for (int x = 0; x < size.x; x++)
                /* Добавление новой координаты оси X и Y */
                allCoordinates.add(new CoordinateSystem(x, y));
    }

    /* Получение размера оси координат X и Y */
    public static CoordinateSystem getSize() {
        return size;
    }

    /* Получение списка всех координат оси X и Y */
    public static ArrayList<CoordinateSystem> getAllCoordinates() {
        return allCoordinates;
    }
}
