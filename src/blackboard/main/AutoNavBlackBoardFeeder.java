package blackboard.main;

import java.util.ArrayList;
import java.util.List;

import blackboard.bb.AutoNavBlackBoard;
import blackboard.bb.AutoNavObserverBlackBoard;
import blackboard.bbo.BrakePedalBBO;
import blackboard.bbo.DeltaSpeedDataBBO;
import blackboard.bbo.FrontVehicleDataBBO;
import blackboard.bbo.RightLaneVehicleDataBBO;
import blackboard.controller.AutoNavBBController;
import blackboard.controller.AutoNavObserverBBController;
import blackboard.framework.BaseBlackBoardController;
import blackboard.framework.BlackBoard;
import blackboard.framework.BlackBoardObject;
import blackboard.framework.KnowledgeSource;
import blackboard.ks.DeltaSpeedDataKS;
import blackboard.ks.FrontVehicleDataKS;
import blackboard.ks.RightLaneVehicleDataKS;

public class AutoNavBlackBoardFeeder {

    public enum BlackBoardObjectType {
        BRAKE_PEDAL,
        DELTA_SPEED,
        FRONT_VEHICLE,
        RIGHT_LANE_VEHICLE
        ;
    }

    private BlackBoard<BlackBoardObject> bb;
    private BaseBlackBoardController<BlackBoardObject> controller;

    public static void main(String[] args) {
        AutoNavBlackBoardFeeder feeder = new AutoNavBlackBoardFeeder(false);

        feeder.addKnowledgeSources();
        feeder.addController();
        feeder.addBlackBoardObjects();
    }

    public AutoNavBlackBoardFeeder(boolean observerMode){
        if(observerMode){
            bb = new AutoNavObserverBlackBoard<>();
            controller = new AutoNavObserverBBController<>();
        }else{
            bb = new AutoNavBlackBoard<>();
            controller = new AutoNavBBController<>();
        }
    }

    public void addBlackBoardObjects() {
        int i = 0;
        while (i < 1) {
            bb.addBlackBoardObject(new FrontVehicleDataBBO());
            bb.addBlackBoardObject(new RightLaneVehicleDataBBO());

            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }

            i++;
        }
    }

    public void addBlackBoardObject(BlackBoardObjectType type){
        switch(type){
            case FRONT_VEHICLE:
                bb.addBlackBoardObject(new FrontVehicleDataBBO());
                break;
            case RIGHT_LANE_VEHICLE:
                bb.addBlackBoardObject(new RightLaneVehicleDataBBO());
                break;
            case DELTA_SPEED:
                bb.addBlackBoardObject(new DeltaSpeedDataBBO());
                break;
            case BRAKE_PEDAL:
                bb.addBlackBoardObject(new BrakePedalBBO());
                break;
            default:
                break;
        }
    }

    public void addController() {
        if(bb instanceof AutoNavObserverBlackBoard){
            ((AutoNavObserverBlackBoard<BlackBoardObject>)bb).addObserver((AutoNavObserverBBController<BlackBoardObject>)controller);
        } else if(bb instanceof AutoNavBlackBoard) {
            ((AutoNavBlackBoard<BlackBoardObject>)bb).subscribe((AutoNavBBController<BlackBoardObject>)controller);
        }
    }

    public void addKnowledgeSources(){
        List<KnowledgeSource<BlackBoardObject>> ksList = new ArrayList<>();
        ksList.add(new RightLaneVehicleDataKS<>(bb));
        ksList.add(new FrontVehicleDataKS<>(bb));
        ksList.add(new DeltaSpeedDataKS<>(bb));
        controller.setKnowledgeSourceList(ksList);
    }
}