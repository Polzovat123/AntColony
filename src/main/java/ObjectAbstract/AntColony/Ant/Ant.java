package ObjectAbstract.AntColony.Ant;

import java.awt.*;

public interface Ant {
    void draw(Graphics2D screen);
    void move(int dx, int dy);
    boolean isFinish(int x, int y);
    int make_decision();
    void go_home();
}
