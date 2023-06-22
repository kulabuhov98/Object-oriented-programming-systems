package sweeper;

class MapLayerBottom {
    /* Карта для объектов нижнего слоя */
    private MapMatrix mapLayerBottom;
    /* Количество бомб на игровом поле */
    private int numberOfBombs;

    /* Конструктор класса MapLayerBottom */
    MapLayerBottom (int numberOfBombs) {
        this.numberOfBombs = numberOfBombs;
        /* Вызов метода limitingNumberOfBombs класса MapLayerBottom */
        limitingNumberOfBombs();
    }

    /* Инициализация карты для объектов нижнего слоя */
    void initMapLayerBottom() {
        /* Объект класса MapMatrix */
        mapLayerBottom = new MapMatrix(ImagesEnum.ZERO);
        /* Размещение бомб на игровом поле */
        for (int i = 0; i < numberOfBombs; i++)
            /* Вызов метода placeBomb класса MapLayerBottom */
            placeBomb();
    }

    /* Получение количества бомб на игровом поле */
    int getNumberOfBombs() {
        return numberOfBombs;
    }

    /* Получение элемента перечисления из карты для объектов нижнего слоя с указаннами координатами */
    ImagesEnum getImageEnum(CoordinateSystem coordinateSystem) {
        /* Вызов метода getImageEnum класса MapMatrix */
        return mapLayerBottom.getImageEnum(coordinateSystem);
    }

    /* Размещение бомбы на игровом поле */
    private void placeBomb() {
        /* Выбор координаты, в которой бомбы нет */
        while (true) {
            /* Получение случайной координаты оси X и Y */
            CoordinateSystem coordinateSystem = Ranges.getRandomCoordinate();
            /* В указанной для размещения координате есть бомба */
            if (ImagesEnum.BOMB == mapLayerBottom.getImageEnum(coordinateSystem))
                continue;
            /* Размещение бомбы на игровом поле */
            mapLayerBottom.setImageEnum(coordinateSystem, ImagesEnum.BOMB);
            /* Вызов метода incNumbersAroundBomb класса MapLayerBottom */
            incNumbersAroundBomb(coordinateSystem);
            /* Конец цикла */
            break;
        }
    }

    /* Увеличение числа от 1 до 8 вокруг бомбы */
    private void incNumbersAroundBomb(CoordinateSystem coordinateSystem) {
        /* Прохождение по списку всех координат оси X и Y вокруг указанной координаты */
        for (CoordinateSystem around : Ranges.getCoordinatesAround(coordinateSystem))
            /* Находится ли в указанной координате бомба */
            if (ImagesEnum.BOMB != mapLayerBottom.getImageEnum(around))
                /* Увеличение числа от 1 до 8 */
                mapLayerBottom.setImageEnum(around, mapLayerBottom.getImageEnum(around).getNextNumber());
    }

    /* Ограничение количества одновременно размещаемых бомб на игровом поле */
    private void limitingNumberOfBombs() {
        /* Максимальное количество бомб на игровом поле */
        int maxBombs = Ranges.getSize().x * Ranges.getSize().y / 2;
        /* Сравнение установленного количества бомб с максимально возможных количеством на игровом поле */
        if (numberOfBombs > maxBombs)
            /* Установка максимального количества бомб на игровом поле */
            numberOfBombs = maxBombs;
    }
}
