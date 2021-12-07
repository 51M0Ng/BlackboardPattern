package blackboard.autonav.ks;

import blackboard.autonav.bb.AutoNavBlackBoard;
import blackboard.autonav.bbo.BrakePedalBBO;
import blackboard.autonav.bbo.DeltaSpeedDataBBO;
import blackboard.framework.AbstractKnowledgeSource;
import blackboard.framework.BlackBoard;
import blackboard.framework.BlackBoardObject;
import blackboard.main.Constant;

public class DeltaSpeedDataKS<T> extends AbstractKnowledgeSource<T> {
    private boolean initBB = false;

    public DeltaSpeedDataKS(BlackBoard<T> bb){
        if(bb instanceof AutoNavBlackBoard){
            this.bb = bb;
            initBB = true;
        }
    }
    
    public boolean canHandle(T bbo, BlackBoard<T> bb) {
        if (bbo instanceof DeltaSpeedDataBBO) {
            this.bbo = bbo;
            if(!initBB){
                this.bb = bb;
            }
            return true;
        }
        return false;
    }
    
    public T process(T bbo) {
        BlackBoardObject brakePedalBBO = new BrakePedalBBO();
        ((BrakePedalBBO)brakePedalBBO).setReady(true);
        Constant.writeLog("==>> DeltaSpeedDataKS processed DeltaSpeedDataBBO");

        return (T) brakePedalBBO;
    }
}
