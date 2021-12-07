package blackboard.framework;

import java.util.Observable;

public abstract class AbstractObserverBlackBoard<T> extends Observable implements BlackBoard<T> {
    public void addBlackBoardObject(T bbo){
        setChanged();
        notifyController(bbo);
    }

    public void notifyController(T bbo){
        notifyObservers(bbo);
    }
}
