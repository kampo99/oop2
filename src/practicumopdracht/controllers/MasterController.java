package practicumopdracht.controllers;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import practicumopdracht.MainApplication;
import practicumopdracht.model.Merk;
import practicumopdracht.model.Telefooneigenaar;
import practicumopdracht.views.Masterview;
import practicumopdracht.views.View;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * This method <description of functionality>
 *
 * @author Po
 */
public class MasterController extends Controller{
    private final View VIEW;
    private Masterview masterview;
    private ObservableList<Merk> merkObservableList;
    private Telefooneigenaar telefooneigenaar;
    private Merk merkmodel;

    public MasterController(){
        masterview = new Masterview();
        merkObservableList = FXCollections.observableList(new ArrayList<>());
        masterview.getLvmerkListView().setItems(merkObservableList);
        telefooneigenaar = new Telefooneigenaar();
        merkmodel = new Merk();

        masterview.getButtonToevoegen().setOnAction(actionEvent -> toevoegenMaster());
        masterview.getButtonVerwijderen().setOnAction(actionEvent -> verwijderenMaster());
        masterview.getButtonDetail().setOnAction(actionEvent -> masterNaarDetail());
        masterview.getButtonOpslaan().setOnAction(actionEvent -> opslaanMaster());

        VIEW = masterview;
    }
    public void toevoegenMaster(){
        if (masterview.getLvmerkListView().getSelectionModel().getSelectedItem() != null){
            masterview.getLvmerkListView().getSelectionModel().clearSelection();
            masterview.getTfmerkNaam().setText("");
            masterview.getTfnetWaarde().setText("");
            masterview.getDpoprichtDatum().setValue(LocalDate.now());
            return;
        }
        while(!checkAlerts()){
            return;
        }
        merkObservableList.addAll(new Merk(masterview.getTfmerkNaam().getText(),masterview.getTfnetWaarde().getText(),masterview.getDpoprichtDatum().getValue()));
            masterview.getTfmerkNaam().setText("");
            masterview.getTfnetWaarde().setText("");
            masterview.getDpoprichtDatum().setValue(LocalDate.now());

        masterview.getLvmerkListView().getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    if(newValue != null)
                        masterview.getTfmerkNaam().setText(newValue.getMerkNaam());
                    if(newValue != null)
                        masterview.getTfnetWaarde().setText(newValue.getNetWaarde());
                    if (newValue != null)
                        masterview.getDpoprichtDatum().setValue(newValue.getOprichtdatum());
                    });
    }
    public void verwijderenMaster(){
            merkObservableList.remove(masterview.getLvmerkListView().getSelectionModel().getSelectedItem());
            masterview.getLvmerkListView().getSelectionModel().clearSelection();
            masterview.getTfmerkNaam().setText("");
            masterview.getTfnetWaarde().setText("");
            masterview.getDpoprichtDatum().setValue(null);
    }
    public void masterNaarDetail(){
        MainApplication.setScene(new DetailController());
    }
        public void opslaanMaster(){
        while(!ishetgeselecteerd()){
            return;
        }
        while (!checkAlerts()){
            return;
        }
        masterview.getLvmerkListView().getSelectionModel().getSelectedItem().setMerkNaam(masterview.getTfmerkNaam().getText());
        masterview.getLvmerkListView().getSelectionModel().getSelectedItem().setNetWaarde(masterview.getTfnetWaarde().getText());
        masterview.getLvmerkListView().getSelectionModel().getSelectedItem().setOprichtdatum(masterview.getDpoprichtDatum().getValue());
        telefooneigenaar.getMerken().add(merkmodel);
        masterview.getLvmerkListView().getSelectionModel().clearSelection();
        masterview.getTfmerkNaam().setText("");
    }
    public boolean ishetgeselecteerd(){
        Alert alertGeselecteerd = new Alert(Alert.AlertType.WARNING);
        if (masterview.getLvmerkListView().getSelectionModel().getSelectedItem() == null){
            masterview.getLvmerkListView().getSelectionModel().clearSelection();
            masterview.getTfmerkNaam().setText("");
            alertGeselecteerd.setContentText("Selecteer een Merk");
            alertGeselecteerd.show();
        }
        return false;
    }
    public boolean checkAlerts(){
        Alert alertMelding = new Alert(Alert.AlertType.WARNING);
        if (masterview.getTfmerkNaam().getText().isEmpty()){
            alertMelding.setContentText("Naam moet ingevuld zijn!");
            alertMelding.show();
            return false;
        }
        if(masterview.getTfnetWaarde().getText().isEmpty()){
            alertMelding.setContentText("Netwaarde moet ingevuld zijn!");
            alertMelding.show();
            return false;
        }
        if(masterview.getDpoprichtDatum().getValue() == null){
            alertMelding.setContentText("Oprichtdatum moet ingevuld zijn!");
            alertMelding.show();
            return false;
        }
        try{
            Double.parseDouble(masterview.getTfnetWaarde().getText());
        } catch (NumberFormatException error){
            alertMelding.setContentText("NETWAARDE MOET EEN GETAL BEVATTEN!\n(decimaal met een punt invoeren ipv. komma)");
            alertMelding.show();
        }
        return true;
    }

    @Override
    public View getView() {
        return VIEW;
    }
}
