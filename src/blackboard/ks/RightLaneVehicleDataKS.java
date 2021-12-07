package blackboard.ks;

import blackboard.bb.AutoNavBlackBoard;
import blackboard.bbo.DeltaSpeedDataBBO;
import blackboard.bbo.RightLaneVehicleDataBBO;
import blackboard.framework.AbstractKnowledgeSource;
import blackboard.framework.BlackBoard;
import blackboard.framework.BlackBoardObject;
import blackboard.main.Constant;

public class RightLaneVehicleDataKS<T> extends AbstractKnowledgeSource<T> {
    private boolean initBB = false;
    
    public RightLaneVehicleDataKS(BlackBoard<T> bb){
        if(bb instanceof AutoNavBlackBoard){
            this.bb = bb;
            initBB = true;
        }
    }
    
    @Override
    public boolean canHandle(T bbo, BlackBoard<T> bb) {
        if(bbo instanceof RightLaneVehicleDataBBO) {
            this.bbo = bbo;
            if(!initBB){
                this.bb = bb;
            }

            return true;
        }
        return false;
    }

    @Override
    public T process(T bbo) {
        BlackBoardObject deltaSpeedBBO = new DeltaSpeedDataBBO();

        try {
            Thread.sleep(1200);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        Constant.writeLog("==>> RightLaneVehicleDataKS processed RightLaneVehicleDataBBO");
        return (T) deltaSpeedBBO;
    }
}
