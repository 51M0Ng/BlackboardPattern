package blackboard.framework;

import java.util.List;

public interface BaseBlackBoardController<T> {
    public void setKnowledgeSourceList(List<KnowledgeSource<T>> ksList);
}
