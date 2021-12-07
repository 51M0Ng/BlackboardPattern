package blackboard.autonav.bb;

import blackboard.framework.AbstractObserverBlackBoard;
import blackboard.main.Constant;

public class AutoNavObserverBlackBoard<T> extends AbstractObserverBlackBoard<T>{
    @Override
    public void addBlackBoardObject(T bbo) {
        Constant.writeLog("Blackboard received BBO " + bbo.getClass().getName());
        super.addBlackBoardObject(bbo);
    }
}
