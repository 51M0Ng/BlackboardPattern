package blackboard.controller.autonav;

import blackboard.framework.BlackBoardObject;
import blackboard.framework.autonav.AbstractObserverBlackBoardController;
import blackboard.main.Constant;

public class AutoNavObserverBBController<T> extends AbstractObserverBlackBoardController<T> {
    @Override
    public void execOutcome(BlackBoardObject bbo) {
        Constant.writeLog("==>> Operating brake pedal");
    }
}
