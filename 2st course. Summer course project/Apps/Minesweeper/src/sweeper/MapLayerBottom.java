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
    }

    /* Получение элемента перечисления из карты для объектов нижнего слоя с указаннами координатами */
    ImagesEnum getImageEnum(CoordinateSystem coordinateSystem) {
        return mapLayerBottom.getImageEnum(coordinateSystem);
    }
}
