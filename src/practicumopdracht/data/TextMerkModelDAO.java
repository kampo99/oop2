package practicumopdracht.data;

import practicumopdracht.model.MerkModel;

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
public class TextMerkModelDAO extends MerkModelDAO {
    public TextMerkModelDAO(){

    }

    @Override
    public boolean save() {
        File masterFile = new File("merkmaster.txt");
        try {
            PrintWriter printWriter = new PrintWriter(masterFile);
            for (MerkModel merkModel : merkModelList) {
                printWriter.println(merkModel.getMerkNaam());
                printWriter.println(merkModel.getNetWaarde());
                printWriter.println(merkModel.getOprichtdatum());
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
        File masterFile = new File("merkmaster.txt");
        merkModelList.clear();
        try (Scanner scanner = new Scanner(masterFile)) {
            while (scanner.hasNext()){
                String merknaam = scanner.nextLine();
                String netwaarde = scanner.nextLine();
                String oprichtdatumstring = scanner.nextLine();
                LocalDate oprichtdatum = LocalDate.parse(oprichtdatumstring);
                merkModelList.add(new MerkModel(merknaam,netwaarde,oprichtdatum));
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }



}
