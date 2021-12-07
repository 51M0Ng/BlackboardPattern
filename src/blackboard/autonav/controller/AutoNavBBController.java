package blackboard.autonav.controller;

import blackboard.framework.AbstractBlackBoardController;
import blackboard.main.Constant;

public class AutoNavBBController<T> extends AbstractBlackBoardController<T> {
    @Override
    public void execOutcome(T bbo) {
        Constant.writeLog("==>> Operating brake pedal");
    }
}
