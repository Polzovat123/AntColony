package UIWorker;

import Fabric.AntColonyFabric;
import Fabric.MFabric;
import ObjectAbstract.AntColony.Colony;

import java.awt.*;
import java.util.ArrayList;

public class FormManager {
    private int D = 40;
    private ArrayList<Colony> colonies;
    private MFabric fbr;
    private int dx =5 , dy=0;
    int width = 800, height = 800;


    public FormManager(int W, int H){
        colonies = new ArrayList<>();
        width = W;
        height = H;
        fbr = new AntColonyFabric();
    }
    public void drawAllComponents(Graphics2D screen){
        for(Colony one: colonies){
            one.draw(screen);
        }
    }
    public boolean createNewColony(int x, int y){
        if(!canINsert(x,y))return false;
        colonies.add(
                fbr.createColony(1).init(x, y)
        );
        return true;
    }
    public void moveAllComponents(){
        System.out.print("move happend");
    }
    public boolean canINsert(int x, int y){
        for(Colony one: colonies){
            if(one.isTouch(x,y))return false;
        }
        if(x+D>width || x-D<0)return false;
        if(y+D>height || y-D<0)return false;
        return true;
    }
    public void moveAllElements(){
        for(Colony one: colonies){
            one.move(dx,dy);
        }
    }
    public void timeToBuildNewAnt(){
        for(Colony one: colonies){
            one.createAnt();
            break;
        }
    }
}
