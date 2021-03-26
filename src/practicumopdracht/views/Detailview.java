package practicumopdracht.views;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import practicumopdracht.model.MerkModel;
import practicumopdracht.model.TelefooneigenaarModel;

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
    private ComboBox<MerkModel> comboMerkenLijst;
    private CheckBox cbstatusAbo;
    private DatePicker dpAankoopDatum;
    private TextField tfAantalTelefoons;
    private ListView<TelefooneigenaarModel> lvTelefooneigenaarListView;
    private Button buttonToevoegen;
    private Button buttonVerwijderen;
    private Button buttonTerug;
    private Button buttonOpslaan;
    private RadioButton telefooneigenaarNaamAZrb;
    private RadioButton telefooneigenaarNaamZArb;

    public Detailview() {
        root = new Pane();
        root.setPadding(new Insets(10, 10, 10, 10));
        VBox vbox = new VBox();
        vbox.prefHeight(200);
        vbox.prefWidth(300);
        vbox.setStyle("-fx-background-color: #3db295");
        GridPane gridpane = new GridPane();
        gridpane.setStyle("-fx-font-size: 14px");
        Label lblTitel = new Label("Detail - TelefooneigenaarModel");
        lblTitel.setStyle("-fx-font-weight: bold");
        Label lblNaam = new Label("Naam: ");
        lblNaam.setStyle("-fx-font-family: Lato");
        this.tfNaam = new TextField();
        tfNaam.setPrefWidth(Double.MIN_VALUE);
        Label lblGarantie = new Label("Garantie: ");
        lblGarantie.setStyle("-fx-font-family: Lato");
        this.tfGarantie = new TextField();
        Label lblComboMerkenLijst = new Label("Kies Merk:");
        lblComboMerkenLijst.setStyle("-fx-font-family: Lato");
        this.comboMerkenLijst = new ComboBox<>();
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
        this.buttonOpslaan = new Button("Opslaan");
        this.lvTelefooneigenaarListView = new ListView<>();

        this.telefooneigenaarNaamAZrb = new RadioButton("Telefooneigenaar Naam (A-Z)");
        this.telefooneigenaarNaamZArb = new RadioButton("Telefooneigenaar Naam (Z-A)");
        this.telefooneigenaarNaamZArb.setSelected(true);
        ToggleGroup telefooneigenaarRbtns = new ToggleGroup();
        telefooneigenaarRbtns.getToggles().addAll(telefooneigenaarNaamAZrb,telefooneigenaarNaamZArb);

        HBox radioButtons2 = new HBox();
        radioButtons2.getChildren().addAll(telefooneigenaarNaamAZrb,telefooneigenaarNaamZArb);

        VBox.setVgrow(gridpane, Priority.ALWAYS);
        gridpane.setHgap(4);
        gridpane.setVgap(8);
        gridpane.setPadding(new Insets(10,10,10,10));
        gridpane.add(lblTitel,0,0);
        gridpane.add(lblComboMerkenLijst, 0,1);
        gridpane.add(comboMerkenLijst,1,1);
        gridpane.add(lblNaam, 0,2);
        gridpane.add(tfNaam,1,2);
        gridpane.add(lblGarantie,0,3);
        gridpane.add(tfGarantie,1,3);
        gridpane.add(lblstatusAbo,0,4);
        gridpane.add(cbstatusAbo,1,4);
        gridpane.add(lblaankoopDatum,0,5);
        gridpane.add(dpAankoopDatum,1,5);
        gridpane.add(lblaantalTelefoons,0,6);
        gridpane.add(tfAantalTelefoons,1,6);
        gridpane.add(buttonOpslaan,0,7);
        gridpane.add(lvTelefooneigenaarListView,1,8);
        gridpane.add(radioButtons2,0,9,2,1);

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

    public ComboBox<MerkModel> getComboMerkenLijst() {
        return comboMerkenLijst;
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

    public ListView<TelefooneigenaarModel> getLvTelefooneigenaarListView() {
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

    public Button getButtonOpslaan(){
        return buttonOpslaan;
    }

    public RadioButton getTelefooneigenaarNaamAZrb() {
        return telefooneigenaarNaamAZrb;
    }

    public RadioButton getTelefooneigenaarNaamZArb() {
        return telefooneigenaarNaamZArb;
    }

    public Parent getRoot() {
        return root;
    }

}
