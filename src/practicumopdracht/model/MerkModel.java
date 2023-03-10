package practicumopdracht.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

/**
 * This method <description of functionality>
 *
 * @author Po
 */
public class MerkModel implements Serializable {
    private String merkNaam;
    private String netWaarde;
    private LocalDate oprichtdatum;
    private transient MerkModel merkModel;

    public MerkModel(String merkNaam, String netWaarde, LocalDate oprichtdatum) {

        this.merkNaam = merkNaam;
        this.netWaarde = netWaarde;
        this.oprichtdatum = oprichtdatum;
    }

    public MerkModel() {

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
        return "MerkNaam: " + merkNaam + '\n' + "NetWaarde: " + netWaarde + " Biljoen" +  "\n" + "Oprichtdatum: " + oprichtdatum;
    }
}
