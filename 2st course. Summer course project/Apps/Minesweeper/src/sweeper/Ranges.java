package sweeper;

import java.util.ArrayList;
import java.util.Random;

public class Ranges {
    /* Значения размеров игрового поля */
    private static CoordinateSystem size;

    /* Список всех координат X и Y */
    private static ArrayList<CoordinateSystem> allCoordinates;

    /* Объект класса Random */
    private static Random random = new Random();

    /* Установка размера игрового поля и заполнение списка всех координат X и Y */
    static void setSize(CoordinateSystem xy) {
        /* Значения размеров игрового поля */
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

    /* Получение размера игрового поля */
    public static CoordinateSystem getSize() {
        return size;
    }

    /* Получение списка всех координат оси X и Y */
    public static ArrayList<CoordinateSystem> getAllCoordinates() {
        return allCoordinates;
    }

    /* Проверка на нахождение указанной координаты на игровом поле */
    static boolean inRangePlayingField(CoordinateSystem coordinateSystem) {
        return coordinateSystem.x >= 0 && coordinateSystem.x < size.x &&
                coordinateSystem.y >= 0 && coordinateSystem.y < size.y;
    }
}
