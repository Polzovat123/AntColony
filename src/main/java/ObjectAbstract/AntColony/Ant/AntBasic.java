package ObjectAbstract.AntColony.Ant;

import java.awt.*;

public class AntBasic implements Ant{
    @Override
    public void draw(Graphics2D screen) {

    }

    @Override
    public void move(int dx, int dy) {

    }

    @Override
    public boolean isFinish(int x, int y) {
        return false;
    }

    @Override
    public int make_decision() {
        return 0;
    }

    @Override
    public void go_home() {

    }
}
