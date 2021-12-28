package ObjectAbstract.AntColony.AntColony;

import ObjectAbstract.AntColony.Ant.Ant;
import ObjectAbstract.AntColony.Ant.AntMarker.Marker;

import java.awt.*;
import java.util.ArrayList;

public class AntColony extends StandartColony {
    public AntColony(){
        super();
    }
    @Override
    public void move(int step){
        move_ants(step);
    }
    @Override
    public void move(int step, ArrayList<Marker> mr) {
        for(Ant ant : myAnt){
            ant.move(step, mr);
        }
    }
    @Override
    public void draw(Graphics2D screen) {
        draw_ant(screen);
        if(x==-1)
            return;
        screen.setColor(new Color(165, 42, 42));
        screen.fillOval(x, y, D, D);
    }
}
