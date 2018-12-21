package gui;

import gui.kunde.KundeControl;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        new KundeControl(primaryStage);

        MySQLAccess.init("localhost","root", "root", "bautraegerfx");

        try {
            MySQLAccess.GetInstance().getConnection().prepareStatement("SELECT * FROM kunde");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}