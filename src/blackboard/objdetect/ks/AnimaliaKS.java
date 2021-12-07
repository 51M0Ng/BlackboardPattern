package blackboard.objdetect.ks;

import blackboard.framework.AbstractKnowledgeSource;
import blackboard.framework.BlackBoard;
import blackboard.objdetect.bb.ObjectDetectBlackBoard;
import blackboard.objdetect.bbo.AbstractObjectBBO;
import blackboard.objdetect.bbo.AnimalBBO;
import blackboard.objdetect.bbo.ItemBBO;
import blackboard.objdetect.bbo.AbstractObjectBBO.ObjectProp;

public class AnimaliaKS<T> extends AbstractKnowledgeSource<T> {
    private boolean initBB = false;

    public AnimaliaKS(BlackBoard<T> bb){
        if(bb instanceof ObjectDetectBlackBoard){
            this.bb = bb;
            initBB = true;
        }
    }
    
    public boolean canHandle(T bbo, BlackBoard<T> bb) {
        if (bbo instanceof AbstractObjectBBO) {
            this.bbo = bbo;
            if(!initBB){
                this.bb = bb;
            }
            return true;
        }
        return false;
    }
    
    public T process(T bbo) {
        AbstractObjectBBO resultBBO = null;
        if(((AbstractObjectBBO)bbo).getProp().contains(ObjectProp.BREATHING)){
            resultBBO = new AnimalBBO();
        } else {
            resultBBO = new ItemBBO();
        }

        resultBBO.setReady(true);
        resultBBO.setType(((AbstractObjectBBO)bbo).getType());
        resultBBO.setProp(((AbstractObjectBBO)bbo).getProp());

        return (T) resultBBO;
    }
}
