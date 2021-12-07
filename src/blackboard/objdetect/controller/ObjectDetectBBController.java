package blackboard.objdetect.controller;

import blackboard.framework.AbstractBlackBoardController;
import blackboard.main.Constant;
import blackboard.objdetect.bbo.AbstractObjectBBO;
import blackboard.objdetect.bbo.AnimalBBO;
import blackboard.objdetect.bbo.ItemBBO;

public class ObjectDetectBBController<T> extends AbstractBlackBoardController<T> {
    @Override
    public void execOutcome(T bbo) {
        if(bbo instanceof AnimalBBO) {
            Constant.writeLog(((AbstractObjectBBO)bbo).getType() + " is animal");
        } else if (bbo instanceof ItemBBO) {
            Constant.writeLog(((AbstractObjectBBO)bbo).getType() + " is items");
        } else {
            Constant.writeLog(((AbstractObjectBBO)bbo).getType() + " is unknown");
        }
    }
}
