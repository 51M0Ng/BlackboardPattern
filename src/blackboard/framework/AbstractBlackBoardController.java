package blackboard.framework;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Flow;

import blackboard.main.Constant;

public abstract class AbstractBlackBoardController<T> implements BlackBoardController<T> {
    protected List<KnowledgeSource<T>> ksList = new ArrayList<>();
    protected ExecutorService exsvc;
    private Flow.Subscription sub;

    public void onSubscribe(Flow.Subscription subscription){
        this.sub = subscription;
        sub.request(1);
    }

    public void onNext(T item) {
        if(((BlackBoardObject) item).isReady()){
            execOutcome((BlackBoardObject) item);
        } else {
            for (KnowledgeSource<T> ks : ksList) {
                if(ks.canHandle(item, null)) {
                    enrollKnowledgeSource(ks, exsvc);
                    break;
                }
            }
        }
        sub.request(1);
    }

    public void onError(Throwable throwable) {
        Constant.writeLog(throwable.getMessage());
    }

    public void onComplete() {
        Constant.writeLog("Done");
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
