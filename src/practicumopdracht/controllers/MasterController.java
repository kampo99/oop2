package practicumopdracht.controllers;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import practicumopdracht.MainApplication;
import practicumopdracht.comparators.MerkNaamComparator;
import practicumopdracht.comparators.MerkOprichtdatumComparator;
import practicumopdracht.comparators.TelefooneigenaarNaamComparator;
import practicumopdracht.data.TextMerkModelDAO;
import practicumopdracht.data.TextTelefooneigenaarModelDAO;
import practicumopdracht.model.MerkModel;
import practicumopdracht.model.TelefooneigenaarModel;
import practicumopdracht.views.Detailview;
import practicumopdracht.views.Masterview;
import practicumopdracht.views.View;

import java.time.LocalDate;

/**
 * This method <description of functionality>
 *
 * @author Po
 */
public class MasterController extends Controller {
    private final View VIEW;
    private Masterview masterview;
    private Detailview detailview;
    private ObservableList<MerkModel> merkModelObservableList;
    private TelefooneigenaarModel telefooneigenaarModel;
    private MerkModel merkmodel;
    private TextMerkModelDAO textMerkModelDAO;
    private TextTelefooneigenaarModelDAO textTelefooneigenaarModelDAO;

    public MasterController() {
        masterview = new Masterview();
        detailview = new Detailview();
        merkModelObservableList = FXCollections.observableList(MainApplication.getMasterDAO().getAll());
        masterview.getLvmerkListView().setItems(merkModelObservableList);
        telefooneigenaarModel = new TelefooneigenaarModel();
        merkmodel = new MerkModel();

        masterview.getButtonToevoegen().setOnAction(actionEvent -> toevoegenMaster());
        masterview.getButtonVerwijderen().setOnAction(actionEvent -> verwijderenMaster());
        masterview.getButtonDetail().setOnAction(actionEvent -> masterNaarDetail());
        masterview.getButtonOpslaan().setOnAction(actionEvent -> opslaanMaster());
        masterview.getLvmerkListView().getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue)-> {
                    select(newValue);
            });

        masterview.getMerknaamAZrb().setOnAction(actionEvent -> merknaamAZ());
        masterview.getMerknaamZArb().setOnAction(actionEvent -> merknaamZA());
        masterview.getMerkOprichtdatumAZrb().setOnAction(actionEvent -> merkdatumAZ());
        masterview.getMerkOprichtdatumZArb().setOnAction(actionEvent -> merkdatumZA());

        masterview.getOpslaan().setOnAction(actionEvent -> menuMerkOpslaan());
        masterview.getOpslaan().setOnAction(actionEvent -> menuTelefooneigenaarOpslaan());
        masterview.getLaden().setOnAction(actionEvent -> menuMerkLaden());
        masterview.getLaden().setOnAction(actionEvent -> menuTelefooneigenaarLaden());

        VIEW = masterview;
    }

    public void toevoegenMaster() {
        if (masterview.getLvmerkListView().getSelectionModel().getSelectedItem() != null) {
            masterview.getLvmerkListView().getSelectionModel().clearSelection();
            masterview.getTfmerkNaam().setText("");
            masterview.getTfnetWaarde().setText("");
            masterview.getDpoprichtDatum().setValue(null);
            return;
        }
        while (!checkAlerts()) {
            return;
        }
        merkModelObservableList.addAll(new MerkModel(masterview.getTfmerkNaam().getText(), masterview.getTfnetWaarde().getText(), masterview.getDpoprichtDatum().getValue()));

        masterview.getLvmerkListView().getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    if (newValue != null)
                        masterview.getTfmerkNaam().setText(newValue.getMerkNaam());
                    if (newValue != null)
                        masterview.getTfnetWaarde().setText(newValue.getNetWaarde());
                    if (newValue != null)
                        masterview.getDpoprichtDatum().setValue(newValue.getOprichtdatum());
                });
    }

    public void verwijderenMaster() {
        merkModelObservableList.remove(masterview.getLvmerkListView().getSelectionModel().getSelectedItem());
        masterview.getLvmerkListView().getSelectionModel().clearSelection();
        masterview.getTfmerkNaam().setText("");
        masterview.getTfnetWaarde().setText("");
        masterview.getDpoprichtDatum().setValue(null);
    }
    public ObservableValue<ObservableList<MerkModel>> getMerkItemsProperty() {
        return masterview.getLvmerkListView().itemsProperty();
    }
    public void masterNaarDetail() {

        MainApplication.setScene(new DetailController());
    }

    public void opslaanMaster() {
        while (!ishetgeselecteerd()) {
            return;
        }
        while (!checkAlerts()) {
            return;
        }
        masterview.getLvmerkListView().getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    if (newValue != null)
                        masterview.getTfmerkNaam().setText(newValue.getMerkNaam());
                    if (newValue != null)
                        masterview.getTfnetWaarde().setText(newValue.getNetWaarde());
                    if (newValue != null)
                        masterview.getDpoprichtDatum().setValue(newValue.getOprichtdatum());
                });

        masterview.getLvmerkListView().getSelectionModel().getSelectedItem().setMerkNaam(masterview.getTfmerkNaam().getText());
        masterview.getLvmerkListView().getSelectionModel().getSelectedItem().setNetWaarde(masterview.getTfnetWaarde().getText());
        masterview.getLvmerkListView().getSelectionModel().getSelectedItem().setOprichtdatum(masterview.getDpoprichtDatum().getValue());

        masterview.getLvmerkListView().getSelectionModel().clearSelection();
    }
    public void merknaamAZ(){
        FXCollections.sort(masterview.getLvmerkListView().getItems(), new MerkNaamComparator());
        masterview.getMerknaamZArb().setSelected(false);
        masterview.getMerkOprichtdatumAZrb().setSelected(false);
        masterview.getMerkOprichtdatumZArb().setSelected(false);
    }
    public void merknaamZA(){
        FXCollections.sort(masterview.getLvmerkListView().getItems(), new MerkNaamComparator().reversed());
        masterview.getMerknaamAZrb().setSelected(false);
        masterview.getMerkOprichtdatumAZrb().setSelected(false);
        masterview.getMerkOprichtdatumZArb().setSelected(false);
    }
    public void merkdatumAZ(){
        FXCollections.sort(masterview.getLvmerkListView().getItems(), new MerkOprichtdatumComparator());
        masterview.getMerknaamAZrb().setSelected(false);
        masterview.getMerknaamZArb().setSelected(false);
        masterview.getMerkOprichtdatumZArb().setSelected(false);
    }
    public void merkdatumZA(){
        FXCollections.sort(masterview.getLvmerkListView().getItems(), new MerkOprichtdatumComparator().reversed());
        masterview.getMerknaamAZrb().setSelected(false);
        masterview.getMerknaamZArb().setSelected(false);
        masterview.getMerkOprichtdatumAZrb().setSelected(false);
    }
    public void menuMerkOpslaan(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        try {
            MainApplication.getMasterDAO().save();
            MainApplication.getTelefooneigenaarModelDAO().save();
        } catch (Exception e) {
            alert.setContentText("Er ging iets fout tijdens het opslaan probeer het opnieuw");
            alert.show();
        }
        alert.setContentText("Het opslaan is gelukt");
        alert.show();
    }
    public void menuTelefooneigenaarOpslaan(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        MainApplication.getTelefooneigenaarModelDAO().save();
        try {
            MainApplication.getMasterDAO().save();
            MainApplication.getTelefooneigenaarModelDAO().save();
        } catch (Exception e) {
            alert.setContentText("Er ging iets fout tijdens het opslaan probeer het opnieuw");
            alert.show();
        }
        alert.setContentText("Het opslaan is gelukt");
        alert.show();
    }
    public void menuMerkLaden(){
        MainApplication.getMasterDAO().load();
    }
    public void menuTelefooneigenaarLaden(){
        MainApplication.getTelefooneigenaarModelDAO().load();
    }
    public boolean ishetgeselecteerd() {
        Alert alertGeselecteerd = new Alert(Alert.AlertType.WARNING);
        if (masterview.getLvmerkListView().getSelectionModel().getSelectedItem() == null) {
            masterview.getLvmerkListView().getSelectionModel().clearSelection();
            masterview.getTfmerkNaam().setText("");
            alertGeselecteerd.setContentText("Selecteer een MerkModel");
            alertGeselecteerd.show();
        }
        return false;
    }

    public boolean checkAlerts() {
        Alert alertMelding = new Alert(Alert.AlertType.WARNING);
        if (masterview.getTfmerkNaam().getText().isEmpty()) {
            alertMelding.setContentText("Naam moet ingevuld zijn!");
            alertMelding.show();
            return false;
        }
        if (masterview.getTfnetWaarde().getText().isEmpty()) {
            alertMelding.setContentText("Netwaarde moet ingevuld zijn!");
            alertMelding.show();
            return false;
        }
        if (masterview.getDpoprichtDatum().getValue() == null) {
            alertMelding.setContentText("Oprichtdatum moet ingevuld zijn!");
            alertMelding.show();
            return false;
        }
        try {
            Double.parseDouble(masterview.getTfnetWaarde().getText());
        } catch (NumberFormatException error) {
            alertMelding.setContentText("NETWAARDE MOET EEN GETAL BEVATTEN!\n(decimaal met een punt invoeren ipv. komma)");
            alertMelding.show();
        }
        return true;
    }

        public void select(MerkModel newValue){
            if (newValue != null){
                masterview.getTfmerkNaam().setText(newValue.getMerkNaam());
            }
            if (newValue != null){
                masterview.getTfnetWaarde().setText(newValue.getNetWaarde());
            }
            if (newValue != null){
                masterview.getDpoprichtDatum().setValue(newValue.getOprichtdatum());
            }

        }

        @Override
    public View getView() {
        return VIEW;
    }
}
