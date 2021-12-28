package Fabric;

import ObjectAbstract.AntColony.Ant.Ant;
import ObjectAbstract.AntColony.Ant.AntBasic;

public class AntFabric {
    public Ant build(int code){
        switch (code){
            default:
                return new AntBasic();
        }
    }
}
