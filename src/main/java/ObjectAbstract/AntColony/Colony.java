package ObjectAbstract.AntColony;

import java.awt.*;

public interface Colony {
    void draw(Graphics2D screen);
    Colony init(int _x, int _y);
    boolean isTouch(int _x, int _y);
    void createAnt();
    void move(int dx, int dy);
    boolean isTouch(Colony b);
}