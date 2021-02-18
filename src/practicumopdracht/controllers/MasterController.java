package practicumopdracht.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import practicumopdracht.MainApplication;
import practicumopdracht.model.Merk;
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

    public MasterController(){
        Masterview masterview = new Masterview();
        ObservableList<Merk> observableList = FXCollections.observableList(new ArrayList<>());
        masterview.getLvmerkListView().setItems(observableList);

        masterview.getButtonToevoegen().setOnAction(event -> {
            observableList.addAll(new Merk(masterview.getTfmerkNaam().getText(),masterview.getTfnetWaarde().getText(),masterview.getDpoprichtDatum().getValue()));
            masterview.getTfmerkNaam().setText("");
            masterview.getTfnetWaarde().setText("");
            masterview.getDpoprichtDatum().setValue(LocalDate.EPOCH);
        });
        masterview.getLvmerkListView().getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    if(newValue != null)
                        masterview.getTfmerkNaam().setText(newValue.toString());
                }
        );
        masterview.getButtonVerwijderen().setOnAction(actionEvent -> {
            observableList.remove(masterview.getLvmerkListView().getSelectionModel().getSelectedItem());
            masterview.getLvmerkListView().getSelectionModel().clearSelection();
            masterview.getTfmerkNaam().setText(null);
        });
        masterview.getButtonDetail().setOnAction(event -> {
            MainApplication.setScene(new DetailController());
        });

        VIEW = masterview;
    }

    @Override
    public View getView() {
        return VIEW;
    }
}
