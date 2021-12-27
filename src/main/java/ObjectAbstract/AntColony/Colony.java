package ObjectAbstract.AntColony;

import java.awt.*;

public interface Colony {
    void draw(Graphics2D screen);
    Colony init(int _x, int _y);
    boolean isTouch(int _x, int _y);
    boolean isTouch(Colony b);
}