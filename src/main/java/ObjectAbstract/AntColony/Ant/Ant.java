package ObjectAbstract.AntColony.Ant;

import java.awt.*;

public interface Ant {
    void draw(Graphics2D screen);
    void move(int step);
    boolean isFinish(int x, int y);
    void isFinish(Point Food, int S);
    void FinishWay();
    void init(int x, int y);
}
