
import UIWorker.Form;

import javax.swing.*;
import java.awt.*;


public class Main extends JFrame{
    Form window = new Form();
    public Main(){
        setTitle("WORLD");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(800, 800);
        setLocation(200,0);
        add(window);
        setVisible(true);
    }

    public static void main(String[] args) {
        Main window = new Main();
    }
}