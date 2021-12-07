package blackboard.controller;

import blackboard.framework.AbstractBlackBoardController;
import blackboard.framework.BlackBoardObject;
import blackboard.main.Constant;

public class AutoNavBBController<T> extends AbstractBlackBoardController<T> {
    @Override
    public void execOutcome(BlackBoardObject bbo) {
        Constant.writeLog("==>> Operating brake pedal");
    }
}
