package Fabric;

import ObjectAbstract.AntColony.AntColony.AntColony;
import ObjectAbstract.AntColony.AntColony.Colony;
import ObjectAbstract.AntColony.AntColony.StandartColony;

public class AntColonyFabric implements MFabric{
    @Override
    public Colony createColony(int code) {
        switch (code){
            case 1:
                return new AntColony();
            default :
                return new StandartColony();
        }
    }
}
