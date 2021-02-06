package practicumopdracht;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class MainApplication extends Application {

    @Override
    public void start(Stage stage) {
        if(!Main.launchedFromMain) {
            System.err.println("Je moet deze applicatie opstarten vanuit de Main-class, niet de MainApplication-class!");
            System.exit(1337);

            return;
        }

        stage.setTitle(String.format("Practicumopdracht OOP2 - %s", Main.studentNaam));
        stage.setWidth(640);
        stage.setHeight(480);
        stage.show();

        HBox rootHBox = new HBox();
        TextField textField = new TextField();
        Button button1 = new Button("knop 1");
        rootHBox.getChildren().addAll(button1);
        Scene scene = new Scene(rootHBox);

        stage.setScene(scene);
    }
}
