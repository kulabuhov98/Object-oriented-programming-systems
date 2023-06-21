package sweeper;

class MapLayerTop {
    /* Карта для объектов верхнего слоя */
    private MapMatrix mapLayerTop;

    /* Инициализация карты для объектов верхнего слоя */
    void initMapLayerTop() {
        /* Объект класса MapMatrix */
        mapLayerTop = new MapMatrix(ImagesEnum.CLOSED);
    }

    /* Получение элемента перечисления из карты для объектов верхнего слоя с указаннами координатами */
    ImagesEnum getImageEnum(CoordinateSystem coordinateSystem) {
        return mapLayerTop.getImageEnum(coordinateSystem);
    }

    /* Установка элемента перечисления OPENED в указанную координату */
    void setOpenedCell(CoordinateSystem coordinateSystem) {
        mapLayerTop.setImageEnum(coordinateSystem, ImagesEnum.OPENED);
    }
}
