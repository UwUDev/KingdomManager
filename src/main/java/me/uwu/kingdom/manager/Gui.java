package me.uwu.kingdom.manager;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Gui extends Application{
    public static Image icon = new Image(Gui.class.getResourceAsStream("icon.png"));
    private static Stage pStage;

    public static void main(String[] args) {
        Vars.initialize();
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        setPrimaryStage(primaryStage);
        pStage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("saveChooser.fxml"));
        pStage.setTitle("Kingdom Manager");
        pStage.setScene(new Scene(root, 865, 551));
        pStage.getScene().getStylesheets().add(String.valueOf(getClass().getResource("style.css")));
        pStage.getIcons().add(icon);
        pStage.show();
        pStage.resizableProperty().set(false);

        /*setPrimaryStage(primaryStage);
        pStage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("Discord.fxml"));
        pStage.setTitle("Kingdom Manage");
        pStage.setScene(new Scene(root, 1280, 720));
        pStage.getScene().getStylesheets().add(String.valueOf(getClass().getResource("style.css")));
        pStage.getIcons().add(icon);
        pStage.show();
        pStage.resizableProperty().set(true);*/
    }

    public static Stage getPrimaryStage() {
        return pStage;
    }

    public static void close(){
        pStage.close();
    }

    public static void setPrimaryStages(Stage stage) {
        pStage = stage;
    }

    private void setPrimaryStage(Stage pStage) {
        Gui.pStage = pStage;
    }
}
