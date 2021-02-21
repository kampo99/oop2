package practicumopdracht.views;

import com.sun.javafx.scene.control.InputField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.util.converter.LocalDateStringConverter;
import javafx.util.converter.LocalDateTimeStringConverter;
import practicumopdracht.model.Merk;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.regex.Matcher;

/**
 * This method <description of functionality>
 *
 * @author Po
 */
public class Masterview extends View {
    private Parent root;
    private ListView<Merk> lvmerkListView;
    private Button buttonToevoegen;
    private Button buttonVerwijderen;
    private Button buttonOpslaan;
    private Button buttonDetail;
    private TextField tfmerkNaam;
    private TextField tfnetWaarde;
    private DatePicker dpoprichtDatum;

    public Masterview(){
        initalizeRoot();
    }

    public void initalizeRoot() {
        root = new Pane();
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10,10,10,10));
        vbox.prefHeight(755);
        vbox.prefWidth(455);
        vbox.setStyle("-fx-background-color: #3db295");
        GridPane gridpane = new GridPane();
        gridpane.setStyle("-fx-font-size: 14px");
        Label lblTitel = new Label("Master - Merk");
        lblTitel.setStyle("-fx-font-weight: bold");
        Label lblmerkNaam = new Label("Merknaam: ");
        lblmerkNaam.setStyle("-fx-font-family: Lato");
        this.tfmerkNaam = new TextField();
        Label lblnetWaarde = new Label("Netwaarde (in miljard): ");
        lblnetWaarde.setStyle("-fx-font-family: Lato");
        this.tfnetWaarde = new TextField();
        Label lbloprichtDatum = new Label("Oprichtdatum: ");
        lbloprichtDatum.setStyle("-fx-font-family: Lato");
        this.dpoprichtDatum = new DatePicker();
        Label lbllistView = new Label("Alle Merken");
        lbllistView.setStyle("-fx-font-size: 14px");
        this.lvmerkListView = new ListView<>();
        lvmerkListView.setStyle("-fx-font-size: 14px");

        VBox.setVgrow(gridpane, Priority.ALWAYS);
        gridpane.setHgap(4);
        gridpane.setVgap(15);
        gridpane.setPadding(new Insets(10,10,10,10));
        gridpane.add(lblTitel,0,0);
        gridpane.add(lblmerkNaam, 0,1);
        gridpane.add(tfmerkNaam,1,1);
        gridpane.add(lblnetWaarde, 0,2);
        gridpane.add(tfnetWaarde,1,2);
        gridpane.add(lbloprichtDatum, 0,3);
        gridpane.add(dpoprichtDatum,1,3);

        HBox buttonbox1 = new HBox();
        HBox.setHgrow(gridpane,Priority.ALWAYS);
        buttonbox1.setStyle("-fx-font-size: 14px");
        buttonbox1.setPadding(new Insets(0,0,10,10));
        buttonbox1.setSpacing(10);
        this.buttonToevoegen = new Button("Toevoegen");
        this.buttonVerwijderen = new Button("Verwijderen");
        buttonbox1.getChildren().addAll(buttonToevoegen,buttonVerwijderen);

        GridPane gridpaneListView = new GridPane();
        gridpaneListView.setStyle("-fx-font-family: Lato");
        gridpaneListView.setPadding(new Insets(10,10,10,10));
        gridpaneListView.setHgap(14);
        gridpaneListView.setVgap(8);
        gridpaneListView.add(lbllistView,0,0);
        gridpaneListView.add(lvmerkListView,1,0);

        HBox buttonbox2 = new HBox();
        buttonbox2.setStyle("-fx-font-size: 14px");
        buttonbox2.setPadding(new Insets(10));
        buttonbox2.setSpacing(10);
        this.buttonOpslaan = new Button("Opslaan");
        this.buttonDetail = new Button("Telefooneigenaren");

        buttonbox2.getChildren().addAll(buttonOpslaan,buttonDetail);
        vbox.getChildren().addAll(gridpane,buttonbox1,gridpaneListView,buttonbox2);
        root = vbox;
    }

    public ListView<Merk> getLvmerkListView() {
        return lvmerkListView;
    }

    public Button getButtonToevoegen() {
        return buttonToevoegen;
    }

    public Button getButtonVerwijderen() {
        return buttonVerwijderen;
    }

    public Button getButtonOpslaan() {
        return buttonOpslaan;
    }

    public Button getButtonDetail() {
        return buttonDetail;
    }

    public TextField getTfmerkNaam() {
        return tfmerkNaam;
    }

    public TextField getTfnetWaarde() {
        return tfnetWaarde;
    }

    public DatePicker getDpoprichtDatum() {
        return dpoprichtDatum;
    }

    public Parent getRoot() {
        return root;
    }
}
