package blackboard.framework.autonav;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import blackboard.framework.BlackBoard;
import blackboard.framework.BlackBoardObject;
import blackboard.framework.KnowledgeSource;
import blackboard.framework.ObserverBlackBoardController;

public abstract class AbstractObserverBlackBoardController<T> implements ObserverBlackBoardController<T> {
    protected List<KnowledgeSource<T>> ksList = new ArrayList<>();
    protected ExecutorService exsvc;

    public void update(Observable bb, Object bbo){
        if(((BlackBoardObject) bbo).isReady()){
            execOutcome((BlackBoardObject) bbo);
        } else {
            for (KnowledgeSource<T> ks : ksList) {
                if(ks.canHandle((T) bbo, (BlackBoard<T>)bb)) {
                    enrollKnowledgeSource(ks, exsvc);
                    break;
                }
            }
        }
    }

    public void setBlackBoard(BlackBoard<T> bb){
    }

    public void setKnowledgeSourceList(List<KnowledgeSource<T>> ksList) {
        this.ksList = ksList;
    }

    public void enrollKnowledgeSource(KnowledgeSource<T> ks, ExecutorService exsvc) {
        exsvc = Executors.newFixedThreadPool(1);
        exsvc.execute(ks);
        exsvc.shutdown();
    }
}
