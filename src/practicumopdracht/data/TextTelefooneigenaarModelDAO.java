package practicumopdracht.data;

import practicumopdracht.model.MerkModel;
import practicumopdracht.model.TelefooneigenaarModel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Scanner;

/**
 * This method <description of functionality>
 *
 * @author Po
 */
public class TextTelefooneigenaarModelDAO extends TelefooneigenaarModelDAO {
    public TextTelefooneigenaarModelDAO(){
     this.load();
    }

    public boolean save() {
        File detailFile = new File("telefooneigenaardetail.txt");
        try {
            PrintWriter printWriter = new PrintWriter(detailFile);
            for (TelefooneigenaarModel telefooneigenaarModel : telefooneigenaarlist) {
                printWriter.println(telefooneigenaarModel.getNaam());
                printWriter.println(telefooneigenaarModel.getGarantie());
                printWriter.println(telefooneigenaarModel.isStatusAbonnement());
                printWriter.println(telefooneigenaarModel.getAankoopdatum());
                printWriter.println(telefooneigenaarModel.getAantalTelefoons());
            }
            printWriter.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean load() {
        File detailFile = new File("telefooneigenaardetail.txt");
        telefooneigenaarlist.clear();
        try {Scanner scanner = new Scanner(detailFile);
            while (scanner.hasNext()){
                String naam = scanner.nextLine();
                String garantiestring = scanner.nextLine();
                String statusabonnementstring = scanner.nextLine();
                String aankoopdatumstring = scanner.nextLine();
                String aantaltelefoonsstring = scanner.nextLine();
                Double garantie = Double.parseDouble(garantiestring);
                Boolean statusabonnement = Boolean.parseBoolean(statusabonnementstring);
                LocalDate aankoopdatum = LocalDate.parse(aankoopdatumstring);
                Integer aantaltelefoons = Integer.parseInt(aantaltelefoonsstring);
                telefooneigenaarlist.add(new TelefooneigenaarModel(naam,garantie,statusabonnement,aankoopdatum,aantaltelefoons));
            }
            scanner.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

}
