package blackboard.framework;

public interface BlackBoard<T> {
    public void addBlackBoardObject(T bbo);
    public void notifyController(T bbo);
}
