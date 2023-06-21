package sweeper;

public class Sweeper {
    /* Конструктор класса Sweeper */
    public Sweeper (int cols, int rows) {
        Ranges.setSize(new CoordinateSystem(cols, rows));
    }

}
