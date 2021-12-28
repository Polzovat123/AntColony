package ObjectAbstract.SomeUsefulComponent.Food;

import java.awt.*;

public class AntFood implements CFood{
    protected int x;
    protected int y;
    public int D=40;
    protected int numFood = 100;
    public AntFood(int _x, int _y){
        x = _x;
        y = _y;
    }
    @Override
    public void draw(Graphics2D screen) {
        screen.setColor(Color.PINK);
        screen.fillOval(x, y, D, D);
    }

    @Override
    public Point getPoint() {
        return new Point(x+D/2, y+D/2);
    }


}
