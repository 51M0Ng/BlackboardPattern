package blackboard.framework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Flow;

public interface BlackBoardController<T> extends Flow.Subscriber<T>, BaseBlackBoardController<T> {
    public void enrollKnowledgeSource(KnowledgeSource<T> ks, ExecutorService exsvc);
    public void execOutcome(BlackBoardObject bbo);
}
