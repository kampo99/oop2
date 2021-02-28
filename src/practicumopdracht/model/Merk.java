package practicumopdracht.model;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * This method <description of functionality>
 *
 * @author Po
 */
public class Merk {
    private String merkNaam;
    private String netWaarde;
    private LocalDate oprichtdatum;

    public Merk(String merkNaam, String netWaarde, LocalDate oprichtdatum) {
        this.merkNaam = merkNaam;
        this.netWaarde = netWaarde;
        this.oprichtdatum = oprichtdatum;

    }

    public Merk() {

    }

    public String getMerkNaam() {
        return merkNaam;
    }

    public void setMerkNaam(String merkNaam) {
        this.merkNaam = merkNaam;
    }

    public String getNetWaarde() {
        return netWaarde;
    }

    public void setNetWaarde(String netWaarde) {
        this.netWaarde = netWaarde;
    }

    public LocalDate getOprichtdatum() {
        return oprichtdatum;
    }

    public void setOprichtdatum(LocalDate oprichtdatum) {
        this.oprichtdatum = oprichtdatum;
    }

    @Override
    public String toString() {
        return "MerkNaam: " + merkNaam + '\n' + "NetWaarde: " + netWaarde + " Miljard" +  "\n" + "Oprichtdatum: " + oprichtdatum;
    }
}
