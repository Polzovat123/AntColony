package ObjectAbstract.AntColony;

import java.awt.*;

public class AntColony extends StandartColony {
    public AntColony(){
        super();
    }
    @Override
    public void draw(Graphics2D screen) {
        if(x==-1)
            return;
        screen.setColor(Color.BLACK);
        screen.fillOval(x, y, D, D);
    }
}
