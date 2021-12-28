package ObjectAbstract.AntColony.Ant.AntMarker;

import java.awt.*;

public class AntBasicMarker implements Marker{
    protected int x;
    protected int y;
    protected int time;
    public AntBasicMarker(int _x, int _y, int _time){
        x = _x;
        y = _y;
        time = _time;
    }



    @Override
    public void move() {
        time--;
        if(time==0)System.out.println("POint is end");
    }

    @Override
    public Point getPositon() {
        return new Point(x, y);
    }

    @Override
    public void draw(Graphics2D screen) {
        screen.setColor(Color.BLACK);
        screen.fillRect(x, y, time/1000, time/1000);
    }

    @Override
    public int getSmell() {
        System.out.println("I smell: "+time);
        if(time==-1)return 100000;
        return time;
    }
}
