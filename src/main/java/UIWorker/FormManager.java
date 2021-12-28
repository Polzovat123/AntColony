package UIWorker;

import Fabric.AntColonyFabric;
import Fabric.MFabric;
import ObjectAbstract.AntColony.Ant.AntMarker.Marker;
import ObjectAbstract.AntColony.AntColony.Colony;
import ObjectAbstract.AntColony.CommandClass.ClassMarkers;
import ObjectAbstract.SomeUsefulComponent.Food.AntFood;

import java.awt.*;
import java.util.ArrayList;

public class FormManager {
    private int D = 40;
    private ArrayList<Colony> colonies;
    private ArrayList<AntFood> foods;
    private ClassMarkers mngM;
    private MFabric fbr;
    private int delta =5;
    private ArrayList<Marker> marker;
    int width = 800, height = 800;


    public FormManager(int W, int H){
        colonies = new ArrayList<>();
        foods = new ArrayList<>();
        mngM = new ClassMarkers();
        marker = new ArrayList<>();
        width = W;
        height = H;
        fbr = new AntColonyFabric();
    }

    public void drawAllComponents(Graphics2D screen){
        for(Colony one: colonies){
            one.draw(screen);
        }
        for(Marker m: marker){
            if(m.getSmell()!=-1)
            m.draw(screen);
        }
        for(AntFood food: foods){
            food.draw(screen);
        }
    }

    public boolean createNewColony(int x, int y){
        if(!canINsert(x,y))return false;
        colonies.add(
                fbr.createColony(1).init(x, y)
        );
        return true;
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
            one.move(delta, marker);
        }
        for(Marker one: marker){
            //one.move();
        }
        for(AntFood food: foods){
            Point f1 = food.getPoint();
            for(Colony one: colonies){
                one.isTouchAnt(f1, food.D);
            }
        }
    }
    public void timeToBuildNewAnt(){
        for(Colony one: colonies){
            one.createAnt();
        }
    }
    public void buildFood(int x, int y){
        AntFood eda = new AntFood(x, y);
        foods.add(eda);
    }

}
