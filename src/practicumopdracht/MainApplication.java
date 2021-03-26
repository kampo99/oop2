package practicumopdracht;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import practicumopdracht.controllers.DetailController;
import practicumopdracht.data.*;
import practicumopdracht.controllers.MasterController;
import practicumopdracht.controllers.Controller;
import practicumopdracht.model.MerkModel;

public class MainApplication extends Application {

    private static Stage stage;
    private static TextMerkModelDAO textMerkModelDAO;
    private static TextTelefooneigenaarModelDAO textTelefooneigenaarModelDAO;
    private static MasterController masterController;
    private static DetailController detailController;
    private static MerkModelDAO merkModelDAO;
    private static TelefooneigenaarModelDAO telefooneigenaarModelDAO;

    @Override
    public void start(Stage stage) {

        MainApplication.stage = stage;
        textMerkModelDAO = new TextMerkModelDAO();
        textTelefooneigenaarModelDAO = new TextTelefooneigenaarModelDAO();
        masterController = new MasterController();
        detailController = new DetailController();
        stage.setOnCloseRequest(event -> {
            ButtonType sluitButton = new ButtonType("Toch afsluiten", ButtonBar.ButtonData.NO);
            ButtonType cancelButton = new ButtonType("Shit, Niet sluiten a zebi!", ButtonBar.ButtonData.CANCEL_CLOSE);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText("Weet u zeker dat u wilt afsluiten?");
            alert.setContentText("Wil je de data opslaan voordat je af sluit?\nNiet opgeslagen gegevens zullen anders verloren gaan.");
            alert.getButtonTypes().setAll(sluitButton, cancelButton);
            ButtonType result = alert.showAndWait().orElse(ButtonType.NO);

            if (result.getButtonData() == ButtonBar.ButtonData.YES) {//Als er op YES geklikt is eerst de data opslaan.
                merkModelDAO.save();
                telefooneigenaarModelDAO.save();
            } else {
                if (result.getButtonData() == ButtonBar.ButtonData.CANCEL_CLOSE) {
                    event.consume();
                }
            }
        });
            if (!Main.launchedFromMain) {
                System.err.println("Je moet deze applicatie opstarten vanuit de Main-class, niet de MainApplication-class!");
                System.exit(1337);
                return;
            }
            stage.setTitle(String.format("Practicumopdracht OOP2 - %s", Main.studentNaam));
            stage.setWidth(525);
            stage.setHeight(755);
            setScene(new MasterController());
            stage.show();
        }
        public static void setScene (Controller controller){
            stage.setScene(new Scene(controller.getView().getRoot()));
        }
        public static MerkModelDAO getMasterDAO () {
            return textMerkModelDAO;
        }
        public static TextTelefooneigenaarModelDAO getTelefooneigenaarModelDAO () {
            return textTelefooneigenaarModelDAO;
        }

    public static MasterController getMasterController() {
        return masterController;
    }
    public static DetailController getDetailController () {
            return detailController;
        }
        public static Stage getStage () {
            return stage;
        }
    }
