package blackboard.main;

import blackboard.main.AutoNavBlackBoardFeeder.BlackBoardObjectType;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AutoNavBlackBoardFeederGUI extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        AutoNavBlackBoardFeeder feeder = new AutoNavBlackBoardFeeder(false);

        feeder.addKnowledgeSources();
        feeder.addController();

        Button btnDS = new Button();
        btnDS.setText("Add DeltaSpeedDataBBO");
        btnDS.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                feeder.addBlackBoardObject(BlackBoardObjectType.DELTA_SPEED);
            }
            
        });

        Button btnFV = new Button();
        btnFV.setText("Add FrontVehicleDataBBO");
        btnFV.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                feeder.addBlackBoardObject(BlackBoardObjectType.FRONT_VEHICLE);
            }
            
        });

        Button btnRLV = new Button();
        btnRLV.setText("Add RightLaneVehicleDataBBO");
        btnRLV.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                feeder.addBlackBoardObject(BlackBoardObjectType.RIGHT_LANE_VEHICLE);
            }
            
        });

        VBox hbox = new VBox(btnDS, btnFV, btnRLV);
        Scene scene = new Scene(hbox, 300, 250);

        primaryStage.setTitle("AutoNavBlackBoardFeeder");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}