package ObjectAbstract.AntColony.Ant;

import java.awt.*;

public interface Ant {
    void draw(Graphics2D screen);
    void move(int dx, int dy);
    boolean isFinish(int x, int y);
    void FinishWay();
    void init(int x, int y);
}
