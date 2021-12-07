package blackboard.framework;

public interface KnowledgeSource<T> extends Runnable {
    public boolean canHandle(T item, BlackBoard<T> bb);
    public T process(T bbo);
    public void updateBlackBoardObject(T bbo);
}
