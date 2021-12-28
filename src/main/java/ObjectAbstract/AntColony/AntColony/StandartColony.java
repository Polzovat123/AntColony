package ObjectAbstract.AntColony.AntColony;

import Fabric.AntFabric;
import ObjectAbstract.AntColony.Ant.Ant;

import java.awt.*;
import java.util.ArrayList;

public class StandartColony implements Colony{
    protected int x=-1;
    protected int y;
    protected int D=40;
    protected AntFabric fbr;
    protected ArrayList<Ant> myAnt;

    public StandartColony(){
        fbr = new AntFabric();
        myAnt = new ArrayList<>();
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
    public void createAnt() {
        Ant n = fbr.build(0);
        n.init(x, y);
        myAnt.add(n);
        System.out.println("Build ant");
    }

    @Override
    public void move(int step) {

    }

    @Override
    public boolean isTouch(Colony b) {
        return b.isTouch(x, y);
    }

    @Override
    public void isTouchAnt(Point FoodPoint, int S) {
        for(Ant ant : myAnt){
            ant.isFinish(FoodPoint, S);
        }
    }

    @Override
    public void draw(Graphics2D screen) {

    }

    protected void draw_ant(Graphics2D screen){
        for(Ant ant : myAnt){
            ant.draw(screen);
        }
    }

    protected  void move_ants(int step){
        for(Ant ant : myAnt){
            ant.move(step);
        }
    }

}
