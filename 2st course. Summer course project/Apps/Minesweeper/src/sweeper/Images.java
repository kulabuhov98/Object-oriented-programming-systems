package sweeper;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Images {
    /* Установка взаимосвязи между изображениями из ресурсов проекта и элементами перечисления */
    public void setImages() {
        /* Прохождение по всем элементам перечисления */
        for (ImagesEnum imagesEnum : ImagesEnum.values()) {
            /* Установка взаимосвязи между изображением и элементом перечисления */
            imagesEnum.image = getImage((imagesEnum.name()));
        }
    }

    /* Получение изображения из ресурсов проекта  */
    public Image getImage(String filename) {
        /* Формирование пути до изображения */
        String resource = "../" + filename.toLowerCase() + ".png";
        /* Получение изображения из ресурсов проекта */
        ImageIcon imageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource(resource)));
        /* Возвращение объекта изображения */
        return imageIcon.getImage();
    }
}
