package UIWorker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Form extends JPanel implements ActionListener {
    FormManager mngr;
    int width = 800, height = 800;
    public Form(int W, int H){
        setBackground(Color.GREEN);
        initComponent(W, H);
        setFocusable(true);
    }
    public void initComponent(int W, int H){
        width = W; height = H;
        mngr = new FormManager(W, H);
        Random r = new Random();
        for(int i=0; i<10; i++)
            if(!mngr.createNewColony(r.nextInt(width),r.nextInt(height)))
                i--;
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D screen = (Graphics2D)g;
        mngr.drawAllComponents(screen);
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        mngr.moveAllComponents();
        repaint();
    }
}
