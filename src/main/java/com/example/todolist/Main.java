package com.example.todolist;

import com.example.todolist.datamodel.Data;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws  Exception{
        Parent root= FXMLLoader.load(getClass().getResource("mainwindow.fxml"));
        stage.setTitle("Todo List");
        stage.setScene(new Scene(root, 900, 500));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void stop() throws Exception {
        try{
            Data.getInstance().storeTodoItems();
        }catch(IOException e){
            System.out.println(e.getMessage());

        }
    }

    @Override
    public void init() throws Exception {
        try{
            Data.getInstance().loadTodoItems();
        }catch(IOException e){
            System.out.println(e.getMessage());

        }
    }
}
