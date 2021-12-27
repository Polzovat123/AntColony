package ObjectAbstract.AntColony;

import java.awt.*;

public class StandartColony implements Colony{
    protected int x=-1;
    protected int y;
    protected int D=40;

    public StandartColony(){

    }
    @Override
    public Colony init(int _x, int _y){
        x = _x;
        y = _y;
        return this;
    }

    @Override
    public boolean isTouch(int _x, int _y) {
        int dist = (x-_x)*(x-_x)+(y-_y)*(y-_y);
        if(dist<=D*D/4)
            return true;
        return false;
    }

    @Override
    public boolean isTouch(Colony b) {
        return b.isTouch(x, y);
    }

    @Override
    public void draw(Graphics2D screen) {

    }
}
