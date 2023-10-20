package co.edu.upb.oasis;

import co.edu.upb.oasis.controllers.startController;
import co.edu.upb.oasis.vistas.Start;
import co.edu.upb.oasis.vistas.VistaAdmin;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        startController init = new startController();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
