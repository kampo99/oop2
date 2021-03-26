package practicumopdracht.data;

import practicumopdracht.model.MerkModel;

import java.io.*;
import java.time.LocalDate;

/**
 * This method <description of functionality>
 *
 * @author Po
 */
public class BinaryMerkModelDAO extends MerkModelDAO{

    @Override
    public boolean save() {
        File binaryfile = new File("merkmaster.dat");

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(binaryfile);
            DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);//geen dubbele data en kunnen afsluiten in de bestand
            dataOutputStream.writeInt(merkModelList.size());
            for (MerkModel merkModel : merkModelList) {
                dataOutputStream.writeUTF(merkModel.getMerkNaam());
                dataOutputStream.writeUTF(merkModel.getNetWaarde());
                LocalDate datum = merkModel.getOprichtdatum();

                int dag = datum.getDayOfMonth();
                int maand = datum.getMonthValue();
                int jaar = datum.getYear();

                dataOutputStream.writeInt(dag);
                dataOutputStream.writeInt(maand);
                dataOutputStream.writeInt(jaar);
            }
            dataOutputStream.close();
            return true;
        } catch (IOException ex){
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean load() {
        File binaryfile = new File("merkmaster.dat");

        merkModelList.clear();
        try {
            FileInputStream fileInputStream = new FileInputStream(binaryfile);
            DataInputStream dataInputStream = new DataInputStream(fileInputStream); //geen dubbele data en kunnen afsluiten in de bestand
            int aantalMerken = dataInputStream.readInt();
            for (int i = 0; i < aantalMerken ; i++) {
                MerkModel merkModel = new MerkModel();
                merkModel.setMerkNaam(dataInputStream.readUTF());
                merkModel.setNetWaarde(dataInputStream.readUTF());

                int dag = dataInputStream.readInt();
                int maand = dataInputStream.readInt();
                int jaar = dataInputStream.readInt();
                LocalDate datum = LocalDate.of(jaar,maand,dag);
                merkModel.setOprichtdatum(datum);
                merkModelList.add(merkModel);
            }
            dataInputStream.close();
            return true;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return false;
    }

}
