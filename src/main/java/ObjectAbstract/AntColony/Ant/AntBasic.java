package ObjectAbstract.AntColony.Ant;

import ObjectAbstract.AntColony.Colony;

import java.awt.*;
import java.util.ArrayList;

public class AntBasic implements Ant{
    protected int x, y;
    protected int D=10;
    protected Color body;
    protected ArrayList<Point> way;
    protected int head;
    protected boolean needFood;
    public AntBasic(){
        head = 3;
        way = new ArrayList<>();
        needFood = true;
        body = Color.RED;
    }

    @Override
    public void init(int _x, int _y) {
        x = _x;
        y = _y;
    }

    @Override
    public void draw(Graphics2D screen) {
        screen.setColor(body);
        screen.fillRect(x, y, D, D);
    }

    @Override
    public void move(int dx, int dy) {
        make_decision(dx, dy);
        way.add(new Point(x, y));
        switch (head){
            case 1://up
                move_use_decision(dx, (-1)*dy);
                 return;
            case 2://down
                move_use_decision(dx, dy);
                return;
            case 3://right
                move_use_decision(dx, dy);
                return;
            case 4://left
                move_use_decision(-dx, dy);
                return;
            default:
                body = Color.BLUE;
                return;
        }
    }

    @Override
    public boolean isFinish(int x, int y) {
        return false;
    }

    protected void make_decision(int dx, int dy) {
        if(head==3)head = 1;
        else head = 3;
    }

    protected void move_use_decision(int dx, int dy){
        x+=dx;
        y+=dy;
    }

    @Override
    public void FinishWay() {
        needFood = !needFood;
    }
}
