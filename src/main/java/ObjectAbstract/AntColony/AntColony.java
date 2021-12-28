package ObjectAbstract.AntColony;

import ObjectAbstract.AntColony.Ant.Ant;

import java.awt.*;

public class AntColony extends StandartColony {
    public AntColony(){
        super();
    }
    @Override
    public void move(int dx, int dy){
        move_ants(dx, dy);
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
