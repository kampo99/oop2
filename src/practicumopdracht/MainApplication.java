package practicumopdracht;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import practicumopdracht.views.Detailview;
import practicumopdracht.views.Masterview;
import practicumopdracht.controllers.MasterController;
import practicumopdracht.controllers.Controller;

public class MainApplication extends Application {

    private static Stage stage;

    @Override
    public void start(Stage stage) {
        MainApplication.stage = stage;
        if(!Main.launchedFromMain) {
            System.err.println("Je moet deze applicatie opstarten vanuit de Main-class, niet de MainApplication-class!");
            System.exit(1337);

            return;
        }
        stage.setTitle(String.format("Practicumopdracht OOP2 - %s", Main.studentNaam));
        stage.setWidth(450);
        stage.setHeight(730);
        setScene(new MasterController());
        stage.show();
    }
    public static void setScene(Controller controller){
        stage.setScene(new Scene(controller.getView().getRoot()));
    }
}
