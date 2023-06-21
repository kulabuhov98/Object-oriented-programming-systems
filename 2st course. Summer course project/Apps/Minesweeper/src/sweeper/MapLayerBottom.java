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
        /* Размещение бомбы на игровом поле */
        placeBomb();
    }

    /* Размещение бомбы на игровом поле */
    private void placeBomb() {

    }

    /* Получение элемента перечисления из карты для объектов нижнего слоя с указаннами координатами */
    ImagesEnum getImageEnum(CoordinateSystem coordinateSystem) {
        return mapLayerBottom.getImageEnum(coordinateSystem);
    }
}
