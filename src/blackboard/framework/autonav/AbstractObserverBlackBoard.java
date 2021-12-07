package blackboard.framework.autonav;

import java.util.Observable;

import blackboard.framework.BlackBoard;

public abstract class AbstractObserverBlackBoard<T> extends Observable implements BlackBoard<T> {
    public void addBlackBoardObject(T bbo){
        setChanged();
        notifyController(bbo);
    }

    public void notifyController(T bbo){
        notifyObservers(bbo);
    }
}
