package practicumopdracht.views;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import org.w3c.dom.Text;
import practicumopdracht.model.Merk;
import practicumopdracht.model.Telefooneigenaar;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * This method <description of functionality>
 *
 * @author Po
 */
public class Detailview extends View {
    private Pane root;

    private TextField tfNaam;
    private TextField tfGarantie;
    private CheckBox cbbinnenGarantie;
    private CheckBox cbstatusAbo;
    private DatePicker dpAankoopDatum;
    private TextField tfAantalTelefoons;
    private ListView<Telefooneigenaar> lvTelefooneigenaarListView;
    private Button buttonToevoegen;
    private Button buttonVerwijderen;
    private Button buttonTerug;

    public Detailview() {
        root = new Pane();
        root.setPadding(new Insets(10, 10, 10, 10));
        VBox vbox = new VBox();
        GridPane gridpane = new GridPane();
        Label lblTitel = new Label("Detail - Telefooneigenaar");
        Label lblNaam = new Label("Naam: ");
        this.tfNaam = new TextField();
        Label lblGarantie = new Label("Garantie: ");
        this.tfGarantie = new TextField();
        this.cbbinnenGarantie = new CheckBox("Binnen Garantie");
        this.cbstatusAbo = new CheckBox("Abonnement");
        Label lblaankoopDatum = new Label("Aankoopdatum: ");
        this.dpAankoopDatum = new DatePicker();
        Label lblaantalTelefoons = new Label("Aantal telefoons: ");
        this.tfAantalTelefoons = new TextField();
        this.lvTelefooneigenaarListView = new ListView<>();

        ObservableList<Telefooneigenaar> observableList = FXCollections.observableList(new ArrayList<>());
        lvTelefooneigenaarListView.setItems(observableList);
        gridpane.setAlignment(Pos.CENTER);
        gridpane.setHgap(4);
        gridpane.setVgap(8);
        gridpane.setPadding(new Insets(10));
        gridpane.add(lblTitel,0,0);
        gridpane.add(lblNaam, 0,1);
        gridpane.add(tfNaam,1,1);
        gridpane.add(lblGarantie, 0,2);
        gridpane.add(tfGarantie,1,2);
        gridpane.add(cbbinnenGarantie,0,3);
        gridpane.add(cbstatusAbo,0,4);
        gridpane.add(lblaankoopDatum,1,4);
        gridpane.add(dpAankoopDatum,1,5);
        gridpane.add(lblaantalTelefoons,0,6);
        gridpane.add(tfAantalTelefoons,1,6);
        gridpane.add(lvTelefooneigenaarListView,1,7);

        HBox buttonbox1 = new HBox();
        buttonbox1.setPadding(new Insets(10));
        buttonbox1.setSpacing(10);
        this.buttonToevoegen = new Button("Toevoegen");
        this.buttonVerwijderen = new Button("Verwijderen");
        this.buttonTerug = new Button("Terug naar Master");

        buttonbox1.getChildren().addAll(buttonToevoegen,buttonVerwijderen,buttonTerug);
        vbox.getChildren().addAll(gridpane,buttonbox1);
        root.getChildren().addAll(vbox);
    }

    public TextField getTfnaam() {
        return tfNaam;
    }

    public TextField getTfGarantie() {
        return tfGarantie;
    }

    public CheckBox getCbbinnenGarantie() {
        return cbbinnenGarantie;
    }

    public CheckBox getCbstatusAbo() {
        return cbstatusAbo;
    }

    public DatePicker getDpAankoopDatum() {
        return dpAankoopDatum;
    }

    public TextField getTfAantalTelefoons() {
        return tfAantalTelefoons;
    }

    public ListView<Telefooneigenaar> getLvTelefooneigenaarListView() {
        return lvTelefooneigenaarListView;
    }

    public Button getButtonToevoegen() {
        return buttonToevoegen;
    }

    public Button getButtonVerwijderen() {
        return buttonVerwijderen;
    }

    public Button getButtonTerug() {
        return buttonTerug;
    }

    public Parent getRoot() {
        return root;
    }

}
