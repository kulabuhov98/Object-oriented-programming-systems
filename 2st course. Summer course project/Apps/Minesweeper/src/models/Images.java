package models;

import sweeper.ImagesForCell;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Images {
    /* Установка соотношения изображения с элементом перечисления */
    public void setImages() {
        /* Прохождение по всем элементам перечисления */
        for (ImagesForCell imagesForCell : ImagesForCell.values()) {
            /* Установка соотношения изображения с элементом перечисления */
            imagesForCell.image = getImage((imagesForCell.name()));
        }
    }

    /* Получение изображения из ресурсов проекта  */
    public Image getImage(String filename) {
        /* Формирование пути до изображения */
        String resource = "../" + filename.toLowerCase() + ".png";
        /* Получение изображения из ресурсов проекта */
        ImageIcon imageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource(resource)));
        /* Возвращение изображения для ячейки игрового поля */
        return imageIcon.getImage();
    }
}
