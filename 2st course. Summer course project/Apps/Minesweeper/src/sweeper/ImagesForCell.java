package sweeper;

import java.awt.*;

public enum ImagesForCell {
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

    public Image image;

    ImagesForCell getNextNumberBox() {
        return ImagesForCell.values()[this.ordinal() + 1];
    }

    int getNumber() {
        return this.ordinal();
    }
}
