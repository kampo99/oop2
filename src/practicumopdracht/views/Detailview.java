package practicumopdracht.views;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import practicumopdracht.model.Merk;
import practicumopdracht.model.Telefooneigenaar;

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
    private ComboBox comboMerkenLijst;
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
        vbox.prefHeight(200);
        vbox.prefWidth(300);
        vbox.setStyle("-fx-background-color: #3db295");
        GridPane gridpane = new GridPane();
        gridpane.setStyle("-fx-font-size: 14px");
        Label lblTitel = new Label("Detail - Telefooneigenaar");
        lblTitel.setStyle("-fx-font-weight: bold");
        Label lblNaam = new Label("Naam: ");
        lblNaam.setStyle("-fx-font-family: Lato");
        this.tfNaam = new TextField();
        Label lblGarantie = new Label("Garantie: ");
        lblGarantie.setStyle("-fx-font-family: Lato");
        this.tfGarantie = new TextField();
        Label lblComboMerkenLijst = new Label("Merkenopties:");
        lblComboMerkenLijst.setStyle("-fx-font-family: Lato");
        ObservableList<String> merkenopties = FXCollections.observableArrayList("Apple", "Samsung", "One Plus");
        this.comboMerkenLijst = new ComboBox<>(merkenopties);
        Label lblstatusAbo = new Label("Abonnement:");
        lblstatusAbo.setStyle("-fx-font-family: Lato");
        this.cbstatusAbo = new CheckBox();
        cbstatusAbo.setAllowIndeterminate(false);
        cbstatusAbo.setAllowIndeterminate(true);
        cbstatusAbo.setStyle("-fx-font-family: Lato");
        Label lblaankoopDatum = new Label("Aankoopdatum: ");
        lblaankoopDatum.setStyle("-fx-font-family: Lato");
        this.dpAankoopDatum = new DatePicker();
        Label lblaantalTelefoons = new Label("Aantal telefoons: ");
        lblaantalTelefoons.setStyle("-fx-font-family: Lato");
        this.tfAantalTelefoons = new TextField();
        this.lvTelefooneigenaarListView = new ListView<>();

        ObservableList<Telefooneigenaar> observableList = FXCollections.observableList(new ArrayList<>());
        lvTelefooneigenaarListView.setItems(observableList);
        VBox.setVgrow(gridpane, Priority.ALWAYS);
        gridpane.setHgap(4);
        gridpane.setVgap(8);
        gridpane.setPadding(new Insets(10,10,10,10));
        gridpane.add(lblTitel,0,0);
        gridpane.add(lblNaam, 0,1);
        gridpane.add(tfNaam,1,1);
        gridpane.add(lblGarantie, 0,2);
        gridpane.add(tfGarantie,1,2);
        gridpane.add(lblComboMerkenLijst,0,3);
        gridpane.add(comboMerkenLijst,1,3);
        gridpane.add(lblstatusAbo,0,4);
        gridpane.add(cbstatusAbo,1,4);
        gridpane.add(lblaankoopDatum,0,5);
        gridpane.add(dpAankoopDatum,1,5);
        gridpane.add(lblaantalTelefoons,0,6);
        gridpane.add(tfAantalTelefoons,1,6);
        gridpane.add(lvTelefooneigenaarListView,1,7);

        HBox buttonbox1 = new HBox();
        HBox.setHgrow(gridpane, Priority.ALWAYS);
        buttonbox1.setStyle("-fx-font-size: 14px");
        buttonbox1.setPadding(new Insets(10));
        buttonbox1.setSpacing(10);
        this.buttonToevoegen = new Button("Toevoegen");
        this.buttonVerwijderen = new Button("Verwijderen");
        this.buttonTerug = new Button("Terug naar Master");

        buttonbox1.getChildren().addAll(buttonToevoegen,buttonVerwijderen,buttonTerug);
        vbox.getChildren().addAll(gridpane,buttonbox1);
        root = vbox;
    }

    public TextField getTfnaam() {
        return tfNaam;
    }

    public TextField getTfGarantie() {
        return tfGarantie;
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
