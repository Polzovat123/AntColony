package ObjectAbstract.AntColony.Ant;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class AntBasic implements Ant{
    protected int x, y;
    protected int D=10;
    protected Color body;
    protected ArrayList<Point> way;
    protected int head;
    protected boolean needFood;
    protected int W=800, H=800;
    int i = 0;
    protected Random direction = new Random();

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
    public void move(int step) {
        if(needFood){
            make_decision();
            way.add(new Point(x, y));
            int dx, dy;
            switch (head){
                case 1://up
                    dy = -step;
                    dx = 0;
                    move_use_decision(dx, dy);
                    return;
                case 2://down
                    dy = step;
                    dx = 0;
                    move_use_decision(dx, dy);
                    return;
                case 4://right
                    dx = step;
                    dy = 0;
                    move_use_decision(dx, dy);
                    return;
                case 3://left
                    dx = -step;
                    dy = 0;
                    move_use_decision(dx, dy);
                    return;
                default:
                    body = Color.BLUE;
                    return;
            }
        }else{
            if(i==0){
                way.clear();
                body = Color.YELLOW;
                FinishWay();
                return;
            }
            Point go = way.get(i-1);
            x = go.x;
            y = go.y;
            i--;
            body = Color.BLUE;
        }
    }

    @Override
    public boolean isFinish(int x, int y) {
        return false;
    }

    @Override
    public void isFinish(Point Food, int S) {
        if(!needFood)return;
        int _x = Food.x, _y = Food.y;
        int dist = (x-_x)*(x-_x)+(y-_y)*(y-_y);
        if(dist<(D+S)*(D+S)/4){
            FinishWay();
        }
    }

    protected void make_decision() {
        head = direction.nextInt(4)+1;
    }

    protected void move_use_decision(int dx, int dy){
        if(!canGo(x+dx, y+dy))return;
        x+=dx;
        y+=dy;
        i++;
    }

    @Override
    public void FinishWay() {
        needFood = !needFood;
    }

    public boolean canGo(int nx, int ny){
        if(nx>W || ny>H || ny<0 ||nx<0){
            return false;
        }
        return true;
    }
}
