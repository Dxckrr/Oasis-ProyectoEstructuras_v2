package co.edu.upb.oasis;

import co.edu.upb.oasis.controllers.StartController;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        StartController init = new StartController();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
