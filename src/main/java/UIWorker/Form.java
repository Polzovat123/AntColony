package UIWorker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Form extends JPanel  {//implements ActionListener in future
    FormManager mngr;
    public Form(){
        setBackground(Color.GREEN);
        initComponent();
        //setFocusable(true);
    }
    public void initComponent(){
        mngr = new FormManager();
    }
}
