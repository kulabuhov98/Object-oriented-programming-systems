package sweeper;

class MapLayerTop {
    /* Карта для объектов верхнего слоя */
    private MapMatrix mapLayerTop;

    /* Количество закрытых ячеек на игровом поле */
    private int numberOfClosedCells;

    /* Инициализация карты для объектов верхнего слоя */
    void initMapLayerTop() {
        /* Объект класса MapMatrix */
        mapLayerTop = new MapMatrix(ImagesEnum.CLOSED);
        /* Инициализация количества закрытых ячеек на игровом поле */
        numberOfClosedCells = Ranges.getSize().x * Ranges.getSize().y;
    }

    /* Получение элемента перечисления из карты для объектов верхнего слоя с указаннами координатами */
    ImagesEnum getImageEnum(CoordinateSystem coordinateSystem) {
        return mapLayerTop.getImageEnum(coordinateSystem);
    }

    /* Установка элемента перечисления OPENED в указанную координату */
    void setOpenedCell(CoordinateSystem coordinateSystem) {
        mapLayerTop.setImageEnum(coordinateSystem, ImagesEnum.OPENED);
        /* Уменьшее количества закрытых ячеек на игровом поле */
        numberOfClosedCells--;
    }

    /* Установка элемента перечисления FLAGED в указанную координату */
    void setFlagedCell(CoordinateSystem coordinateSystem) {
        mapLayerTop.setImageEnum(coordinateSystem, ImagesEnum.FLAGED);
    }

    /* Установка элемента перечисления CLOSED в указанную координату */
    void setClosedCell(CoordinateSystem coordinateSystem) {
        mapLayerTop.setImageEnum(coordinateSystem, ImagesEnum.CLOSED);
    }

    /* Переключатель элемента перечисления FLAGGED и CLOSED в уканной координате */
    void toggleFlagedCell(CoordinateSystem coordinateSystem) {
        /* Получение текущего элемента перечисления в указанной координате */
        switch (mapLayerTop.getImageEnum(coordinateSystem)) {
            /* Установка элемента перечисления FLAGGED в указанную координату */
            case FLAGED -> setClosedCell(coordinateSystem);
            /* Установка элемента перечисления CLOSED в указанную координату */
            case CLOSED -> setFlagedCell(coordinateSystem);
        }
    }

    /* Получение количества закрытых ячеек на игровом поле */
    int getNumberOfClosedCells() {
        return numberOfClosedCells;
    }
}
