package blackboard.objdetect.ks;

import blackboard.framework.AbstractKnowledgeSource;
import blackboard.framework.BlackBoard;
import blackboard.objdetect.bb.ObjectDetectBlackBoard;
import blackboard.objdetect.bbo.AbstractObjectBBO;
import blackboard.objdetect.bbo.AnimalBBO;
import blackboard.objdetect.bbo.DogBBO;

public class DogKS<T> extends AbstractKnowledgeSource<T> {
    private boolean initBB = false;

    public DogKS(BlackBoard<T> bb){
        if(bb instanceof ObjectDetectBlackBoard){
            this.bb = bb;
            initBB = true;
        }
    }
    
    public boolean canHandle(T bbo, BlackBoard<T> bb) {
        if (bbo instanceof DogBBO) {
            this.bbo = bbo;
            if(!initBB){
                this.bb = bb;
            }
            return true;
        }
        return false;
    }
    
    public T process(T bbo) {
        AbstractObjectBBO animalBBO = new AnimalBBO();
        animalBBO.setType(((AbstractObjectBBO)bbo).getType());
        animalBBO.setProp(((AbstractObjectBBO)bbo).getProp());
        return (T) animalBBO;
    }
}
