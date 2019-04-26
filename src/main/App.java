package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import main.java.utpb.science.fair.models.JudgeDistributor;
import main.java.utpb.science.fair.models.group.Group;
import main.java.utpb.science.fair.models.judge.Judge;
import main.java.utpb.science.fair.models.project.Project;
import main.java.utpb.science.fair.util.FileUtil;

import java.io.IOException;
import java.util.List;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("java/utpb/science/fair/GUI.fxml"));
        primaryStage.setTitle("Judge Scheduler");
        primaryStage.setScene(new Scene(root, 650, 450));
        primaryStage.show();
    }


    public static void main(String[] args){
             launch(args);
    }
}
