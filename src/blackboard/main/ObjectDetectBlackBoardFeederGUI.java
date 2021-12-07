package blackboard.main;

import blackboard.main.ObjectDetectBlackBoardFeeder.ObjectType;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ObjectDetectBlackBoardFeederGUI extends Application {
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        ObjectDetectBlackBoardFeeder feeder = new ObjectDetectBlackBoardFeeder();

        feeder.addKnowledgeSources();
        feeder.addController();

        Button btnCat = new Button();
        btnCat.setText("Add Cat");
        btnCat.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                feeder.addBlackBoardObject(ObjectType.CAT);
            }
            
        });

        Button btnDog = new Button();
        btnDog.setText("Add Dog");
        btnDog.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                feeder.addBlackBoardObject(ObjectType.DOG);
            }
            
        });

        Button btnTree = new Button();
        btnTree.setText("Add Tree");
        btnTree.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                feeder.addBlackBoardObject(ObjectType.TREE);
            }
            
        });

        Button btnCar = new Button();
        btnCar.setText("Add Car");
        btnCar.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                feeder.addBlackBoardObject(ObjectType.CAR);
            }
            
        });

        VBox hbox = new VBox(btnCat, btnDog, btnTree, btnCar);
        Scene scene = new Scene(hbox, 300, 250);

        primaryStage.setTitle("ObjectDetectBlackBoardFeeder");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
