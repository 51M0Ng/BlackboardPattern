package blackboard.framework;

import java.util.concurrent.SubmissionPublisher;

public abstract class AbstractBlackBoard<T> extends SubmissionPublisher<T> implements BlackBoard<T> {
    public void addBlackBoardObject(T bbo){
        notifyController(bbo);
    }

    public void notifyController(T bbo){
        submit(bbo);
    }
}
