package ObjectAbstract.AntColony.AntColony;

import java.awt.*;

public interface Colony {
    void draw(Graphics2D screen);
    Colony init(int _x, int _y);
    boolean isTouch(int _x, int _y);
    void createAnt();
    void move(int step);
    boolean isTouch(Colony b);
    void isTouchAnt(Point FoodPoint,int S);
}