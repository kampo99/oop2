package practicumopdracht.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

    public DetailController(){
        Detailview detailview = new Detailview();
        ObservableList<Telefooneigenaar> observableList = FXCollections.observableList(new ArrayList<>());
        detailview.getLvTelefooneigenaarListView().setItems(observableList);

        detailview.getButtonToevoegen().setOnAction(event -> {
            observableList.addAll(new Telefooneigenaar(detailview.getTfnaam().getText(),detailview.getTfGarantie().getAnchor(),detailview.getCbbinnenGarantie().isAllowIndeterminate(),
                    detailview.getCbstatusAbo().isAllowIndeterminate(),detailview.getDpAankoopDatum().getValue(),detailview.getTfAantalTelefoons().getAnchor()));
            detailview.getTfnaam().setText("");
            detailview.getTfGarantie().setText("");

            detailview.getDpAankoopDatum().setValue(LocalDate.EPOCH);
        });
        detailview.getLvTelefooneigenaarListView().getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    if(newValue != null)
                        detailview.getTfnaam().setText(newValue.toString());
                    if(newValue != null)
                        detailview.getTfGarantie().setText(newValue.toString());
                    if (newValue != null)
                        detailview.getCbbinnenGarantie().isAllowIndeterminate();
                }
        );
        detailview.getButtonVerwijderen().setOnAction(actionEvent -> {
            observableList.remove(detailview.getLvTelefooneigenaarListView().getSelectionModel().getSelectedItem());
            detailview.getLvTelefooneigenaarListView().getSelectionModel().clearSelection();
            detailview.getTfnaam().setText(null);
            detailview.getTfGarantie().setText(null);
        });
        detailview.getButtonTerug().setOnAction(event -> {
            MainApplication.setScene(new MasterController());
        });
        VIEW = detailview;
    }

    @Override
    public View getView() {
        return VIEW;
    }
}
