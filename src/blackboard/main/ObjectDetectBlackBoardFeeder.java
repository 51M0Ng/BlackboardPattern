package blackboard.main;

import java.util.ArrayList;
import java.util.List;

import blackboard.framework.BaseBlackBoardController;
import blackboard.framework.BlackBoard;
import blackboard.framework.BlackBoardObject;
import blackboard.framework.KnowledgeSource;
import blackboard.objdetect.bb.ObjectDetectBlackBoard;
import blackboard.objdetect.bbo.AbstractObjectBBO;
import blackboard.objdetect.bbo.CarBBO;
import blackboard.objdetect.bbo.CatBBO;
import blackboard.objdetect.bbo.DogBBO;
import blackboard.objdetect.bbo.TreeBBO;
import blackboard.objdetect.controller.ObjectDetectBBController;
import blackboard.objdetect.ks.AnimalKS;
import blackboard.objdetect.ks.CatKS;
import blackboard.objdetect.ks.DogKS;
import blackboard.objdetect.ks.TreeKS;

public class ObjectDetectBlackBoardFeeder {

    public enum ObjectType {
        CAT,
        DOG,
        CAR,
        TREE
        ;
    }

    private BlackBoard<AbstractObjectBBO> bb;
    private BaseBlackBoardController<AbstractObjectBBO> controller;

    public static void main(String[] args) {
    }

    public ObjectDetectBlackBoardFeeder(){
        bb = new ObjectDetectBlackBoard<>();
        controller = new ObjectDetectBBController<>();
    }

    public void addBlackBoardObject(ObjectType type){
        switch(type){
            case CAT:
                bb.addBlackBoardObject(new CatBBO());
                break;
            case DOG:
                bb.addBlackBoardObject(new DogBBO());
                break;
            case CAR:
                bb.addBlackBoardObject(new CarBBO());
                break;
            case TREE:
                bb.addBlackBoardObject(new TreeBBO());
                break;
            default:
                break;
        }
    }

    public void addController() {
        ((ObjectDetectBlackBoard<AbstractObjectBBO>)bb).subscribe((ObjectDetectBBController<AbstractObjectBBO>)controller);
    }

    public void addKnowledgeSources(){
        List<KnowledgeSource<AbstractObjectBBO>> ksList = new ArrayList<>();
        ksList.add(new CatKS<>(bb));
        ksList.add(new DogKS<>(bb));
        ksList.add(new TreeKS<>(bb));
        ksList.add(new AnimalKS<>(bb));
        controller.setKnowledgeSourceList(ksList);
    }
}
