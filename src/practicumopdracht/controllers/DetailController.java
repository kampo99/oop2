package practicumopdracht.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import practicumopdracht.MainApplication;
import practicumopdracht.model.Merk;
import practicumopdracht.model.Telefooneigenaar;
import practicumopdracht.views.Detailview;
import practicumopdracht.views.Masterview;
import practicumopdracht.views.View;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * This method <description of functionality>
 *
 * @author Po
 */
public class DetailController extends Controller{
    private final View VIEW;
    private Detailview detailview;
    private ObservableList<Telefooneigenaar> telefoonEigenaarObservableList;

    public DetailController(){
        detailview = new Detailview();
        telefoonEigenaarObservableList = FXCollections.observableList(new ArrayList<>());
        detailview.getLvTelefooneigenaarListView().setItems(telefoonEigenaarObservableList);

        detailview.getButtonToevoegen().setOnAction(actionEvent -> toevoegenTE());
        detailview.getButtonVerwijderen().setOnAction(actionEvent -> verwijderenTE());
        detailview.getButtonTerug().setOnAction(actionEvent -> detailNaarMaster());

        VIEW = detailview;
    }
    public void toevoegenTE(){
        if(detailview.getLvTelefooneigenaarListView().getSelectionModel().getSelectedItem() != null){
            detailview.getLvTelefooneigenaarListView().getSelectionModel().clearSelection();
            detailview.getTfnaam().setText("");
            detailview.getTfGarantie().setText("");
            detailview.getCbstatusAbo().setText(null);
            detailview.getDpAankoopDatum().setValue(null);
            detailview.getTfAantalTelefoons().setText("");
            return;
        }
        while (!checkAlerts()){
            return;
        }
        telefoonEigenaarObservableList.addAll(new Telefooneigenaar(detailview.getTfnaam().getText(),Double.parseDouble(detailview.getTfGarantie().getText()),
                detailview.getCbstatusAbo().isAllowIndeterminate(),detailview.getDpAankoopDatum().getValue(),Integer.parseInt(detailview.getTfAantalTelefoons().getText())));
        detailview.getTfnaam().setText("");
        detailview.getTfGarantie().setText("");
        detailview.getCbstatusAbo().setText("");
        detailview.getDpAankoopDatum().setValue(LocalDate.now());
        detailview.getTfAantalTelefoons().setText("");

        detailview.getLvTelefooneigenaarListView().getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    if(newValue != null)
                        detailview.getTfnaam().setText(newValue.getNaam());
                    if(newValue != null)
                        detailview.getTfGarantie().setText(String.valueOf(newValue.getGarantie()));
                    if (newValue !=null)
                        detailview.getCbstatusAbo().setIndeterminate(true);
                    if (newValue != null)
                        detailview.getDpAankoopDatum().setValue(newValue.getAankoopdatum());
                    if (newValue != null)
                        detailview.getTfAantalTelefoons().setText(String.valueOf(newValue.getAantalTelefoons()));
                }
        );
    }
    public void verwijderenTE(){
        telefoonEigenaarObservableList.remove(detailview.getLvTelefooneigenaarListView().getSelectionModel().getSelectedItem());
        detailview.getLvTelefooneigenaarListView().getSelectionModel().clearSelection();
        detailview.getTfnaam().setText("");
        detailview.getTfGarantie().setText("");
        detailview.getCbstatusAbo().setAllowIndeterminate(false);
        detailview.getDpAankoopDatum().setValue(null);
        detailview.getTfAantalTelefoons().setText("");

    }
    public void detailNaarMaster(){
        MainApplication.setScene(new MasterController());
    }

    public boolean checkAlerts(){
        Alert alertMelding = new Alert(Alert.AlertType.WARNING);
        if (detailview.getTfnaam().getText().isEmpty()){
            alertMelding.setContentText("Naam moet verplicht ingevuld zijn!");
            alertMelding.show();
            return false;
        }
        if(detailview.getTfGarantie().getText().isEmpty()){
            alertMelding.setContentText("Netwaarde moet verplicht ingevuld zijn!");
            alertMelding.show();
            return false;
        }
        if (detailview.getTfAantalTelefoons().getText().isEmpty()){
            alertMelding.setContentText("Aantal telefoons moet verplicht ingevuld zijn!");
            return false;
        }
        try{
            Double.parseDouble(detailview.getTfGarantie().getText());
        } catch (NumberFormatException error){
            alertMelding.setContentText("NETWAARDE MOET EEN GETAL BEVATTEN!\n(decimaal met een punt invoeren ipv. komma)");
            alertMelding.show();
        }
        try{
            Integer.parseInt(detailview.getTfAantalTelefoons().getText());
        } catch (NumberFormatException error){
            alertMelding.setContentText("AANTAL TELEFOONS MOET EEN GETAL ZONDER KOMMA BEVATTEN!");
            alertMelding.show();
        }
        return true;
    }

    @Override
    public View getView() {
        return VIEW;
    }
}
