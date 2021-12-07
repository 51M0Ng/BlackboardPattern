package blackboard.ks;

import blackboard.bb.AutoNavBlackBoard;
import blackboard.bbo.DeltaSpeedDataBBO;
import blackboard.bbo.FrontVehicleDataBBO;
import blackboard.framework.AbstractKnowledgeSource;
import blackboard.framework.BlackBoard;
import blackboard.framework.BlackBoardObject;
import blackboard.main.Constant;

public class FrontVehicleDataKS<T> extends AbstractKnowledgeSource<T> {
    private boolean initBB = false;
    
    public FrontVehicleDataKS(BlackBoard<T> bb){
        if(bb instanceof AutoNavBlackBoard){
            this.bb = bb;
            initBB = true;
        }
    }
    
    @Override
    public boolean canHandle(T bbo, BlackBoard<T> bb) {
        if(bbo instanceof FrontVehicleDataBBO) {
            this.bbo = bbo;
            if(!initBB){
                this.bb = bb;
            }

            return true;
        }
        return false;
    }

    /**
      * Processes a FrontVehicleDataBBO and returns a transformed DeltaSpeedDataBBO
      */

    @Override
    public T process(T bbo) {
        BlackBoardObject deltaSpeedDataBBO = new DeltaSpeedDataBBO();

        try {
            // Pretend the KS is working
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        Constant.writeLog("==>> FrontVehicleDataKS processed FrontVehicleDataBBO");
        return (T) deltaSpeedDataBBO;
    }
}
