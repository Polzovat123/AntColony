package ObjectAbstract.AntColony.Ant;

import ObjectAbstract.AntColony.Ant.AntMarker.AntBasicMarker;
import ObjectAbstract.AntColony.Ant.AntMarker.Marker;

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
    protected int time = 8000;
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
        }
        else{
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
    public void move(int step, ArrayList<Marker> Markers) {
        if(needFood){
            make_decision(Markers);
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
        }
        else{
            if(i==0){
                way.clear();
                body = Color.YELLOW;
                FinishWay();
                return;
            }
            Point go = way.get(i-1);
            Markers.add(new AntBasicMarker(go.x, go.y, i));
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

    protected void make_decision(ArrayList<Marker> markers) {
        int best_smels = -1;
        Marker nextP = null;
        for(Marker m : markers){
            if(best_smels<score_interest(m)){
                nextP = m;
                best_smels = score_interest(m);
            }
        }
        if(best_smels!=-1)
            System.out.println(best_smels);
        if(best_smels<=0){
            body = Color.RED;
            head = direction.nextInt(4)+1;
            return;
        }
        body = Color.BLACK;
        Point f = nextP.getPositon();
        int x1 = f.x, y1 = f.y;
        if(x>x1){
            head = 3;
            return;
        }
        if(x<x1){
            head = 4;
            return;
        }
        if(y>y1){
            head = 1;
            return;
        }
        if(y>y1){
            head = 2;
            return;
        }
    }

    protected int score_interest(Marker marker){
        Point d = marker.getPositon();
        int x1=d.x, y1=d.y;
        int dist = (x-x1)*(x-x1)+(y-y1)*(y-y1);
        if(dist<=D*D/4)return marker.getSmell();
        return -1;
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
