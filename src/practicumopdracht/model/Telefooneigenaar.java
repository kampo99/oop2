package practicumopdracht.model;

import java.time.LocalDate;

/**
 * This method <description of functionality>
 *
 * @author Po
 */
public class Telefooneigenaar {
    private String naam;
    private double garantie;
    private boolean binnenGarantie;
    private boolean statusAbonnement;
    private LocalDate aankoopdatum;
    private int aantalTelefoons;

    public Telefooneigenaar(String naam, double garantie, boolean statusAbonnement, boolean binnenGarantie, LocalDate aankoopdatum, int aantalTelefoons) {
        this.naam = naam;
        this.garantie = garantie;
        this.statusAbonnement = statusAbonnement;
        this.binnenGarantie = binnenGarantie;
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

    public boolean isBinnenGarantie() {
        return binnenGarantie;
    }

    public void setBinnenGarantie(boolean binnenGarantie) {
        this.binnenGarantie = binnenGarantie;
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

    @Override
    public String toString() {
        return "naam=" + naam + "\n" + "garantie=" + garantie + "\n" + "binnenGarantie=" +
                binnenGarantie + "\n" + "statusAbonnement=" + statusAbonnement + "\n" + "aankoopdatum=" +
                aankoopdatum + "\n" + "aantalTelefoons=" + aantalTelefoons;
    }
}
