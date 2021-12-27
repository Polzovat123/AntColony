
import UIWorker.Form;

import javax.swing.*;
import java.awt.*;


public class Main extends JFrame{
    int width = 800, height = 800;
    Form window = new Form(width, height);
    public Main(){
        setTitle("WORLD");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(width, height);
        setLocation(600,0);
        add(window);
        setVisible(true);
    }

    public static void main(String[] args) {
        Main window = new Main();
    }
}