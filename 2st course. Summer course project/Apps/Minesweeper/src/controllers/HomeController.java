package controllers;

import models.Images;

import java.awt.*;

public class HomeController {
    private final Images images;

    /* Конструктор класса HomeController */
    public HomeController(Images images) {
        this.images = images;
    }

    /* Получение изображения из ресурсов проекта */
    public Image getImage(String filename) {
        /* Вызов метода getImage класса модели Images */
        return images.getImage(filename);
    }

    /* Установка взаимосвязи между изображениями из ресурсов проекта с элементами перечисления */
    public void setImages() {
        /* Вызов метода setImages класса модели Images */
        images.setImages();
    }
}
