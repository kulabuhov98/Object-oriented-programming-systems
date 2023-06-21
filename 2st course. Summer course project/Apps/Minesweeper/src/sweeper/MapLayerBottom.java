package sweeper;

class MapLayerBottom {
    /* Карта для объектов нижнего слоя */
    private MapMatrix mapLayerBottom;
    /* Общее количество бомб на игровом поле */
    private int numberOfBombs;

    /* Конструктор класса MapLayerBottom */
    MapLayerBottom (int numberOfBombs) {
        this.numberOfBombs = numberOfBombs;
    }

    /* Инициализация карты для объектов нижнего слоя */
    void initMapLayerBottom() {
        /* Объект класса MapMatrix */
        mapLayerBottom = new MapMatrix(ImagesEnum.ZERO);
        /* Размещение бомб на игровом поле */
        for (int i = 0; i < numberOfBombs; i++)
            placeBomb();
    }

    /* Размещение бомбы на игровом поле */
    private void placeBomb() {
        /* Получение случайной координаты оси X и Y */
        CoordinateSystem coordinateSystem = Ranges.getRandomCoordinate();
        /* Размещение бомбы на игровом поле */
        mapLayerBottom.setImageEnum(coordinateSystem, ImagesEnum.BOMB);
        /* Вызов метода incNumbersAroundBomb класса MapLayerBottom */
        incNumbersAroundBomb(coordinateSystem);
    }

    /* Увеличение числа от 1 до 8 вокруг бомбы */
    private void incNumbersAroundBomb(CoordinateSystem coordinateSystem) {
        /* Прохождение по списку всех координат оси X и Y вокруг указанной координаты */
        for (CoordinateSystem around : Ranges.getCoordinatesAround(coordinateSystem))
            /* Находится ли в указанной коориднате бомба */
            if (ImagesEnum.BOMB != mapLayerBottom.getImageEnum(around))
                /* Увеличение числа от 1 до 8 */
                mapLayerBottom.setImageEnum(around, mapLayerBottom.getImageEnum(around).getNextNumber());
    }

    /* Получение элемента перечисления из карты для объектов нижнего слоя с указаннами координатами */
    ImagesEnum getImageEnum(CoordinateSystem coordinateSystem) {
        return mapLayerBottom.getImageEnum(coordinateSystem);
    }
}
