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

    /* Получение количества закрытых ячеек на игровом поле */
    int getNumberOfClosedCells() {
        return numberOfClosedCells;
    }

    /* Получение элемента перечисления из карты для объектов верхнего слоя с указаннами координатами */
    ImagesEnum getImageEnum(CoordinateSystem coordinateSystem) {
        /* Вызов метода getImageEnum класса MapMatrix */
        return mapLayerTop.getImageEnum(coordinateSystem);
    }

    /* Установка элемента перечисления OPENED в указанную координату */
    void setOpenedCell(CoordinateSystem coordinateSystem) {
        /* Вызов метода setImageEnum класса MapMatrix */
        mapLayerTop.setImageEnum(coordinateSystem, ImagesEnum.OPENED);
        /* Уменьшее количества закрытых ячеек на игровом поле */
        numberOfClosedCells--;
    }

    /* Установка элемента перечисления FLAGED в указанную координату */
    void setFlagedCell(CoordinateSystem coordinateSystem) {
        /* Вызов метода setImageEnum класса MapMatrix */
        mapLayerTop.setImageEnum(coordinateSystem, ImagesEnum.FLAGED);
    }

    /* Установка элемента перечисления CLOSED в указанную координату */
    void setClosedCell(CoordinateSystem coordinateSystem) {
        /* Вызов метода setImageEnum класса MapMatrix */
        mapLayerTop.setImageEnum(coordinateSystem, ImagesEnum.CLOSED);
    }

    /* Установка элемента перечисления BOMBED в указанную координату */
    void setBombedCell(CoordinateSystem coordinateSystem) {
        /* Вызов метода setImageEnum класса MapMatrix */
        mapLayerTop.setImageEnum(coordinateSystem, ImagesEnum.BOMBED);
    }

    /* Установка элемента перечисления OPENED в указанную координату с элементом перечисления BOMB */
    void setOpenedCellToBomb(CoordinateSystem coordinates) {
        /* Если в указанной координате установлен элемент перечисления CLOSED */
        if (mapLayerTop.getImageEnum(coordinates) == ImagesEnum.CLOSED)
            /* Установка элемента перечисления OPENED в указанную координату */
            mapLayerTop.setImageEnum(coordinates, ImagesEnum.OPENED);
    }

    /* Установка элемента перечисления NOBOMB в указанную координату с элементом перечисления FLAGED */
    void setFlagedCellToNobomb(CoordinateSystem coordinates) {
        /* Если в указанной координате установлен элемент перечисления FLAGED */
        if (mapLayerTop.getImageEnum(coordinates) == ImagesEnum.FLAGED)
            /* Установка элемента перечисления OPENED в указанную координату */
            mapLayerTop.setImageEnum(coordinates, ImagesEnum.NOBOMB);
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
}
