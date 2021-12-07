package blackboard.bb;

import blackboard.framework.AbstractBlackBoard;
import blackboard.main.Constant;

public class AutoNavBlackBoard<T> extends AbstractBlackBoard<T>{

    @Override
    public void addBlackBoardObject(T bbo) {
        Constant.writeLog("Blackboard received BBO " + bbo.getClass().getName());
        super.addBlackBoardObject(bbo);
    }
}
