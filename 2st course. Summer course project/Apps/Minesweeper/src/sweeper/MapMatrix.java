package sweeper;

class MapMatrix {
    /* Элементы перечисления в виде матрицы */
    private final ImagesEnum[][] matrix;

    /* Конструктор класса MapMatrix */
    MapMatrix(ImagesEnum imagesEnum) {
        /* Формирование матрицы */
        matrix = new ImagesEnum[Ranges.getSize().x][Ranges.getSize().x];
        /* Прохождение по списку всех координат оси X и Y */
        for (CoordinateSystem coordinateSystem : Ranges.getAllCoordinates())
            /* Заполнение матрицы элементами перечисления */
            matrix[coordinateSystem.x][coordinateSystem.y] = imagesEnum;
    }

    /* Получение элемента перечисления из матрицы с указаннами координатами */
    ImagesEnum getImageEnum(CoordinateSystem coordinateSystem) {
        /* Находится ли указанная координата на игровом поле */
        if (Ranges.inRangePlayingField(coordinateSystem))
            /* Получение элемента перечисления из ячейки матрицы с указаннами координатами */
            return matrix[coordinateSystem.x][coordinateSystem.y];
        return null;
    }

    /* Установка элемента перечисления в матрицу с указаннами координатами */
    void setImageEnum(CoordinateSystem coordinateSystem, ImagesEnum imagesEnum) {
        /* Находится ли указанная координата на игровом поле */
        if (Ranges.inRangePlayingField(coordinateSystem))
            /* Установка элемента перечисления в ячейку матрицу с указаннами координатами */
            matrix[coordinateSystem.x][coordinateSystem.y] = imagesEnum;
    }
}
