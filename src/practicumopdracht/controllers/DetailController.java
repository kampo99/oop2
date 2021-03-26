package practicumopdracht.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import practicumopdracht.MainApplication;
import practicumopdracht.comparators.TelefooneigenaarNaamComparator;
import practicumopdracht.model.TelefooneigenaarModel;
import practicumopdracht.views.Detailview;
import practicumopdracht.views.View;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * This method <description of functionality>
 *
 * @author Po
 */
public class DetailController extends Controller {
    private final View VIEW;
    private Detailview detailview;
    private TelefooneigenaarModel telefooneigenaarModel;
    private ObservableList<TelefooneigenaarModel> telefoonEigenaarObservableList;

    public DetailController() {
        detailview = new Detailview();
        telefooneigenaarModel = new TelefooneigenaarModel();
        telefoonEigenaarObservableList = FXCollections.observableList(MainApplication.getTelefooneigenaarModelDAO().getAll());
        detailview.getLvTelefooneigenaarListView().setItems(telefoonEigenaarObservableList);

        detailview.getButtonToevoegen().setOnAction(actionEvent -> toevoegenDetail());
        detailview.getButtonVerwijderen().setOnAction(actionEvent -> verwijderenDetail());
        detailview.getButtonTerug().setOnAction(actionEvent -> detailNaarMaster());
        detailview.getButtonOpslaan().setOnAction(actionEvent -> opslaanDetail());
//        detailview.getComboMerkenLijst().setOnAction(actionEvent -> comboBoxSelecteren());
        detailview.getLvTelefooneigenaarListView().getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    select(newValue);
                });
        detailview.getComboMerkenLijst().itemsProperty().bind(MainApplication.getMasterController().getMerkItemsProperty());

        detailview.getTelefooneigenaarNaamAZrb().setOnAction(actionEvent -> telefoonnaamAZ());
        detailview.getTelefooneigenaarNaamZArb().setOnAction(actionEvent -> telefoonnaamZA());

        VIEW = detailview;
    }

    public void toevoegenDetail() {
        if (detailview.getLvTelefooneigenaarListView().getSelectionModel().getSelectedItem() != null) {
            detailview.getLvTelefooneigenaarListView().getSelectionModel().clearSelection();
            detailview.getTfnaam().setText("");
            detailview.getTfGarantie().setText("");
            detailview.getCbstatusAbo().setText(null);
            detailview.getDpAankoopDatum().setValue(null);
            detailview.getTfAantalTelefoons().setText("");
            return;
        }
        while (!checkAlerts()) {
            return;
        }
        telefoonEigenaarObservableList.add(new TelefooneigenaarModel(detailview.getTfnaam().getText(), Double.parseDouble(detailview.getTfGarantie().getText()),
                detailview.getCbstatusAbo().isIndeterminate(), detailview.getDpAankoopDatum().getValue(), Integer.parseInt(detailview.getTfAantalTelefoons().getText())));
        detailview.getTfnaam().setText("");
        detailview.getTfGarantie().setText("");
        detailview.getCbstatusAbo().setText("");
        detailview.getDpAankoopDatum().setValue(LocalDate.now());
        detailview.getTfAantalTelefoons().setText("");

        detailview.getLvTelefooneigenaarListView().getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    if (newValue != null)
                        detailview.getTfnaam().setText(newValue.getNaam());
                    if (newValue != null)
                        detailview.getTfGarantie().setText(String.valueOf(newValue.getGarantie()));
                    if (newValue != null)
                        detailview.getCbstatusAbo().setIndeterminate(newValue.isStatusAbonnement());
                    if (newValue != null)
                        detailview.getDpAankoopDatum().setValue(newValue.getAankoopdatum());
                    if (newValue != null)
                        detailview.getTfAantalTelefoons().setText(String.valueOf(newValue.getAantalTelefoons()));
                }
        );
    }

    public void verwijderenDetail() {
        telefoonEigenaarObservableList.remove(detailview.getLvTelefooneigenaarListView().getSelectionModel().getSelectedItem());
        detailview.getLvTelefooneigenaarListView().getSelectionModel().clearSelection();
        detailview.getTfnaam().setText("");
        detailview.getTfGarantie().setText("");
        detailview.getCbstatusAbo().setAllowIndeterminate(false);
        detailview.getDpAankoopDatum().setValue(null);
        detailview.getTfAantalTelefoons().setText("");

    }

    public void detailNaarMaster() {
        MainApplication.setScene(new MasterController());
    }

    public void opslaanDetail() {
        while (!ishetgeselecteerd()) {
            return;
        }
        while (!checkAlerts()) {
            return;
        }
        detailview.getLvTelefooneigenaarListView().getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    if (newValue != null)
                        detailview.getTfnaam().setText(newValue.getNaam());
                    if (newValue != null)
                        detailview.getTfGarantie().setText(String.valueOf(newValue.getGarantie()));
                    if (newValue != null)
                        detailview.getCbstatusAbo().setIndeterminate(newValue.isStatusAbonnement());
                    if (newValue != null)
                        detailview.getDpAankoopDatum().setValue(newValue.getAankoopdatum());
                    if (newValue != null)
                        detailview.getTfAantalTelefoons().setText(String.valueOf(newValue.getAantalTelefoons()));
                }
        );
        detailview.getLvTelefooneigenaarListView().getSelectionModel().getSelectedItem().setNaam(detailview.getTfnaam().getText());
        detailview.getLvTelefooneigenaarListView().getSelectionModel().getSelectedItem().setGarantie(Double.parseDouble(detailview.getTfGarantie().getText()));
        detailview.getLvTelefooneigenaarListView().getSelectionModel().getSelectedItem().setStatusAbonnement(detailview.getCbstatusAbo().isIndeterminate());
        detailview.getLvTelefooneigenaarListView().getSelectionModel().getSelectedItem().setAankoopdatum(detailview.getDpAankoopDatum().getValue());
        detailview.getLvTelefooneigenaarListView().getSelectionModel().getSelectedItem().setAantalTelefoons(Integer.parseInt(detailview.getTfAantalTelefoons().getText()));

        detailview.getLvTelefooneigenaarListView().getSelectionModel().clearSelection();
    }

    //    public void placeholderNieuweMerk(){
//        detailview.getComboMerkenLijst().getItems().add();
//        detailview.getComboMerkenLijst().getSelectionModel().select();
//    }
    public void telefoonnaamAZ() {
        FXCollections.sort(detailview.getLvTelefooneigenaarListView().getItems(), new TelefooneigenaarNaamComparator());
    }

    public void telefoonnaamZA() {
        FXCollections.sort(detailview.getLvTelefooneigenaarListView().getItems(), new TelefooneigenaarNaamComparator().reversed());
    }

    public void showModel(TelefooneigenaarModel model) {
        detailview.getTfnaam().setText(model.getNaam());
        detailview.getTfGarantie().setText(String.valueOf(model.getGarantie()));
        detailview.getCbstatusAbo().setIndeterminate(model.isStatusAbonnement());
        detailview.getDpAankoopDatum().setValue(model.getAankoopdatum());
        detailview.getTfAantalTelefoons().setText(String.valueOf(model.getAantalTelefoons()));

    }

    public boolean ishetgeselecteerd() {
        Alert alertGeselecteerd = new Alert(Alert.AlertType.WARNING);
        if (detailview.getLvTelefooneigenaarListView().getSelectionModel().getSelectedItem() == null) {
            detailview.getLvTelefooneigenaarListView().getSelectionModel().clearSelection();
            detailview.getTfnaam().setText("");
            alertGeselecteerd.setContentText("Selecteer een MerkModel");
            alertGeselecteerd.show();
        }
        return false;
    }

    public boolean checkAlerts() {
        Alert alertMelding = new Alert(Alert.AlertType.WARNING);
        if (detailview.getTfnaam().getText().isEmpty()) {
            alertMelding.setContentText("Naam moet verplicht ingevuld zijn!");
            alertMelding.show();
            return false;
        }
        if (detailview.getTfGarantie().getText().isEmpty()) {
            alertMelding.setContentText("Garantie moet verplicht ingevuld zijn!");
            alertMelding.show();
            return false;
        }
        if (detailview.getDpAankoopDatum().getValue() == null) {
            alertMelding.setContentText("Aankoopdatum moet verplicht ingevuld zijn!");
            alertMelding.show();
            return false;
        }
        if (detailview.getTfAantalTelefoons().getText().isEmpty()) {
            alertMelding.setContentText("Aantal telefoons moet verplicht ingevuld zijn!");
            alertMelding.show();
            return false;
        }
        try {
            Double.parseDouble(detailview.getTfGarantie().getText());
        } catch (NumberFormatException error) {
            alertMelding.setContentText("NETWAARDE MOET EEN GETAL BEVATTEN!\n(decimaal met een punt invoeren ipv. komma)");
            alertMelding.show();
        }
        try {
            Integer.parseInt(detailview.getTfAantalTelefoons().getText());
        } catch (NumberFormatException error) {
            alertMelding.setContentText("AANTAL TELEFOONS MOET EEN GETAL ZONDER KOMMA BEVATTEN!");
            alertMelding.show();
        }
        return true;
    }

    public void select(TelefooneigenaarModel newValue) {
        if (newValue != null)
            detailview.getTfnaam().setText(newValue.getNaam());
        if (newValue != null)
            detailview.getTfGarantie().setText(String.valueOf(newValue.getGarantie()));
        if (newValue != null)
            detailview.getCbstatusAbo().setIndeterminate(newValue.isStatusAbonnement());
        if (newValue != null)
            detailview.getDpAankoopDatum().setValue(newValue.getAankoopdatum());
        if (newValue != null)
            detailview.getTfAantalTelefoons().setText(String.valueOf(newValue.getAantalTelefoons()));
    }

    @Override
    public View getView() {
        return VIEW;
    }
}
