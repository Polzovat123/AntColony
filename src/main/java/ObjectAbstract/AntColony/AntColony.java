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
        screen.setColor(new Color(165, 42, 42));
        screen.fillOval(x, y, D, D);
    }
}
