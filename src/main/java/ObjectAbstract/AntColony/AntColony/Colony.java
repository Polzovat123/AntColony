package ObjectAbstract.AntColony.AntColony;

import ObjectAbstract.AntColony.Ant.AntMarker.Marker;

import java.awt.*;
import java.util.ArrayList;

public interface Colony {
    void draw(Graphics2D screen);
    Colony init(int _x, int _y);
    boolean isTouch(int _x, int _y);
    void createAnt();
    void move(int step);
    void move(int step, ArrayList<Marker> Markers);
    boolean isTouch(Colony b);
    void isTouchAnt(Point FoodPoint,int S);
}