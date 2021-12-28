package ObjectAbstract.AntColony.Ant.AntMarker;

import java.awt.*;

public interface Marker {
    void move();
    Point getPositon();
    void draw(Graphics2D screen);
    int getSmell();
}
