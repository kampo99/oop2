package practicumopdracht.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * This method <description of functionality>
 *
 * @author Po
 */
public class Telefooneigenaar {
    private String naam;
    private double garantie;
    private boolean statusAbonnement;
    private LocalDate aankoopdatum;
    private int aantalTelefoons;
    private ObservableList<Merk> merken;

    public Telefooneigenaar(){
        merken = FXCollections.observableArrayList(new ArrayList<>());
    }
    public Telefooneigenaar(String naam, double garantie, boolean statusAbonnement, LocalDate aankoopdatum, int aantalTelefoons) {
        this.naam = naam;
        this.garantie = garantie;
        this.statusAbonnement = statusAbonnement;

        this.aankoopdatum = aankoopdatum;
        this.aantalTelefoons = aantalTelefoons;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public double getGarantie() {
        return garantie;
    }

    public void setGarantie(double garantie) {
        this.garantie = garantie;
    }

    public boolean isStatusAbonnement() {
        return statusAbonnement;
    }

    public void setStatusAbonnement(boolean statusAbonnement) {
        this.statusAbonnement = statusAbonnement;
    }


    public LocalDate getAankoopdatum() {
        return aankoopdatum;
    }

    public void setAankoopdatum(LocalDate aankoopdatum) {
        this.aankoopdatum = aankoopdatum;
    }

    public int getAantalTelefoons() {
        return aantalTelefoons;
    }

    public void setAantalTelefoons(int aantalTelefoons) {
        this.aantalTelefoons = aantalTelefoons;
    }

    public void setMerken(ObservableList<Merk> merk){
        this.merken = merk;
    }

    public ObservableList<Merk> getMerken() {
        return merken;
    }

    @Override
    public String toString() {
        return "naam: " + this.naam + "\n" + "garantie: " + this.garantie + "\n" + "Type merk: " + "\n" + "statusAbonnement: " + (this.statusAbonnement  ? "Wel abonnement" : "Geen abonnement") + "\n" + "aankoopdatum: " +
                aankoopdatum + "\n" + "aantalTelefoons: " + aantalTelefoons;
    }
}
