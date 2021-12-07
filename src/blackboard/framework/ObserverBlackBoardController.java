package blackboard.framework;

import java.util.Observer;
import java.util.concurrent.ExecutorService;

public interface ObserverBlackBoardController<T> extends Observer, BaseBlackBoardController<T> {
    public void enrollKnowledgeSource(KnowledgeSource<T> ks, ExecutorService exsvc);
    public void execOutcome(BlackBoardObject bbo);
}
