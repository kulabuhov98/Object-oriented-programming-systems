package sweeper;

import java.awt.*;

public enum ImagesEnum {
    ZERO,
    NUM1,
    NUM2,
    NUM3,
    NUM4,
    NUM5,
    NUM6,
    NUM7,
    NUM8,
    BOMB,
    OPENED,
    CLOSED,
    FLAGED,
    BOMBED,
    NOBOMB;

    /* Объект изображения */
    public Image image;

    /* Увеличение числа от 1 до 8 */
    ImagesEnum getNextNumber() {
        return ImagesEnum.values()[this.ordinal() + 1];
    }
}
