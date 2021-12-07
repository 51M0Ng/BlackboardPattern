package blackboard.autonav.controller;

import blackboard.framework.AbstractObserverBlackBoardController;
import blackboard.framework.BlackBoardObject;
import blackboard.main.Constant;

public class AutoNavObserverBBController<T> extends AbstractObserverBlackBoardController<T> {
    @Override
    public void execOutcome(BlackBoardObject bbo) {
        Constant.writeLog("==>> Operating brake pedal");
    }
}
