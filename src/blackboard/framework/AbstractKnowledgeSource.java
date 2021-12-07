package blackboard.framework;

public abstract class AbstractKnowledgeSource<T> implements KnowledgeSource<T> {
    protected T bbo;
    protected BlackBoard<T> bb;

    public void run() {
        updateBlackBoardObject(process(bbo));
    }
    
    public void updateBlackBoardObject(T bbo) {
        bb.addBlackBoardObject(bbo);
    }
}
