package ObjectAbstract.AntColony.Ant;

import ObjectAbstract.AntColony.Ant.AntMarker.Marker;

import java.awt.*;
import java.util.ArrayList;

public interface Ant {
    void draw(Graphics2D screen);
    void move(int step);
    void move(int step, ArrayList<Marker> Markers);
    boolean isFinish(int x, int y);
    void isFinish(Point Food, int S);
    void FinishWay();
    void init(int x, int y);
}
