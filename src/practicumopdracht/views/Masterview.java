package practicumopdracht.views;

import com.sun.javafx.scene.control.InputField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.*;
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
    private Pane root;
    private ListView<Merk> lvmerkListView;
    private Button buttonToevoegen;
    private Button buttonVerwijderen;
    private Button buttonDetail;
    private TextField tfmerkNaam;
    private TextField tfnetWaarde;
    private DatePicker dpoprichtDatum;

    public Masterview() {
        root = new Pane();
        root.setPadding(new Insets(10, 10, 10, 10));

        VBox vbox = new VBox();
        GridPane gridpane = new GridPane();
        Label lblTitel = new Label("Master - Merk");
        Label lblmerkNaam = new Label("Merknaam: ");
        this.tfmerkNaam = new TextField();
        Label lblnetWaarde = new Label("Netwaarde: ");
        this.tfnetWaarde = new TextField();
        Label lbloprichtDatum = new Label("Oprichtdatum: ");
        this.dpoprichtDatum = new DatePicker();
        this.buttonToevoegen = new Button("Toevoegen");
        this.buttonVerwijderen = new Button("Verwijderen");
        Label lbllistView = new Label("Alle Merken");
        this.lvmerkListView = new ListView<>();

        VBox.setVgrow(gridpane, Priority.ALWAYS);
        gridpane.setHgap(4);
        gridpane.setVgap(8);
        gridpane.setPadding(new Insets(10));
        gridpane.add(lblTitel,0,0);
        gridpane.add(lblmerkNaam, 0,1);
        gridpane.add(tfmerkNaam,1,1);
        gridpane.add(lblnetWaarde, 0,2);
        gridpane.add(tfnetWaarde,1,2);
        gridpane.add(lbloprichtDatum, 0,3);
        gridpane.add(dpoprichtDatum,1,3);
        gridpane.add(buttonToevoegen,0,4);
        gridpane.add(buttonVerwijderen,1,4);
        gridpane.add(lbllistView,0,5);
        gridpane.add(lvmerkListView,1,5);
        Separator aparteLijn = new Separator(); // nieuwe regellijn
        HBox buttonbox = new HBox();
        buttonbox.setPadding(new Insets(10));
        buttonbox.setSpacing(10);
        this.buttonDetail = new Button("Telefooneigenaren");

        buttonbox.getChildren().addAll(buttonDetail);
        vbox.getChildren().addAll(gridpane,aparteLijn,buttonbox);
        root.getChildren().addAll(vbox);

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
