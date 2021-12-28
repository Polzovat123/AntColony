package UIWorker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Form extends JPanel implements ActionListener {
    Timer timer;
    FormManager mngr;
    int width = 800, height = 800;
    int count = 0;

    public Form(int W, int H){
        setBackground(Color.GREEN);
        initComponent(W, H);
        setFocusable(true);
        refreshScreen();
    }
    public void initComponent(int W, int H){
        width = W; height = H;
        mngr = new FormManager(W, H);
        Random r = new Random();
        for(int i=0; i<10; i++)
            if(!mngr.createNewColony(r.nextInt(width),r.nextInt(height)))
                i--;
        mngr.buildFood(300, 300);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D screen = (Graphics2D)g;
        mngr.drawAllComponents(screen);
    }

    public void move(){
        if(count%10==0&&count<1000){
            mngr.timeToBuildNewAnt();
        }
        count++;
        mngr.moveAllElements();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        move();
        repaint();
    }

    public void refreshScreen(){
        timer = new Timer(1, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                move();
                repaint();
            }
        });
        timer.setRepeats(true);
        timer.setDelay(1);
        timer.start();
    }
}
